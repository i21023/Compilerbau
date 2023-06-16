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
		T__24=25, T__25=26, T__26=27, STATIC=28, VOID=29, NEW=30, THIS=31, CLASS=32, 
		PUBLIC=33, PRIVATE=34, PROTECTED=35, PACKAGE=36, MAIN=37, LEFT_BRACE=38, 
		RIGHT_BRACE=39, LEFT_BRACKET=40, RIGHT_BRACKET=41, SEMICOLON=42, COMMA=43, 
		EQUALS=44, ASSIGN=45, DOT=46, NOT=47, IF=48, ELSE=49, WHILE=50, FOR=51, 
		RETURN=52, INT=53, BOOLEAN=54, CHAR=55, STRING=56, NULL=57, ID=58, WS=59, 
		InlineComment=60, MultilineComment=61;
	public static final int
		RULE_program = 0, RULE_public_class_decl = 1, RULE_class_decl = 2, RULE_const_decl = 3, 
		RULE_method_decl = 4, RULE_main_method_decl = 5, RULE_string_args = 6, 
		RULE_field_decl = 7, RULE_field_decl_concat = 8, RULE_parameter_list = 9, 
		RULE_method_type = 10, RULE_block = 11, RULE_statement_block = 12, RULE_statement = 13, 
		RULE_statement_block_inline = 14, RULE_statement_inline = 15, RULE_local_var_decl = 16, 
		RULE_local_var_decl_concat = 17, RULE_if_else_statement = 18, RULE_if_statement_inline = 19, 
		RULE_else_statement = 20, RULE_while_statement = 21, RULE_while_statement_inline = 22, 
		RULE_for_statement = 23, RULE_for_statement_inline = 24, RULE_for_init = 25, 
		RULE_for_statement_expr = 26, RULE_return_statement = 27, RULE_statement_expr = 28, 
		RULE_method_call_statement = 29, RULE_method_owner_prefix = 30, RULE_method_chain = 31, 
		RULE_new_statement = 32, RULE_argumentList = 33, RULE_assign_statement = 34, 
		RULE_crement_statement = 35, RULE_inst_var = 36, RULE_expr = 37, RULE_logical_or_expr = 38, 
		RULE_logical_and_expr = 39, RULE_bitwise_or_expr = 40, RULE_bitwise_and_expr = 41, 
		RULE_equality_expr = 42, RULE_relational_expr = 43, RULE_additive_expr = 44, 
		RULE_multiplicative_expr = 45, RULE_unary_expr = 46, RULE_primary_expr = 47, 
		RULE_logical_or_op = 48, RULE_logical_and_op = 49, RULE_bitwise_or_op = 50, 
		RULE_bitwise_and_op = 51, RULE_equality_op = 52, RULE_relational_op = 53, 
		RULE_add_sub_op = 54, RULE_mul_div_op = 55, RULE_pre_cre_op = 56, RULE_suf_cre_op = 57, 
		RULE_assign_op = 58, RULE_type = 59, RULE_access_mod = 60, RULE_literal = 61, 
		RULE_int = 62;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "public_class_decl", "class_decl", "const_decl", "method_decl", 
			"main_method_decl", "string_args", "field_decl", "field_decl_concat", 
			"parameter_list", "method_type", "block", "statement_block", "statement", 
			"statement_block_inline", "statement_inline", "local_var_decl", "local_var_decl_concat", 
			"if_else_statement", "if_statement_inline", "else_statement", "while_statement", 
			"while_statement_inline", "for_statement", "for_statement_inline", "for_init", 
			"for_statement_expr", "return_statement", "statement_expr", "method_call_statement", 
			"method_owner_prefix", "method_chain", "new_statement", "argumentList", 
			"assign_statement", "crement_statement", "inst_var", "expr", "logical_or_expr", 
			"logical_and_expr", "bitwise_or_expr", "bitwise_and_expr", "equality_expr", 
			"relational_expr", "additive_expr", "multiplicative_expr", "unary_expr", 
			"primary_expr", "logical_or_op", "logical_and_op", "bitwise_or_op", "bitwise_and_op", 
			"equality_op", "relational_op", "add_sub_op", "mul_div_op", "pre_cre_op", 
			"suf_cre_op", "assign_op", "type", "access_mod", "literal", "int"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'String'", "'['", "']'", "'args'", "'||'", "'&&'", "'|'", "'&'", 
			"'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'++'", 
			"'--'", "'+='", "'-='", "'*='", "'/='", "'%='", "'int'", "'boolean'", 
			"'char'", "'static'", "'void'", "'new'", "'this'", "'class'", "'public'", 
			"'private'", "'protected'", "'package'", "'main'", "'{'", "'}'", "'('", 
			"')'", "';'", "','", "'=='", "'='", "'.'", "'!'", "'if'", "'else'", "'while'", 
			"'for'", "'return'", null, null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "STATIC", "VOID", "NEW", "THIS", "CLASS", "PUBLIC", 
			"PRIVATE", "PROTECTED", "PACKAGE", "MAIN", "LEFT_BRACE", "RIGHT_BRACE", 
			"LEFT_BRACKET", "RIGHT_BRACKET", "SEMICOLON", "COMMA", "EQUALS", "ASSIGN", 
			"DOT", "NOT", "IF", "ELSE", "WHILE", "FOR", "RETURN", "INT", "BOOLEAN", 
			"CHAR", "STRING", "NULL", "ID", "WS", "InlineComment", "MultilineComment"
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
		public TerminalNode PACKAGE() { return getToken(MiniJavaParser.PACKAGE, 0); }
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
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(126);
				match(PACKAGE);
				setState(127);
				match(ID);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(128);
					match(DOT);
					setState(129);
					match(ID);
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(135);
				match(SEMICOLON);
				}
			}

			setState(138);
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
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public TerminalNode CLASS() { return getToken(MiniJavaParser.CLASS, 0); }
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
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PUBLIC:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(PUBLIC);
				setState(141);
				match(CLASS);
				setState(142);
				match(ID);
				setState(143);
				match(LEFT_BRACE);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((_la) & ~0x3f) == 0 && ((1L << _la) & 288230437321441282L) != 0) {
					{
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						setState(144);
						const_decl();
						}
						break;
					case 2:
						{
						setState(145);
						method_decl();
						}
						break;
					case 3:
						{
						setState(146);
						field_decl();
						}
						break;
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				match(RIGHT_BRACE);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CLASS) {
					{
					{
					setState(153);
					class_decl();
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(159);
					class_decl();
					}
					}
					setState(162); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CLASS );
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
		public TerminalNode CLASS() { return getToken(MiniJavaParser.CLASS, 0); }
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
			setState(166);
			match(CLASS);
			setState(167);
			match(ID);
			setState(168);
			match(LEFT_BRACE);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 288230437321441282L) != 0) {
				{
				setState(172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(169);
					const_decl();
					}
					break;
				case 2:
					{
					setState(170);
					method_decl();
					}
					break;
				case 3:
					{
					setState(171);
					field_decl();
					}
					break;
				}
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(177);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Access_modContext access_mod() {
			return getRuleContext(Access_modContext.class,0);
		}
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
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0) {
				{
				setState(179);
				access_mod();
				}
			}

			setState(182);
			match(ID);
			setState(183);
			match(LEFT_BRACKET);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376386592770L) != 0) {
				{
				setState(184);
				parameter_list();
				}
			}

			setState(187);
			match(RIGHT_BRACKET);
			setState(188);
			block();
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Access_modContext access_mod() {
			return getRuleContext(Access_modContext.class,0);
		}
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
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				main_method_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0) {
					{
					setState(191);
					access_mod();
					}
				}

				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(194);
					match(STATIC);
					}
				}

				setState(197);
				method_type();
				setState(198);
				match(ID);
				setState(199);
				match(LEFT_BRACKET);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376386592770L) != 0) {
					{
					setState(200);
					parameter_list();
					}
				}

				setState(203);
				match(RIGHT_BRACKET);
				setState(204);
				block();
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
	public static class Main_method_declContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public TerminalNode STATIC() { return getToken(MiniJavaParser.STATIC, 0); }
		public TerminalNode VOID() { return getToken(MiniJavaParser.VOID, 0); }
		public TerminalNode MAIN() { return getToken(MiniJavaParser.MAIN, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public String_argsContext string_args() {
			return getRuleContext(String_argsContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(PUBLIC);
			setState(209);
			match(STATIC);
			setState(210);
			match(VOID);
			setState(211);
			match(MAIN);
			setState(212);
			match(LEFT_BRACKET);
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(213);
				string_args();
				}
				break;
			case 2:
				{
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376386592770L) != 0) {
					{
					setState(214);
					parameter_list();
					}
				}

				}
				break;
			}
			setState(219);
			match(RIGHT_BRACKET);
			setState(220);
			block();
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
	public static class String_argsContext extends ParserRuleContext {
		public String_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterString_args(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitString_args(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitString_args(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_argsContext string_args() throws RecognitionException {
		String_argsContext _localctx = new String_argsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_string_args);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(T__0);
			setState(223);
			match(T__1);
			setState(224);
			match(T__2);
			setState(225);
			match(T__3);
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
		public Access_modContext access_mod() {
			return getRuleContext(Access_modContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0) {
				{
				setState(227);
				access_mod();
				}
			}

			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(230);
				match(STATIC);
				}
			}

			setState(233);
			type();
			setState(234);
			match(ID);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(235);
				match(ASSIGN);
				setState(236);
				expr();
				}
			}

			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(239);
				match(COMMA);
				setState(240);
				field_decl_concat();
				}
				}
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(246);
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
		enterRule(_localctx, 16, RULE_field_decl_concat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(ID);
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(249);
				match(ASSIGN);
				setState(250);
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
		enterRule(_localctx, 18, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			type();
			setState(254);
			match(ID);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(255);
				match(COMMA);
				setState(256);
				type();
				setState(257);
				match(ID);
				}
				}
				setState(263);
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
		enterRule(_localctx, 20, RULE_method_type);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(VOID);
				}
				break;
			case T__0:
			case T__24:
			case T__25:
			case T__26:
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(MiniJavaParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(MiniJavaParser.RIGHT_BRACE, 0); }
		public List<Statement_blockContext> statement_block() {
			return getRuleContexts(Statement_blockContext.class);
		}
		public Statement_blockContext statement_block(int i) {
			return getRuleContext(Statement_blockContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(LEFT_BRACE);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 368451022849048578L) != 0) {
				{
				{
				setState(269);
				statement_block();
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(275);
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
	public static class Statement_blockContext extends ParserRuleContext {
		public Local_var_declContext local_var_decl() {
			return getRuleContext(Local_var_declContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Statement_block_inlineContext statement_block_inline() {
			return getRuleContext(Statement_block_inlineContext.class,0);
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
		enterRule(_localctx, 24, RULE_statement_block);
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				local_var_decl();
				setState(278);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(280);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(281);
				statement_block_inline();
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
	public static class StatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 26, RULE_statement);
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				block();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				if_else_statement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				while_statement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(287);
				for_statement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(288);
				return_statement();
				setState(289);
				match(SEMICOLON);
				}
				break;
			case T__17:
			case T__18:
			case NEW:
			case THIS:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(291);
				statement_expr();
				setState(292);
				match(SEMICOLON);
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
	public static class Statement_block_inlineContext extends ParserRuleContext {
		public If_statement_inlineContext if_statement_inline() {
			return getRuleContext(If_statement_inlineContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public Statement_inlineContext statement_inline() {
			return getRuleContext(Statement_inlineContext.class,0);
		}
		public Statement_block_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_block_inline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatement_block_inline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatement_block_inline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatement_block_inline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_block_inlineContext statement_block_inline() throws RecognitionException {
		Statement_block_inlineContext _localctx = new Statement_block_inlineContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement_block_inline);
		try {
			setState(309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				if_statement_inline();
				setState(299);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEMICOLON:
					{
					setState(297);
					match(SEMICOLON);
					}
					break;
				case T__17:
				case T__18:
				case NEW:
				case THIS:
				case LEFT_BRACE:
				case IF:
				case WHILE:
				case FOR:
				case RETURN:
				case STRING:
				case ID:
					{
					setState(298);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(302);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(301);
					else_statement();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				statement_inline();
				setState(307);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEMICOLON:
					{
					setState(305);
					match(SEMICOLON);
					}
					break;
				case T__17:
				case T__18:
				case NEW:
				case THIS:
				case LEFT_BRACE:
				case IF:
				case WHILE:
				case FOR:
				case RETURN:
				case STRING:
				case ID:
					{
					setState(306);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
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
	public static class Statement_inlineContext extends ParserRuleContext {
		public If_statement_inlineContext if_statement_inline() {
			return getRuleContext(If_statement_inlineContext.class,0);
		}
		public While_statement_inlineContext while_statement_inline() {
			return getRuleContext(While_statement_inlineContext.class,0);
		}
		public For_statement_inlineContext for_statement_inline() {
			return getRuleContext(For_statement_inlineContext.class,0);
		}
		public Statement_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_inline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterStatement_inline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitStatement_inline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitStatement_inline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_inlineContext statement_inline() throws RecognitionException {
		Statement_inlineContext _localctx = new Statement_inlineContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statement_inline);
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(311);
				if_statement_inline();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				while_statement_inline();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(313);
				for_statement_inline();
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
		enterRule(_localctx, 32, RULE_local_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			type();
			setState(317);
			match(ID);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(318);
				match(ASSIGN);
				setState(319);
				expr();
				}
			}

			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(322);
				match(COMMA);
				setState(323);
				local_var_decl_concat();
				}
				}
				setState(328);
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
		enterRule(_localctx, 34, RULE_local_var_decl_concat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(ID);
			setState(332);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(330);
				match(ASSIGN);
				setState(331);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 36, RULE_if_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(IF);
			setState(335);
			match(LEFT_BRACKET);
			setState(336);
			expr();
			setState(337);
			match(RIGHT_BRACKET);
			setState(338);
			block();
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(339);
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
	public static class If_statement_inlineContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniJavaParser.IF, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Statement_inlineContext statement_inline() {
			return getRuleContext(Statement_inlineContext.class,0);
		}
		public If_statement_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement_inline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterIf_statement_inline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitIf_statement_inline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitIf_statement_inline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statement_inlineContext if_statement_inline() throws RecognitionException {
		If_statement_inlineContext _localctx = new If_statement_inlineContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_if_statement_inline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(IF);
			setState(343);
			match(LEFT_BRACKET);
			setState(344);
			expr();
			setState(345);
			match(RIGHT_BRACKET);
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(346);
				statement_inline();
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
		public TerminalNode SEMICOLON() { return getToken(MiniJavaParser.SEMICOLON, 0); }
		public Statement_block_inlineContext statement_block_inline() {
			return getRuleContext(Statement_block_inlineContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
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
		enterRule(_localctx, 40, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(ELSE);
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(350);
				match(SEMICOLON);
				}
				break;
			case 2:
				{
				setState(351);
				statement_block_inline();
				}
				break;
			case 3:
				{
				setState(352);
				block();
				}
				break;
			case 4:
				{
				setState(353);
				statement();
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
	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 42, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(WHILE);
			setState(357);
			match(LEFT_BRACKET);
			setState(358);
			expr();
			setState(359);
			match(RIGHT_BRACKET);
			setState(360);
			block();
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
	public static class While_statement_inlineContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniJavaParser.WHILE, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public Statement_inlineContext statement_inline() {
			return getRuleContext(Statement_inlineContext.class,0);
		}
		public While_statement_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement_inline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterWhile_statement_inline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitWhile_statement_inline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitWhile_statement_inline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statement_inlineContext while_statement_inline() throws RecognitionException {
		While_statement_inlineContext _localctx = new While_statement_inlineContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_while_statement_inline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(WHILE);
			setState(363);
			match(LEFT_BRACKET);
			setState(364);
			expr();
			setState(365);
			match(RIGHT_BRACKET);
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(366);
				statement_inline();
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
	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniJavaParser.FOR, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniJavaParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniJavaParser.SEMICOLON, i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 46, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(FOR);
			setState(370);
			match(LEFT_BRACKET);
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 360287973646532610L) != 0) {
				{
				setState(371);
				for_init();
				}
			}

			setState(374);
			match(SEMICOLON);
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 567595393270726656L) != 0) {
				{
				setState(375);
				expr();
				}
			}

			setState(378);
			match(SEMICOLON);
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 360287973411651584L) != 0) {
				{
				setState(379);
				for_statement_expr();
				}
			}

			setState(382);
			match(RIGHT_BRACKET);
			setState(383);
			block();
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
	public static class For_statement_inlineContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MiniJavaParser.FOR, 0); }
		public TerminalNode LEFT_BRACKET() { return getToken(MiniJavaParser.LEFT_BRACKET, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MiniJavaParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MiniJavaParser.SEMICOLON, i);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(MiniJavaParser.RIGHT_BRACKET, 0); }
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public For_statement_exprContext for_statement_expr() {
			return getRuleContext(For_statement_exprContext.class,0);
		}
		public Statement_inlineContext statement_inline() {
			return getRuleContext(Statement_inlineContext.class,0);
		}
		public For_statement_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement_inline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterFor_statement_inline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitFor_statement_inline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitFor_statement_inline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statement_inlineContext for_statement_inline() throws RecognitionException {
		For_statement_inlineContext _localctx = new For_statement_inlineContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_for_statement_inline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			match(FOR);
			setState(386);
			match(LEFT_BRACKET);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 360287973646532610L) != 0) {
				{
				setState(387);
				for_init();
				}
			}

			setState(390);
			match(SEMICOLON);
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 567595393270726656L) != 0) {
				{
				setState(391);
				expr();
				}
			}

			setState(394);
			match(SEMICOLON);
			setState(396);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 360287973411651584L) != 0) {
				{
				setState(395);
				for_statement_expr();
				}
			}

			setState(398);
			match(RIGHT_BRACKET);
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(399);
				statement_inline();
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
		enterRule(_localctx, 50, RULE_for_init);
		try {
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(402);
				for_statement_expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
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
		enterRule(_localctx, 52, RULE_for_statement_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			statement_expr();
			setState(411);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(407);
				match(COMMA);
				setState(408);
				statement_expr();
				}
				}
				setState(413);
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
		enterRule(_localctx, 54, RULE_return_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			match(RETURN);
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 567595393270726656L) != 0) {
				{
				setState(415);
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
		enterRule(_localctx, 56, RULE_statement_expr);
		try {
			setState(422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				method_call_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				new_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(420);
				assign_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(421);
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
		enterRule(_localctx, 58, RULE_method_call_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(424);
				method_owner_prefix();
				}
				break;
			}
			setState(430);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(427);
					method_chain();
					}
					} 
				}
				setState(432);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			{
			setState(433);
			match(ID);
			setState(434);
			match(LEFT_BRACKET);
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 567595393270726656L) != 0) {
				{
				setState(435);
				argumentList();
				}
			}

			setState(438);
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
		public TerminalNode STRING() { return getToken(MiniJavaParser.STRING, 0); }
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
		enterRule(_localctx, 60, RULE_method_owner_prefix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(440);
				match(THIS);
				}
				break;
			case 2:
				{
				setState(441);
				inst_var();
				}
				break;
			case 3:
				{
				setState(442);
				new_statement();
				}
				break;
			case 4:
				{
				setState(443);
				match(ID);
				}
				break;
			case 5:
				{
				setState(444);
				match(STRING);
				}
				break;
			}
			setState(447);
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
		enterRule(_localctx, 62, RULE_method_chain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(ID);
			setState(450);
			match(LEFT_BRACKET);
			setState(452);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 567595393270726656L) != 0) {
				{
				setState(451);
				argumentList();
				}
			}

			setState(454);
			match(RIGHT_BRACKET);
			setState(455);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		enterRule(_localctx, 64, RULE_new_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(NEW);
			setState(458);
			type();
			setState(459);
			match(LEFT_BRACKET);
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 567595393270726656L) != 0) {
				{
				setState(460);
				argumentList();
				}
			}

			setState(463);
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
		enterRule(_localctx, 66, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			expr();
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(466);
				match(COMMA);
				setState(467);
				expr();
				}
				}
				setState(472);
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
		enterRule(_localctx, 68, RULE_assign_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(473);
				inst_var();
				}
				break;
			case 2:
				{
				setState(474);
				match(ID);
				}
				break;
			}
			setState(477);
			assign_op();
			setState(478);
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
		enterRule(_localctx, 70, RULE_crement_statement);
		try {
			setState(490);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(480);
				pre_cre_op();
				setState(483);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
				case 1:
					{
					setState(481);
					match(ID);
					}
					break;
				case 2:
					{
					setState(482);
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
				setState(487);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
				case 1:
					{
					setState(485);
					match(ID);
					}
					break;
				case 2:
					{
					setState(486);
					inst_var();
					}
					break;
				}
				setState(489);
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
		enterRule(_localctx, 72, RULE_inst_var);
		try {
			int _alt;
			setState(512);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(494);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case THIS:
					{
					setState(492);
					match(THIS);
					}
					break;
				case NEW:
					{
					setState(493);
					new_statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(496);
				match(DOT);
				setState(497);
				match(ID);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(503);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case THIS:
					{
					{
					setState(498);
					match(THIS);
					setState(499);
					match(DOT);
					}
					}
					break;
				case NEW:
					{
					{
					setState(500);
					new_statement();
					setState(501);
					match(DOT);
					}
					}
					break;
				case ID:
					break;
				default:
					break;
				}
				setState(507); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(505);
						match(ID);
						setState(506);
						match(DOT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(509); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,63,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(511);
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
		enterRule(_localctx, 74, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
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
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_logical_or_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(517);
			logical_and_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(525);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Logical_or_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logical_or_expr);
					setState(519);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(520);
					logical_or_op();
					setState(521);
					logical_and_expr(0);
					}
					} 
				}
				setState(527);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
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
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_logical_and_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(529);
			bitwise_or_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(537);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Logical_and_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logical_and_expr);
					setState(531);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(532);
					logical_and_op();
					setState(533);
					bitwise_or_expr(0);
					}
					} 
				}
				setState(539);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
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
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_bitwise_or_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(541);
			bitwise_and_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(549);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_or_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_or_expr);
					setState(543);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(544);
					bitwise_or_op();
					setState(545);
					bitwise_and_expr(0);
					}
					} 
				}
				setState(551);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
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
		int _startState = 82;
		enterRecursionRule(_localctx, 82, RULE_bitwise_and_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(553);
			equality_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(561);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_and_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_and_expr);
					setState(555);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(556);
					bitwise_and_op();
					setState(557);
					equality_expr(0);
					}
					} 
				}
				setState(563);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
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
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_equality_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(565);
			relational_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(573);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equality_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equality_expr);
					setState(567);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(568);
					equality_op();
					setState(569);
					relational_expr(0);
					}
					} 
				}
				setState(575);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,69,_ctx);
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
		int _startState = 86;
		enterRecursionRule(_localctx, 86, RULE_relational_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(577);
			additive_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(585);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Relational_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relational_expr);
					setState(579);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(580);
					relational_op();
					setState(581);
					additive_expr(0);
					}
					} 
				}
				setState(587);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_additive_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(589);
			multiplicative_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(597);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Additive_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_additive_expr);
					setState(591);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(592);
					add_sub_op();
					setState(593);
					multiplicative_expr(0);
					}
					} 
				}
				setState(599);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
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
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_multiplicative_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(601);
			unary_expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(609);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Multiplicative_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multiplicative_expr);
					setState(603);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(604);
					mul_div_op();
					setState(605);
					unary_expr();
					}
					} 
				}
				setState(611);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
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
		enterRule(_localctx, 92, RULE_unary_expr);
		try {
			setState(614);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(612);
				crement_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(613);
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
		enterRule(_localctx, 94, RULE_primary_expr);
		try {
			setState(627);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(616);
				match(THIS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(617);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(618);
				inst_var();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(619);
				statement_expr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(620);
				match(NOT);
				setState(621);
				expr();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(622);
				match(LEFT_BRACKET);
				setState(623);
				expr();
				setState(624);
				match(RIGHT_BRACKET);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(626);
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
		enterRule(_localctx, 96, RULE_logical_or_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(T__4);
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
		enterRule(_localctx, 98, RULE_logical_and_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			match(T__5);
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
		enterRule(_localctx, 100, RULE_bitwise_or_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			match(T__6);
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
		enterRule(_localctx, 102, RULE_bitwise_and_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			match(T__7);
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
		enterRule(_localctx, 104, RULE_equality_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==EQUALS) ) {
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
		enterRule(_localctx, 106, RULE_relational_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 15360L) != 0) ) {
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
		enterRule(_localctx, 108, RULE_add_sub_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
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
		enterRule(_localctx, 110, RULE_mul_div_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			_la = _input.LA(1);
			if ( !(_la==T__15 || _la==T__16) ) {
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
		enterRule(_localctx, 112, RULE_pre_cre_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
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
		enterRule(_localctx, 114, RULE_suf_cre_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
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
		enterRule(_localctx, 116, RULE_assign_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 35184404594688L) != 0) ) {
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
		enterRule(_localctx, 118, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376386592770L) != 0) ) {
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
	public static class Access_modContext extends ParserRuleContext {
		public TerminalNode PRIVATE() { return getToken(MiniJavaParser.PRIVATE, 0); }
		public TerminalNode PUBLIC() { return getToken(MiniJavaParser.PUBLIC, 0); }
		public TerminalNode PROTECTED() { return getToken(MiniJavaParser.PROTECTED, 0); }
		public Access_modContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access_mod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).enterAccess_mod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniJavaListener ) ((MiniJavaListener)listener).exitAccess_mod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniJavaVisitor ) return ((MiniJavaVisitor<? extends T>)visitor).visitAccess_mod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Access_modContext access_mod() throws RecognitionException {
		Access_modContext _localctx = new Access_modContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_access_mod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 60129542144L) != 0) ) {
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
		enterRule(_localctx, 122, RULE_literal);
		try {
			setState(660);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__14:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(655);
				int_();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(656);
				match(BOOLEAN);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(657);
				match(CHAR);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(658);
				match(STRING);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 5);
				{
				setState(659);
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
		enterRule(_localctx, 124, RULE_int);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13 || _la==T__14) {
				{
				setState(662);
				add_sub_op();
				}
			}

			setState(665);
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
		case 38:
			return logical_or_expr_sempred((Logical_or_exprContext)_localctx, predIndex);
		case 39:
			return logical_and_expr_sempred((Logical_and_exprContext)_localctx, predIndex);
		case 40:
			return bitwise_or_expr_sempred((Bitwise_or_exprContext)_localctx, predIndex);
		case 41:
			return bitwise_and_expr_sempred((Bitwise_and_exprContext)_localctx, predIndex);
		case 42:
			return equality_expr_sempred((Equality_exprContext)_localctx, predIndex);
		case 43:
			return relational_expr_sempred((Relational_exprContext)_localctx, predIndex);
		case 44:
			return additive_expr_sempred((Additive_exprContext)_localctx, predIndex);
		case 45:
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
		"\u0004\u0001=\u029c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000\u0083\b\u0000\n\u0000\f\u0000\u0086\t\u0000\u0001"+
		"\u0000\u0003\u0000\u0089\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001\u0094\b\u0001\n\u0001\f\u0001\u0097\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001\u009b\b\u0001\n\u0001\f\u0001\u009e\t\u0001\u0001\u0001\u0004"+
		"\u0001\u00a1\b\u0001\u000b\u0001\f\u0001\u00a2\u0003\u0001\u00a5\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002\u00ad\b\u0002\n\u0002\f\u0002\u00b0\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0003\u0003\u00b5\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u00ba\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0003\u0004\u00c1\b\u0004\u0001\u0004\u0003\u0004\u00c4"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00ca"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00cf\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u00d8\b\u0005\u0003\u0005\u00da\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0003\u0007\u00e5\b\u0007\u0001\u0007\u0003"+
		"\u0007\u00e8\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00ee\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00f2\b\u0007"+
		"\n\u0007\f\u0007\u00f5\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0003\b\u00fc\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u0104\b\t\n\t\f\t\u0107\t\t\u0001\n\u0001\n\u0003\n\u010b\b"+
		"\n\u0001\u000b\u0001\u000b\u0005\u000b\u010f\b\u000b\n\u000b\f\u000b\u0112"+
		"\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u011b\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u0127\b\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u012c\b\u000e\u0001\u000e\u0003\u000e\u012f\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0134\b\u000e\u0003\u000e"+
		"\u0136\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u013b\b"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0141"+
		"\b\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0145\b\u0010\n\u0010\f\u0010"+
		"\u0148\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u014d\b"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u0155\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u015c\b\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0163\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0170\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0175\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u0179\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u017d"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u0185\b\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0189"+
		"\b\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u018d\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u0191\b\u0018\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u0195\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u019a\b"+
		"\u001a\n\u001a\f\u001a\u019d\t\u001a\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u01a1\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u01a7\b\u001c\u0001\u001d\u0003\u001d\u01aa\b\u001d\u0001\u001d\u0005"+
		"\u001d\u01ad\b\u001d\n\u001d\f\u001d\u01b0\t\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u01b5\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01be\b\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u01c5\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0003 \u01ce\b \u0001 \u0001 \u0001!\u0001!\u0001!\u0005!\u01d5"+
		"\b!\n!\f!\u01d8\t!\u0001\"\u0001\"\u0003\"\u01dc\b\"\u0001\"\u0001\"\u0001"+
		"\"\u0001#\u0001#\u0001#\u0003#\u01e4\b#\u0001#\u0001#\u0003#\u01e8\b#"+
		"\u0001#\u0003#\u01eb\b#\u0001$\u0001$\u0003$\u01ef\b$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0003$\u01f8\b$\u0001$\u0001$\u0004$\u01fc"+
		"\b$\u000b$\f$\u01fd\u0001$\u0003$\u0201\b$\u0001%\u0001%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001&\u0005&\u020c\b&\n&\f&\u020f\t&\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u0218\b\'\n"+
		"\'\f\'\u021b\t\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0005"+
		"(\u0224\b(\n(\f(\u0227\t(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0005)\u0230\b)\n)\f)\u0233\t)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0005*\u023c\b*\n*\f*\u023f\t*\u0001+\u0001+\u0001+\u0001+\u0001"+
		"+\u0001+\u0001+\u0005+\u0248\b+\n+\f+\u024b\t+\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0005,\u0254\b,\n,\f,\u0257\t,\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0005-\u0260\b-\n-\f-\u0263\t-\u0001.\u0001"+
		".\u0003.\u0267\b.\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0003/\u0274\b/\u00010\u00010\u00011\u00011\u0001"+
		"2\u00012\u00013\u00013\u00014\u00014\u00015\u00015\u00016\u00016\u0001"+
		"7\u00017\u00018\u00018\u00019\u00019\u0001:\u0001:\u0001;\u0001;\u0001"+
		"<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u0295\b=\u0001>\u0003"+
		">\u0298\b>\u0001>\u0001>\u0001>\u0000\bLNPRTVXZ?\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|\u0000\b\u0002\u0000\t\t,,\u0001"+
		"\u0000\n\r\u0001\u0000\u000e\u000f\u0001\u0000\u0010\u0011\u0001\u0000"+
		"\u0012\u0013\u0002\u0000\u0014\u0018--\u0003\u0000\u0001\u0001\u0019\u001b"+
		"::\u0001\u0000!#\u02c1\u0000\u0088\u0001\u0000\u0000\u0000\u0002\u00a4"+
		"\u0001\u0000\u0000\u0000\u0004\u00a6\u0001\u0000\u0000\u0000\u0006\u00b4"+
		"\u0001\u0000\u0000\u0000\b\u00ce\u0001\u0000\u0000\u0000\n\u00d0\u0001"+
		"\u0000\u0000\u0000\f\u00de\u0001\u0000\u0000\u0000\u000e\u00e4\u0001\u0000"+
		"\u0000\u0000\u0010\u00f8\u0001\u0000\u0000\u0000\u0012\u00fd\u0001\u0000"+
		"\u0000\u0000\u0014\u010a\u0001\u0000\u0000\u0000\u0016\u010c\u0001\u0000"+
		"\u0000\u0000\u0018\u011a\u0001\u0000\u0000\u0000\u001a\u0126\u0001\u0000"+
		"\u0000\u0000\u001c\u0135\u0001\u0000\u0000\u0000\u001e\u013a\u0001\u0000"+
		"\u0000\u0000 \u013c\u0001\u0000\u0000\u0000\"\u0149\u0001\u0000\u0000"+
		"\u0000$\u014e\u0001\u0000\u0000\u0000&\u0156\u0001\u0000\u0000\u0000("+
		"\u015d\u0001\u0000\u0000\u0000*\u0164\u0001\u0000\u0000\u0000,\u016a\u0001"+
		"\u0000\u0000\u0000.\u0171\u0001\u0000\u0000\u00000\u0181\u0001\u0000\u0000"+
		"\u00002\u0194\u0001\u0000\u0000\u00004\u0196\u0001\u0000\u0000\u00006"+
		"\u019e\u0001\u0000\u0000\u00008\u01a6\u0001\u0000\u0000\u0000:\u01a9\u0001"+
		"\u0000\u0000\u0000<\u01bd\u0001\u0000\u0000\u0000>\u01c1\u0001\u0000\u0000"+
		"\u0000@\u01c9\u0001\u0000\u0000\u0000B\u01d1\u0001\u0000\u0000\u0000D"+
		"\u01db\u0001\u0000\u0000\u0000F\u01ea\u0001\u0000\u0000\u0000H\u0200\u0001"+
		"\u0000\u0000\u0000J\u0202\u0001\u0000\u0000\u0000L\u0204\u0001\u0000\u0000"+
		"\u0000N\u0210\u0001\u0000\u0000\u0000P\u021c\u0001\u0000\u0000\u0000R"+
		"\u0228\u0001\u0000\u0000\u0000T\u0234\u0001\u0000\u0000\u0000V\u0240\u0001"+
		"\u0000\u0000\u0000X\u024c\u0001\u0000\u0000\u0000Z\u0258\u0001\u0000\u0000"+
		"\u0000\\\u0266\u0001\u0000\u0000\u0000^\u0273\u0001\u0000\u0000\u0000"+
		"`\u0275\u0001\u0000\u0000\u0000b\u0277\u0001\u0000\u0000\u0000d\u0279"+
		"\u0001\u0000\u0000\u0000f\u027b\u0001\u0000\u0000\u0000h\u027d\u0001\u0000"+
		"\u0000\u0000j\u027f\u0001\u0000\u0000\u0000l\u0281\u0001\u0000\u0000\u0000"+
		"n\u0283\u0001\u0000\u0000\u0000p\u0285\u0001\u0000\u0000\u0000r\u0287"+
		"\u0001\u0000\u0000\u0000t\u0289\u0001\u0000\u0000\u0000v\u028b\u0001\u0000"+
		"\u0000\u0000x\u028d\u0001\u0000\u0000\u0000z\u0294\u0001\u0000\u0000\u0000"+
		"|\u0297\u0001\u0000\u0000\u0000~\u007f\u0005$\u0000\u0000\u007f\u0084"+
		"\u0005:\u0000\u0000\u0080\u0081\u0005.\u0000\u0000\u0081\u0083\u0005:"+
		"\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000"+
		"\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000"+
		"\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0087\u0089\u0005*\u0000\u0000\u0088~\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0003\u0002\u0001\u0000\u008b\u0001\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005!\u0000\u0000\u008d\u008e\u0005 \u0000\u0000\u008e\u008f"+
		"\u0005:\u0000\u0000\u008f\u0095\u0005&\u0000\u0000\u0090\u0094\u0003\u0006"+
		"\u0003\u0000\u0091\u0094\u0003\b\u0004\u0000\u0092\u0094\u0003\u000e\u0007"+
		"\u0000\u0093\u0090\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000"+
		"\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000"+
		"\u0000\u0098\u009c\u0005\'\u0000\u0000\u0099\u009b\u0003\u0004\u0002\u0000"+
		"\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u00a5\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009f\u00a1\u0003\u0004\u0002\u0000\u00a0\u009f\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a4\u008c\u0001\u0000\u0000\u0000\u00a4\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a5\u0003\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005 \u0000\u0000\u00a7"+
		"\u00a8\u0005:\u0000\u0000\u00a8\u00ae\u0005&\u0000\u0000\u00a9\u00ad\u0003"+
		"\u0006\u0003\u0000\u00aa\u00ad\u0003\b\u0004\u0000\u00ab\u00ad\u0003\u000e"+
		"\u0007\u0000\u00ac\u00a9\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0005\'\u0000\u0000\u00b2\u0005\u0001\u0000\u0000"+
		"\u0000\u00b3\u00b5\u0003x<\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0005:\u0000\u0000\u00b7\u00b9\u0005(\u0000\u0000\u00b8\u00ba\u0003"+
		"\u0012\t\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005)\u0000"+
		"\u0000\u00bc\u00bd\u0003\u0016\u000b\u0000\u00bd\u0007\u0001\u0000\u0000"+
		"\u0000\u00be\u00cf\u0003\n\u0005\u0000\u00bf\u00c1\u0003x<\u0000\u00c0"+
		"\u00bf\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c2\u00c4\u0005\u001c\u0000\u0000\u00c3"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0003\u0014\n\u0000\u00c6\u00c7"+
		"\u0005:\u0000\u0000\u00c7\u00c9\u0005(\u0000\u0000\u00c8\u00ca\u0003\u0012"+
		"\t\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005)\u0000\u0000"+
		"\u00cc\u00cd\u0003\u0016\u000b\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000"+
		"\u00ce\u00be\u0001\u0000\u0000\u0000\u00ce\u00c0\u0001\u0000\u0000\u0000"+
		"\u00cf\t\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005!\u0000\u0000\u00d1"+
		"\u00d2\u0005\u001c\u0000\u0000\u00d2\u00d3\u0005\u001d\u0000\u0000\u00d3"+
		"\u00d4\u0005%\u0000\u0000\u00d4\u00d9\u0005(\u0000\u0000\u00d5\u00da\u0003"+
		"\f\u0006\u0000\u00d6\u00d8\u0003\u0012\t\u0000\u00d7\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00da\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d5\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc\u0005)\u0000"+
		"\u0000\u00dc\u00dd\u0003\u0016\u000b\u0000\u00dd\u000b\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0005\u0001\u0000\u0000\u00df\u00e0\u0005\u0002\u0000"+
		"\u0000\u00e0\u00e1\u0005\u0003\u0000\u0000\u00e1\u00e2\u0005\u0004\u0000"+
		"\u0000\u00e2\r\u0001\u0000\u0000\u0000\u00e3\u00e5\u0003x<\u0000\u00e4"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e8\u0005\u001c\u0000\u0000\u00e7"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea\u0003v;\u0000\u00ea\u00ed\u0005"+
		":\u0000\u0000\u00eb\u00ec\u0005-\u0000\u0000\u00ec\u00ee\u0003J%\u0000"+
		"\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ee\u00f3\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005+\u0000\u0000\u00f0"+
		"\u00f2\u0003\u0010\b\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005*\u0000\u0000\u00f7\u000f\u0001"+
		"\u0000\u0000\u0000\u00f8\u00fb\u0005:\u0000\u0000\u00f9\u00fa\u0005-\u0000"+
		"\u0000\u00fa\u00fc\u0003J%\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fc\u0011\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fe\u0003v;\u0000\u00fe\u0105\u0005:\u0000\u0000\u00ff\u0100\u0005"+
		"+\u0000\u0000\u0100\u0101\u0003v;\u0000\u0101\u0102\u0005:\u0000\u0000"+
		"\u0102\u0104\u0001\u0000\u0000\u0000\u0103\u00ff\u0001\u0000\u0000\u0000"+
		"\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000"+
		"\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0013\u0001\u0000\u0000\u0000"+
		"\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010b\u0005\u001d\u0000\u0000"+
		"\u0109\u010b\u0003v;\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u0109"+
		"\u0001\u0000\u0000\u0000\u010b\u0015\u0001\u0000\u0000\u0000\u010c\u0110"+
		"\u0005&\u0000\u0000\u010d\u010f\u0003\u0018\f\u0000\u010e\u010d\u0001"+
		"\u0000\u0000\u0000\u010f\u0112\u0001\u0000\u0000\u0000\u0110\u010e\u0001"+
		"\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0113\u0001"+
		"\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000\u0113\u0114\u0005"+
		"\'\u0000\u0000\u0114\u0017\u0001\u0000\u0000\u0000\u0115\u0116\u0003 "+
		"\u0010\u0000\u0116\u0117\u0005*\u0000\u0000\u0117\u011b\u0001\u0000\u0000"+
		"\u0000\u0118\u011b\u0003\u001a\r\u0000\u0119\u011b\u0003\u001c\u000e\u0000"+
		"\u011a\u0115\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000"+
		"\u011a\u0119\u0001\u0000\u0000\u0000\u011b\u0019\u0001\u0000\u0000\u0000"+
		"\u011c\u0127\u0003\u0016\u000b\u0000\u011d\u0127\u0003$\u0012\u0000\u011e"+
		"\u0127\u0003*\u0015\u0000\u011f\u0127\u0003.\u0017\u0000\u0120\u0121\u0003"+
		"6\u001b\u0000\u0121\u0122\u0005*\u0000\u0000\u0122\u0127\u0001\u0000\u0000"+
		"\u0000\u0123\u0124\u00038\u001c\u0000\u0124\u0125\u0005*\u0000\u0000\u0125"+
		"\u0127\u0001\u0000\u0000\u0000\u0126\u011c\u0001\u0000\u0000\u0000\u0126"+
		"\u011d\u0001\u0000\u0000\u0000\u0126\u011e\u0001\u0000\u0000\u0000\u0126"+
		"\u011f\u0001\u0000\u0000\u0000\u0126\u0120\u0001\u0000\u0000\u0000\u0126"+
		"\u0123\u0001\u0000\u0000\u0000\u0127\u001b\u0001\u0000\u0000\u0000\u0128"+
		"\u012b\u0003&\u0013\u0000\u0129\u012c\u0005*\u0000\u0000\u012a\u012c\u0003"+
		"\u001a\r\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012a\u0001\u0000"+
		"\u0000\u0000\u012c\u012e\u0001\u0000\u0000\u0000\u012d\u012f\u0003(\u0014"+
		"\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000"+
		"\u0000\u012f\u0136\u0001\u0000\u0000\u0000\u0130\u0133\u0003\u001e\u000f"+
		"\u0000\u0131\u0134\u0005*\u0000\u0000\u0132\u0134\u0003\u001a\r\u0000"+
		"\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0132\u0001\u0000\u0000\u0000"+
		"\u0134\u0136\u0001\u0000\u0000\u0000\u0135\u0128\u0001\u0000\u0000\u0000"+
		"\u0135\u0130\u0001\u0000\u0000\u0000\u0136\u001d\u0001\u0000\u0000\u0000"+
		"\u0137\u013b\u0003&\u0013\u0000\u0138\u013b\u0003,\u0016\u0000\u0139\u013b"+
		"\u00030\u0018\u0000\u013a\u0137\u0001\u0000\u0000\u0000\u013a\u0138\u0001"+
		"\u0000\u0000\u0000\u013a\u0139\u0001\u0000\u0000\u0000\u013b\u001f\u0001"+
		"\u0000\u0000\u0000\u013c\u013d\u0003v;\u0000\u013d\u0140\u0005:\u0000"+
		"\u0000\u013e\u013f\u0005-\u0000\u0000\u013f\u0141\u0003J%\u0000\u0140"+
		"\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141"+
		"\u0146\u0001\u0000\u0000\u0000\u0142\u0143\u0005+\u0000\u0000\u0143\u0145"+
		"\u0003\"\u0011\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0148\u0001"+
		"\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001"+
		"\u0000\u0000\u0000\u0147!\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000"+
		"\u0000\u0000\u0149\u014c\u0005:\u0000\u0000\u014a\u014b\u0005-\u0000\u0000"+
		"\u014b\u014d\u0003J%\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d"+
		"\u0001\u0000\u0000\u0000\u014d#\u0001\u0000\u0000\u0000\u014e\u014f\u0005"+
		"0\u0000\u0000\u014f\u0150\u0005(\u0000\u0000\u0150\u0151\u0003J%\u0000"+
		"\u0151\u0152\u0005)\u0000\u0000\u0152\u0154\u0003\u0016\u000b\u0000\u0153"+
		"\u0155\u0003(\u0014\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0154\u0155"+
		"\u0001\u0000\u0000\u0000\u0155%\u0001\u0000\u0000\u0000\u0156\u0157\u0005"+
		"0\u0000\u0000\u0157\u0158\u0005(\u0000\u0000\u0158\u0159\u0003J%\u0000"+
		"\u0159\u015b\u0005)\u0000\u0000\u015a\u015c\u0003\u001e\u000f\u0000\u015b"+
		"\u015a\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c"+
		"\'\u0001\u0000\u0000\u0000\u015d\u0162\u00051\u0000\u0000\u015e\u0163"+
		"\u0005*\u0000\u0000\u015f\u0163\u0003\u001c\u000e\u0000\u0160\u0163\u0003"+
		"\u0016\u000b\u0000\u0161\u0163\u0003\u001a\r\u0000\u0162\u015e\u0001\u0000"+
		"\u0000\u0000\u0162\u015f\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000"+
		"\u0000\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0163)\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u00052\u0000\u0000\u0165\u0166\u0005(\u0000\u0000\u0166"+
		"\u0167\u0003J%\u0000\u0167\u0168\u0005)\u0000\u0000\u0168\u0169\u0003"+
		"\u0016\u000b\u0000\u0169+\u0001\u0000\u0000\u0000\u016a\u016b\u00052\u0000"+
		"\u0000\u016b\u016c\u0005(\u0000\u0000\u016c\u016d\u0003J%\u0000\u016d"+
		"\u016f\u0005)\u0000\u0000\u016e\u0170\u0003\u001e\u000f\u0000\u016f\u016e"+
		"\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170-\u0001"+
		"\u0000\u0000\u0000\u0171\u0172\u00053\u0000\u0000\u0172\u0174\u0005(\u0000"+
		"\u0000\u0173\u0175\u00032\u0019\u0000\u0174\u0173\u0001\u0000\u0000\u0000"+
		"\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000"+
		"\u0176\u0178\u0005*\u0000\u0000\u0177\u0179\u0003J%\u0000\u0178\u0177"+
		"\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u017a"+
		"\u0001\u0000\u0000\u0000\u017a\u017c\u0005*\u0000\u0000\u017b\u017d\u0003"+
		"4\u001a\u0000\u017c\u017b\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000"+
		"\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0005)\u0000"+
		"\u0000\u017f\u0180\u0003\u0016\u000b\u0000\u0180/\u0001\u0000\u0000\u0000"+
		"\u0181\u0182\u00053\u0000\u0000\u0182\u0184\u0005(\u0000\u0000\u0183\u0185"+
		"\u00032\u0019\u0000\u0184\u0183\u0001\u0000\u0000\u0000\u0184\u0185\u0001"+
		"\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186\u0188\u0005"+
		"*\u0000\u0000\u0187\u0189\u0003J%\u0000\u0188\u0187\u0001\u0000\u0000"+
		"\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000"+
		"\u0000\u018a\u018c\u0005*\u0000\u0000\u018b\u018d\u00034\u001a\u0000\u018c"+
		"\u018b\u0001\u0000\u0000\u0000\u018c\u018d\u0001\u0000\u0000\u0000\u018d"+
		"\u018e\u0001\u0000\u0000\u0000\u018e\u0190\u0005)\u0000\u0000\u018f\u0191"+
		"\u0003\u001e\u000f\u0000\u0190\u018f\u0001\u0000\u0000\u0000\u0190\u0191"+
		"\u0001\u0000\u0000\u0000\u01911\u0001\u0000\u0000\u0000\u0192\u0195\u0003"+
		"4\u001a\u0000\u0193\u0195\u0003 \u0010\u0000\u0194\u0192\u0001\u0000\u0000"+
		"\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u01953\u0001\u0000\u0000\u0000"+
		"\u0196\u019b\u00038\u001c\u0000\u0197\u0198\u0005+\u0000\u0000\u0198\u019a"+
		"\u00038\u001c\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u019a\u019d\u0001"+
		"\u0000\u0000\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019b\u019c\u0001"+
		"\u0000\u0000\u0000\u019c5\u0001\u0000\u0000\u0000\u019d\u019b\u0001\u0000"+
		"\u0000\u0000\u019e\u01a0\u00054\u0000\u0000\u019f\u01a1\u0003J%\u0000"+
		"\u01a0\u019f\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a17\u0001\u0000\u0000\u0000\u01a2\u01a7\u0003:\u001d\u0000\u01a3\u01a7"+
		"\u0003@ \u0000\u01a4\u01a7\u0003D\"\u0000\u01a5\u01a7\u0003F#\u0000\u01a6"+
		"\u01a2\u0001\u0000\u0000\u0000\u01a6\u01a3\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a5\u0001\u0000\u0000\u0000\u01a7"+
		"9\u0001\u0000\u0000\u0000\u01a8\u01aa\u0003<\u001e\u0000\u01a9\u01a8\u0001"+
		"\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ae\u0001"+
		"\u0000\u0000\u0000\u01ab\u01ad\u0003>\u001f\u0000\u01ac\u01ab\u0001\u0000"+
		"\u0000\u0000\u01ad\u01b0\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000"+
		"\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b1\u01b2\u0005:\u0000"+
		"\u0000\u01b2\u01b4\u0005(\u0000\u0000\u01b3\u01b5\u0003B!\u0000\u01b4"+
		"\u01b3\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5"+
		"\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b7\u0005)\u0000\u0000\u01b7;\u0001"+
		"\u0000\u0000\u0000\u01b8\u01be\u0005\u001f\u0000\u0000\u01b9\u01be\u0003"+
		"H$\u0000\u01ba\u01be\u0003@ \u0000\u01bb\u01be\u0005:\u0000\u0000\u01bc"+
		"\u01be\u00058\u0000\u0000\u01bd\u01b8\u0001\u0000\u0000\u0000\u01bd\u01b9"+
		"\u0001\u0000\u0000\u0000\u01bd\u01ba\u0001\u0000\u0000\u0000\u01bd\u01bb"+
		"\u0001\u0000\u0000\u0000\u01bd\u01bc\u0001\u0000\u0000\u0000\u01be\u01bf"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c0\u0005.\u0000\u0000\u01c0=\u0001\u0000"+
		"\u0000\u0000\u01c1\u01c2\u0005:\u0000\u0000\u01c2\u01c4\u0005(\u0000\u0000"+
		"\u01c3\u01c5\u0003B!\u0000\u01c4\u01c3\u0001\u0000\u0000\u0000\u01c4\u01c5"+
		"\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6\u01c7"+
		"\u0005)\u0000\u0000\u01c7\u01c8\u0005.\u0000\u0000\u01c8?\u0001\u0000"+
		"\u0000\u0000\u01c9\u01ca\u0005\u001e\u0000\u0000\u01ca\u01cb\u0003v;\u0000"+
		"\u01cb\u01cd\u0005(\u0000\u0000\u01cc\u01ce\u0003B!\u0000\u01cd\u01cc"+
		"\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01cf"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d0\u0005)\u0000\u0000\u01d0A\u0001\u0000"+
		"\u0000\u0000\u01d1\u01d6\u0003J%\u0000\u01d2\u01d3\u0005+\u0000\u0000"+
		"\u01d3\u01d5\u0003J%\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5\u01d8"+
		"\u0001\u0000\u0000\u0000\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d7"+
		"\u0001\u0000\u0000\u0000\u01d7C\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001"+
		"\u0000\u0000\u0000\u01d9\u01dc\u0003H$\u0000\u01da\u01dc\u0005:\u0000"+
		"\u0000\u01db\u01d9\u0001\u0000\u0000\u0000\u01db\u01da\u0001\u0000\u0000"+
		"\u0000\u01dc\u01dd\u0001\u0000\u0000\u0000\u01dd\u01de\u0003t:\u0000\u01de"+
		"\u01df\u0003J%\u0000\u01dfE\u0001\u0000\u0000\u0000\u01e0\u01e3\u0003"+
		"p8\u0000\u01e1\u01e4\u0005:\u0000\u0000\u01e2\u01e4\u0003H$\u0000\u01e3"+
		"\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e4"+
		"\u01eb\u0001\u0000\u0000\u0000\u01e5\u01e8\u0005:\u0000\u0000\u01e6\u01e8"+
		"\u0003H$\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e7\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9\u01eb\u0003r9\u0000"+
		"\u01ea\u01e0\u0001\u0000\u0000\u0000\u01ea\u01e7\u0001\u0000\u0000\u0000"+
		"\u01ebG\u0001\u0000\u0000\u0000\u01ec\u01ef\u0005\u001f\u0000\u0000\u01ed"+
		"\u01ef\u0003@ \u0000\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ee\u01ed\u0001"+
		"\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0\u01f1\u0005"+
		".\u0000\u0000\u01f1\u0201\u0005:\u0000\u0000\u01f2\u01f3\u0005\u001f\u0000"+
		"\u0000\u01f3\u01f8\u0005.\u0000\u0000\u01f4\u01f5\u0003@ \u0000\u01f5"+
		"\u01f6\u0005.\u0000\u0000\u01f6\u01f8\u0001\u0000\u0000\u0000\u01f7\u01f2"+
		"\u0001\u0000\u0000\u0000\u01f7\u01f4\u0001\u0000\u0000\u0000\u01f7\u01f8"+
		"\u0001\u0000\u0000\u0000\u01f8\u01fb\u0001\u0000\u0000\u0000\u01f9\u01fa"+
		"\u0005:\u0000\u0000\u01fa\u01fc\u0005.\u0000\u0000\u01fb\u01f9\u0001\u0000"+
		"\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000"+
		"\u0000\u0000\u01ff\u0201\u0005:\u0000\u0000\u0200\u01ee\u0001\u0000\u0000"+
		"\u0000\u0200\u01f7\u0001\u0000\u0000\u0000\u0201I\u0001\u0000\u0000\u0000"+
		"\u0202\u0203\u0003L&\u0000\u0203K\u0001\u0000\u0000\u0000\u0204\u0205"+
		"\u0006&\uffff\uffff\u0000\u0205\u0206\u0003N\'\u0000\u0206\u020d\u0001"+
		"\u0000\u0000\u0000\u0207\u0208\n\u0002\u0000\u0000\u0208\u0209\u0003`"+
		"0\u0000\u0209\u020a\u0003N\'\u0000\u020a\u020c\u0001\u0000\u0000\u0000"+
		"\u020b\u0207\u0001\u0000\u0000\u0000\u020c\u020f\u0001\u0000\u0000\u0000"+
		"\u020d\u020b\u0001\u0000\u0000\u0000\u020d\u020e\u0001\u0000\u0000\u0000"+
		"\u020eM\u0001\u0000\u0000\u0000\u020f\u020d\u0001\u0000\u0000\u0000\u0210"+
		"\u0211\u0006\'\uffff\uffff\u0000\u0211\u0212\u0003P(\u0000\u0212\u0219"+
		"\u0001\u0000\u0000\u0000\u0213\u0214\n\u0002\u0000\u0000\u0214\u0215\u0003"+
		"b1\u0000\u0215\u0216\u0003P(\u0000\u0216\u0218\u0001\u0000\u0000\u0000"+
		"\u0217\u0213\u0001\u0000\u0000\u0000\u0218\u021b\u0001\u0000\u0000\u0000"+
		"\u0219\u0217\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000"+
		"\u021aO\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000\u0000\u0000\u021c"+
		"\u021d\u0006(\uffff\uffff\u0000\u021d\u021e\u0003R)\u0000\u021e\u0225"+
		"\u0001\u0000\u0000\u0000\u021f\u0220\n\u0002\u0000\u0000\u0220\u0221\u0003"+
		"d2\u0000\u0221\u0222\u0003R)\u0000\u0222\u0224\u0001\u0000\u0000\u0000"+
		"\u0223\u021f\u0001\u0000\u0000\u0000\u0224\u0227\u0001\u0000\u0000\u0000"+
		"\u0225\u0223\u0001\u0000\u0000\u0000\u0225\u0226\u0001\u0000\u0000\u0000"+
		"\u0226Q\u0001\u0000\u0000\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0228"+
		"\u0229\u0006)\uffff\uffff\u0000\u0229\u022a\u0003T*\u0000\u022a\u0231"+
		"\u0001\u0000\u0000\u0000\u022b\u022c\n\u0002\u0000\u0000\u022c\u022d\u0003"+
		"f3\u0000\u022d\u022e\u0003T*\u0000\u022e\u0230\u0001\u0000\u0000\u0000"+
		"\u022f\u022b\u0001\u0000\u0000\u0000\u0230\u0233\u0001\u0000\u0000\u0000"+
		"\u0231\u022f\u0001\u0000\u0000\u0000\u0231\u0232\u0001\u0000\u0000\u0000"+
		"\u0232S\u0001\u0000\u0000\u0000\u0233\u0231\u0001\u0000\u0000\u0000\u0234"+
		"\u0235\u0006*\uffff\uffff\u0000\u0235\u0236\u0003V+\u0000\u0236\u023d"+
		"\u0001\u0000\u0000\u0000\u0237\u0238\n\u0002\u0000\u0000\u0238\u0239\u0003"+
		"h4\u0000\u0239\u023a\u0003V+\u0000\u023a\u023c\u0001\u0000\u0000\u0000"+
		"\u023b\u0237\u0001\u0000\u0000\u0000\u023c\u023f\u0001\u0000\u0000\u0000"+
		"\u023d\u023b\u0001\u0000\u0000\u0000\u023d\u023e\u0001\u0000\u0000\u0000"+
		"\u023eU\u0001\u0000\u0000\u0000\u023f\u023d\u0001\u0000\u0000\u0000\u0240"+
		"\u0241\u0006+\uffff\uffff\u0000\u0241\u0242\u0003X,\u0000\u0242\u0249"+
		"\u0001\u0000\u0000\u0000\u0243\u0244\n\u0002\u0000\u0000\u0244\u0245\u0003"+
		"j5\u0000\u0245\u0246\u0003X,\u0000\u0246\u0248\u0001\u0000\u0000\u0000"+
		"\u0247\u0243\u0001\u0000\u0000\u0000\u0248\u024b\u0001\u0000\u0000\u0000"+
		"\u0249\u0247\u0001\u0000\u0000\u0000\u0249\u024a\u0001\u0000\u0000\u0000"+
		"\u024aW\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024c"+
		"\u024d\u0006,\uffff\uffff\u0000\u024d\u024e\u0003Z-\u0000\u024e\u0255"+
		"\u0001\u0000\u0000\u0000\u024f\u0250\n\u0002\u0000\u0000\u0250\u0251\u0003"+
		"l6\u0000\u0251\u0252\u0003Z-\u0000\u0252\u0254\u0001\u0000\u0000\u0000"+
		"\u0253\u024f\u0001\u0000\u0000\u0000\u0254\u0257\u0001\u0000\u0000\u0000"+
		"\u0255\u0253\u0001\u0000\u0000\u0000\u0255\u0256\u0001\u0000\u0000\u0000"+
		"\u0256Y\u0001\u0000\u0000\u0000\u0257\u0255\u0001\u0000\u0000\u0000\u0258"+
		"\u0259\u0006-\uffff\uffff\u0000\u0259\u025a\u0003\\.\u0000\u025a\u0261"+
		"\u0001\u0000\u0000\u0000\u025b\u025c\n\u0002\u0000\u0000\u025c\u025d\u0003"+
		"n7\u0000\u025d\u025e\u0003\\.\u0000\u025e\u0260\u0001\u0000\u0000\u0000"+
		"\u025f\u025b\u0001\u0000\u0000\u0000\u0260\u0263\u0001\u0000\u0000\u0000"+
		"\u0261\u025f\u0001\u0000\u0000\u0000\u0261\u0262\u0001\u0000\u0000\u0000"+
		"\u0262[\u0001\u0000\u0000\u0000\u0263\u0261\u0001\u0000\u0000\u0000\u0264"+
		"\u0267\u0003F#\u0000\u0265\u0267\u0003^/\u0000\u0266\u0264\u0001\u0000"+
		"\u0000\u0000\u0266\u0265\u0001\u0000\u0000\u0000\u0267]\u0001\u0000\u0000"+
		"\u0000\u0268\u0274\u0005\u001f\u0000\u0000\u0269\u0274\u0005:\u0000\u0000"+
		"\u026a\u0274\u0003H$\u0000\u026b\u0274\u00038\u001c\u0000\u026c\u026d"+
		"\u0005/\u0000\u0000\u026d\u0274\u0003J%\u0000\u026e\u026f\u0005(\u0000"+
		"\u0000\u026f\u0270\u0003J%\u0000\u0270\u0271\u0005)\u0000\u0000\u0271"+
		"\u0274\u0001\u0000\u0000\u0000\u0272\u0274\u0003z=\u0000\u0273\u0268\u0001"+
		"\u0000\u0000\u0000\u0273\u0269\u0001\u0000\u0000\u0000\u0273\u026a\u0001"+
		"\u0000\u0000\u0000\u0273\u026b\u0001\u0000\u0000\u0000\u0273\u026c\u0001"+
		"\u0000\u0000\u0000\u0273\u026e\u0001\u0000\u0000\u0000\u0273\u0272\u0001"+
		"\u0000\u0000\u0000\u0274_\u0001\u0000\u0000\u0000\u0275\u0276\u0005\u0005"+
		"\u0000\u0000\u0276a\u0001\u0000\u0000\u0000\u0277\u0278\u0005\u0006\u0000"+
		"\u0000\u0278c\u0001\u0000\u0000\u0000\u0279\u027a\u0005\u0007\u0000\u0000"+
		"\u027ae\u0001\u0000\u0000\u0000\u027b\u027c\u0005\b\u0000\u0000\u027c"+
		"g\u0001\u0000\u0000\u0000\u027d\u027e\u0007\u0000\u0000\u0000\u027ei\u0001"+
		"\u0000\u0000\u0000\u027f\u0280\u0007\u0001\u0000\u0000\u0280k\u0001\u0000"+
		"\u0000\u0000\u0281\u0282\u0007\u0002\u0000\u0000\u0282m\u0001\u0000\u0000"+
		"\u0000\u0283\u0284\u0007\u0003\u0000\u0000\u0284o\u0001\u0000\u0000\u0000"+
		"\u0285\u0286\u0007\u0004\u0000\u0000\u0286q\u0001\u0000\u0000\u0000\u0287"+
		"\u0288\u0007\u0004\u0000\u0000\u0288s\u0001\u0000\u0000\u0000\u0289\u028a"+
		"\u0007\u0005\u0000\u0000\u028au\u0001\u0000\u0000\u0000\u028b\u028c\u0007"+
		"\u0006\u0000\u0000\u028cw\u0001\u0000\u0000\u0000\u028d\u028e\u0007\u0007"+
		"\u0000\u0000\u028ey\u0001\u0000\u0000\u0000\u028f\u0295\u0003|>\u0000"+
		"\u0290\u0295\u00056\u0000\u0000\u0291\u0295\u00057\u0000\u0000\u0292\u0295"+
		"\u00058\u0000\u0000\u0293\u0295\u00059\u0000\u0000\u0294\u028f\u0001\u0000"+
		"\u0000\u0000\u0294\u0290\u0001\u0000\u0000\u0000\u0294\u0291\u0001\u0000"+
		"\u0000\u0000\u0294\u0292\u0001\u0000\u0000\u0000\u0294\u0293\u0001\u0000"+
		"\u0000\u0000\u0295{\u0001\u0000\u0000\u0000\u0296\u0298\u0003l6\u0000"+
		"\u0297\u0296\u0001\u0000\u0000\u0000\u0297\u0298\u0001\u0000\u0000\u0000"+
		"\u0298\u0299\u0001\u0000\u0000\u0000\u0299\u029a\u00055\u0000\u0000\u029a"+
		"}\u0001\u0000\u0000\u0000M\u0084\u0088\u0093\u0095\u009c\u00a2\u00a4\u00ac"+
		"\u00ae\u00b4\u00b9\u00c0\u00c3\u00c9\u00ce\u00d7\u00d9\u00e4\u00e7\u00ed"+
		"\u00f3\u00fb\u0105\u010a\u0110\u011a\u0126\u012b\u012e\u0133\u0135\u013a"+
		"\u0140\u0146\u014c\u0154\u015b\u0162\u016f\u0174\u0178\u017c\u0184\u0188"+
		"\u018c\u0190\u0194\u019b\u01a0\u01a6\u01a9\u01ae\u01b4\u01bd\u01c4\u01cd"+
		"\u01d6\u01db\u01e3\u01e7\u01ea\u01ee\u01f7\u01fd\u0200\u020d\u0219\u0225"+
		"\u0231\u023d\u0249\u0255\u0261\u0266\u0273\u0294\u0297";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}