// Generated from D:\soft\free\ts_grammar\grammar\ts.g4 by ANTLR 4.8
package com.parser.ts;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tsParser}.
 */
public interface tsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(tsParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(tsParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#data_item}.
	 * @param ctx the parse tree
	 */
	void enterData_item(tsParser.Data_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#data_item}.
	 * @param ctx the parse tree
	 */
	void exitData_item(tsParser.Data_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#data_property}.
	 * @param ctx the parse tree
	 */
	void enterData_property(tsParser.Data_propertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#data_property}.
	 * @param ctx the parse tree
	 */
	void exitData_property(tsParser.Data_propertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#data_participant}.
	 * @param ctx the parse tree
	 */
	void enterData_participant(tsParser.Data_participantContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#data_participant}.
	 * @param ctx the parse tree
	 */
	void exitData_participant(tsParser.Data_participantContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#data_participant_identities}.
	 * @param ctx the parse tree
	 */
	void enterData_participant_identities(tsParser.Data_participant_identitiesContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#data_participant_identities}.
	 * @param ctx the parse tree
	 */
	void exitData_participant_identities(tsParser.Data_participant_identitiesContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#data_element}.
	 * @param ctx the parse tree
	 */
	void enterData_element(tsParser.Data_elementContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#data_element}.
	 * @param ctx the parse tree
	 */
	void exitData_element(tsParser.Data_elementContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#data_declaration}.
	 * @param ctx the parse tree
	 */
	void enterData_declaration(tsParser.Data_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#data_declaration}.
	 * @param ctx the parse tree
	 */
	void exitData_declaration(tsParser.Data_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#domain_type}.
	 * @param ctx the parse tree
	 */
	void enterDomain_type(tsParser.Domain_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#domain_type}.
	 * @param ctx the parse tree
	 */
	void exitDomain_type(tsParser.Domain_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#data_annotation_list}.
	 * @param ctx the parse tree
	 */
	void enterData_annotation_list(tsParser.Data_annotation_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#data_annotation_list}.
	 * @param ctx the parse tree
	 */
	void exitData_annotation_list(tsParser.Data_annotation_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#data_annotation}.
	 * @param ctx the parse tree
	 */
	void enterData_annotation(tsParser.Data_annotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#data_annotation}.
	 * @param ctx the parse tree
	 */
	void exitData_annotation(tsParser.Data_annotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#logic_item}.
	 * @param ctx the parse tree
	 */
	void enterLogic_item(tsParser.Logic_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#logic_item}.
	 * @param ctx the parse tree
	 */
	void exitLogic_item(tsParser.Logic_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#x_logic_item}.
	 * @param ctx the parse tree
	 */
	void enterX_logic_item(tsParser.X_logic_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#x_logic_item}.
	 * @param ctx the parse tree
	 */
	void exitX_logic_item(tsParser.X_logic_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#x_on_chain_separate}.
	 * @param ctx the parse tree
	 */
	void enterX_on_chain_separate(tsParser.X_on_chain_separateContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#x_on_chain_separate}.
	 * @param ctx the parse tree
	 */
	void exitX_on_chain_separate(tsParser.X_on_chain_separateContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#x_on_main_system_separate}.
	 * @param ctx the parse tree
	 */
	void enterX_on_main_system_separate(tsParser.X_on_main_system_separateContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#x_on_main_system_separate}.
	 * @param ctx the parse tree
	 */
	void exitX_on_main_system_separate(tsParser.X_on_main_system_separateContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#x_both}.
	 * @param ctx the parse tree
	 */
	void enterX_both(tsParser.X_bothContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#x_both}.
	 * @param ctx the parse tree
	 */
	void exitX_both(tsParser.X_bothContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#block_of_code}.
	 * @param ctx the parse tree
	 */
	void enterBlock_of_code(tsParser.Block_of_codeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#block_of_code}.
	 * @param ctx the parse tree
	 */
	void exitBlock_of_code(tsParser.Block_of_codeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#block_of_code_inner}.
	 * @param ctx the parse tree
	 */
	void enterBlock_of_code_inner(tsParser.Block_of_code_innerContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#block_of_code_inner}.
	 * @param ctx the parse tree
	 */
	void exitBlock_of_code_inner(tsParser.Block_of_code_innerContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#block_of_code_outer}.
	 * @param ctx the parse tree
	 */
	void enterBlock_of_code_outer(tsParser.Block_of_code_outerContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#block_of_code_outer}.
	 * @param ctx the parse tree
	 */
	void exitBlock_of_code_outer(tsParser.Block_of_code_outerContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(tsParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(tsParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(tsParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(tsParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#controller_and_function}.
	 * @param ctx the parse tree
	 */
	void enterController_and_function(tsParser.Controller_and_functionContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#controller_and_function}.
	 * @param ctx the parse tree
	 */
	void exitController_and_function(tsParser.Controller_and_functionContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#list_of_params}.
	 * @param ctx the parse tree
	 */
	void enterList_of_params(tsParser.List_of_paramsContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#list_of_params}.
	 * @param ctx the parse tree
	 */
	void exitList_of_params(tsParser.List_of_paramsContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#param_declaration}.
	 * @param ctx the parse tree
	 */
	void enterParam_declaration(tsParser.Param_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#param_declaration}.
	 * @param ctx the parse tree
	 */
	void exitParam_declaration(tsParser.Param_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(tsParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(tsParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(tsParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(tsParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tsParser#generic}.
	 * @param ctx the parse tree
	 */
	void enterGeneric(tsParser.GenericContext ctx);
	/**
	 * Exit a parse tree produced by {@link tsParser#generic}.
	 * @param ctx the parse tree
	 */
	void exitGeneric(tsParser.GenericContext ctx);
}