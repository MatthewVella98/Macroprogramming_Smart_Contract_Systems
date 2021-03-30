package com.parser.model;

import com.parser.util.CustomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.*;

// Section 3 in the PDF
public class XBothResult implements ParsingResultInterface {

    private String controllerName;
    private String functionName;
    private List<ParameterDeclaration> declarations = new ArrayList<>();
    private String blockOfCodeInner;
    private String blockOfCodeOuter;
    //private String functionSpecifiers;

    private String delimiter = System.lineSeparator();

    public String getControllerName() {
        return controllerName;
    }

    public void setControllerName(String controllerName) {
        this.controllerName = controllerName;
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

    public String getBlockOfCodeInner() {
        return blockOfCodeInner;
    }

    public void setBlockOfCodeInner(String blockOfCodeInner) {
        this.blockOfCodeInner = blockOfCodeInner;
    }

    public String getBlockOfCodeOuter() {
        return blockOfCodeOuter;
    }

    public void setBlockOfCodeOuter(String blockOfCodeOuter) {
        this.blockOfCodeOuter = blockOfCodeOuter;
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
        // for this case 2 blocks are generated:  XOnChain and the one for main system

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

        sb.append(/*functionSpecifiersFinal +*/ "public async " + functionName + "(\n");

        StringJoiner stringJoiner = new StringJoiner(",\n");
        declarations.forEach(declaration -> {
            stringJoiner.add("  @Param(yup." + declaration.getType() + "())\n  " + declaration.getName() + ": " + declaration.getType());
        });
        sb.append(stringJoiner.toString());
        sb.append("\n) {");
        if (StringUtils.isNotBlank(blockOfCodeInner)) {
            sb.append(CustomStringUtils.trimTrailingSpaces(blockOfCodeInner));
        }
        sb.append("\n}");

        //**********************
        //sb.append("\n===============\n");
        sb.append("\n\n");

        sb.append("export async function " + controllerName + "_" + functionName + "(req: Request, res: Response): Promise<void>{\n");

        sb.append("    try {\n");
        sb.append("         let params = req.body;\n");
        sb.append("              res.status(200).send(await " + controllerName + "Backend\n");
        sb.append("                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n");
        sb.append("    } catch(ex){\n");
        sb.append("        console.log('Error post PropertyController_createProperty', ex.stack);\n");
        sb.append("        res.status(500).send(ex)\n");
        sb.append("    }\n");

        if (StringUtils.isNotBlank(blockOfCodeOuter)) {
            sb.append(CustomStringUtils.trimTrailingSpaces(blockOfCodeOuter));
        }
        sb.append("\n}");

        return sb.toString();
    }

    @Override
    public List<FileEntityResult> getFileEntities() {

        List<FileEntityResult> list = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        sb.append("export async function " + controllerName + "_" + functionName + "(req: Request, res: Response): Promise<void>{\n");

        sb.append("    try {\n");
        sb.append("         let params = req.body;\n");
        sb.append("              res.status(200).send(await " + controllerName + "Backend\n");
        sb.append("                  .createProperty(params.id, params.propertyType, params.ownerId, params.price, params.isForSale));\n");
        sb.append("    } catch(ex){\n");
        sb.append("        console.log('Error post " + controllerName + "_" + functionName + "', ex.stack);\n");
        sb.append("        res.status(500).send(ex)\n");
        sb.append("    }\n");

        if (StringUtils.isNotBlank(blockOfCodeOuter)) {
            sb.append(CustomStringUtils.trimTrailingSpaces(blockOfCodeOuter));
        }
        sb.append("\n}");


        FileEntityResult result1 = new FileEntityResult();
        result1.setPath(MAIN_SYSTEM_DIR + File.separator + CONTROLLERS_TS);
        result1.setContent(sb.toString());
        result1.setPositionInFile(2);

        list.add(result1);

        //-------------------------------------------

        sb = new StringBuilder();

        sb.append("@Invokeable()\n");

        sb.append("public async " + functionName + "(\n");

        StringJoiner stringJoiner = new StringJoiner(",\n");
        declarations.forEach(declaration -> {
            stringJoiner.add("  @Param(yup." + declaration.getType() + "())\n  " + declaration.getName() + ": " + declaration.getType());
        });
        sb.append(stringJoiner.toString());
        sb.append("\n) {");
        if (StringUtils.isNotBlank(blockOfCodeInner)) {
            sb.append(CustomStringUtils.trimTrailingSpaces(blockOfCodeInner));
        }
        sb.append("\n}");

        String filenamePrefix = CustomStringUtils.getFileNamePrefixFromControllerName(controllerName);
        String folder = CustomStringUtils.getFolderNameFromControllerName(controllerName);

        FileEntityResult result2 = new FileEntityResult();

        //result2.setPath(PROPERY_DIR + File.separator + PROPERTY_CONTROLLER_TS);
        result2.setPath(folder + File.separator + filenamePrefix + CONTROLLER_TS_APPENDIX);
        result2.setContent(sb.toString());
        result2.setPositionInFile(2);

        list.add(result2);

        //-------------------------

        /*FileEntityResult result3 = new FileEntityResult();
        result3.setPath(PROPERY_DIR + File.separator + PROPERTY_CONTROLLERS_TS);
        result3.setContent("\n}"); // for controller
        result3.setPositionInFile(1000); // should be in the end

        list.add(result3);*/

        return list;
    }
}
