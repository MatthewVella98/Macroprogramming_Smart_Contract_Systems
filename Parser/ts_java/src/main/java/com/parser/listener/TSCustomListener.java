package com.parser.listener;

import com.parser.model.*;
import com.parser.ts.tsBaseListener;
import com.parser.ts.tsParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// This class takes tsBaseListener (generated by ANTLR) + adds logic.
// Each rule in ANTLR grammar produces 2 methods: Enter | Exit 
public class TSCustomListener extends tsBaseListener {

    private String blockOfCode;
    private String controllerName;
    private String functionNameSubstring;
    private List<ParameterDeclaration> declarations = new ArrayList<>();

    private String functionNameOnMainOnly;

    private String blockOfCodeInner;
    private String blockOfCodeOuter;

    private List<String> annotationList = new ArrayList<>();

    private List<ParsingResultInterface> logicItemList = new ArrayList<>();

    private DataTypeElement dataTypeElement;
    private List<DataFieldElement> dataElements = new ArrayList<>();

    private List<ParsingResultInterface> dataItemList = new ArrayList<>();

    private ProgramResult programResult;

    public ProgramResult getProgramResult() {
        return programResult;
    }

    @Override
    public void exitProgram(tsParser.ProgramContext ctx) {
        programResult = new ProgramResult();
        programResult.setLogicItems(logicItemList);
        programResult.setDataItems(dataItemList);
    }

    @Override
    public void enterData_property(tsParser.Data_propertyContext ctx) {
        // entering new data section so need to start a new list
        dataElements = new ArrayList<>();
    }

    @Override
    public void exitData_property(tsParser.Data_propertyContext ctx) {
        DataPropertyResult dataPropertyResult = new DataPropertyResult();
        dataPropertyResult.setDataElements(dataElements);

        dataPropertyResult.setDataTypeElement(dataTypeElement);
        dataTypeElement = null;

        dataItemList.add(dataPropertyResult);
    }

    @Override
    public void enterData_participant(tsParser.Data_participantContext ctx) {
        // entering new data section so need to start a new list
        dataElements = new ArrayList<>();
    }

    @Override
    public void exitData_participant(tsParser.Data_participantContext ctx) {
        DataParticipantResult dataParticipantResult = new DataParticipantResult();
        dataParticipantResult.setDataElements(dataElements);

        dataParticipantResult.setDataTypeElement(dataTypeElement);
        dataTypeElement = null;

        dataItemList.add(dataParticipantResult);
    }

    @Override
    public void enterData_participant_identities(tsParser.Data_participant_identitiesContext ctx) {
        // entering new data section so need to start a new list
        dataElements = new ArrayList<>();
    }

    @Override
    public void exitData_participant_identities(tsParser.Data_participant_identitiesContext ctx) {
        DataParticipantIdentitiesResult dataParticipantIdentitiesResult = new DataParticipantIdentitiesResult();

        dataParticipantIdentitiesResult.setDataElements(dataElements);

        dataParticipantIdentitiesResult.setDataTypeElement(dataTypeElement);
        dataTypeElement = null;

        dataItemList.add(dataParticipantIdentitiesResult);
    }

    @Override
    public void exitData_element(tsParser.Data_elementContext ctx) {

        if (ctx.data_declaration().identifier() != null) {
            DataFieldElement dataElement = new DataFieldElement();

            String varName = ctx.data_declaration().identifier().getText();

            dataElement.setVarName(varName);
            dataElement.setAnnotations(annotationList);

            String type = "n/a";
            if (ctx.data_declaration().type() != null) {
                type = ctx.data_declaration().type().getText();
            } else {
                throw new IllegalStateException("unknown type1");
            }
            dataElement.setType(type);

            dataElements.add(dataElement);
        } else {
            dataTypeElement = new DataTypeElement();
            dataTypeElement.setReadOnly(ctx.data_declaration().READONLY() != null);

            String type = "n/a";
            if (ctx.data_declaration().domain_type() != null) {
                type = ctx.data_declaration().domain_type().getText();
            } else {
                throw new IllegalStateException("unknown type2");
            }
            dataTypeElement.setAnnotations(annotationList);

            dataTypeElement.setType(type);

        }

        annotationList = new ArrayList<>();
    }

    @Override
    public void exitData_annotation(tsParser.Data_annotationContext ctx) {
        //System.out.println("annotation " + ctx.getText());
        annotationList.add(ctx.getText());
    }

    @Override
    public void exitX_on_chain_separate(tsParser.X_on_chain_separateContext ctx) {
        XOnChainOnlyResult xOnChainOnlyResult = new XOnChainOnlyResult();

        xOnChainOnlyResult.setFunctionName(functionNameSubstring);
        xOnChainOnlyResult.setBlockOfCode(blockOfCode);
        xOnChainOnlyResult.setDeclarations(declarations);
        xOnChainOnlyResult.setControllerName(controllerName);

        logicItemList.add(xOnChainOnlyResult);
    }

    @Override
    public void exitX_on_main_system_separate(tsParser.X_on_main_system_separateContext ctx) {
        XOnMainSystemResult xOnMainSystemOnlyResult = new XOnMainSystemResult();

        xOnMainSystemOnlyResult.setBlockOfCode(blockOfCode);
        xOnMainSystemOnlyResult.setDeclarations(declarations);
        xOnMainSystemOnlyResult.setFunctionName(functionNameOnMainOnly);

        logicItemList.add(xOnMainSystemOnlyResult);
    }

    @Override
    public void exitX_both(tsParser.X_bothContext ctx) {
        XBothResult xBoth = new XBothResult();

        xBoth.setControllerName(controllerName);
        xBoth.setFunctionName(functionNameSubstring);
        xBoth.setBlockOfCodeInner(blockOfCodeInner);
        xBoth.setBlockOfCodeOuter(blockOfCodeOuter);
        xBoth.setDeclarations(declarations);

        logicItemList.add(xBoth);
    }

    @Override
    public void exitFunction_name(tsParser.Function_nameContext ctx) {
        functionNameOnMainOnly = ctx.getText();
    }

    @Override
    public void exitBlock_of_code(tsParser.Block_of_codeContext ctx) {
        blockOfCode = ctx.getText();
    }

    @Override
    public void exitBlock_of_code_outer(tsParser.Block_of_code_outerContext ctx) {
        blockOfCodeOuter = ctx.getText();
    }

    @Override
    public void exitBlock_of_code_inner(tsParser.Block_of_code_innerContext ctx) {
        blockOfCodeInner = ctx.getText();
    }

    @Override
    public void exitList_of_params(tsParser.List_of_paramsContext ctx) {
        List<tsParser.Param_declarationContext> params = ctx.param_declaration();
        if (params != null) {
            declarations = params.stream().map(param -> {
                ParameterDeclaration parameterDeclaration = new ParameterDeclaration();

                parameterDeclaration.setName(param.identifier().getText());
                parameterDeclaration.setType(param.type().getText());

                return parameterDeclaration;
            }).collect(Collectors.toList());
        }
    }

    @Override
    public void exitController_and_function(tsParser.Controller_and_functionContext ctx) {
        String identifier = ctx.IDENTIFIER().getText();

        int position = identifier.indexOf("_");
        controllerName = identifier.substring(0, position);
        functionNameSubstring = identifier.substring(position + 1);
    }
}
