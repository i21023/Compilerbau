// Generated from java-escape by ANTLR 4.11.1
package mmc.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniJavaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniJavaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#public_class_decl}.
	 * @param ctx the parse tree
	 */
	void enterPublic_class_decl(MiniJavaParser.Public_class_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#public_class_decl}.
	 * @param ctx the parse tree
	 */
	void exitPublic_class_decl(MiniJavaParser.Public_class_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void enterClass_decl(MiniJavaParser.Class_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void exitClass_decl(MiniJavaParser.Class_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#const_decl}.
	 * @param ctx the parse tree
	 */
	void enterConst_decl(MiniJavaParser.Const_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#const_decl}.
	 * @param ctx the parse tree
	 */
	void exitConst_decl(MiniJavaParser.Const_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void enterMethod_decl(MiniJavaParser.Method_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#method_decl}.
	 * @param ctx the parse tree
	 */
	void exitMethod_decl(MiniJavaParser.Method_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#main_method_decl}.
	 * @param ctx the parse tree
	 */
	void enterMain_method_decl(MiniJavaParser.Main_method_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#main_method_decl}.
	 * @param ctx the parse tree
	 */
	void exitMain_method_decl(MiniJavaParser.Main_method_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#string_args}.
	 * @param ctx the parse tree
	 */
	void enterString_args(MiniJavaParser.String_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#string_args}.
	 * @param ctx the parse tree
	 */
	void exitString_args(MiniJavaParser.String_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void enterField_decl(MiniJavaParser.Field_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#field_decl}.
	 * @param ctx the parse tree
	 */
	void exitField_decl(MiniJavaParser.Field_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#field_decl_concat}.
	 * @param ctx the parse tree
	 */
	void enterField_decl_concat(MiniJavaParser.Field_decl_concatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#field_decl_concat}.
	 * @param ctx the parse tree
	 */
	void exitField_decl_concat(MiniJavaParser.Field_decl_concatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(MiniJavaParser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(MiniJavaParser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#method_type}.
	 * @param ctx the parse tree
	 */
	void enterMethod_type(MiniJavaParser.Method_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#method_type}.
	 * @param ctx the parse tree
	 */
	void exitMethod_type(MiniJavaParser.Method_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void enterStatement_block(MiniJavaParser.Statement_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement_block}.
	 * @param ctx the parse tree
	 */
	void exitStatement_block(MiniJavaParser.Statement_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement_block_inline}.
	 * @param ctx the parse tree
	 */
	void enterStatement_block_inline(MiniJavaParser.Statement_block_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement_block_inline}.
	 * @param ctx the parse tree
	 */
	void exitStatement_block_inline(MiniJavaParser.Statement_block_inlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement_inline}.
	 * @param ctx the parse tree
	 */
	void enterStatement_inline(MiniJavaParser.Statement_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement_inline}.
	 * @param ctx the parse tree
	 */
	void exitStatement_inline(MiniJavaParser.Statement_inlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#local_var_decl}.
	 * @param ctx the parse tree
	 */
	void enterLocal_var_decl(MiniJavaParser.Local_var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#local_var_decl}.
	 * @param ctx the parse tree
	 */
	void exitLocal_var_decl(MiniJavaParser.Local_var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#local_var_decl_concat}.
	 * @param ctx the parse tree
	 */
	void enterLocal_var_decl_concat(MiniJavaParser.Local_var_decl_concatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#local_var_decl_concat}.
	 * @param ctx the parse tree
	 */
	void exitLocal_var_decl_concat(MiniJavaParser.Local_var_decl_concatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#if_else_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_else_statement(MiniJavaParser.If_else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#if_else_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_else_statement(MiniJavaParser.If_else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#if_statement_inline}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement_inline(MiniJavaParser.If_statement_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#if_statement_inline}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement_inline(MiniJavaParser.If_statement_inlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(MiniJavaParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(MiniJavaParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(MiniJavaParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(MiniJavaParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#while_statement_inline}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement_inline(MiniJavaParser.While_statement_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#while_statement_inline}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement_inline(MiniJavaParser.While_statement_inlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(MiniJavaParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(MiniJavaParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#for_statement_inline}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement_inline(MiniJavaParser.For_statement_inlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#for_statement_inline}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement_inline(MiniJavaParser.For_statement_inlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterFor_init(MiniJavaParser.For_initContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitFor_init(MiniJavaParser.For_initContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#for_statement_expr}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement_expr(MiniJavaParser.For_statement_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#for_statement_expr}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement_expr(MiniJavaParser.For_statement_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(MiniJavaParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(MiniJavaParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#statement_expr}.
	 * @param ctx the parse tree
	 */
	void enterStatement_expr(MiniJavaParser.Statement_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#statement_expr}.
	 * @param ctx the parse tree
	 */
	void exitStatement_expr(MiniJavaParser.Statement_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#method_call_statement}.
	 * @param ctx the parse tree
	 */
	void enterMethod_call_statement(MiniJavaParser.Method_call_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#method_call_statement}.
	 * @param ctx the parse tree
	 */
	void exitMethod_call_statement(MiniJavaParser.Method_call_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#method_owner_prefix}.
	 * @param ctx the parse tree
	 */
	void enterMethod_owner_prefix(MiniJavaParser.Method_owner_prefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#method_owner_prefix}.
	 * @param ctx the parse tree
	 */
	void exitMethod_owner_prefix(MiniJavaParser.Method_owner_prefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#method_chain}.
	 * @param ctx the parse tree
	 */
	void enterMethod_chain(MiniJavaParser.Method_chainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#method_chain}.
	 * @param ctx the parse tree
	 */
	void exitMethod_chain(MiniJavaParser.Method_chainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#new_statement}.
	 * @param ctx the parse tree
	 */
	void enterNew_statement(MiniJavaParser.New_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#new_statement}.
	 * @param ctx the parse tree
	 */
	void exitNew_statement(MiniJavaParser.New_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MiniJavaParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MiniJavaParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assign_statement}.
	 * @param ctx the parse tree
	 */
	void enterAssign_statement(MiniJavaParser.Assign_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assign_statement}.
	 * @param ctx the parse tree
	 */
	void exitAssign_statement(MiniJavaParser.Assign_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#crement_statement}.
	 * @param ctx the parse tree
	 */
	void enterCrement_statement(MiniJavaParser.Crement_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#crement_statement}.
	 * @param ctx the parse tree
	 */
	void exitCrement_statement(MiniJavaParser.Crement_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#inst_var}.
	 * @param ctx the parse tree
	 */
	void enterInst_var(MiniJavaParser.Inst_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#inst_var}.
	 * @param ctx the parse tree
	 */
	void exitInst_var(MiniJavaParser.Inst_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#inst_var_in_between}.
	 * @param ctx the parse tree
	 */
	void enterInst_var_in_between(MiniJavaParser.Inst_var_in_betweenContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#inst_var_in_between}.
	 * @param ctx the parse tree
	 */
	void exitInst_var_in_between(MiniJavaParser.Inst_var_in_betweenContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiniJavaParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiniJavaParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#logical_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogical_or_expr(MiniJavaParser.Logical_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#logical_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogical_or_expr(MiniJavaParser.Logical_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#logical_and_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogical_and_expr(MiniJavaParser.Logical_and_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#logical_and_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogical_and_expr(MiniJavaParser.Logical_and_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#bitwise_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitwise_or_expr(MiniJavaParser.Bitwise_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#bitwise_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitwise_or_expr(MiniJavaParser.Bitwise_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#bitwise_and_expr}.
	 * @param ctx the parse tree
	 */
	void enterBitwise_and_expr(MiniJavaParser.Bitwise_and_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#bitwise_and_expr}.
	 * @param ctx the parse tree
	 */
	void exitBitwise_and_expr(MiniJavaParser.Bitwise_and_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#equality_expr}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expr(MiniJavaParser.Equality_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#equality_expr}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expr(MiniJavaParser.Equality_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#relational_expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expr(MiniJavaParser.Relational_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#relational_expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expr(MiniJavaParser.Relational_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#additive_expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expr(MiniJavaParser.Additive_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#additive_expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expr(MiniJavaParser.Additive_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#multiplicative_expr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expr(MiniJavaParser.Multiplicative_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#multiplicative_expr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expr(MiniJavaParser.Multiplicative_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(MiniJavaParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(MiniJavaParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expr(MiniJavaParser.Primary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#primary_expr}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expr(MiniJavaParser.Primary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#logical_or_op}.
	 * @param ctx the parse tree
	 */
	void enterLogical_or_op(MiniJavaParser.Logical_or_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#logical_or_op}.
	 * @param ctx the parse tree
	 */
	void exitLogical_or_op(MiniJavaParser.Logical_or_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#logical_and_op}.
	 * @param ctx the parse tree
	 */
	void enterLogical_and_op(MiniJavaParser.Logical_and_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#logical_and_op}.
	 * @param ctx the parse tree
	 */
	void exitLogical_and_op(MiniJavaParser.Logical_and_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#bitwise_or_op}.
	 * @param ctx the parse tree
	 */
	void enterBitwise_or_op(MiniJavaParser.Bitwise_or_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#bitwise_or_op}.
	 * @param ctx the parse tree
	 */
	void exitBitwise_or_op(MiniJavaParser.Bitwise_or_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#bitwise_and_op}.
	 * @param ctx the parse tree
	 */
	void enterBitwise_and_op(MiniJavaParser.Bitwise_and_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#bitwise_and_op}.
	 * @param ctx the parse tree
	 */
	void exitBitwise_and_op(MiniJavaParser.Bitwise_and_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#equality_op}.
	 * @param ctx the parse tree
	 */
	void enterEquality_op(MiniJavaParser.Equality_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#equality_op}.
	 * @param ctx the parse tree
	 */
	void exitEquality_op(MiniJavaParser.Equality_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#relational_op}.
	 * @param ctx the parse tree
	 */
	void enterRelational_op(MiniJavaParser.Relational_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#relational_op}.
	 * @param ctx the parse tree
	 */
	void exitRelational_op(MiniJavaParser.Relational_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#add_sub_op}.
	 * @param ctx the parse tree
	 */
	void enterAdd_sub_op(MiniJavaParser.Add_sub_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#add_sub_op}.
	 * @param ctx the parse tree
	 */
	void exitAdd_sub_op(MiniJavaParser.Add_sub_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#mul_div_op}.
	 * @param ctx the parse tree
	 */
	void enterMul_div_op(MiniJavaParser.Mul_div_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#mul_div_op}.
	 * @param ctx the parse tree
	 */
	void exitMul_div_op(MiniJavaParser.Mul_div_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#pre_cre_op}.
	 * @param ctx the parse tree
	 */
	void enterPre_cre_op(MiniJavaParser.Pre_cre_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#pre_cre_op}.
	 * @param ctx the parse tree
	 */
	void exitPre_cre_op(MiniJavaParser.Pre_cre_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#suf_cre_op}.
	 * @param ctx the parse tree
	 */
	void enterSuf_cre_op(MiniJavaParser.Suf_cre_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#suf_cre_op}.
	 * @param ctx the parse tree
	 */
	void exitSuf_cre_op(MiniJavaParser.Suf_cre_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void enterAssign_op(MiniJavaParser.Assign_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#assign_op}.
	 * @param ctx the parse tree
	 */
	void exitAssign_op(MiniJavaParser.Assign_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniJavaParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#access_mod}.
	 * @param ctx the parse tree
	 */
	void enterAccess_mod(MiniJavaParser.Access_modContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#access_mod}.
	 * @param ctx the parse tree
	 */
	void exitAccess_mod(MiniJavaParser.Access_modContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#int}.
	 * @param ctx the parse tree
	 */
	void enterInt(MiniJavaParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#int}.
	 * @param ctx the parse tree
	 */
	void exitInt(MiniJavaParser.IntContext ctx);
}