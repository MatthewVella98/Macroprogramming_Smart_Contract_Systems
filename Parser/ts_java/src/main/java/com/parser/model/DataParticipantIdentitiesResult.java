package com.parser.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataParticipantIdentitiesResult implements ParsingResultInterface {

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

        stringBuilder.append("export class x509Identities extends ConvectorModel<x509Identities> {\n\n");

        if (dataTypeElement != null) {
            String type = dataTypeElement.getType();
            stringBuilder.append("  @ReadOnly() public readonly type = '" + type.substring(1, type.length() - 1) + "';\n\n");
        } else {
            throw new IllegalStateException("no dataTypeElement");
        }

        dataElements.forEach(dataElement -> {

            List<String> annotations = dataElement.getAnnotations();
            if (annotations != null) {
                stringBuilder.append("  ");
                annotations.forEach(annotation -> {

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

        return stringBuilder.toString();
    }

    @Override
    public List<FileEntityResult> getFileEntities() {

        List<FileEntityResult> list = new ArrayList<>();

        /*StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("export class x509Identities extends ConvectorModel<x509Identities> {\n\n");

        if (dataTypeElement != null) {
            String type = dataTypeElement.getType();
            stringBuilder.append("  @ReadOnly() public readonly type = '" + type.substring(1, type.length() - 1) + "';\n\n");
        } else {
            throw new IllegalStateException("no dataTypeElement");
        }

        dataElements.forEach(dataElement -> {

            List<String> annotations = dataElement.getAnnotations();
            if (annotations != null) {
                stringBuilder.append("  ");
                annotations.forEach(annotation -> {

                    if (annotation.equals("@XOnlyOnChain")) {
                        return;
                    }

                    stringBuilder.append(annotation + " ");
                });
                stringBuilder.append("\n");
            }
            stringBuilder.append("  public " + dataElement.getVarName() + ": " + dataElement.getType() + ";\n\n");
        });

        stringBuilder.append("}");*/

        FileEntityResult result1 = new FileEntityResult();
        result1.setPath(PARTICIPANT_DIR + File.separator + PARTICIPANT_MODEL_TS);
        String translated = translate();
        result1.setContent(translated);
        result1.setPositionInFile(1);
        list.add(result1);

        //----------------------------------------------

        return list;
    }
}
