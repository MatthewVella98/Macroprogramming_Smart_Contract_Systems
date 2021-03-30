package com.parser.model;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

public class XOnMainSystemResult implements ParsingResultInterface {

    private String blockOfCode;
    private String functionName;
    private List<ParameterDeclaration> declarations = new ArrayList<>();

    private String delimiter = System.lineSeparator();

    public String getBlockOfCode() {
        return blockOfCode;
    }

    public void setBlockOfCode(String blockOfCode) {
        this.blockOfCode = blockOfCode;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public List<ParameterDeclaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(List<ParameterDeclaration> declarations) {
        this.declarations = declarations;
    }

    @Override
    public String translate() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("function " + functionName + "(");
        StringJoiner stringJoiner = new StringJoiner(",\n");
        declarations.forEach(declaration -> {
            stringJoiner.add(declaration.getName() + ": " + declaration.getType());
        });
        stringBuilder.append(stringJoiner.toString() + ") {\n");
        if (StringUtils.isNotBlank(blockOfCode)) {
            stringBuilder.append(blockOfCode);
        }
        stringBuilder.append("\n}");

        return stringBuilder.toString();
    }

    @Override
    public List<FileEntityResult> getFileEntities() {
        List<FileEntityResult> list = new ArrayList<>();

        FileEntityResult result1 = new FileEntityResult();

        String translated = translate();

        result1.setPath(MAIN_SYSTEM_DIR + File.separator + CONTROLLERS_TS);
        result1.setContent(translated);
        result1.setPositionInFile(10);
        list.add(result1);

        //*****************************************************

        return list;

    }
}
