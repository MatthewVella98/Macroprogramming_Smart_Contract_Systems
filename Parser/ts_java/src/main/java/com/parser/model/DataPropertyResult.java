package com.parser.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DataPropertyResult implements ParsingResultInterface {

    private DataTypeElement dataTypeElement; // @XOnlyOnChain  @ReadOnly() @Required()  public readonly type = 'io.worldsibu.property';
    private List<DataFieldElement> dataElements;

    public List<DataFieldElement> getDataElements() {
        return dataElements;
    }

    public void setDataElements(List<DataFieldElement> dataElements) {
        this.dataElements = dataElements;
    }

    public DataTypeElement getDataTypeElement() {
        return dataTypeElement;
    }

    public void setDataTypeElement(DataTypeElement dataTypeElement) {
        this.dataTypeElement = dataTypeElement;
    }

    @Override
    public String translate() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n\nimport * as yup from 'yup':\n");
        stringBuilder.append("import {\n");
        stringBuilder.append("  ConvectorModel,\n");
        stringBuilder.append("  Default,\n");
        stringBuilder.append("  ReadOnly,\n");
        stringBuilder.append("  Required,\n");
        stringBuilder.append("  Validate\n");
        stringBuilder.append("} from '@worldsibu/convector-core-model'; \n\n");

        stringBuilder.append("export class Property extends ConvectorModel<Property> {\n\n");

        if (dataTypeElement != null) {
            String type = dataTypeElement.getType();
            stringBuilder.append("  @ReadOnly() @Required() public readonly type = '" + type.substring(1, type.length()-1) + "';\n\n");
        } else {
            throw new IllegalStateException("no dataTypeElement");
        }


        AtomicReference<DataFieldElement> withXALLRef = new AtomicReference<>();
        dataElements.forEach(dataElement -> {

            List<String> annotations = dataElement.getAnnotations();
            if (annotations != null) {
                stringBuilder.append("  ");
                annotations.forEach(annotation-> {

                    if (annotation.equals("@XAll")) {
                        withXALLRef.set(dataElement);

                        stringBuilder.append("@ReadOnly() @Required() @Validate(yup." + dataElement.getType() + "())");
                        return;
                    }
                    if (annotation.equals("@XOnlyOnChain")) {
                        return;
                    }

                    stringBuilder.append(annotation + " ");
                });
                stringBuilder.append("\n");
            }
            stringBuilder.append("  public " + dataElement.getVarName() + ": " + dataElement.getType() + ";\n\n");
        });

        stringBuilder.append("}");

        stringBuilder.append("\n\n");

        DataFieldElement withXALL = withXALLRef.get();

        if (withXALL != null) {
            stringBuilder.append("export class PropertyMainSystem {\n");
            stringBuilder.append("  public " + withXALL.getVarName() + ": " + withXALL.getType() + ";\n");
            stringBuilder.append("}");
        } else {
            throw new IllegalStateException("no XAll field");
        }

        return stringBuilder.toString();
    }

    @Override
    public List<FileEntityResult> getFileEntities() {
        List<FileEntityResult> list = new ArrayList<>();


        AtomicReference<DataFieldElement> withXALLRef = new AtomicReference<>();

        // searching property with annotation XAll
        dataElements.forEach(dataElement -> {
            List<String> annotations = dataElement.getAnnotations();
            if (annotations != null) {
                annotations.forEach(annotation-> {
                    if (annotation.equals("@XAll")) {
                        withXALLRef.set(dataElement);
                        return;
                    }
                });
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        DataFieldElement withXALL = withXALLRef.get();

        if (withXALL != null) {
            stringBuilder.append("export class PropertyMainSystem {\n");
            stringBuilder.append("  public " + withXALL.getVarName() + ": " + withXALL.getType() + ";\n");
            stringBuilder.append("}");
        } else {
            throw new IllegalStateException("no XAll field");
        }

        FileEntityResult result1 = new FileEntityResult();
        result1.setPath(MAIN_SYSTEM_DIR + File.separator + PROPERTY_MAIN_SYSTEM_MODEL_TS);
        result1.setContent(stringBuilder.toString());
        list.add(result1);

        //---------------------------------------------

        StringBuilder sb = new StringBuilder();

        sb.append("import * as yup from 'yup':\n");
        sb.append("import {\n");
        sb.append("  ConvectorModel,\n");
        sb.append("  Default,\n");
        sb.append("  ReadOnly,\n");
        sb.append("  Required,\n");
        sb.append("  Validate\n");
        sb.append("} from '@worldsibu/convector-core-model'; \n\n");

        sb.append("export class Property extends ConvectorModel<Property> {\n\n");

        if (dataTypeElement != null) {
            String type = dataTypeElement.getType();
            sb.append("  @ReadOnly() @Required() public readonly type = '" + type.substring(1, type.length()-1) + "';\n\n");
        } else {
            throw new IllegalStateException("no dataTypeElement");
        }

        dataElements.forEach(dataElement -> {

            List<String> annotations = dataElement.getAnnotations();
            if (annotations != null) {
                sb.append("  ");
                annotations.forEach(annotation-> {

                    // skip this annotation
                    if (annotation.equals("@XOnlyOnChain")) {
                        return;
                    }
                    if (annotation.equals("@XAll")) {

                        sb.append("@ReadOnly() @Required() @Validate(yup." + dataElement.getType() + "())");
                        return;
                    }

                    sb.append(annotation + " ");
                });
                sb.append("\n");
            }
            sb.append("  public " + dataElement.getVarName() + ": " + dataElement.getType() + ";\n\n");
        });

        sb.append("}");

        FileEntityResult result2 = new FileEntityResult();
        result2.setPath(PROPERY_DIR + File.separator + PROPERTY_MODEL_TS);
        result2.setContent(sb.toString());
        list.add(result2);

        return list;
    }
}
