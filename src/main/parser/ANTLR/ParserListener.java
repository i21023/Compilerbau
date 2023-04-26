// Generated from C:/Users/nina-/Documents/Programmieren/viertes-Semester/src/main/parser\MiniJava.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParserParser}.
 */
public interface ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ParserParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(ParserParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(ParserParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ParserParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ParserParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ParserParser.ExprContext ctx);
}