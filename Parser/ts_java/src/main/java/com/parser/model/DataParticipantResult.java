package com.parser.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataParticipantResult implements ParsingResultInterface {

    private DataTypeElement dataTypeElement; // @XOnlyOnChain  @ReadOnly() @Required()  public readonly type = 'io.worldsibu.property';
    private List<DataFieldElement> dataElements;

    public DataTypeElement getDataTypeElement() {
        return dataTypeElement;
    }

    public void setDataTypeElement(DataTypeElement dataTypeElement) {
        this.dataTypeElement = dataTypeElement;
    }

    public List<DataFieldElement> getDataElements() {
        return dataElements;
    }

    public void setDataElements(List<DataFieldElement> dataElements) {
        this.dataElements = dataElements;
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

        stringBuilder.append("export class Participant extends ConvectorModel<Participant> {\n\n");

        if (dataTypeElement != null) {
            String type = dataTypeElement.getType();
            stringBuilder.append("  @ReadOnly() @Required() public readonly type = '" + type.substring(1, type.length()-1) + "';\n\n");
        } else {
            throw new IllegalStateException("no dataTypeElement");
        }

        dataElements.forEach(dataElement -> {

            List<String> annotations = dataElement.getAnnotations();
            if (annotations != null) {
                stringBuilder.append("  ");
                annotations.forEach(annotation-> {

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

        return stringBuilder.toString();
    }

    @Override
    public List<FileEntityResult> getFileEntities() {
        List<FileEntityResult> list = new ArrayList<>();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("import * as yup from 'yup';\n");
        stringBuilder.append("import {\n");
        stringBuilder.append("  ConvectorModel,\n");
        stringBuilder.append("  ReadOnly,\n");
        stringBuilder.append("  Required,\n");
        stringBuilder.append("  Validate,\n");
        stringBuilder.append("  FlatConvectorModel\n");
        stringBuilder.append("} from '@worldsibu/convector-core'; \n\n");

        stringBuilder.append("export class Participant extends ConvectorModel<Participant> {\n\n");

        if (dataTypeElement != null) {
            String type = dataTypeElement.getType();
            stringBuilder.append("  @ReadOnly() @Required() public readonly type = '" + type.substring(1, type.length()-1) + "';\n\n");
        } else {
            throw new IllegalStateException("no dataTypeElement");
        }

        dataElements.forEach(dataElement -> {

            List<String> annotations = dataElement.getAnnotations();
            if (annotations != null) {
                stringBuilder.append("  ");
                annotations.forEach(annotation-> {

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

        FileEntityResult result1 = new FileEntityResult();
        result1.setPath(PARTICIPANT_DIR + File.separator + PARTICIPANT_MODEL_TS);
        result1.setContent(stringBuilder.toString());
        result1.setPositionInFile(1);
        list.add(result1);

        //----------------------------------



        return list;
    }
}
