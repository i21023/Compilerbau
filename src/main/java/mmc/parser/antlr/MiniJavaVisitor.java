// Generated from java-escape by ANTLR 4.11.1
package mmc.parser.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniJavaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#public_class_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPublic_class_decl(MiniJavaParser.Public_class_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#class_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_decl(MiniJavaParser.Class_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#const_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_decl(MiniJavaParser.Const_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#method_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_decl(MiniJavaParser.Method_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#main_method_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_method_decl(MiniJavaParser.Main_method_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#string_args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_args(MiniJavaParser.String_argsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_decl(MiniJavaParser.Field_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#field_decl_concat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_decl_concat(MiniJavaParser.Field_decl_concatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(MiniJavaParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_type(MiniJavaParser.Method_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniJavaParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_block(MiniJavaParser.Statement_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniJavaParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#local_var_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_var_decl(MiniJavaParser.Local_var_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#local_var_decl_concat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocal_var_decl_concat(MiniJavaParser.Local_var_decl_concatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#if_else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_else_statement(MiniJavaParser.If_else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(MiniJavaParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(MiniJavaParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(MiniJavaParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_init(MiniJavaParser.For_initContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#for_statement_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement_expr(MiniJavaParser.For_statement_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(MiniJavaParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#statement_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_expr(MiniJavaParser.Statement_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#method_call_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call_statement(MiniJavaParser.Method_call_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#method_owner_prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_owner_prefix(MiniJavaParser.Method_owner_prefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#method_chain}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_chain(MiniJavaParser.Method_chainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#new_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_statement(MiniJavaParser.New_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(MiniJavaParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assign_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_statement(MiniJavaParser.Assign_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#crement_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrement_statement(MiniJavaParser.Crement_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#inst_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst_var(MiniJavaParser.Inst_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MiniJavaParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#logical_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or_expr(MiniJavaParser.Logical_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#logical_and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and_expr(MiniJavaParser.Logical_and_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#bitwise_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_or_expr(MiniJavaParser.Bitwise_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#bitwise_and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_and_expr(MiniJavaParser.Bitwise_and_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#equality_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expr(MiniJavaParser.Equality_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#relational_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expr(MiniJavaParser.Relational_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#additive_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expr(MiniJavaParser.Additive_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#multiplicative_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expr(MiniJavaParser.Multiplicative_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#unary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(MiniJavaParser.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#primary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expr(MiniJavaParser.Primary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#logical_or_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or_op(MiniJavaParser.Logical_or_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#logical_and_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and_op(MiniJavaParser.Logical_and_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#bitwise_or_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_or_op(MiniJavaParser.Bitwise_or_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#bitwise_and_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwise_and_op(MiniJavaParser.Bitwise_and_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#equality_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_op(MiniJavaParser.Equality_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#relational_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_op(MiniJavaParser.Relational_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#add_sub_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_sub_op(MiniJavaParser.Add_sub_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#mul_div_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul_div_op(MiniJavaParser.Mul_div_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#pre_cre_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPre_cre_op(MiniJavaParser.Pre_cre_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#suf_cre_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuf_cre_op(MiniJavaParser.Suf_cre_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assign_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_op(MiniJavaParser.Assign_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#access_mod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccess_mod(MiniJavaParser.Access_modContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(MiniJavaParser.IntContext ctx);
}