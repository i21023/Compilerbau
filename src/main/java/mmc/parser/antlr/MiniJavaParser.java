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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		ACCES_MOD=32, STATIC=33, VOID=34, NEW=35, THIS=36, LEFT_BRACE=37, RIGHT_BRACE=38, 
		LEFT_BRACKET=39, RIGHT_BRACKET=40, SEMICOLON=41, COMMA=42, EQUALS=43, 
		ASSIGN=44, DOT=45, NOT=46, IF=47, ELSE=48, WHILE=49, FOR=50, RETURN=51, 
		INT=52, BOOLEAN=53, CHAR=54, STRING=55, NULL=56, ID=57, WS=58, InlineComment=59, 
		MultilineComment=60;
	public static final int
		RULE_program = 0, RULE_public_class_decl = 1, RULE_class_decl = 2, RULE_const_decl = 3, 
		RULE_method_decl = 4, RULE_main_method_decl = 5, RULE_field_decl = 6, 
		RULE_field_decl_concat = 7, RULE_parameter_list = 8, RULE_method_type = 9, 
		RULE_statement_block = 10, RULE_statement = 11, RULE_local_var_decl = 12, 
		RULE_local_var_decl_concat = 13, RULE_if_else_statement = 14, RULE_else_statement = 15, 
		RULE_while_statement = 16, RULE_for_statement = 17, RULE_for_init = 18, 
		RULE_for_statement_expr = 19, RULE_return_statement = 20, RULE_statement_expr = 21, 
		RULE_method_call_statement = 22, RULE_method_owner_prefix = 23, RULE_method_chain = 24, 
		RULE_new_statement = 25, RULE_argumentList = 26, RULE_assign_statement = 27, 
		RULE_crement_statement = 28, RULE_inst_var = 29, RULE_expr = 30, RULE_logical_or_expr = 31, 
		RULE_logical_and_expr = 32, RULE_bitwise_or_expr = 33, RULE_bitwise_and_expr = 34, 
		RULE_equality_expr = 35, RULE_relational_expr = 36, RULE_additive_expr = 37, 
		RULE_multiplicative_expr = 38, RULE_unary_expr = 39, RULE_primary_expr = 40, 
		RULE_logical_or_op = 41, RULE_logical_and_op = 42, RULE_bitwise_or_op = 43, 
		RULE_bitwise_and_op = 44, RULE_equality_op = 45, RULE_relational_op = 46, 
		RULE_add_sub_op = 47, RULE_mul_div_op = 48, RULE_pre_cre_op = 49, RULE_suf_cre_op = 50, 
		RULE_assign_op = 51, RULE_type = 52, RULE_literal = 53, RULE_int = 54;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "public_class_decl", "class_decl", "const_decl", "method_decl", 
			"main_method_decl", "field_decl", "field_decl_concat", "parameter_list", 
			"method_type", "statement_block", "statement", "local_var_decl", "local_var_decl_concat", 
			"if_else_statement", "else_statement", "while_statement", "for_statement", 
			"for_init", "for_statement_expr", "return_statement", "statement_expr", 
			"method_call_statement", "method_owner_prefix", "method_chain", "new_statement", 
			"argumentList", "assign_statement", "crement_statement", "inst_var", 
			"expr", "logical_or_expr", "logical_and_expr", "bitwise_or_expr", "bitwise_and_expr", 
			"equality_expr", "relational_expr", "additive_expr", "multiplicative_expr", 
			"unary_expr", "primary_expr", "logical_or_op", "logical_and_op", "bitwise_or_op", 
			"bitwise_and_op", "equality_op", "relational_op", "add_sub_op", "mul_div_op", 
			"pre_cre_op", "suf_cre_op", "assign_op", "type", "literal", "int"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'package'", "'public'", "'class'", "'main'", "'String'", "'['", 
			"']'", "'args'", "'||'", "'&&'", "'|'", "'&'", "'!='", "'<'", "'>'", 
			"'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'++'", "'--'", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'int'", "'boolean'", "'char'", null, "'static'", 
			"'void'", "'new'", "'this'", "'{'", "'}'", "'('", "')'", "';'", "','", 
			"'=='", "'='", "'.'", "'!'", "'if'", "'else'", "'while'", "'for'", "'return'", 
			null, null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "ACCES_MOD", "STATIC", 
			"VOID", "NEW", "THIS", "LEFT_BRACE", "RIGHT_BRACE", "LEFT_BRACKET", "RIGHT_BRACKET", 
			"SEMICOLON", "COMMA", "EQUALS", "ASSIGN", "DOT", "NOT", "IF", "ELSE", 
			"WHILE", "FOR", "RETURN", "INT", "BOOLEAN", "CHAR", "STRING", "NULL", 
			"ID", "WS", "InlineComment", "MultilineComment"
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
		public Public_class_declContext public_class_decl() {
			return getRuleContext(Public_class_declContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public List<TerminalNode> DOT() { return getTokens(MiniJavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MiniJavaParser.DOT, i);
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
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(110);
				match(T__0);
				setState(111);
				match(ID);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(112);
					match(DOT);
					setState(113);
					match(ID);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				match(SEMICOLON);
				}
			}

			setState(122);
			public_class_decl();
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
	public static class Public_class_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(MiniJavaParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(MiniJavaParser.RIGHT_BRACE, 0); }
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
		public List<Class_declContext> class_decl() {
			return getRuleContexts(Class_declContext.class);
		}
		public Class_declContext class_decl(int i) {
			return getRuleContext(Class_declContext.class,i);
		}
		public Public_class_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_public_class_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterPublic_class_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitPublic_class_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPublic_class_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Public_class_declContext public_class_decl() throws RecognitionException {
		Public_class_declContext _localctx = new Public_class_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_public_class_decl);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(T__1);
				setState(125);
				match(T__2);
				setState(126);
				match(ID);
				setState(127);
				match(LEFT_BRACE);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 144115221898723332L) != 0) {
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(128);
						const_decl();
						}
						break;
					case 2:
						{
						setState(129);
						method_decl();
						}
						break;
					case 3:
						{
						setState(130);
						field_decl();
						}
						break;
					}
					}
					setState(135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(136);
				match(RIGHT_BRACE);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(137);
					class_decl();
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(143);
					class_decl();
					}
					}
					setState(146); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 );
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
	public static class Class_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(MiniJavaParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(MiniJavaParser.RIGHT_BRACE, 0); }
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
		enterRule(_localctx, 4, RULE_class_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__2);
			setState(151);
			match(ID);
			setState(152);
			match(LEFT_BRACE);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 144115221898723332L) != 0) {
				{
				setState(156);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(153);
					const_decl();
					}
					break;
				case 2:
					{
					setState(154);
					method_decl();
					}
					break;
				case 3:
					{
					setState(155);
					field_decl();
					}
					break;
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
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
		enterRule(_localctx, 6, RULE_const_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCES_MOD) {
				{
				setState(163);
				match(ACCES_MOD);
				}
			}

			setState(166);
			match(ID);
			setState(167);
			match(LEFT_BRACKET);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 144115191833952256L) != 0) {
				{
				setState(168);
				parameter_list();
				}
			}

			setState(171);
			match(RIGHT_BRACKET);
			setState(172);
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
		public Main_method_declContext main_method_decl() {
			return getRuleContext(Main_method_declContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_method_decl);
		int _la;
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				main_method_decl();
				}
				break;
			case T__28:
			case T__29:
			case T__30:
			case ACCES_MOD:
			case STATIC:
			case VOID:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ACCES_MOD) {
					{
					setState(175);
					match(ACCES_MOD);
					}
				}

				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(178);
					match(STATIC);
					}
				}

				setState(181);
				method_type();
				setState(182);
				match(ID);
				setState(183);
				match(LEFT_BRACKET);
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 144115191833952256L) != 0) {
					{
					setState(184);
					parameter_list();
					}
				}

				setState(187);
				match(RIGHT_BRACKET);
				setState(188);
				statement_block();
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
	public static class Main_method_declContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(MiniJavaParser.STATIC, 0); }
		public TerminalNode VOID() { return getToken(MiniJavaParser.VOID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class,0);
		}
		public Main_method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMain_method_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMain_method_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMain_method_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Main_method_declContext main_method_decl() throws RecognitionException {
		Main_method_declContext _localctx = new Main_method_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_main_method_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__1);
			setState(193);
			match(STATIC);
			setState(194);
			match(VOID);
			setState(195);
			match(T__3);
			setState(196);
			match(LEFT_BRACKET);
			setState(197);
			match(T__4);
			setState(198);
			match(T__5);
			setState(199);
			match(T__6);
			setState(200);
			match(T__7);
			setState(201);
			match(RIGHT_BRACKET);
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
	public static class Field_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public TerminalNode ACCES_MOD() { return getToken(MiniJavaParser.ACCES_MOD, 0); }
		public TerminalNode STATIC() { return getToken(MiniJavaParser.STATIC, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public List<Field_decl_concatContext> field_decl_concat() {
			return getRuleContexts(Field_decl_concatContext.class);
		}
		public Field_decl_concatContext field_decl_concat(int i) {
			return getRuleContext(Field_decl_concatContext.class,i);
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
		enterRule(_localctx, 12, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCES_MOD) {
				{
				setState(204);
				match(ACCES_MOD);
				}
			}

			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(207);
				match(STATIC);
				}
			}

			setState(210);
			type();
			setState(211);
			match(ID);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(212);
				match(ASSIGN);
				setState(213);
				expr();
				}
			}

			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(216);
				match(COMMA);
				setState(217);
				field_decl_concat();
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(223);
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
	public static class Field_decl_concatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Field_decl_concatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl_concat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterField_decl_concat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitField_decl_concat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitField_decl_concat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Field_decl_concatContext field_decl_concat() throws RecognitionException {
		Field_decl_concatContext _localctx = new Field_decl_concatContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field_decl_concat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ID);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(226);
				match(ASSIGN);
				setState(227);
				expr();
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
		enterRule(_localctx, 16, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			type();
			setState(231);
			match(ID);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(232);
				match(COMMA);
				setState(233);
				type();
				setState(234);
				match(ID);
				}
				}
				setState(240);
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
		enterRule(_localctx, 18, RULE_method_type);
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(VOID);
				}
				break;
			case T__28:
			case T__29:
			case T__30:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
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
		enterRule(_localctx, 20, RULE_statement_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(LEFT_BRACE);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 148196819527008256L) != 0) {
				{
				{
				setState(246);
				statement();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
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
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				statement_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				local_var_decl();
				setState(256);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(258);
				if_else_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				while_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				for_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
				return_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(262);
				statement_expr();
				setState(263);
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
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public List<Local_var_decl_concatContext> local_var_decl_concat() {
			return getRuleContexts(Local_var_decl_concatContext.class);
		}
		public Local_var_decl_concatContext local_var_decl_concat(int i) {
			return getRuleContext(Local_var_decl_concatContext.class,i);
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
		enterRule(_localctx, 24, RULE_local_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			type();
			setState(268);
			match(ID);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(269);
				match(ASSIGN);
				setState(270);
				expr();
				}
			}

			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(273);
				match(COMMA);
				setState(274);
				local_var_decl_concat();
				}
				}
				setState(279);
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
	public static class Local_var_decl_concatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Local_var_decl_concatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_var_decl_concat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLocal_var_decl_concat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLocal_var_decl_concat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLocal_var_decl_concat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_var_decl_concatContext local_var_decl_concat() throws RecognitionException {
		Local_var_decl_concatContext _localctx = new Local_var_decl_concatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_local_var_decl_concat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(ID);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(281);
				match(ASSIGN);
				setState(282);
				expr();
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
	public static class If_else_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
		enterRule(_localctx, 28, RULE_if_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(IF);
			setState(286);
			match(LEFT_BRACKET);
			setState(287);
			expr();
			setState(288);
			match(RIGHT_BRACKET);
			setState(289);
			statement();
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(290);
				else_statement();
				}
				break;
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
		enterRule(_localctx, 30, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(ELSE);
			setState(294);
			statement();
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
		enterRule(_localctx, 32, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(WHILE);
			setState(297);
			match(LEFT_BRACKET);
			setState(298);
			expr();
			setState(299);
			match(RIGHT_BRACKET);
			setState(300);
			statement();
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
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_statement_exprContext for_statement_expr() {
			return getRuleContext(For_statement_exprContext.class,0);
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
		enterRule(_localctx, 34, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(FOR);
			setState(303);
			match(LEFT_BRACKET);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 144115294925750272L) != 0) {
				{
				setState(304);
				for_init();
				}
			}

			setState(307);
			match(SEMICOLON);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 283797798116917248L) != 0) {
				{
				setState(308);
				expr();
				}
			}

			setState(311);
			match(SEMICOLON);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 144115291167653888L) != 0) {
				{
				setState(312);
				for_statement_expr();
				}
			}

			setState(315);
			match(RIGHT_BRACKET);
			setState(316);
			statement();
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
	public static class For_initContext extends ParserRuleContext {
		public For_statement_exprContext for_statement_expr() {
			return getRuleContext(For_statement_exprContext.class,0);
		}
		public Local_var_declContext local_var_decl() {
			return getRuleContext(Local_var_declContext.class,0);
		}
		public For_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFor_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFor_init(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitFor_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_for_init);
		try {
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				for_statement_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				local_var_decl();
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
	public static class For_statement_exprContext extends ParserRuleContext {
		public List<Statement_exprContext> statement_expr() {
			return getRuleContexts(Statement_exprContext.class);
		}
		public Statement_exprContext statement_expr(int i) {
			return getRuleContext(Statement_exprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MiniJavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MiniJavaParser.COMMA, i);
		}
		public For_statement_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFor_statement_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFor_statement_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitFor_statement_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statement_exprContext for_statement_expr() throws RecognitionException {
		For_statement_exprContext _localctx = new For_statement_exprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_for_statement_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			statement_expr();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(323);
				match(COMMA);
				setState(324);
				statement_expr();
				}
				}
				setState(329);
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
		enterRule(_localctx, 40, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(RETURN);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 283797798116917248L) != 0) {
				{
				setState(331);
				expr();
				}
			}

			setState(334);
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
		public Crement_statementContext crement_statement() {
			return getRuleContext(Crement_statementContext.class,0);
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
		enterRule(_localctx, 42, RULE_statement_expr);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				method_call_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				new_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				assign_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(339);
				crement_statement();
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
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Method_owner_prefixContext method_owner_prefix() {
			return getRuleContext(Method_owner_prefixContext.class,0);
		}
		public List<Method_chainContext> method_chain() {
			return getRuleContexts(Method_chainContext.class);
		}
		public Method_chainContext method_chain(int i) {
			return getRuleContext(Method_chainContext.class,i);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
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
		enterRule(_localctx, 44, RULE_method_call_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(342);
				method_owner_prefix();
				}
				break;
			}
			setState(348);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(345);
					method_chain();
					}
					} 
				}
				setState(350);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			{
			setState(351);
			match(ID);
			setState(352);
			match(LEFT_BRACKET);
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 283797798116917248L) != 0) {
				{
				setState(353);
				argumentList();
				}
			}

			setState(356);
			match(RIGHT_BRACKET);
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
	public static class Method_owner_prefixContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(MiniJavaParser.DOT, 0); }
		public TerminalNode THIS() { return getToken(MiniJavaParser.THIS, 0); }
		public Inst_varContext inst_var() {
			return getRuleContext(Inst_varContext.class,0);
		}
		public New_statementContext new_statement() {
			return getRuleContext(New_statementContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Method_owner_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_owner_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethod_owner_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethod_owner_prefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethod_owner_prefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_owner_prefixContext method_owner_prefix() throws RecognitionException {
		Method_owner_prefixContext _localctx = new Method_owner_prefixContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_method_owner_prefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(358);
				match(THIS);
				}
				break;
			case 2:
				{
				setState(359);
				inst_var();
				}
				break;
			case 3:
				{
				setState(360);
				new_statement();
				}
				break;
			case 4:
				{
				setState(361);
				match(ID);
				}
				break;
			}
			setState(364);
			match(DOT);
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
	public static class Method_chainContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public TerminalNode DOT() { return getToken(MiniJavaParser.DOT, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public Method_chainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMethod_chain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMethod_chain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMethod_chain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_chainContext method_chain() throws RecognitionException {
		Method_chainContext _localctx = new Method_chainContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_method_chain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(ID);
			setState(367);
			match(LEFT_BRACKET);
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 283797798116917248L) != 0) {
				{
				setState(368);
				argumentList();
				}
			}

			setState(371);
			match(RIGHT_BRACKET);
			setState(372);
			match(DOT);
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
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_new_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(NEW);
			setState(375);
			match(ID);
			setState(376);
			match(LEFT_BRACKET);
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 283797798116917248L) != 0) {
				{
				setState(377);
				argumentList();
				}
			}

			setState(380);
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
	public static class ArgumentListContext extends ParserRuleContext {
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
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			expr();
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(383);
				match(COMMA);
				setState(384);
				expr();
				}
				}
				setState(389);
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
	public static class Assign_statementContext extends ParserRuleContext {
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
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
		enterRule(_localctx, 54, RULE_assign_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(390);
				inst_var();
				}
				break;
			case 2:
				{
				setState(391);
				match(ID);
				}
				break;
			}
			setState(394);
			assign_op();
			setState(395);
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
	public static class Crement_statementContext extends ParserRuleContext {
		public Pre_cre_opContext pre_cre_op() {
			return getRuleContext(Pre_cre_opContext.class,0);
		}
		public TerminalNode ID() { return getToken(MiniJavaParser.ID, 0); }
		public Inst_varContext inst_var() {
			return getRuleContext(Inst_varContext.class,0);
		}
		public Suf_cre_opContext suf_cre_op() {
			return getRuleContext(Suf_cre_opContext.class,0);
		}
		public Crement_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_crement_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterCrement_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitCrement_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitCrement_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Crement_statementContext crement_statement() throws RecognitionException {
		Crement_statementContext _localctx = new Crement_statementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_crement_statement);
		try {
			setState(407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(397);
				pre_cre_op();
				setState(400);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(398);
					match(ID);
					}
					break;
				case 2:
					{
					setState(399);
					inst_var();
					}
					break;
				}
				}
				}
				break;
			case NEW:
			case THIS:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(404);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
				case 1:
					{
					setState(402);
					match(ID);
					}
					break;
				case 2:
					{
					setState(403);
					inst_var();
					}
					break;
				}
				setState(406);
				suf_cre_op();
				}
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
		public List<TerminalNode> DOT() { return getTokens(MiniJavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MiniJavaParser.DOT, i);
		}
		public List<TerminalNode> ID() { return getTokens(MiniJavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MiniJavaParser.ID, i);
		}
		public TerminalNode THIS() { return getToken(MiniJavaParser.THIS, 0); }
		public New_statementContext new_statement() {
			return getRuleContext(New_statementContext.class,0);
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
		enterRule(_localctx, 58, RULE_inst_var);
		try {
			int _alt;
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(411);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case THIS:
					{
					setState(409);
					match(THIS);
					}
					break;
				case NEW:
					{
					setState(410);
					new_statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(413);
				match(DOT);
				setState(414);
				match(ID);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(420);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case THIS:
					{
					{
					setState(415);
					match(THIS);
					setState(416);
					match(DOT);
					}
					}
					break;
				case NEW:
					{
					{
					setState(417);
					new_statement();
					setState(418);
					match(DOT);
					}
					}
					break;
				case ID:
					break;
				default:
					break;
				}
				setState(424); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(422);
						match(ID);
						setState(423);
						match(DOT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(426); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(428);
				match(ID);
				}
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
		public Logical_or_exprContext logical_or_expr() {
			return getRuleContext(Logical_or_exprContext.class,0);
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
		enterRule(_localctx, 60, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			logical_or_expr(0);
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
	public static class Logical_or_exprContext extends ParserRuleContext {
		public Logical_and_exprContext logical_and_expr() {
			return getRuleContext(Logical_and_exprContext.class,0);
		}
		public Logical_or_exprContext logical_or_expr() {
			return getRuleContext(Logical_or_exprContext.class,0);
		}
		public Logical_or_opContext logical_or_op() {
			return getRuleContext(Logical_or_opContext.class,0);
		}
		public Logical_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLogical_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLogical_or_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLogical_or_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_or_exprContext logical_or_expr() throws RecognitionException {
		return logical_or_expr(0);
	}

	private Logical_or_exprContext logical_or_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_or_exprContext _localctx = new Logical_or_exprContext(_ctx, _parentState);
		Logical_or_exprContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_logical_or_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(434);
			logical_and_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(442);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Logical_or_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logical_or_expr);
					setState(436);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(437);
					logical_or_op();
					setState(438);
					logical_and_expr(0);
					}
					} 
				}
				setState(444);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
	public static class Logical_and_exprContext extends ParserRuleContext {
		public Bitwise_or_exprContext bitwise_or_expr() {
			return getRuleContext(Bitwise_or_exprContext.class,0);
		}
		public Logical_and_exprContext logical_and_expr() {
			return getRuleContext(Logical_and_exprContext.class,0);
		}
		public Logical_and_opContext logical_and_op() {
			return getRuleContext(Logical_and_opContext.class,0);
		}
		public Logical_and_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLogical_and_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLogical_and_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLogical_and_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_and_exprContext logical_and_expr() throws RecognitionException {
		return logical_and_expr(0);
	}

	private Logical_and_exprContext logical_and_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logical_and_exprContext _localctx = new Logical_and_exprContext(_ctx, _parentState);
		Logical_and_exprContext _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_logical_and_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(446);
			bitwise_or_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(454);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Logical_and_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logical_and_expr);
					setState(448);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(449);
					logical_and_op();
					setState(450);
					bitwise_or_expr(0);
					}
					} 
				}
				setState(456);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
	public static class Bitwise_or_exprContext extends ParserRuleContext {
		public Bitwise_and_exprContext bitwise_and_expr() {
			return getRuleContext(Bitwise_and_exprContext.class,0);
		}
		public Bitwise_or_exprContext bitwise_or_expr() {
			return getRuleContext(Bitwise_or_exprContext.class,0);
		}
		public Bitwise_or_opContext bitwise_or_op() {
			return getRuleContext(Bitwise_or_opContext.class,0);
		}
		public Bitwise_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBitwise_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBitwise_or_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBitwise_or_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_or_exprContext bitwise_or_expr() throws RecognitionException {
		return bitwise_or_expr(0);
	}

	private Bitwise_or_exprContext bitwise_or_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bitwise_or_exprContext _localctx = new Bitwise_or_exprContext(_ctx, _parentState);
		Bitwise_or_exprContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_bitwise_or_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(458);
			bitwise_and_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(466);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_or_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_or_expr);
					setState(460);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(461);
					bitwise_or_op();
					setState(462);
					bitwise_and_expr(0);
					}
					} 
				}
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
	public static class Bitwise_and_exprContext extends ParserRuleContext {
		public Equality_exprContext equality_expr() {
			return getRuleContext(Equality_exprContext.class,0);
		}
		public Bitwise_and_exprContext bitwise_and_expr() {
			return getRuleContext(Bitwise_and_exprContext.class,0);
		}
		public Bitwise_and_opContext bitwise_and_op() {
			return getRuleContext(Bitwise_and_opContext.class,0);
		}
		public Bitwise_and_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBitwise_and_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBitwise_and_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBitwise_and_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_and_exprContext bitwise_and_expr() throws RecognitionException {
		return bitwise_and_expr(0);
	}

	private Bitwise_and_exprContext bitwise_and_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bitwise_and_exprContext _localctx = new Bitwise_and_exprContext(_ctx, _parentState);
		Bitwise_and_exprContext _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_bitwise_and_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(470);
			equality_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(478);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_and_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_and_expr);
					setState(472);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(473);
					bitwise_and_op();
					setState(474);
					equality_expr(0);
					}
					} 
				}
				setState(480);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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
	public static class Equality_exprContext extends ParserRuleContext {
		public Relational_exprContext relational_expr() {
			return getRuleContext(Relational_exprContext.class,0);
		}
		public Equality_exprContext equality_expr() {
			return getRuleContext(Equality_exprContext.class,0);
		}
		public Equality_opContext equality_op() {
			return getRuleContext(Equality_opContext.class,0);
		}
		public Equality_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterEquality_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitEquality_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitEquality_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_exprContext equality_expr() throws RecognitionException {
		return equality_expr(0);
	}

	private Equality_exprContext equality_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Equality_exprContext _localctx = new Equality_exprContext(_ctx, _parentState);
		Equality_exprContext _prevctx = _localctx;
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_equality_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(482);
			relational_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(490);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equality_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equality_expr);
					setState(484);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(485);
					equality_op();
					setState(486);
					relational_expr(0);
					}
					} 
				}
				setState(492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
	public static class Relational_exprContext extends ParserRuleContext {
		public Additive_exprContext additive_expr() {
			return getRuleContext(Additive_exprContext.class,0);
		}
		public Relational_exprContext relational_expr() {
			return getRuleContext(Relational_exprContext.class,0);
		}
		public Relational_opContext relational_op() {
			return getRuleContext(Relational_opContext.class,0);
		}
		public Relational_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterRelational_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitRelational_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitRelational_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_exprContext relational_expr() throws RecognitionException {
		return relational_expr(0);
	}

	private Relational_exprContext relational_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Relational_exprContext _localctx = new Relational_exprContext(_ctx, _parentState);
		Relational_exprContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_relational_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(494);
			additive_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(502);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Relational_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relational_expr);
					setState(496);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(497);
					relational_op();
					setState(498);
					additive_expr(0);
					}
					} 
				}
				setState(504);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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
	public static class Additive_exprContext extends ParserRuleContext {
		public Multiplicative_exprContext multiplicative_expr() {
			return getRuleContext(Multiplicative_exprContext.class,0);
		}
		public Additive_exprContext additive_expr() {
			return getRuleContext(Additive_exprContext.class,0);
		}
		public Add_sub_opContext add_sub_op() {
			return getRuleContext(Add_sub_opContext.class,0);
		}
		public Additive_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAdditive_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAdditive_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAdditive_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_exprContext additive_expr() throws RecognitionException {
		return additive_expr(0);
	}

	private Additive_exprContext additive_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Additive_exprContext _localctx = new Additive_exprContext(_ctx, _parentState);
		Additive_exprContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_additive_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(506);
			multiplicative_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(514);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expr);
					setState(508);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(509);
					add_sub_op();
					setState(510);
					multiplicative_expr(0);
					}
					} 
				}
				setState(516);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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
	public static class Multiplicative_exprContext extends ParserRuleContext {
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public Multiplicative_exprContext multiplicative_expr() {
			return getRuleContext(Multiplicative_exprContext.class,0);
		}
		public Mul_div_opContext mul_div_op() {
			return getRuleContext(Mul_div_opContext.class,0);
		}
		public Multiplicative_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterMultiplicative_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitMultiplicative_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitMultiplicative_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiplicative_exprContext multiplicative_expr() throws RecognitionException {
		return multiplicative_expr(0);
	}

	private Multiplicative_exprContext multiplicative_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Multiplicative_exprContext _localctx = new Multiplicative_exprContext(_ctx, _parentState);
		Multiplicative_exprContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_multiplicative_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(518);
			unary_expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(526);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expr);
					setState(520);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(521);
					mul_div_op();
					setState(522);
					unary_expr();
					}
					} 
				}
				setState(528);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
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
	public static class Unary_exprContext extends ParserRuleContext {
		public Crement_statementContext crement_statement() {
			return getRuleContext(Crement_statementContext.class,0);
		}
		public Primary_exprContext primary_expr() {
			return getRuleContext(Primary_exprContext.class,0);
		}
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitUnary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_unary_expr);
		try {
			setState(531);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(529);
				crement_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(530);
				primary_expr();
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
	public static class Primary_exprContext extends ParserRuleContext {
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
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Primary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterPrimary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitPrimary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPrimary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primary_exprContext primary_expr() throws RecognitionException {
		Primary_exprContext _localctx = new Primary_exprContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_primary_expr);
		try {
			setState(544);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(533);
				match(THIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(534);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(535);
				inst_var();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(536);
				statement_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(537);
				match(NOT);
				setState(538);
				expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(539);
				match(LEFT_BRACKET);
				setState(540);
				expr();
				setState(541);
				match(RIGHT_BRACKET);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(543);
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
	public static class Logical_or_opContext extends ParserRuleContext {
		public Logical_or_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_or_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLogical_or_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLogical_or_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLogical_or_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_or_opContext logical_or_op() throws RecognitionException {
		Logical_or_opContext _localctx = new Logical_or_opContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_logical_or_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			match(T__8);
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
	public static class Logical_and_opContext extends ParserRuleContext {
		public Logical_and_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical_and_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterLogical_and_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitLogical_and_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitLogical_and_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logical_and_opContext logical_and_op() throws RecognitionException {
		Logical_and_opContext _localctx = new Logical_and_opContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_logical_and_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			match(T__9);
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
	public static class Bitwise_or_opContext extends ParserRuleContext {
		public Bitwise_or_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_or_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBitwise_or_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBitwise_or_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBitwise_or_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_or_opContext bitwise_or_op() throws RecognitionException {
		Bitwise_or_opContext _localctx = new Bitwise_or_opContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_bitwise_or_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(T__10);
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
	public static class Bitwise_and_opContext extends ParserRuleContext {
		public Bitwise_and_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_and_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBitwise_and_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBitwise_and_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBitwise_and_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_and_opContext bitwise_and_op() throws RecognitionException {
		Bitwise_and_opContext _localctx = new Bitwise_and_opContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_bitwise_and_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			match(T__11);
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
	public static class Equality_opContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(MiniJavaParser.EQUALS, 0); }
		public Equality_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterEquality_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitEquality_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitEquality_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_opContext equality_op() throws RecognitionException {
		Equality_opContext _localctx = new Equality_opContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_equality_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			_la = _input.LA(1);
			if ( !(_la==T__12 || _la==EQUALS) ) {
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
	public static class Relational_opContext extends ParserRuleContext {
		public Relational_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterRelational_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitRelational_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitRelational_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_opContext relational_op() throws RecognitionException {
		Relational_opContext _localctx = new Relational_opContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_relational_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0) ) {
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
		enterRule(_localctx, 94, RULE_add_sub_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			_la = _input.LA(1);
			if ( !(_la==T__17 || _la==T__18) ) {
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
		enterRule(_localctx, 96, RULE_mul_div_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__20) ) {
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
	public static class Pre_cre_opContext extends ParserRuleContext {
		public Pre_cre_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pre_cre_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterPre_cre_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitPre_cre_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitPre_cre_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pre_cre_opContext pre_cre_op() throws RecognitionException {
		Pre_cre_opContext _localctx = new Pre_cre_opContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_pre_cre_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
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
	public static class Suf_cre_opContext extends ParserRuleContext {
		public Suf_cre_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suf_cre_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterSuf_cre_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitSuf_cre_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitSuf_cre_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Suf_cre_opContext suf_cre_op() throws RecognitionException {
		Suf_cre_opContext _localctx = new Suf_cre_opContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_suf_cre_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			_la = _input.LA(1);
			if ( !(_la==T__21 || _la==T__22) ) {
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
	public static class Assign_opContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(MiniJavaParser.ASSIGN, 0); }
		public Assign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAssign_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAssign_op(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAssign_op(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_opContext assign_op() throws RecognitionException {
		Assign_opContext _localctx = new Assign_opContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_assign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 17592706138112L) != 0) ) {
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
		enterRule(_localctx, 104, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 144115191833952256L) != 0) ) {
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
	public static class LiteralContext extends ParserRuleContext {
		public IntContext int_() {
			return getRuleContext(IntContext.class,0);
		}
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
		enterRule(_localctx, 106, RULE_literal);
		try {
			setState(575);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__18:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(570);
				int_();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(571);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(572);
				match(CHAR);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(573);
				match(STRING);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(574);
				match(NULL);
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
	public static class IntContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MiniJavaParser.INT, 0); }
		public Add_sub_opContext add_sub_op() {
			return getRuleContext(Add_sub_opContext.class,0);
		}
		public IntContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntContext int_() throws RecognitionException {
		IntContext _localctx = new IntContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_int);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17 || _la==T__18) {
				{
				setState(577);
				add_sub_op();
				}
			}

			setState(580);
			match(INT);
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
		case 31:
			return logical_or_expr_sempred((Logical_or_exprContext)_localctx, predIndex);
		case 32:
			return logical_and_expr_sempred((Logical_and_exprContext)_localctx, predIndex);
		case 33:
			return bitwise_or_expr_sempred((Bitwise_or_exprContext)_localctx, predIndex);
		case 34:
			return bitwise_and_expr_sempred((Bitwise_and_exprContext)_localctx, predIndex);
		case 35:
			return equality_expr_sempred((Equality_exprContext)_localctx, predIndex);
		case 36:
			return relational_expr_sempred((Relational_exprContext)_localctx, predIndex);
		case 37:
			return additive_expr_sempred((Additive_exprContext)_localctx, predIndex);
		case 38:
			return multiplicative_expr_sempred((Multiplicative_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_or_expr_sempred(Logical_or_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean logical_and_expr_sempred(Logical_and_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitwise_or_expr_sempred(Bitwise_or_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitwise_and_expr_sempred(Bitwise_and_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean equality_expr_sempred(Equality_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean relational_expr_sempred(Relational_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean additive_expr_sempred(Additive_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multiplicative_expr_sempred(Multiplicative_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001<\u0247\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000s\b\u0000\n\u0000"+
		"\f\u0000v\t\u0000\u0001\u0000\u0003\u0000y\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u0084\b\u0001\n\u0001\f\u0001\u0087\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001\u008b\b\u0001\n\u0001\f\u0001\u008e\t\u0001"+
		"\u0001\u0001\u0004\u0001\u0091\b\u0001\u000b\u0001\f\u0001\u0092\u0003"+
		"\u0001\u0095\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002\u009d\b\u0002\n\u0002\f\u0002\u00a0\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0003\u0003\u00a5\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003\u00aa\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u00b1\b\u0004\u0001\u0004"+
		"\u0003\u0004\u00b4\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00ba\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u00bf\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0003\u0006\u00ce\b\u0006\u0001\u0006\u0003\u0006"+
		"\u00d1\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00d7\b\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00db\b\u0006\n\u0006"+
		"\f\u0006\u00de\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00e5\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0005\b\u00ed\b\b\n\b\f\b\u00f0\t\b\u0001\t\u0001\t\u0003"+
		"\t\u00f4\b\t\u0001\n\u0001\n\u0005\n\u00f8\b\n\n\n\f\n\u00fb\t\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u010a\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0110"+
		"\b\f\u0001\f\u0001\f\u0005\f\u0114\b\f\n\f\f\f\u0117\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0003\r\u011c\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0124\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0132"+
		"\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0136\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u013a\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u0141\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u0146\b\u0013\n\u0013\f\u0013\u0149\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u014d\b\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0155\b\u0015\u0001"+
		"\u0016\u0003\u0016\u0158\b\u0016\u0001\u0016\u0005\u0016\u015b\b\u0016"+
		"\n\u0016\f\u0016\u015e\t\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u0163\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u016b\b\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0172\b\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003"+
		"\u0019\u017b\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u0182\b\u001a\n\u001a\f\u001a\u0185\t\u001a\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u0189\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0191\b\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u0195\b\u001c\u0001\u001c\u0003\u001c\u0198\b"+
		"\u001c\u0001\u001d\u0001\u001d\u0003\u001d\u019c\b\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u01a5\b\u001d\u0001\u001d\u0001\u001d\u0004\u001d\u01a9\b\u001d"+
		"\u000b\u001d\f\u001d\u01aa\u0001\u001d\u0003\u001d\u01ae\b\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u01b9\b\u001f\n\u001f\f\u001f"+
		"\u01bc\t\u001f\u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005"+
		" \u01c5\b \n \f \u01c8\t \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0005!\u01d1\b!\n!\f!\u01d4\t!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0005\"\u01dd\b\"\n\"\f\"\u01e0\t\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0005#\u01e9\b#\n#\f#\u01ec\t#\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0005$\u01f5\b$\n$\f$\u01f8\t$\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0005%\u0201\b%\n%\f%\u0204"+
		"\t%\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u020d\b&\n"+
		"&\f&\u0210\t&\u0001\'\u0001\'\u0003\'\u0214\b\'\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u0221\b(\u0001"+
		")\u0001)\u0001*\u0001*\u0001+\u0001+\u0001,\u0001,\u0001-\u0001-\u0001"+
		".\u0001.\u0001/\u0001/\u00010\u00010\u00011\u00011\u00012\u00012\u0001"+
		"3\u00013\u00014\u00014\u00015\u00015\u00015\u00015\u00015\u00035\u0240"+
		"\b5\u00016\u00036\u0243\b6\u00016\u00016\u00016\u0000\b>@BDFHJL7\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjl\u0000\u0007\u0002\u0000"+
		"\r\r++\u0001\u0000\u000e\u0011\u0001\u0000\u0012\u0013\u0001\u0000\u0014"+
		"\u0015\u0001\u0000\u0016\u0017\u0002\u0000\u0018\u001c,,\u0002\u0000\u001d"+
		"\u001f99\u0261\u0000x\u0001\u0000\u0000\u0000\u0002\u0094\u0001\u0000"+
		"\u0000\u0000\u0004\u0096\u0001\u0000\u0000\u0000\u0006\u00a4\u0001\u0000"+
		"\u0000\u0000\b\u00be\u0001\u0000\u0000\u0000\n\u00c0\u0001\u0000\u0000"+
		"\u0000\f\u00cd\u0001\u0000\u0000\u0000\u000e\u00e1\u0001\u0000\u0000\u0000"+
		"\u0010\u00e6\u0001\u0000\u0000\u0000\u0012\u00f3\u0001\u0000\u0000\u0000"+
		"\u0014\u00f5\u0001\u0000\u0000\u0000\u0016\u0109\u0001\u0000\u0000\u0000"+
		"\u0018\u010b\u0001\u0000\u0000\u0000\u001a\u0118\u0001\u0000\u0000\u0000"+
		"\u001c\u011d\u0001\u0000\u0000\u0000\u001e\u0125\u0001\u0000\u0000\u0000"+
		" \u0128\u0001\u0000\u0000\u0000\"\u012e\u0001\u0000\u0000\u0000$\u0140"+
		"\u0001\u0000\u0000\u0000&\u0142\u0001\u0000\u0000\u0000(\u014a\u0001\u0000"+
		"\u0000\u0000*\u0154\u0001\u0000\u0000\u0000,\u0157\u0001\u0000\u0000\u0000"+
		".\u016a\u0001\u0000\u0000\u00000\u016e\u0001\u0000\u0000\u00002\u0176"+
		"\u0001\u0000\u0000\u00004\u017e\u0001\u0000\u0000\u00006\u0188\u0001\u0000"+
		"\u0000\u00008\u0197\u0001\u0000\u0000\u0000:\u01ad\u0001\u0000\u0000\u0000"+
		"<\u01af\u0001\u0000\u0000\u0000>\u01b1\u0001\u0000\u0000\u0000@\u01bd"+
		"\u0001\u0000\u0000\u0000B\u01c9\u0001\u0000\u0000\u0000D\u01d5\u0001\u0000"+
		"\u0000\u0000F\u01e1\u0001\u0000\u0000\u0000H\u01ed\u0001\u0000\u0000\u0000"+
		"J\u01f9\u0001\u0000\u0000\u0000L\u0205\u0001\u0000\u0000\u0000N\u0213"+
		"\u0001\u0000\u0000\u0000P\u0220\u0001\u0000\u0000\u0000R\u0222\u0001\u0000"+
		"\u0000\u0000T\u0224\u0001\u0000\u0000\u0000V\u0226\u0001\u0000\u0000\u0000"+
		"X\u0228\u0001\u0000\u0000\u0000Z\u022a\u0001\u0000\u0000\u0000\\\u022c"+
		"\u0001\u0000\u0000\u0000^\u022e\u0001\u0000\u0000\u0000`\u0230\u0001\u0000"+
		"\u0000\u0000b\u0232\u0001\u0000\u0000\u0000d\u0234\u0001\u0000\u0000\u0000"+
		"f\u0236\u0001\u0000\u0000\u0000h\u0238\u0001\u0000\u0000\u0000j\u023f"+
		"\u0001\u0000\u0000\u0000l\u0242\u0001\u0000\u0000\u0000no\u0005\u0001"+
		"\u0000\u0000ot\u00059\u0000\u0000pq\u0005-\u0000\u0000qs\u00059\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000wy\u0005)\u0000\u0000xn\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0003\u0002\u0001\u0000"+
		"{\u0001\u0001\u0000\u0000\u0000|}\u0005\u0002\u0000\u0000}~\u0005\u0003"+
		"\u0000\u0000~\u007f\u00059\u0000\u0000\u007f\u0085\u0005%\u0000\u0000"+
		"\u0080\u0084\u0003\u0006\u0003\u0000\u0081\u0084\u0003\b\u0004\u0000\u0082"+
		"\u0084\u0003\f\u0006\u0000\u0083\u0080\u0001\u0000\u0000\u0000\u0083\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087"+
		"\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0085"+
		"\u0001\u0000\u0000\u0000\u0088\u008c\u0005&\u0000\u0000\u0089\u008b\u0003"+
		"\u0004\u0002\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u008e\u0001"+
		"\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001"+
		"\u0000\u0000\u0000\u008d\u0095\u0001\u0000\u0000\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008f\u0091\u0003\u0004\u0002\u0000\u0090\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0090\u0001"+
		"\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0095\u0001"+
		"\u0000\u0000\u0000\u0094|\u0001\u0000\u0000\u0000\u0094\u0090\u0001\u0000"+
		"\u0000\u0000\u0095\u0003\u0001\u0000\u0000\u0000\u0096\u0097\u0005\u0003"+
		"\u0000\u0000\u0097\u0098\u00059\u0000\u0000\u0098\u009e\u0005%\u0000\u0000"+
		"\u0099\u009d\u0003\u0006\u0003\u0000\u009a\u009d\u0003\b\u0004\u0000\u009b"+
		"\u009d\u0003\f\u0006\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009c\u009a"+
		"\u0001\u0000\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u00a0"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005&\u0000\u0000\u00a2\u0005\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a5\u0005 \u0000\u0000\u00a4\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u00059\u0000\u0000\u00a7\u00a9\u0005\'\u0000"+
		"\u0000\u00a8\u00aa\u0003\u0010\b\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0005(\u0000\u0000\u00ac\u00ad\u0003\u0014\n\u0000\u00ad"+
		"\u0007\u0001\u0000\u0000\u0000\u00ae\u00bf\u0003\n\u0005\u0000\u00af\u00b1"+
		"\u0005 \u0000\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b4\u0005"+
		"!\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0003\u0012"+
		"\t\u0000\u00b6\u00b7\u00059\u0000\u0000\u00b7\u00b9\u0005\'\u0000\u0000"+
		"\u00b8\u00ba\u0003\u0010\b\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0005(\u0000\u0000\u00bc\u00bd\u0003\u0014\n\u0000\u00bd\u00bf"+
		"\u0001\u0000\u0000\u0000\u00be\u00ae\u0001\u0000\u0000\u0000\u00be\u00b0"+
		"\u0001\u0000\u0000\u0000\u00bf\t\u0001\u0000\u0000\u0000\u00c0\u00c1\u0005"+
		"\u0002\u0000\u0000\u00c1\u00c2\u0005!\u0000\u0000\u00c2\u00c3\u0005\""+
		"\u0000\u0000\u00c3\u00c4\u0005\u0004\u0000\u0000\u00c4\u00c5\u0005\'\u0000"+
		"\u0000\u00c5\u00c6\u0005\u0005\u0000\u0000\u00c6\u00c7\u0005\u0006\u0000"+
		"\u0000\u00c7\u00c8\u0005\u0007\u0000\u0000\u00c8\u00c9\u0005\b\u0000\u0000"+
		"\u00c9\u00ca\u0005(\u0000\u0000\u00ca\u00cb\u0003\u0014\n\u0000\u00cb"+
		"\u000b\u0001\u0000\u0000\u0000\u00cc\u00ce\u0005 \u0000\u0000\u00cd\u00cc"+
		"\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d1\u0005!\u0000\u0000\u00d0\u00cf\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0003h4\u0000\u00d3\u00d6\u00059\u0000"+
		"\u0000\u00d4\u00d5\u0005,\u0000\u0000\u00d5\u00d7\u0003<\u001e\u0000\u00d6"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7"+
		"\u00dc\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005*\u0000\u0000\u00d9\u00db"+
		"\u0003\u000e\u0007\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00de"+
		"\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0001\u0000\u0000\u0000\u00dd\u00df\u0001\u0000\u0000\u0000\u00de\u00dc"+
		"\u0001\u0000\u0000\u0000\u00df\u00e0\u0005)\u0000\u0000\u00e0\r\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e4\u00059\u0000\u0000\u00e2\u00e3\u0005,\u0000"+
		"\u0000\u00e3\u00e5\u0003<\u001e\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u000f\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0003h4\u0000\u00e7\u00ee\u00059\u0000\u0000\u00e8\u00e9"+
		"\u0005*\u0000\u0000\u00e9\u00ea\u0003h4\u0000\u00ea\u00eb\u00059\u0000"+
		"\u0000\u00eb\u00ed\u0001\u0000\u0000\u0000\u00ec\u00e8\u0001\u0000\u0000"+
		"\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u0011\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f4\u0005\"\u0000\u0000"+
		"\u00f2\u00f4\u0003h4\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f4\u0013\u0001\u0000\u0000\u0000\u00f5\u00f9"+
		"\u0005%\u0000\u0000\u00f6\u00f8\u0003\u0016\u000b\u0000\u00f7\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005"+
		"&\u0000\u0000\u00fd\u0015\u0001\u0000\u0000\u0000\u00fe\u010a\u0003\u0014"+
		"\n\u0000\u00ff\u0100\u0003\u0018\f\u0000\u0100\u0101\u0005)\u0000\u0000"+
		"\u0101\u010a\u0001\u0000\u0000\u0000\u0102\u010a\u0003\u001c\u000e\u0000"+
		"\u0103\u010a\u0003 \u0010\u0000\u0104\u010a\u0003\"\u0011\u0000\u0105"+
		"\u010a\u0003(\u0014\u0000\u0106\u0107\u0003*\u0015\u0000\u0107\u0108\u0005"+
		")\u0000\u0000\u0108\u010a\u0001\u0000\u0000\u0000\u0109\u00fe\u0001\u0000"+
		"\u0000\u0000\u0109\u00ff\u0001\u0000\u0000\u0000\u0109\u0102\u0001\u0000"+
		"\u0000\u0000\u0109\u0103\u0001\u0000\u0000\u0000\u0109\u0104\u0001\u0000"+
		"\u0000\u0000\u0109\u0105\u0001\u0000\u0000\u0000\u0109\u0106\u0001\u0000"+
		"\u0000\u0000\u010a\u0017\u0001\u0000\u0000\u0000\u010b\u010c\u0003h4\u0000"+
		"\u010c\u010f\u00059\u0000\u0000\u010d\u010e\u0005,\u0000\u0000\u010e\u0110"+
		"\u0003<\u001e\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110\u0001"+
		"\u0000\u0000\u0000\u0110\u0115\u0001\u0000\u0000\u0000\u0111\u0112\u0005"+
		"*\u0000\u0000\u0112\u0114\u0003\u001a\r\u0000\u0113\u0111\u0001\u0000"+
		"\u0000\u0000\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0019\u0001\u0000"+
		"\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u011b\u00059\u0000"+
		"\u0000\u0119\u011a\u0005,\u0000\u0000\u011a\u011c\u0003<\u001e\u0000\u011b"+
		"\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c"+
		"\u001b\u0001\u0000\u0000\u0000\u011d\u011e\u0005/\u0000\u0000\u011e\u011f"+
		"\u0005\'\u0000\u0000\u011f\u0120\u0003<\u001e\u0000\u0120\u0121\u0005"+
		"(\u0000\u0000\u0121\u0123\u0003\u0016\u000b\u0000\u0122\u0124\u0003\u001e"+
		"\u000f\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000"+
		"\u0000\u0000\u0124\u001d\u0001\u0000\u0000\u0000\u0125\u0126\u00050\u0000"+
		"\u0000\u0126\u0127\u0003\u0016\u000b\u0000\u0127\u001f\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u00051\u0000\u0000\u0129\u012a\u0005\'\u0000\u0000"+
		"\u012a\u012b\u0003<\u001e\u0000\u012b\u012c\u0005(\u0000\u0000\u012c\u012d"+
		"\u0003\u0016\u000b\u0000\u012d!\u0001\u0000\u0000\u0000\u012e\u012f\u0005"+
		"2\u0000\u0000\u012f\u0131\u0005\'\u0000\u0000\u0130\u0132\u0003$\u0012"+
		"\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000"+
		"\u0000\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0135\u0005)\u0000\u0000"+
		"\u0134\u0136\u0003<\u001e\u0000\u0135\u0134\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137"+
		"\u0139\u0005)\u0000\u0000\u0138\u013a\u0003&\u0013\u0000\u0139\u0138\u0001"+
		"\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a\u013b\u0001"+
		"\u0000\u0000\u0000\u013b\u013c\u0005(\u0000\u0000\u013c\u013d\u0003\u0016"+
		"\u000b\u0000\u013d#\u0001\u0000\u0000\u0000\u013e\u0141\u0003&\u0013\u0000"+
		"\u013f\u0141\u0003\u0018\f\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140"+
		"\u013f\u0001\u0000\u0000\u0000\u0141%\u0001\u0000\u0000\u0000\u0142\u0147"+
		"\u0003*\u0015\u0000\u0143\u0144\u0005*\u0000\u0000\u0144\u0146\u0003*"+
		"\u0015\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u0149\u0001\u0000"+
		"\u0000\u0000\u0147\u0145\u0001\u0000\u0000\u0000\u0147\u0148\u0001\u0000"+
		"\u0000\u0000\u0148\'\u0001\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000"+
		"\u0000\u014a\u014c\u00053\u0000\u0000\u014b\u014d\u0003<\u001e\u0000\u014c"+
		"\u014b\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d"+
		"\u014e\u0001\u0000\u0000\u0000\u014e\u014f\u0005)\u0000\u0000\u014f)\u0001"+
		"\u0000\u0000\u0000\u0150\u0155\u0003,\u0016\u0000\u0151\u0155\u00032\u0019"+
		"\u0000\u0152\u0155\u00036\u001b\u0000\u0153\u0155\u00038\u001c\u0000\u0154"+
		"\u0150\u0001\u0000\u0000\u0000\u0154\u0151\u0001\u0000\u0000\u0000\u0154"+
		"\u0152\u0001\u0000\u0000\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0155"+
		"+\u0001\u0000\u0000\u0000\u0156\u0158\u0003.\u0017\u0000\u0157\u0156\u0001"+
		"\u0000\u0000\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u015c\u0001"+
		"\u0000\u0000\u0000\u0159\u015b\u00030\u0018\u0000\u015a\u0159\u0001\u0000"+
		"\u0000\u0000\u015b\u015e\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015f\u0001\u0000"+
		"\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000\u015f\u0160\u00059\u0000"+
		"\u0000\u0160\u0162\u0005\'\u0000\u0000\u0161\u0163\u00034\u001a\u0000"+
		"\u0162\u0161\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000\u0000\u0000"+
		"\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0165\u0005(\u0000\u0000\u0165"+
		"-\u0001\u0000\u0000\u0000\u0166\u016b\u0005$\u0000\u0000\u0167\u016b\u0003"+
		":\u001d\u0000\u0168\u016b\u00032\u0019\u0000\u0169\u016b\u00059\u0000"+
		"\u0000\u016a\u0166\u0001\u0000\u0000\u0000\u016a\u0167\u0001\u0000\u0000"+
		"\u0000\u016a\u0168\u0001\u0000\u0000\u0000\u016a\u0169\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016d\u0005-\u0000\u0000"+
		"\u016d/\u0001\u0000\u0000\u0000\u016e\u016f\u00059\u0000\u0000\u016f\u0171"+
		"\u0005\'\u0000\u0000\u0170\u0172\u00034\u001a\u0000\u0171\u0170\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0173\u0001"+
		"\u0000\u0000\u0000\u0173\u0174\u0005(\u0000\u0000\u0174\u0175\u0005-\u0000"+
		"\u0000\u01751\u0001\u0000\u0000\u0000\u0176\u0177\u0005#\u0000\u0000\u0177"+
		"\u0178\u00059\u0000\u0000\u0178\u017a\u0005\'\u0000\u0000\u0179\u017b"+
		"\u00034\u001a\u0000\u017a\u0179\u0001\u0000\u0000\u0000\u017a\u017b\u0001"+
		"\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u017d\u0005"+
		"(\u0000\u0000\u017d3\u0001\u0000\u0000\u0000\u017e\u0183\u0003<\u001e"+
		"\u0000\u017f\u0180\u0005*\u0000\u0000\u0180\u0182\u0003<\u001e\u0000\u0181"+
		"\u017f\u0001\u0000\u0000\u0000\u0182\u0185\u0001\u0000\u0000\u0000\u0183"+
		"\u0181\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184"+
		"5\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0186\u0189"+
		"\u0003:\u001d\u0000\u0187\u0189\u00059\u0000\u0000\u0188\u0186\u0001\u0000"+
		"\u0000\u0000\u0188\u0187\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000"+
		"\u0000\u0000\u018a\u018b\u0003f3\u0000\u018b\u018c\u0003<\u001e\u0000"+
		"\u018c7\u0001\u0000\u0000\u0000\u018d\u0190\u0003b1\u0000\u018e\u0191"+
		"\u00059\u0000\u0000\u018f\u0191\u0003:\u001d\u0000\u0190\u018e\u0001\u0000"+
		"\u0000\u0000\u0190\u018f\u0001\u0000\u0000\u0000\u0191\u0198\u0001\u0000"+
		"\u0000\u0000\u0192\u0195\u00059\u0000\u0000\u0193\u0195\u0003:\u001d\u0000"+
		"\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0193\u0001\u0000\u0000\u0000"+
		"\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0198\u0003d2\u0000\u0197\u018d"+
		"\u0001\u0000\u0000\u0000\u0197\u0194\u0001\u0000\u0000\u0000\u01989\u0001"+
		"\u0000\u0000\u0000\u0199\u019c\u0005$\u0000\u0000\u019a\u019c\u00032\u0019"+
		"\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019a\u0001\u0000\u0000"+
		"\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d\u019e\u0005-\u0000\u0000"+
		"\u019e\u01ae\u00059\u0000\u0000\u019f\u01a0\u0005$\u0000\u0000\u01a0\u01a5"+
		"\u0005-\u0000\u0000\u01a1\u01a2\u00032\u0019\u0000\u01a2\u01a3\u0005-"+
		"\u0000\u0000\u01a3\u01a5\u0001\u0000\u0000\u0000\u01a4\u019f\u0001\u0000"+
		"\u0000\u0000\u01a4\u01a1\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a8\u0001\u0000\u0000\u0000\u01a6\u01a7\u00059\u0000"+
		"\u0000\u01a7\u01a9\u0005-\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000"+
		"\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000"+
		"\u01ac\u01ae\u00059\u0000\u0000\u01ad\u019b\u0001\u0000\u0000\u0000\u01ad"+
		"\u01a4\u0001\u0000\u0000\u0000\u01ae;\u0001\u0000\u0000\u0000\u01af\u01b0"+
		"\u0003>\u001f\u0000\u01b0=\u0001\u0000\u0000\u0000\u01b1\u01b2\u0006\u001f"+
		"\uffff\uffff\u0000\u01b2\u01b3\u0003@ \u0000\u01b3\u01ba\u0001\u0000\u0000"+
		"\u0000\u01b4\u01b5\n\u0002\u0000\u0000\u01b5\u01b6\u0003R)\u0000\u01b6"+
		"\u01b7\u0003@ \u0000\u01b7\u01b9\u0001\u0000\u0000\u0000\u01b8\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b9\u01bc\u0001\u0000\u0000\u0000\u01ba\u01b8\u0001"+
		"\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb?\u0001\u0000"+
		"\u0000\u0000\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bd\u01be\u0006 \uffff"+
		"\uffff\u0000\u01be\u01bf\u0003B!\u0000\u01bf\u01c6\u0001\u0000\u0000\u0000"+
		"\u01c0\u01c1\n\u0002\u0000\u0000\u01c1\u01c2\u0003T*\u0000\u01c2\u01c3"+
		"\u0003B!\u0000\u01c3\u01c5\u0001\u0000\u0000\u0000\u01c4\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c5\u01c8\u0001\u0000\u0000\u0000\u01c6\u01c4\u0001\u0000"+
		"\u0000\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7A\u0001\u0000\u0000"+
		"\u0000\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c9\u01ca\u0006!\uffff\uffff"+
		"\u0000\u01ca\u01cb\u0003D\"\u0000\u01cb\u01d2\u0001\u0000\u0000\u0000"+
		"\u01cc\u01cd\n\u0002\u0000\u0000\u01cd\u01ce\u0003V+\u0000\u01ce\u01cf"+
		"\u0003D\"\u0000\u01cf\u01d1\u0001\u0000\u0000\u0000\u01d0\u01cc\u0001"+
		"\u0000\u0000\u0000\u01d1\u01d4\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3C\u0001\u0000"+
		"\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5\u01d6\u0006\"\uffff"+
		"\uffff\u0000\u01d6\u01d7\u0003F#\u0000\u01d7\u01de\u0001\u0000\u0000\u0000"+
		"\u01d8\u01d9\n\u0002\u0000\u0000\u01d9\u01da\u0003X,\u0000\u01da\u01db"+
		"\u0003F#\u0000\u01db\u01dd\u0001\u0000\u0000\u0000\u01dc\u01d8\u0001\u0000"+
		"\u0000\u0000\u01dd\u01e0\u0001\u0000\u0000\u0000\u01de\u01dc\u0001\u0000"+
		"\u0000\u0000\u01de\u01df\u0001\u0000\u0000\u0000\u01dfE\u0001\u0000\u0000"+
		"\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e1\u01e2\u0006#\uffff\uffff"+
		"\u0000\u01e2\u01e3\u0003H$\u0000\u01e3\u01ea\u0001\u0000\u0000\u0000\u01e4"+
		"\u01e5\n\u0002\u0000\u0000\u01e5\u01e6\u0003Z-\u0000\u01e6\u01e7\u0003"+
		"H$\u0000\u01e7\u01e9\u0001\u0000\u0000\u0000\u01e8\u01e4\u0001\u0000\u0000"+
		"\u0000\u01e9\u01ec\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000"+
		"\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01ebG\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ea\u0001\u0000\u0000\u0000\u01ed\u01ee\u0006$\uffff\uffff\u0000"+
		"\u01ee\u01ef\u0003J%\u0000\u01ef\u01f6\u0001\u0000\u0000\u0000\u01f0\u01f1"+
		"\n\u0002\u0000\u0000\u01f1\u01f2\u0003\\.\u0000\u01f2\u01f3\u0003J%\u0000"+
		"\u01f3\u01f5\u0001\u0000\u0000\u0000\u01f4\u01f0\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f8\u0001\u0000\u0000\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000"+
		"\u01f6\u01f7\u0001\u0000\u0000\u0000\u01f7I\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f6\u0001\u0000\u0000\u0000\u01f9\u01fa\u0006%\uffff\uffff\u0000\u01fa"+
		"\u01fb\u0003L&\u0000\u01fb\u0202\u0001\u0000\u0000\u0000\u01fc\u01fd\n"+
		"\u0002\u0000\u0000\u01fd\u01fe\u0003^/\u0000\u01fe\u01ff\u0003L&\u0000"+
		"\u01ff\u0201\u0001\u0000\u0000\u0000\u0200\u01fc\u0001\u0000\u0000\u0000"+
		"\u0201\u0204\u0001\u0000\u0000\u0000\u0202\u0200\u0001\u0000\u0000\u0000"+
		"\u0202\u0203\u0001\u0000\u0000\u0000\u0203K\u0001\u0000\u0000\u0000\u0204"+
		"\u0202\u0001\u0000\u0000\u0000\u0205\u0206\u0006&\uffff\uffff\u0000\u0206"+
		"\u0207\u0003N\'\u0000\u0207\u020e\u0001\u0000\u0000\u0000\u0208\u0209"+
		"\n\u0002\u0000\u0000\u0209\u020a\u0003`0\u0000\u020a\u020b\u0003N\'\u0000"+
		"\u020b\u020d\u0001\u0000\u0000\u0000\u020c\u0208\u0001\u0000\u0000\u0000"+
		"\u020d\u0210\u0001\u0000\u0000\u0000\u020e\u020c\u0001\u0000\u0000\u0000"+
		"\u020e\u020f\u0001\u0000\u0000\u0000\u020fM\u0001\u0000\u0000\u0000\u0210"+
		"\u020e\u0001\u0000\u0000\u0000\u0211\u0214\u00038\u001c\u0000\u0212\u0214"+
		"\u0003P(\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0213\u0212\u0001\u0000"+
		"\u0000\u0000\u0214O\u0001\u0000\u0000\u0000\u0215\u0221\u0005$\u0000\u0000"+
		"\u0216\u0221\u00059\u0000\u0000\u0217\u0221\u0003:\u001d\u0000\u0218\u0221"+
		"\u0003*\u0015\u0000\u0219\u021a\u0005.\u0000\u0000\u021a\u0221\u0003<"+
		"\u001e\u0000\u021b\u021c\u0005\'\u0000\u0000\u021c\u021d\u0003<\u001e"+
		"\u0000\u021d\u021e\u0005(\u0000\u0000\u021e\u0221\u0001\u0000\u0000\u0000"+
		"\u021f\u0221\u0003j5\u0000\u0220\u0215\u0001\u0000\u0000\u0000\u0220\u0216"+
		"\u0001\u0000\u0000\u0000\u0220\u0217\u0001\u0000\u0000\u0000\u0220\u0218"+
		"\u0001\u0000\u0000\u0000\u0220\u0219\u0001\u0000\u0000\u0000\u0220\u021b"+
		"\u0001\u0000\u0000\u0000\u0220\u021f\u0001\u0000\u0000\u0000\u0221Q\u0001"+
		"\u0000\u0000\u0000\u0222\u0223\u0005\t\u0000\u0000\u0223S\u0001\u0000"+
		"\u0000\u0000\u0224\u0225\u0005\n\u0000\u0000\u0225U\u0001\u0000\u0000"+
		"\u0000\u0226\u0227\u0005\u000b\u0000\u0000\u0227W\u0001\u0000\u0000\u0000"+
		"\u0228\u0229\u0005\f\u0000\u0000\u0229Y\u0001\u0000\u0000\u0000\u022a"+
		"\u022b\u0007\u0000\u0000\u0000\u022b[\u0001\u0000\u0000\u0000\u022c\u022d"+
		"\u0007\u0001\u0000\u0000\u022d]\u0001\u0000\u0000\u0000\u022e\u022f\u0007"+
		"\u0002\u0000\u0000\u022f_\u0001\u0000\u0000\u0000\u0230\u0231\u0007\u0003"+
		"\u0000\u0000\u0231a\u0001\u0000\u0000\u0000\u0232\u0233\u0007\u0004\u0000"+
		"\u0000\u0233c\u0001\u0000\u0000\u0000\u0234\u0235\u0007\u0004\u0000\u0000"+
		"\u0235e\u0001\u0000\u0000\u0000\u0236\u0237\u0007\u0005\u0000\u0000\u0237"+
		"g\u0001\u0000\u0000\u0000\u0238\u0239\u0007\u0006\u0000\u0000\u0239i\u0001"+
		"\u0000\u0000\u0000\u023a\u0240\u0003l6\u0000\u023b\u0240\u00055\u0000"+
		"\u0000\u023c\u0240\u00056\u0000\u0000\u023d\u0240\u00057\u0000\u0000\u023e"+
		"\u0240\u00058\u0000\u0000\u023f\u023a\u0001\u0000\u0000\u0000\u023f\u023b"+
		"\u0001\u0000\u0000\u0000\u023f\u023c\u0001\u0000\u0000\u0000\u023f\u023d"+
		"\u0001\u0000\u0000\u0000\u023f\u023e\u0001\u0000\u0000\u0000\u0240k\u0001"+
		"\u0000\u0000\u0000\u0241\u0243\u0003^/\u0000\u0242\u0241\u0001\u0000\u0000"+
		"\u0000\u0242\u0243\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000"+
		"\u0000\u0244\u0245\u00054\u0000\u0000\u0245m\u0001\u0000\u0000\u0000>"+
		"tx\u0083\u0085\u008c\u0092\u0094\u009c\u009e\u00a4\u00a9\u00b0\u00b3\u00b9"+
		"\u00be\u00cd\u00d0\u00d6\u00dc\u00e4\u00ee\u00f3\u00f9\u0109\u010f\u0115"+
		"\u011b\u0123\u0131\u0135\u0139\u0140\u0147\u014c\u0154\u0157\u015c\u0162"+
		"\u016a\u0171\u017a\u0183\u0188\u0190\u0194\u0197\u019b\u01a4\u01aa\u01ad"+
		"\u01ba\u01c6\u01d2\u01de\u01ea\u01f6\u0202\u020e\u0213\u0220\u023f\u0242";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}