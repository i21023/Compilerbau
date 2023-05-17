// Generated from java-escape by ANTLR 4.11.1
package mmc.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniJavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, ACCES_MOD=17, 
		STATIC=18, VOID=19, NEW=20, THIS=21, LEFT_BRACE=22, RIGHT_BRACE=23, LEFT_BRACKET=24, 
		RIGHT_BRACKET=25, SEMICOLON=26, COMMA=27, EQUALS=28, ASSIGN=29, DOT=30, 
		NOT=31, IF=32, ELSE=33, WHILE=34, FOR=35, RETURN=36, INT=37, BOOLEAN=38, 
		CHAR=39, STRING=40, NULL=41, ID=42, WS=43, InlineComment=44, MultilineComment=45;
	public static final int
		RULE_program = 0, RULE_class_decl = 1, RULE_const_decl = 2, RULE_method_decl = 3, 
		RULE_field_decl = 4, RULE_parameter_list = 5, RULE_method_type = 6, RULE_statement_block = 7, 
		RULE_statement = 8, RULE_local_var_decl = 9, RULE_if_else_statement = 10, 
		RULE_else_statement = 11, RULE_while_statement = 12, RULE_for_statement = 13, 
		RULE_return_statement = 14, RULE_statement_expr = 15, RULE_method_call_statement = 16, 
		RULE_new_statement = 17, RULE_assign_statement = 18, RULE_cre_expr = 19, 
		RULE_inst_var = 20, RULE_expr = 21, RULE_binary_expr = 22, RULE_basic_expr = 23, 
		RULE_logical_expr = 24, RULE_calculate_expr = 25, RULE_value_calculate_expr = 26, 
		RULE_mul_div_expr = 27, RULE_calculate_op = 28, RULE_logical_op = 29, 
		RULE_add_sub_op = 30, RULE_mul_div_op = 31, RULE_cre_op = 32, RULE_type = 33, 
		RULE_main = 34, RULE_literal = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class_decl", "const_decl", "method_decl", "field_decl", "parameter_list", 
			"method_type", "statement_block", "statement", "local_var_decl", "if_else_statement", 
			"else_statement", "while_statement", "for_statement", "return_statement", 
			"statement_expr", "method_call_statement", "new_statement", "assign_statement", 
			"cre_expr", "inst_var", "expr", "binary_expr", "basic_expr", "logical_expr", 
			"calculate_expr", "value_calculate_expr", "mul_div_expr", "calculate_op", 
			"logical_op", "add_sub_op", "mul_div_op", "cre_op", "type", "main", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", 
			"'*'", "'/'", "'++'", "'--'", "'int'", "'boolean'", "'char'", "'String[] args'", 
			null, "'static'", "'void'", "'new'", "'this'", "'{'", "'}'", "'('", "')'", 
			"';'", "','", "'=='", "'='", "'.'", "'!'", "'if'", "'else'", "'while'", 
			"'for'", "'return'", null, null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "ACCES_MOD", "STATIC", "VOID", "NEW", "THIS", 
			"LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", "SEMICOLON", 
			"COMMA", "EQUALS", "ASSIGN", "DOT", "NOT", "IF", "ELSE", "WHILE", "FOR", 
			"RETURN", "INT", "BOOLEAN", "CHAR", "STRING", "NULL", "ID", "WS", "InlineComment", 
			"MultilineComment"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniJavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<Class_declContext> class_decl() {
			return getRuleContexts(Class_declContext.class);
		}
		public Class_declContext class_decl(int i) {
			return getRuleContext(Class_declContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==ACCES_MOD) {
				{
				{
				setState(72);
				class_decl();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(MiniJavaParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(MiniJavaParser.RIGHT_BRACE, 0); }
		public TerminalNode ACCES_MOD() { return getToken(MiniJavaParser.ACCES_MOD, 0); }
		public List<Const_declContext> const_decl() {
			return getRuleContexts(Const_declContext.class);
		}
		public Const_declContext const_decl(int i) {
			return getRuleContext(Const_declContext.class,i);
		}
		public List<Method_declContext> method_decl() {
			return getRuleContexts(Method_declContext.class);
		}
		public Method_declContext method_decl(int i) {
			return getRuleContext(Method_declContext.class,i);
		}
		public List<Field_declContext> field_decl() {
			return getRuleContexts(Field_declContext.class);
		}
		public Field_declContext field_decl(int i) {
			return getRuleContext(Field_declContext.class,i);
		}
		public Class_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterClass_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitClass_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitClass_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_declContext class_decl() throws RecognitionException {
		Class_declContext _localctx = new Class_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCES_MOD) {
				{
				setState(78);
				match(ACCES_MOD);
				}
			}

			setState(81);
			match(T__0);
			setState(82);
			match(ID);
			setState(83);
			match(LEFT_BRACE);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4398047485952L) != 0) {
				{
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(84);
					const_decl();
					}
					break;
				case 2:
					{
					setState(85);
					method_decl();
					}
					break;
				case 3:
					{
					setState(86);
					field_decl();
					}
					break;
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Const_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode ACCES_MOD() { return getToken(MiniJavaParser.ACCES_MOD, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Const_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterConst_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitConst_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitConst_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_declContext const_decl() throws RecognitionException {
		Const_declContext _localctx = new Const_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_const_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCES_MOD) {
				{
				setState(94);
				match(ACCES_MOD);
				}
			}

			setState(97);
			match(ID);
			setState(98);
			match(LEFT_BRACKET);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046568448L) != 0) {
				{
				setState(99);
				parameter_list();
				}
			}

			setState(102);
			match(RIGHT_BRACKET);
			setState(103);
			statement_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_declContext extends ParserRuleContext {
		public Method_typeContext method_type() {
			return getRuleContext(Method_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public TerminalNode ACCES_MOD() { return getToken(MiniJavaParser.ACCES_MOD, 0); }
		public TerminalNode STATIC() { return getToken(MiniJavaParser.STATIC, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethod_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethod_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCES_MOD) {
				{
				setState(105);
				match(ACCES_MOD);
				}
			}

			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(108);
				match(STATIC);
				}
			}

			setState(111);
			method_type();
			setState(112);
			match(ID);
			setState(113);
			match(LEFT_BRACKET);
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046568448L) != 0) {
					{
					setState(114);
					parameter_list();
					}
				}

				}
				break;
			case 2:
				{
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__15) {
					{
					setState(117);
					main();
					}
				}

				}
				break;
			}
			setState(122);
			match(RIGHT_BRACKET);
			setState(123);
			statement_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Field_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public TerminalNode ACCES_MOD() { return getToken(MiniJavaParser.ACCES_MOD, 0); }
		public TerminalNode STATIC() { return getToken(MiniJavaParser.STATIC, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(MiniJavaParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(MiniJavaParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public Field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterField_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitField_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitField_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_declContext field_decl() throws RecognitionException {
		Field_declContext _localctx = new Field_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCES_MOD) {
				{
				setState(125);
				match(ACCES_MOD);
				}
			}

			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(128);
				match(STATIC);
				}
			}

			setState(131);
			type();
			setState(132);
			match(ID);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(133);
				match(ASSIGN);
				setState(134);
				expr();
				}
			}

			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(137);
				match(COMMA);
				setState(138);
				match(ID);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(139);
					match(ASSIGN);
					setState(140);
					expr();
					}
				}

				}
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(148);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Parameter_listContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterParameter_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitParameter_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			type();
			setState(151);
			match(ID);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(152);
				match(COMMA);
				setState(153);
				type();
				setState(154);
				match(ID);
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_typeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(MiniJavaParser.VOID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Method_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethod_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethod_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethod_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_typeContext method_type() throws RecognitionException {
		Method_typeContext _localctx = new Method_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_method_type);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(VOID);
				}
				break;
			case T__12:
			case T__13:
			case T__14:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Statement_blockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(MiniJavaParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(MiniJavaParser.RIGHT_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatement_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatement_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatement_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(LEFT_BRACE);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 4660046919680L) != 0) {
				{
				{
				setState(166);
				statement();
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(172);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Local_var_declContext local_var_decl() {
			return getRuleContext(Local_var_declContext.class,0);
		}
		public If_else_statementContext if_else_statement() {
			return getRuleContext(If_else_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public Statement_exprContext statement_expr() {
			return getRuleContext(Statement_exprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				statement_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				local_var_decl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				if_else_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				while_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				for_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(179);
				return_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(180);
				statement_expr();
				setState(181);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Local_var_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Local_var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLocal_var_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLocal_var_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLocal_var_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_var_declContext local_var_decl() throws RecognitionException {
		Local_var_declContext _localctx = new Local_var_declContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_local_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			type();
			setState(186);
			match(ID);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(187);
				match(ASSIGN);
				setState(188);
				expr();
				}
			}

			setState(191);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_else_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public If_else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterIf_else_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitIf_else_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitIf_else_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_else_statementContext if_else_statement() throws RecognitionException {
		If_else_statementContext _localctx = new If_else_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_if_else_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(IF);
			setState(194);
			match(LEFT_BRACKET);
			setState(195);
			expr();
			setState(196);
			match(RIGHT_BRACKET);
			setState(197);
			statement_block();
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(198);
				else_statement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(MiniJavaParser.ELSE, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitElse_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitElse_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(ELSE);
			setState(202);
			statement_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitWhile_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitWhile_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(WHILE);
			setState(205);
			match(LEFT_BRACKET);
			setState(206);
			logical_expr();
			setState(207);
			match(RIGHT_BRACKET);
			setState(208);
			statement_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniJavaParser.FOR, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniJavaParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniJavaParser.SEMICOLON, i);
		}
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public List<Statement_exprContext> statement_expr() {
			return getRuleContexts(Statement_exprContext.class);
		}
		public Statement_exprContext statement_expr(int i) {
			return getRuleContext(Statement_exprContext.class,i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Local_var_declContext local_var_decl() {
			return getRuleContext(Local_var_declContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFor_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_for_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(FOR);
			setState(211);
			match(LEFT_BRACKET);
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(212);
				statement_expr();
				}
				break;
			case 2:
				{
				setState(213);
				local_var_decl();
				}
				break;
			}
			setState(216);
			match(SEMICOLON);
			setState(217);
			logical_expr();
			setState(218);
			match(SEMICOLON);
			setState(219);
			statement_expr();
			setState(220);
			match(RIGHT_BRACKET);
			setState(221);
			statement_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_statementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniJavaParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterReturn_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitReturn_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitReturn_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(RETURN);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 8660821481856L) != 0) {
				{
				setState(224);
				expr();
				}
			}

			setState(227);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Statement_exprContext extends ParserRuleContext {
		public Method_call_statementContext method_call_statement() {
			return getRuleContext(Method_call_statementContext.class,0);
		}
		public New_statementContext new_statement() {
			return getRuleContext(New_statementContext.class,0);
		}
		public Assign_statementContext assign_statement() {
			return getRuleContext(Assign_statementContext.class,0);
		}
		public Cre_exprContext cre_expr() {
			return getRuleContext(Cre_exprContext.class,0);
		}
		public Statement_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatement_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatement_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatement_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_exprContext statement_expr() throws RecognitionException {
		Statement_exprContext _localctx = new Statement_exprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement_expr);
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				method_call_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				new_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(231);
				assign_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				cre_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Method_call_statementContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Inst_varContext inst_var() {
			return getRuleContext(Inst_varContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public Method_call_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethod_call_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethod_call_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethod_call_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_call_statementContext method_call_statement() throws RecognitionException {
		Method_call_statementContext _localctx = new Method_call_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_method_call_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(235);
				inst_var();
				}
				break;
			case 2:
				{
				setState(236);
				match(ID);
				}
				break;
			}
			setState(239);
			match(LEFT_BRACKET);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 8660821481856L) != 0) {
				{
				setState(240);
				expr();
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(241);
					match(COMMA);
					setState(242);
					expr();
					}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(250);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class New_statementContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(MiniJavaParser.NEW, 0); }
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public New_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterNew_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitNew_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitNew_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_statementContext new_statement() throws RecognitionException {
		New_statementContext _localctx = new New_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_new_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(NEW);
			setState(253);
			match(ID);
			setState(254);
			match(LEFT_BRACKET);
			setState(255);
			expr();
			setState(256);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assign_statementContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Inst_varContext inst_var() {
			return getRuleContext(Inst_varContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Assign_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAssign_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAssign_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAssign_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_statementContext assign_statement() throws RecognitionException {
		Assign_statementContext _localctx = new Assign_statementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assign_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(258);
				inst_var();
				}
				break;
			case 2:
				{
				setState(259);
				match(ID);
				}
				break;
			}
			setState(262);
			match(ASSIGN);
			setState(263);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cre_exprContext extends ParserRuleContext {
		public Cre_opContext cre_op() {
			return getRuleContext(Cre_opContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public Inst_varContext inst_var() {
			return getRuleContext(Inst_varContext.class,0);
		}
		public Cre_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cre_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCre_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCre_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCre_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cre_exprContext cre_expr() throws RecognitionException {
		Cre_exprContext _localctx = new Cre_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cre_expr);
		try {
			setState(277);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				cre_op();
				setState(269);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(266);
					match(ID);
					}
					break;
				case 2:
					{
					setState(267);
					match(INT);
					}
					break;
				case 3:
					{
					setState(268);
					inst_var();
					}
					break;
				}
				}
				break;
			case THIS:
			case INT:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(274);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(271);
					match(ID);
					}
					break;
				case 2:
					{
					setState(272);
					match(INT);
					}
					break;
				case 3:
					{
					setState(273);
					inst_var();
					}
					break;
				}
				setState(276);
				cre_op();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Inst_varContext extends ParserRuleContext {
		public TerminalNode THIS() { return getToken(MiniJavaParser.THIS, 0); }
		public List<TerminalNode> DOT() { return getTokens(MiniJavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MiniJavaParser.DOT, i);
		}
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public Inst_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterInst_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitInst_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitInst_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inst_varContext inst_var() throws RecognitionException {
		Inst_varContext _localctx = new Inst_varContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_inst_var);
		int _la;
		try {
			int _alt;
			setState(295);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(THIS);
				setState(280);
				match(DOT);
				setState(282);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(281);
					match(ID);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THIS) {
					{
					setState(284);
					match(THIS);
					setState(285);
					match(DOT);
					}
				}

				setState(290); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(288);
						match(ID);
						setState(289);
						match(DOT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(292); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(294);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public Binary_exprContext binary_expr() {
			return getRuleContext(Binary_exprContext.class,0);
		}
		public Basic_exprContext basic_expr() {
			return getRuleContext(Basic_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr);
		try {
			setState(299);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				binary_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				basic_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Binary_exprContext extends ParserRuleContext {
		public Logical_exprContext logical_expr() {
			return getRuleContext(Logical_exprContext.class,0);
		}
		public Calculate_exprContext calculate_expr() {
			return getRuleContext(Calculate_exprContext.class,0);
		}
		public Binary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBinary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBinary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBinary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_exprContext binary_expr() throws RecognitionException {
		Binary_exprContext _localctx = new Binary_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_binary_expr);
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				logical_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
				calculate_expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Basic_exprContext extends ParserRuleContext {
		public TerminalNode THIS() { return getToken(MiniJavaParser.THIS, 0); }
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Inst_varContext inst_var() {
			return getRuleContext(Inst_varContext.class,0);
		}
		public Statement_exprContext statement_expr() {
			return getRuleContext(Statement_exprContext.class,0);
		}
		public TerminalNode NOT() { return getToken(MiniJavaParser.NOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Add_sub_opContext add_sub_op() {
			return getRuleContext(Add_sub_opContext.class,0);
		}
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Basic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basic_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBasic_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBasic_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBasic_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Basic_exprContext basic_expr() throws RecognitionException {
		Basic_exprContext _localctx = new Basic_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_basic_expr);
		try {
			setState(319);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(THIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				inst_var();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(308);
				statement_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(309);
				match(NOT);
				setState(310);
				expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(311);
				match(LEFT_BRACKET);
				setState(312);
				expr();
				setState(313);
				match(RIGHT_BRACKET);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(315);
				add_sub_op();
				setState(316);
				match(INT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(318);
				literal();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_exprContext extends ParserRuleContext {
		public Basic_exprContext basic_expr() {
			return getRuleContext(Basic_exprContext.class,0);
		}
		public List<Logical_opContext> logical_op() {
			return getRuleContexts(Logical_opContext.class);
		}
		public Logical_opContext logical_op(int i) {
			return getRuleContext(Logical_opContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Logical_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLogical_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLogical_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLogical_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_exprContext logical_expr() throws RecognitionException {
		Logical_exprContext _localctx = new Logical_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_logical_expr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			basic_expr();
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(322);
					logical_op();
					setState(323);
					expr();
					}
					} 
				}
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Calculate_exprContext extends ParserRuleContext {
		public Mul_div_exprContext mul_div_expr() {
			return getRuleContext(Mul_div_exprContext.class,0);
		}
		public Calculate_exprContext calculate_expr() {
			return getRuleContext(Calculate_exprContext.class,0);
		}
		public Add_sub_opContext add_sub_op() {
			return getRuleContext(Add_sub_opContext.class,0);
		}
		public Calculate_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculate_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCalculate_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCalculate_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCalculate_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Calculate_exprContext calculate_expr() throws RecognitionException {
		return calculate_expr(0);
	}

	private Calculate_exprContext calculate_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Calculate_exprContext _localctx = new Calculate_exprContext(_ctx, _parentState);
		Calculate_exprContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_calculate_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(331);
			mul_div_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(339);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Calculate_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_calculate_expr);
					setState(333);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(334);
					add_sub_op();
					setState(335);
					mul_div_expr(0);
					}
					} 
				}
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_calculate_exprContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Inst_varContext inst_var() {
			return getRuleContext(Inst_varContext.class,0);
		}
		public Method_call_statementContext method_call_statement() {
			return getRuleContext(Method_call_statementContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public Calculate_exprContext calculate_expr() {
			return getRuleContext(Calculate_exprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Cre_exprContext cre_expr() {
			return getRuleContext(Cre_exprContext.class,0);
		}
		public Value_calculate_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_calculate_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterValue_calculate_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitValue_calculate_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitValue_calculate_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_calculate_exprContext value_calculate_expr() throws RecognitionException {
		Value_calculate_exprContext _localctx = new Value_calculate_exprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_value_calculate_expr);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				inst_var();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(345);
				method_call_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(346);
				match(LEFT_BRACKET);
				setState(347);
				calculate_expr(0);
				setState(348);
				match(RIGHT_BRACKET);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(350);
				cre_expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mul_div_exprContext extends ParserRuleContext {
		public Value_calculate_exprContext value_calculate_expr() {
			return getRuleContext(Value_calculate_exprContext.class,0);
		}
		public Mul_div_exprContext mul_div_expr() {
			return getRuleContext(Mul_div_exprContext.class,0);
		}
		public Mul_div_opContext mul_div_op() {
			return getRuleContext(Mul_div_opContext.class,0);
		}
		public Mul_div_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul_div_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMul_div_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMul_div_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMul_div_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mul_div_exprContext mul_div_expr() throws RecognitionException {
		return mul_div_expr(0);
	}

	private Mul_div_exprContext mul_div_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Mul_div_exprContext _localctx = new Mul_div_exprContext(_ctx, _parentState);
		Mul_div_exprContext _prevctx = _localctx;
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_mul_div_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(354);
			value_calculate_expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(362);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Mul_div_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mul_div_expr);
					setState(356);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(357);
					mul_div_op();
					setState(358);
					value_calculate_expr();
					}
					} 
				}
				setState(364);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Calculate_opContext extends ParserRuleContext {
		public Mul_div_opContext mul_div_op() {
			return getRuleContext(Mul_div_opContext.class,0);
		}
		public Add_sub_opContext add_sub_op() {
			return getRuleContext(Add_sub_opContext.class,0);
		}
		public Calculate_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calculate_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCalculate_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCalculate_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCalculate_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Calculate_opContext calculate_op() throws RecognitionException {
		Calculate_opContext _localctx = new Calculate_opContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_calculate_op);
		try {
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(365);
				mul_div_op();
				}
				break;
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				add_sub_op();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Logical_opContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(MiniJavaParser.EQUALS, 0); }
		public Logical_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLogical_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLogical_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLogical_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_opContext logical_op() throws RecognitionException {
		Logical_opContext _localctx = new Logical_opContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_logical_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 268435580L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Add_sub_opContext extends ParserRuleContext {
		public Add_sub_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add_sub_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAdd_sub_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAdd_sub_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAdd_sub_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Add_sub_opContext add_sub_op() throws RecognitionException {
		Add_sub_opContext _localctx = new Add_sub_opContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_add_sub_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mul_div_opContext extends ParserRuleContext {
		public Mul_div_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul_div_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMul_div_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMul_div_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMul_div_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mul_div_opContext mul_div_op() throws RecognitionException {
		Mul_div_opContext _localctx = new Mul_div_opContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_mul_div_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==T__9) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Cre_opContext extends ParserRuleContext {
		public Cre_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cre_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCre_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCre_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCre_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cre_opContext cre_op() throws RecognitionException {
		Cre_opContext _localctx = new Cre_opContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_cre_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_la = _input.LA(1);
			if ( !(_la==T__10 || _la==T__11) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4398046568448L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(T__15);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public TerminalNode BOOLEAN() { return getToken(MiniJavaParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(MiniJavaParser.CHAR, 0); }
		public TerminalNode STRING() { return getToken(MiniJavaParser.STRING, 0); }
		public TerminalNode NULL() { return getToken(MiniJavaParser.NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 4260607557632L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 25:
			return calculate_expr_sempred((Calculate_exprContext)_localctx, predIndex);
		case 27:
			return mul_div_expr_sempred((Mul_div_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean calculate_expr_sempred(Calculate_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mul_div_expr_sempred(Mul_div_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0180\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0001\u0000\u0005\u0000J\b\u0000\n\u0000\f\u0000M\t\u0000\u0001"+
		"\u0001\u0003\u0001P\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001X\b\u0001\n\u0001\f\u0001[\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0003\u0002`\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002e\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0003\u0003k\b\u0003\u0001\u0003\u0003"+
		"\u0003n\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003t\b\u0003\u0001\u0003\u0003\u0003w\b\u0003\u0003\u0003y\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0003\u0004\u007f\b\u0004"+
		"\u0001\u0004\u0003\u0004\u0082\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u0088\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u008e\b\u0004\u0005\u0004\u0090\b\u0004\n\u0004"+
		"\f\u0004\u0093\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u009d\b\u0005"+
		"\n\u0005\f\u0005\u00a0\t\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u00a4"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0005\u0007\u00a8\b\u0007\n\u0007\f\u0007"+
		"\u00ab\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b8\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00be\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c8\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0003\r\u00d7\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u00e2\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00ea\b\u000f\u0001\u0010\u0001\u0010\u0003\u0010\u00ee\b\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00f4\b\u0010"+
		"\n\u0010\f\u0010\u00f7\t\u0010\u0003\u0010\u00f9\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u0105\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u010e\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0113"+
		"\b\u0013\u0001\u0013\u0003\u0013\u0116\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u011b\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014"+
		"\u011f\b\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u0123\b\u0014\u000b"+
		"\u0014\f\u0014\u0124\u0001\u0014\u0003\u0014\u0128\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u012c\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u0130\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0140\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0146\b\u0018\n\u0018"+
		"\f\u0018\u0149\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0152\b\u0019\n\u0019"+
		"\f\u0019\u0155\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0160\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0005\u001b\u0169\b\u001b\n\u001b\f\u001b\u016c"+
		"\t\u001b\u0001\u001c\u0001\u001c\u0003\u001c\u0170\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0000\u000226$\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDF\u0000\u0006\u0002\u0000\u0002\u0006\u001c"+
		"\u001c\u0001\u0000\u0007\b\u0001\u0000\t\n\u0001\u0000\u000b\f\u0002\u0000"+
		"\r\u000f**\u0001\u0000%)\u019b\u0000K\u0001\u0000\u0000\u0000\u0002O\u0001"+
		"\u0000\u0000\u0000\u0004_\u0001\u0000\u0000\u0000\u0006j\u0001\u0000\u0000"+
		"\u0000\b~\u0001\u0000\u0000\u0000\n\u0096\u0001\u0000\u0000\u0000\f\u00a3"+
		"\u0001\u0000\u0000\u0000\u000e\u00a5\u0001\u0000\u0000\u0000\u0010\u00b7"+
		"\u0001\u0000\u0000\u0000\u0012\u00b9\u0001\u0000\u0000\u0000\u0014\u00c1"+
		"\u0001\u0000\u0000\u0000\u0016\u00c9\u0001\u0000\u0000\u0000\u0018\u00cc"+
		"\u0001\u0000\u0000\u0000\u001a\u00d2\u0001\u0000\u0000\u0000\u001c\u00df"+
		"\u0001\u0000\u0000\u0000\u001e\u00e9\u0001\u0000\u0000\u0000 \u00ed\u0001"+
		"\u0000\u0000\u0000\"\u00fc\u0001\u0000\u0000\u0000$\u0104\u0001\u0000"+
		"\u0000\u0000&\u0115\u0001\u0000\u0000\u0000(\u0127\u0001\u0000\u0000\u0000"+
		"*\u012b\u0001\u0000\u0000\u0000,\u012f\u0001\u0000\u0000\u0000.\u013f"+
		"\u0001\u0000\u0000\u00000\u0141\u0001\u0000\u0000\u00002\u014a\u0001\u0000"+
		"\u0000\u00004\u015f\u0001\u0000\u0000\u00006\u0161\u0001\u0000\u0000\u0000"+
		"8\u016f\u0001\u0000\u0000\u0000:\u0171\u0001\u0000\u0000\u0000<\u0173"+
		"\u0001\u0000\u0000\u0000>\u0175\u0001\u0000\u0000\u0000@\u0177\u0001\u0000"+
		"\u0000\u0000B\u0179\u0001\u0000\u0000\u0000D\u017b\u0001\u0000\u0000\u0000"+
		"F\u017d\u0001\u0000\u0000\u0000HJ\u0003\u0002\u0001\u0000IH\u0001\u0000"+
		"\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000L\u0001\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000"+
		"\u0000NP\u0005\u0011\u0000\u0000ON\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000PQ\u0001\u0000\u0000\u0000QR\u0005\u0001\u0000\u0000RS\u0005"+
		"*\u0000\u0000SY\u0005\u0016\u0000\u0000TX\u0003\u0004\u0002\u0000UX\u0003"+
		"\u0006\u0003\u0000VX\u0003\b\u0004\u0000WT\u0001\u0000\u0000\u0000WU\u0001"+
		"\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000"+
		"YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000"+
		"\u0000[Y\u0001\u0000\u0000\u0000\\]\u0005\u0017\u0000\u0000]\u0003\u0001"+
		"\u0000\u0000\u0000^`\u0005\u0011\u0000\u0000_^\u0001\u0000\u0000\u0000"+
		"_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0005*\u0000\u0000"+
		"bd\u0005\u0018\u0000\u0000ce\u0003\n\u0005\u0000dc\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0005\u0019\u0000"+
		"\u0000gh\u0003\u000e\u0007\u0000h\u0005\u0001\u0000\u0000\u0000ik\u0005"+
		"\u0011\u0000\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"km\u0001\u0000\u0000\u0000ln\u0005\u0012\u0000\u0000ml\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000op\u0003\f\u0006"+
		"\u0000pq\u0005*\u0000\u0000qx\u0005\u0018\u0000\u0000rt\u0003\n\u0005"+
		"\u0000sr\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000ty\u0001\u0000"+
		"\u0000\u0000uw\u0003D\"\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000wy\u0001\u0000\u0000\u0000xs\u0001\u0000\u0000\u0000xv\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u0019\u0000\u0000"+
		"{|\u0003\u000e\u0007\u0000|\u0007\u0001\u0000\u0000\u0000}\u007f\u0005"+
		"\u0011\u0000\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080\u0082\u0005\u0012\u0000"+
		"\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0003B!\u0000\u0084"+
		"\u0087\u0005*\u0000\u0000\u0085\u0086\u0005\u001d\u0000\u0000\u0086\u0088"+
		"\u0003*\u0015\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0091\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\u001b\u0000\u0000\u008a\u008d\u0005*\u0000\u0000\u008b\u008c\u0005\u001d"+
		"\u0000\u0000\u008c\u008e\u0003*\u0015\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000"+
		"\u0000\u008f\u0089\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000"+
		"\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0005\u001a\u0000\u0000\u0095\t\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0003B!\u0000\u0097\u009e\u0005*\u0000\u0000\u0098\u0099"+
		"\u0005\u001b\u0000\u0000\u0099\u009a\u0003B!\u0000\u009a\u009b\u0005*"+
		"\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u0098\u0001\u0000"+
		"\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000"+
		"\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u000b\u0001\u0000"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0005\u0013"+
		"\u0000\u0000\u00a2\u00a4\u0003B!\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\r\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a9\u0005\u0016\u0000\u0000\u00a6\u00a8\u0003\u0010\b\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0005\u0017\u0000\u0000\u00ad\u000f\u0001\u0000\u0000\u0000\u00ae\u00b8"+
		"\u0003\u000e\u0007\u0000\u00af\u00b8\u0003\u0012\t\u0000\u00b0\u00b8\u0003"+
		"\u0014\n\u0000\u00b1\u00b8\u0003\u0018\f\u0000\u00b2\u00b8\u0003\u001a"+
		"\r\u0000\u00b3\u00b8\u0003\u001c\u000e\u0000\u00b4\u00b5\u0003\u001e\u000f"+
		"\u0000\u00b5\u00b6\u0005\u001a\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b7\u00ae\u0001\u0000\u0000\u0000\u00b7\u00af\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b0\u0001\u0000\u0000\u0000\u00b7\u00b1\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b2\u0001\u0000\u0000\u0000\u00b7\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b8\u0011\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0003B!\u0000\u00ba\u00bd\u0005*\u0000\u0000\u00bb"+
		"\u00bc\u0005\u001d\u0000\u0000\u00bc\u00be\u0003*\u0015\u0000\u00bd\u00bb"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u001a\u0000\u0000\u00c0\u0013"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0005 \u0000\u0000\u00c2\u00c3\u0005"+
		"\u0018\u0000\u0000\u00c3\u00c4\u0003*\u0015\u0000\u00c4\u00c5\u0005\u0019"+
		"\u0000\u0000\u00c5\u00c7\u0003\u000e\u0007\u0000\u00c6\u00c8\u0003\u0016"+
		"\u000b\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c8\u0015\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005!\u0000"+
		"\u0000\u00ca\u00cb\u0003\u000e\u0007\u0000\u00cb\u0017\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0005\"\u0000\u0000\u00cd\u00ce\u0005\u0018\u0000\u0000"+
		"\u00ce\u00cf\u00030\u0018\u0000\u00cf\u00d0\u0005\u0019\u0000\u0000\u00d0"+
		"\u00d1\u0003\u000e\u0007\u0000\u00d1\u0019\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0005#\u0000\u0000\u00d3\u00d6\u0005\u0018\u0000\u0000\u00d4\u00d7"+
		"\u0003\u001e\u000f\u0000\u00d5\u00d7\u0003\u0012\t\u0000\u00d6\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u00d8\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0005\u001a\u0000\u0000\u00d9\u00da\u0003"+
		"0\u0018\u0000\u00da\u00db\u0005\u001a\u0000\u0000\u00db\u00dc\u0003\u001e"+
		"\u000f\u0000\u00dc\u00dd\u0005\u0019\u0000\u0000\u00dd\u00de\u0003\u000e"+
		"\u0007\u0000\u00de\u001b\u0001\u0000\u0000\u0000\u00df\u00e1\u0005$\u0000"+
		"\u0000\u00e0\u00e2\u0003*\u0015\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e4\u0005\u001a\u0000\u0000\u00e4\u001d\u0001\u0000\u0000\u0000"+
		"\u00e5\u00ea\u0003 \u0010\u0000\u00e6\u00ea\u0003\"\u0011\u0000\u00e7"+
		"\u00ea\u0003$\u0012\u0000\u00e8\u00ea\u0003&\u0013\u0000\u00e9\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e9\u00e6\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00ea\u001f\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ee\u0003(\u0014\u0000\u00ec\u00ee\u0005*\u0000"+
		"\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f8\u0005\u0018\u0000"+
		"\u0000\u00f0\u00f5\u0003*\u0015\u0000\u00f1\u00f2\u0005\u001b\u0000\u0000"+
		"\u00f2\u00f4\u0003*\u0015\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000\u0000\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f0\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fb\u0005\u0019\u0000\u0000\u00fb!\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0005\u0014\u0000\u0000\u00fd\u00fe\u0005*\u0000\u0000\u00fe\u00ff\u0005"+
		"\u0018\u0000\u0000\u00ff\u0100\u0003*\u0015\u0000\u0100\u0101\u0005\u0019"+
		"\u0000\u0000\u0101#\u0001\u0000\u0000\u0000\u0102\u0105\u0003(\u0014\u0000"+
		"\u0103\u0105\u0005*\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0104"+
		"\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0005\u001d\u0000\u0000\u0107\u0108\u0003*\u0015\u0000\u0108%\u0001"+
		"\u0000\u0000\u0000\u0109\u010d\u0003@ \u0000\u010a\u010e\u0005*\u0000"+
		"\u0000\u010b\u010e\u0005%\u0000\u0000\u010c\u010e\u0003(\u0014\u0000\u010d"+
		"\u010a\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d"+
		"\u010c\u0001\u0000\u0000\u0000\u010e\u0116\u0001\u0000\u0000\u0000\u010f"+
		"\u0113\u0005*\u0000\u0000\u0110\u0113\u0005%\u0000\u0000\u0111\u0113\u0003"+
		"(\u0014\u0000\u0112\u010f\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000"+
		"\u0000\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000"+
		"\u0000\u0000\u0114\u0116\u0003@ \u0000\u0115\u0109\u0001\u0000\u0000\u0000"+
		"\u0115\u0112\u0001\u0000\u0000\u0000\u0116\'\u0001\u0000\u0000\u0000\u0117"+
		"\u0118\u0005\u0015\u0000\u0000\u0118\u011a\u0005\u001e\u0000\u0000\u0119"+
		"\u011b\u0005*\u0000\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\u0001\u0000\u0000\u0000\u011b\u0128\u0001\u0000\u0000\u0000\u011c\u011d"+
		"\u0005\u0015\u0000\u0000\u011d\u011f\u0005\u001e\u0000\u0000\u011e\u011c"+
		"\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0122"+
		"\u0001\u0000\u0000\u0000\u0120\u0121\u0005*\u0000\u0000\u0121\u0123\u0005"+
		"\u001e\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0124\u0001"+
		"\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001"+
		"\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0128\u0005"+
		"*\u0000\u0000\u0127\u0117\u0001\u0000\u0000\u0000\u0127\u011e\u0001\u0000"+
		"\u0000\u0000\u0128)\u0001\u0000\u0000\u0000\u0129\u012c\u0003,\u0016\u0000"+
		"\u012a\u012c\u0003.\u0017\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b"+
		"\u012a\u0001\u0000\u0000\u0000\u012c+\u0001\u0000\u0000\u0000\u012d\u0130"+
		"\u00030\u0018\u0000\u012e\u0130\u00032\u0019\u0000\u012f\u012d\u0001\u0000"+
		"\u0000\u0000\u012f\u012e\u0001\u0000\u0000\u0000\u0130-\u0001\u0000\u0000"+
		"\u0000\u0131\u0140\u0005\u0015\u0000\u0000\u0132\u0140\u0005*\u0000\u0000"+
		"\u0133\u0140\u0003(\u0014\u0000\u0134\u0140\u0003\u001e\u000f\u0000\u0135"+
		"\u0136\u0005\u001f\u0000\u0000\u0136\u0140\u0003*\u0015\u0000\u0137\u0138"+
		"\u0005\u0018\u0000\u0000\u0138\u0139\u0003*\u0015\u0000\u0139\u013a\u0005"+
		"\u0019\u0000\u0000\u013a\u0140\u0001\u0000\u0000\u0000\u013b\u013c\u0003"+
		"<\u001e\u0000\u013c\u013d\u0005%\u0000\u0000\u013d\u0140\u0001\u0000\u0000"+
		"\u0000\u013e\u0140\u0003F#\u0000\u013f\u0131\u0001\u0000\u0000\u0000\u013f"+
		"\u0132\u0001\u0000\u0000\u0000\u013f\u0133\u0001\u0000\u0000\u0000\u013f"+
		"\u0134\u0001\u0000\u0000\u0000\u013f\u0135\u0001\u0000\u0000\u0000\u013f"+
		"\u0137\u0001\u0000\u0000\u0000\u013f\u013b\u0001\u0000\u0000\u0000\u013f"+
		"\u013e\u0001\u0000\u0000\u0000\u0140/\u0001\u0000\u0000\u0000\u0141\u0147"+
		"\u0003.\u0017\u0000\u0142\u0143\u0003:\u001d\u0000\u0143\u0144\u0003*"+
		"\u0015\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145\u0142\u0001\u0000"+
		"\u0000\u0000\u0146\u0149\u0001\u0000\u0000\u0000\u0147\u0145\u0001\u0000"+
		"\u0000\u0000\u0147\u0148\u0001\u0000\u0000\u0000\u01481\u0001\u0000\u0000"+
		"\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u014a\u014b\u0006\u0019\uffff"+
		"\uffff\u0000\u014b\u014c\u00036\u001b\u0000\u014c\u0153\u0001\u0000\u0000"+
		"\u0000\u014d\u014e\n\u0002\u0000\u0000\u014e\u014f\u0003<\u001e\u0000"+
		"\u014f\u0150\u00036\u001b\u0000\u0150\u0152\u0001\u0000\u0000\u0000\u0151"+
		"\u014d\u0001\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153"+
		"\u0151\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154"+
		"3\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156\u0160"+
		"\u0005%\u0000\u0000\u0157\u0160\u0005*\u0000\u0000\u0158\u0160\u0003("+
		"\u0014\u0000\u0159\u0160\u0003 \u0010\u0000\u015a\u015b\u0005\u0018\u0000"+
		"\u0000\u015b\u015c\u00032\u0019\u0000\u015c\u015d\u0005\u0019\u0000\u0000"+
		"\u015d\u0160\u0001\u0000\u0000\u0000\u015e\u0160\u0003&\u0013\u0000\u015f"+
		"\u0156\u0001\u0000\u0000\u0000\u015f\u0157\u0001\u0000\u0000\u0000\u015f"+
		"\u0158\u0001\u0000\u0000\u0000\u015f\u0159\u0001\u0000\u0000\u0000\u015f"+
		"\u015a\u0001\u0000\u0000\u0000\u015f\u015e\u0001\u0000\u0000\u0000\u0160"+
		"5\u0001\u0000\u0000\u0000\u0161\u0162\u0006\u001b\uffff\uffff\u0000\u0162"+
		"\u0163\u00034\u001a\u0000\u0163\u016a\u0001\u0000\u0000\u0000\u0164\u0165"+
		"\n\u0002\u0000\u0000\u0165\u0166\u0003>\u001f\u0000\u0166\u0167\u0003"+
		"4\u001a\u0000\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u0164\u0001\u0000"+
		"\u0000\u0000\u0169\u016c\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000"+
		"\u0000\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b7\u0001\u0000\u0000"+
		"\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u0170\u0003>\u001f\u0000"+
		"\u016e\u0170\u0003<\u001e\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f"+
		"\u016e\u0001\u0000\u0000\u0000\u01709\u0001\u0000\u0000\u0000\u0171\u0172"+
		"\u0007\u0000\u0000\u0000\u0172;\u0001\u0000\u0000\u0000\u0173\u0174\u0007"+
		"\u0001\u0000\u0000\u0174=\u0001\u0000\u0000\u0000\u0175\u0176\u0007\u0002"+
		"\u0000\u0000\u0176?\u0001\u0000\u0000\u0000\u0177\u0178\u0007\u0003\u0000"+
		"\u0000\u0178A\u0001\u0000\u0000\u0000\u0179\u017a\u0007\u0004\u0000\u0000"+
		"\u017aC\u0001\u0000\u0000\u0000\u017b\u017c\u0005\u0010\u0000\u0000\u017c"+
		"E\u0001\u0000\u0000\u0000\u017d\u017e\u0007\u0005\u0000\u0000\u017eG\u0001"+
		"\u0000\u0000\u0000,KOWY_djmsvx~\u0081\u0087\u008d\u0091\u009e\u00a3\u00a9"+
		"\u00b7\u00bd\u00c7\u00d6\u00e1\u00e9\u00ed\u00f5\u00f8\u0104\u010d\u0112"+
		"\u0115\u011a\u011e\u0124\u0127\u012b\u012f\u013f\u0147\u0153\u015f\u016a"+
		"\u016f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}