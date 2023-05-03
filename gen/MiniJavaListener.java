// Generated from C:/Users/nina-/Documents/Programmieren/viertes-Semester/src/main/parser\MiniJava.g4 by ANTLR 4.12.0
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
	 * Enter a parse tree produced by {@link MiniJavaParser#constructor_decl}.
	 * @param ctx the parse tree
	 */
	void enterConstructor_decl(MiniJavaParser.Constructor_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#constructor_decl}.
	 * @param ctx the parse tree
	 */
	void exitConstructor_decl(MiniJavaParser.Constructor_declContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#cre_expr}.
	 * @param ctx the parse tree
	 */
	void enterCre_expr(MiniJavaParser.Cre_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#cre_expr}.
	 * @param ctx the parse tree
	 */
	void exitCre_expr(MiniJavaParser.Cre_exprContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#binary_expr}.
	 * @param ctx the parse tree
	 */
	void enterBinary_expr(MiniJavaParser.Binary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#binary_expr}.
	 * @param ctx the parse tree
	 */
	void exitBinary_expr(MiniJavaParser.Binary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#basic_expr}.
	 * @param ctx the parse tree
	 */
	void enterBasic_expr(MiniJavaParser.Basic_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#basic_expr}.
	 * @param ctx the parse tree
	 */
	void exitBasic_expr(MiniJavaParser.Basic_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogical_expr(MiniJavaParser.Logical_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#logical_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogical_expr(MiniJavaParser.Logical_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#calculate_expr}.
	 * @param ctx the parse tree
	 */
	void enterCalculate_expr(MiniJavaParser.Calculate_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#calculate_expr}.
	 * @param ctx the parse tree
	 */
	void exitCalculate_expr(MiniJavaParser.Calculate_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#value_calculate_expr}.
	 * @param ctx the parse tree
	 */
	void enterValue_calculate_expr(MiniJavaParser.Value_calculate_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#value_calculate_expr}.
	 * @param ctx the parse tree
	 */
	void exitValue_calculate_expr(MiniJavaParser.Value_calculate_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#mul_div_expr}.
	 * @param ctx the parse tree
	 */
	void enterMul_div_expr(MiniJavaParser.Mul_div_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#mul_div_expr}.
	 * @param ctx the parse tree
	 */
	void exitMul_div_expr(MiniJavaParser.Mul_div_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#calculate_op}.
	 * @param ctx the parse tree
	 */
	void enterCalculate_op(MiniJavaParser.Calculate_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#calculate_op}.
	 * @param ctx the parse tree
	 */
	void exitCalculate_op(MiniJavaParser.Calculate_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#logical_op}.
	 * @param ctx the parse tree
	 */
	void enterLogical_op(MiniJavaParser.Logical_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#logical_op}.
	 * @param ctx the parse tree
	 */
	void exitLogical_op(MiniJavaParser.Logical_opContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#cre_op}.
	 * @param ctx the parse tree
	 */
	void enterCre_op(MiniJavaParser.Cre_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#cre_op}.
	 * @param ctx the parse tree
	 */
	void exitCre_op(MiniJavaParser.Cre_opContext ctx);
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
	 * Enter a parse tree produced by {@link MiniJavaParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(MiniJavaParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(MiniJavaParser.MainContext ctx);
}