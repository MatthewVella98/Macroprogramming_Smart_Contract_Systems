// Generated from D:\soft\free\ts_grammar\grammar\ts.g4 by ANTLR 4.8
package com.parser.ts;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tsParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(tsParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#data_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_item(tsParser.Data_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#data_property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_property(tsParser.Data_propertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#data_participant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_participant(tsParser.Data_participantContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#data_participant_identities}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_participant_identities(tsParser.Data_participant_identitiesContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#data_element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_element(tsParser.Data_elementContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#data_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_declaration(tsParser.Data_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#domain_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomain_type(tsParser.Domain_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#data_annotation_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_annotation_list(tsParser.Data_annotation_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#data_annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitData_annotation(tsParser.Data_annotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#logic_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_item(tsParser.Logic_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#x_logic_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_logic_item(tsParser.X_logic_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#x_on_chain_separate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_on_chain_separate(tsParser.X_on_chain_separateContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#x_on_main_system_separate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_on_main_system_separate(tsParser.X_on_main_system_separateContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#x_both}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX_both(tsParser.X_bothContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#block_of_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_of_code(tsParser.Block_of_codeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#block_of_code_inner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_of_code_inner(tsParser.Block_of_code_innerContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#block_of_code_outer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_of_code_outer(tsParser.Block_of_code_outerContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(tsParser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#function_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_name(tsParser.Function_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#controller_and_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitController_and_function(tsParser.Controller_and_functionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#list_of_params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_of_params(tsParser.List_of_paramsContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#param_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_declaration(tsParser.Param_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(tsParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(tsParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tsParser#generic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGeneric(tsParser.GenericContext ctx);
}