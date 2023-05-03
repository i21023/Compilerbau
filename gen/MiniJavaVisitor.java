// Generated from C:/Users/nina-/Documents/Programmieren/viertes-Semester/src/main/parser\MiniJava.g4 by ANTLR 4.12.0
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
	 * Visit a parse tree produced by {@link MiniJavaParser#class_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_decl(MiniJavaParser.Class_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#field_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField_decl(MiniJavaParser.Field_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#method_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_decl(MiniJavaParser.Method_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#constructor_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor_decl(MiniJavaParser.Constructor_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(MiniJavaParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(MiniJavaParser.Parameter_listContext ctx);
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
	 * Visit a parse tree produced by {@link MiniJavaParser#method_call_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_call_statement(MiniJavaParser.Method_call_statementContext ctx);
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
	 * Visit a parse tree produced by {@link MiniJavaParser#new_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNew_statement(MiniJavaParser.New_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#assign_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_statement(MiniJavaParser.Assign_statementContext ctx);
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
	 * Visit a parse tree produced by {@link MiniJavaParser#binary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_expr(MiniJavaParser.Binary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#method_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod_type(MiniJavaParser.Method_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(MiniJavaParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(MiniJavaParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniJavaParser.TypeContext ctx);
}