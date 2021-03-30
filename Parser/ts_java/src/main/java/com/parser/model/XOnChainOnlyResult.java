package com.parser.model;

import com.parser.util.CustomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

public class XOnChainOnlyResult implements ParsingResultInterface {

    private String blockOfCode;
    private String controllerName;
    private String functionName;
    //private String functionSpecifiers;
    private List<ParameterDeclaration> declarations = new ArrayList<>();

    private String delimiter = System.lineSeparator();

    public String getBlockOfCode() {
        return blockOfCode;
    }

    public String getControllerName() {
        return controllerName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public List<ParameterDeclaration> getDeclarations() {
        return declarations;
    }

    public void setBlockOfCode(String blockOfCode) {
        this.blockOfCode = blockOfCode;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public void setDeclarations(List<ParameterDeclaration> declarations) {
        this.declarations = declarations;
    }

    /*public String getFunctionSpecifiers() {
        return functionSpecifiers;
    }*/

    /*public void setFunctionSpecifiers(String functionSpecifiers) {
        this.functionSpecifiers = functionSpecifiers;
    }*/

    @Override
    public String translate() {
        StringBuilder sb = new StringBuilder();

        sb.append("@Invokeable()\n");

        /*int positionOfAsync = functionSpecifiers.indexOf("async");
        // remove 'function word'
        String functionSpecifiersFinal = functionSpecifiers.trim().replace("function", "");
        if (positionOfAsync == -1) {
            // if async wasn't included in the block. Checking that we avoid doubled "async"
            functionSpecifiersFinal += " async";
        }
        // if there was no word 'public', prepend it
        int posOfPublic = functionSpecifiers.indexOf("public");
        if (posOfPublic == -1) {
            // if async wasn't included in the block. Checking that we avoid doubled "async"
            functionSpecifiersFinal = "public" + functionSpecifiersFinal;
        }*/

        sb.append(/*functionSpecifiersFinal + */ "public async " + functionName + "(\n");

        StringJoiner stringJoiner = new StringJoiner(",\n");
        declarations.forEach(declaration -> {
            stringJoiner.add("  " + declaration.getName() + ": " + declaration.getType());
        });
        sb.append(stringJoiner.toString());
        sb.append("\n) {");
        if (StringUtils.isNotBlank(blockOfCode)) {
            sb.append(CustomStringUtils.trimTrailingSpaces(blockOfCode) + "\n");
        }
        sb.append("}"); // for the invokable function

        return sb.toString();
    }

    @Override
    public List<FileEntityResult> getFileEntities() {
        List<FileEntityResult> list = new ArrayList<>();

        FileEntityResult result1 = new FileEntityResult();

        String filenamePrefix = CustomStringUtils.getFileNamePrefixFromControllerName(controllerName);
        String folder = CustomStringUtils.getFolderNameFromControllerName(controllerName);

        result1.setPath(folder + File.separator + filenamePrefix + CONTROLLER_TS_APPENDIX);
        result1.setContent(translate());
        result1.setPositionInFile(3);

        list.add(result1);

        return list;
    }
}
