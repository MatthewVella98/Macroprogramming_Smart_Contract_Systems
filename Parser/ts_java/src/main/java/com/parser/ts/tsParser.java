// Generated from D:\soft\free\ts_grammar\grammar\ts.g4 by ANTLR 4.8
package com.parser.ts;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SINGLE_QUOTED_LITERAL=1, TYPE=2, Program=3, Data=4, Property=5, Participant=6, 
		Participant_x509Identities=7, FUNCTION=8, STRING=9, NUMBER=10, BOOLEAN=11, 
		READONLY=12, TYPE_KEYWORD=13, PUBLIC=14, ASYNC=15, X_ON_CHAIN_ANNOTATION=16, 
		X_ON_MAIN_SYSTEM_ANNOTATION=17, X_ALL_ANNOTATION=18, X_ONLY_ON_CHAIN_ANNOTATION=19, 
		READONLY_ANNOTATION=20, VALIDATE_ANNOTATION=21, REQUIRED_ANNOTATION=22, 
		YUP=23, COMMENT_START=24, COMMENT_END=25, LESS_EQUAL=26, GREATER_EQUAL=27, 
		OPEN_BLOCK=28, CLOSE_BLOCK=29, EQUAL=30, SEMICOLON=31, COLON=32, COMMA=33, 
		OPEN_BRACKET=34, CLOSE_BRACKET=35, OPEN_CBRACE=36, CLOSE_CBRACE=37, IDENTIFIER=38, 
		WHITE_SPACE=39, ERROR_CHAR=40;
	public static final int
		RULE_program = 0, RULE_data_item = 1, RULE_data_property = 2, RULE_data_participant = 3, 
		RULE_data_participant_identities = 4, RULE_data_element = 5, RULE_data_declaration = 6, 
		RULE_domain_type = 7, RULE_data_annotation_list = 8, RULE_data_annotation = 9, 
		RULE_logic_item = 10, RULE_x_logic_item = 11, RULE_x_on_chain_separate = 12, 
		RULE_x_on_main_system_separate = 13, RULE_x_both = 14, RULE_block_of_code = 15, 
		RULE_block_of_code_inner = 16, RULE_block_of_code_outer = 17, RULE_comment = 18, 
		RULE_function_name = 19, RULE_controller_and_function = 20, RULE_list_of_params = 21, 
		RULE_param_declaration = 22, RULE_identifier = 23, RULE_type = 24, RULE_generic = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "data_item", "data_property", "data_participant", "data_participant_identities", 
			"data_element", "data_declaration", "domain_type", "data_annotation_list", 
			"data_annotation", "logic_item", "x_logic_item", "x_on_chain_separate", 
			"x_on_main_system_separate", "x_both", "block_of_code", "block_of_code_inner", 
			"block_of_code_outer", "comment", "function_name", "controller_and_function", 
			"list_of_params", "param_declaration", "identifier", "type", "generic"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'program'", "'data'", "'Property'", "'Participant'", 
			"'Participant_x509Identities'", "'function'", "'string'", "'number'", 
			"'boolean'", "'readonly'", "'type'", "'public'", "'async'", "'@XOnChain'", 
			"'@XOnMainSystem'", "'@XAll'", "'@XOnlyOnChain'", null, null, null, "'yup.'", 
			"'/*'", "'*/'", "'<'", "'>'", "'{{'", "'}}'", "'='", "';'", "':'", "','", 
			"'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SINGLE_QUOTED_LITERAL", "TYPE", "Program", "Data", "Property", 
			"Participant", "Participant_x509Identities", "FUNCTION", "STRING", "NUMBER", 
			"BOOLEAN", "READONLY", "TYPE_KEYWORD", "PUBLIC", "ASYNC", "X_ON_CHAIN_ANNOTATION", 
			"X_ON_MAIN_SYSTEM_ANNOTATION", "X_ALL_ANNOTATION", "X_ONLY_ON_CHAIN_ANNOTATION", 
			"READONLY_ANNOTATION", "VALIDATE_ANNOTATION", "REQUIRED_ANNOTATION", 
			"YUP", "COMMENT_START", "COMMENT_END", "LESS_EQUAL", "GREATER_EQUAL", 
			"OPEN_BLOCK", "CLOSE_BLOCK", "EQUAL", "SEMICOLON", "COLON", "COMMA", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "OPEN_CBRACE", "CLOSE_CBRACE", "IDENTIFIER", 
			"WHITE_SPACE", "ERROR_CHAR"
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
	public String getGrammarFileName() { return "ts.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public tsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode Program() { return getToken(tsParser.Program, 0); }
		public TerminalNode OPEN_CBRACE() { return getToken(tsParser.OPEN_CBRACE, 0); }
		public TerminalNode CLOSE_CBRACE() { return getToken(tsParser.CLOSE_CBRACE, 0); }
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public List<Logic_itemContext> logic_item() {
			return getRuleContexts(Logic_itemContext.class);
		}
		public Logic_itemContext logic_item(int i) {
			return getRuleContext(Logic_itemContext.class,i);
		}
		public List<Data_itemContext> data_item() {
			return getRuleContexts(Data_itemContext.class);
		}
		public Data_itemContext data_item(int i) {
			return getRuleContext(Data_itemContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(Program);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(53);
				match(WHITE_SPACE);
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(OPEN_CBRACE);
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(60);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66);
					logic_item();
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(75);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(72);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(77);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Data) {
				{
				{
				setState(78);
				data_item();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(84);
				match(WHITE_SPACE);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			match(CLOSE_CBRACE);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(91);
				match(WHITE_SPACE);
				}
				}
				setState(96);
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

	public static class Data_itemContext extends ParserRuleContext {
		public Data_propertyContext data_property() {
			return getRuleContext(Data_propertyContext.class,0);
		}
		public Data_participantContext data_participant() {
			return getRuleContext(Data_participantContext.class,0);
		}
		public Data_participant_identitiesContext data_participant_identities() {
			return getRuleContext(Data_participant_identitiesContext.class,0);
		}
		public Data_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterData_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitData_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitData_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_itemContext data_item() throws RecognitionException {
		Data_itemContext _localctx = new Data_itemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_data_item);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				data_property();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				data_participant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				data_participant_identities();
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

	public static class Data_propertyContext extends ParserRuleContext {
		public TerminalNode Data() { return getToken(tsParser.Data, 0); }
		public TerminalNode Property() { return getToken(tsParser.Property, 0); }
		public TerminalNode OPEN_BLOCK() { return getToken(tsParser.OPEN_BLOCK, 0); }
		public TerminalNode CLOSE_BLOCK() { return getToken(tsParser.CLOSE_BLOCK, 0); }
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public List<Data_elementContext> data_element() {
			return getRuleContexts(Data_elementContext.class);
		}
		public Data_elementContext data_element(int i) {
			return getRuleContext(Data_elementContext.class,i);
		}
		public Data_propertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_property; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterData_property(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitData_property(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitData_property(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_propertyContext data_property() throws RecognitionException {
		Data_propertyContext _localctx = new Data_propertyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_data_property);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(Data);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(103);
				match(WHITE_SPACE);
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(Property);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(110);
				match(WHITE_SPACE);
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
			match(OPEN_BLOCK);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(117);
				match(WHITE_SPACE);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(123);
				data_element();
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(124);
						match(WHITE_SPACE);
						}
						} 
					}
					setState(129);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << X_ALL_ANNOTATION) | (1L << X_ONLY_ON_CHAIN_ANNOTATION) | (1L << READONLY_ANNOTATION) | (1L << VALIDATE_ANNOTATION) | (1L << REQUIRED_ANNOTATION))) != 0) );
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(134);
				match(WHITE_SPACE);
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
			match(CLOSE_BLOCK);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(141);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	public static class Data_participantContext extends ParserRuleContext {
		public TerminalNode Data() { return getToken(tsParser.Data, 0); }
		public TerminalNode Participant() { return getToken(tsParser.Participant, 0); }
		public TerminalNode OPEN_BLOCK() { return getToken(tsParser.OPEN_BLOCK, 0); }
		public TerminalNode CLOSE_BLOCK() { return getToken(tsParser.CLOSE_BLOCK, 0); }
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public List<Data_elementContext> data_element() {
			return getRuleContexts(Data_elementContext.class);
		}
		public Data_elementContext data_element(int i) {
			return getRuleContext(Data_elementContext.class,i);
		}
		public Data_participantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_participant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterData_participant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitData_participant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitData_participant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_participantContext data_participant() throws RecognitionException {
		Data_participantContext _localctx = new Data_participantContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_data_participant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(Data);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(148);
				match(WHITE_SPACE);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			match(Participant);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(155);
				match(WHITE_SPACE);
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			match(OPEN_BLOCK);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(162);
				match(WHITE_SPACE);
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(175); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				data_element();
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(169);
						match(WHITE_SPACE);
						}
						} 
					}
					setState(174);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				}
				}
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << X_ALL_ANNOTATION) | (1L << X_ONLY_ON_CHAIN_ANNOTATION) | (1L << READONLY_ANNOTATION) | (1L << VALIDATE_ANNOTATION) | (1L << REQUIRED_ANNOTATION))) != 0) );
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(179);
				match(WHITE_SPACE);
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(CLOSE_BLOCK);
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(186);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(191);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class Data_participant_identitiesContext extends ParserRuleContext {
		public TerminalNode Data() { return getToken(tsParser.Data, 0); }
		public TerminalNode Participant_x509Identities() { return getToken(tsParser.Participant_x509Identities, 0); }
		public TerminalNode OPEN_BLOCK() { return getToken(tsParser.OPEN_BLOCK, 0); }
		public TerminalNode CLOSE_BLOCK() { return getToken(tsParser.CLOSE_BLOCK, 0); }
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public List<Data_elementContext> data_element() {
			return getRuleContexts(Data_elementContext.class);
		}
		public Data_elementContext data_element(int i) {
			return getRuleContext(Data_elementContext.class,i);
		}
		public Data_participant_identitiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_participant_identities; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterData_participant_identities(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitData_participant_identities(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitData_participant_identities(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_participant_identitiesContext data_participant_identities() throws RecognitionException {
		Data_participant_identitiesContext _localctx = new Data_participant_identitiesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_data_participant_identities);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(Data);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(193);
				match(WHITE_SPACE);
				}
				}
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(199);
			match(Participant_x509Identities);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(200);
				match(WHITE_SPACE);
				}
				}
				setState(205);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(206);
			match(OPEN_BLOCK);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(207);
				match(WHITE_SPACE);
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(213);
				data_element();
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(214);
						match(WHITE_SPACE);
						}
						} 
					}
					setState(219);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				}
				}
				setState(222); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << X_ALL_ANNOTATION) | (1L << X_ONLY_ON_CHAIN_ANNOTATION) | (1L << READONLY_ANNOTATION) | (1L << VALIDATE_ANNOTATION) | (1L << REQUIRED_ANNOTATION))) != 0) );
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(224);
				match(WHITE_SPACE);
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(230);
			match(CLOSE_BLOCK);
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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

	public static class Data_elementContext extends ParserRuleContext {
		public Data_annotation_listContext data_annotation_list() {
			return getRuleContext(Data_annotation_listContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(tsParser.PUBLIC, 0); }
		public Data_declarationContext data_declaration() {
			return getRuleContext(Data_declarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(tsParser.SEMICOLON, 0); }
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public Data_elementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterData_element(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitData_element(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitData_element(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_elementContext data_element() throws RecognitionException {
		Data_elementContext _localctx = new Data_elementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_data_element);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			data_annotation_list();
			setState(238);
			match(PUBLIC);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(239);
				match(WHITE_SPACE);
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245);
			data_declaration();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(246);
				match(WHITE_SPACE);
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(252);
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

	public static class Data_declarationContext extends ParserRuleContext {
		public TerminalNode READONLY() { return getToken(tsParser.READONLY, 0); }
		public TerminalNode TYPE_KEYWORD() { return getToken(tsParser.TYPE_KEYWORD, 0); }
		public TerminalNode EQUAL() { return getToken(tsParser.EQUAL, 0); }
		public Domain_typeContext domain_type() {
			return getRuleContext(Domain_typeContext.class,0);
		}
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(tsParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Data_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterData_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitData_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitData_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_declarationContext data_declaration() throws RecognitionException {
		Data_declarationContext _localctx = new Data_declarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_data_declaration);
		int _la;
		try {
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case READONLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(READONLY);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITE_SPACE) {
					{
					{
					setState(255);
					match(WHITE_SPACE);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(261);
				match(TYPE_KEYWORD);
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITE_SPACE) {
					{
					{
					setState(262);
					match(WHITE_SPACE);
					}
					}
					setState(267);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(268);
				match(EQUAL);
				setState(272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITE_SPACE) {
					{
					{
					setState(269);
					match(WHITE_SPACE);
					}
					}
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(275);
				domain_type();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(276);
				identifier();
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITE_SPACE) {
					{
					{
					setState(277);
					match(WHITE_SPACE);
					}
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(283);
				match(COLON);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITE_SPACE) {
					{
					{
					setState(284);
					match(WHITE_SPACE);
					}
					}
					setState(289);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(290);
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

	public static class Domain_typeContext extends ParserRuleContext {
		public TerminalNode SINGLE_QUOTED_LITERAL() { return getToken(tsParser.SINGLE_QUOTED_LITERAL, 0); }
		public Domain_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domain_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterDomain_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitDomain_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitDomain_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Domain_typeContext domain_type() throws RecognitionException {
		Domain_typeContext _localctx = new Domain_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_domain_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(SINGLE_QUOTED_LITERAL);
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

	public static class Data_annotation_listContext extends ParserRuleContext {
		public List<Data_annotationContext> data_annotation() {
			return getRuleContexts(Data_annotationContext.class);
		}
		public Data_annotationContext data_annotation(int i) {
			return getRuleContext(Data_annotationContext.class,i);
		}
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public Data_annotation_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_annotation_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterData_annotation_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitData_annotation_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitData_annotation_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_annotation_listContext data_annotation_list() throws RecognitionException {
		Data_annotation_listContext _localctx = new Data_annotation_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_data_annotation_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(296);
				data_annotation();
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WHITE_SPACE) {
					{
					{
					setState(297);
					match(WHITE_SPACE);
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(305); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << X_ALL_ANNOTATION) | (1L << X_ONLY_ON_CHAIN_ANNOTATION) | (1L << READONLY_ANNOTATION) | (1L << VALIDATE_ANNOTATION) | (1L << REQUIRED_ANNOTATION))) != 0) );
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

	public static class Data_annotationContext extends ParserRuleContext {
		public TerminalNode REQUIRED_ANNOTATION() { return getToken(tsParser.REQUIRED_ANNOTATION, 0); }
		public TerminalNode VALIDATE_ANNOTATION() { return getToken(tsParser.VALIDATE_ANNOTATION, 0); }
		public TerminalNode READONLY_ANNOTATION() { return getToken(tsParser.READONLY_ANNOTATION, 0); }
		public TerminalNode X_ONLY_ON_CHAIN_ANNOTATION() { return getToken(tsParser.X_ONLY_ON_CHAIN_ANNOTATION, 0); }
		public TerminalNode X_ALL_ANNOTATION() { return getToken(tsParser.X_ALL_ANNOTATION, 0); }
		public Data_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_data_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterData_annotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitData_annotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitData_annotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Data_annotationContext data_annotation() throws RecognitionException {
		Data_annotationContext _localctx = new Data_annotationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_data_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << X_ALL_ANNOTATION) | (1L << X_ONLY_ON_CHAIN_ANNOTATION) | (1L << READONLY_ANNOTATION) | (1L << VALIDATE_ANNOTATION) | (1L << REQUIRED_ANNOTATION))) != 0)) ) {
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

	public static class Logic_itemContext extends ParserRuleContext {
		public X_logic_itemContext x_logic_item() {
			return getRuleContext(X_logic_itemContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public Logic_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterLogic_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitLogic_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitLogic_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_itemContext logic_item() throws RecognitionException {
		Logic_itemContext _localctx = new Logic_itemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_logic_item);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT_START) {
				{
				setState(309);
				comment();
				}
			}

			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(312);
				match(WHITE_SPACE);
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(318);
			x_logic_item();
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(319);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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

	public static class X_logic_itemContext extends ParserRuleContext {
		public X_on_chain_separateContext x_on_chain_separate() {
			return getRuleContext(X_on_chain_separateContext.class,0);
		}
		public X_on_main_system_separateContext x_on_main_system_separate() {
			return getRuleContext(X_on_main_system_separateContext.class,0);
		}
		public X_bothContext x_both() {
			return getRuleContext(X_bothContext.class,0);
		}
		public X_logic_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_logic_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterX_logic_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitX_logic_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitX_logic_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_logic_itemContext x_logic_item() throws RecognitionException {
		X_logic_itemContext _localctx = new X_logic_itemContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_x_logic_item);
		try {
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				x_on_chain_separate();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(326);
				x_on_main_system_separate();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(327);
				x_both();
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

	public static class X_on_chain_separateContext extends ParserRuleContext {
		public TerminalNode X_ON_CHAIN_ANNOTATION() { return getToken(tsParser.X_ON_CHAIN_ANNOTATION, 0); }
		public List<TerminalNode> OPEN_BRACKET() { return getTokens(tsParser.OPEN_BRACKET); }
		public TerminalNode OPEN_BRACKET(int i) {
			return getToken(tsParser.OPEN_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_BRACKET() { return getTokens(tsParser.CLOSE_BRACKET); }
		public TerminalNode CLOSE_BRACKET(int i) {
			return getToken(tsParser.CLOSE_BRACKET, i);
		}
		public TerminalNode OPEN_BLOCK() { return getToken(tsParser.OPEN_BLOCK, 0); }
		public TerminalNode FUNCTION() { return getToken(tsParser.FUNCTION, 0); }
		public Controller_and_functionContext controller_and_function() {
			return getRuleContext(Controller_and_functionContext.class,0);
		}
		public List_of_paramsContext list_of_params() {
			return getRuleContext(List_of_paramsContext.class,0);
		}
		public TerminalNode OPEN_CBRACE() { return getToken(tsParser.OPEN_CBRACE, 0); }
		public TerminalNode CLOSE_CBRACE() { return getToken(tsParser.CLOSE_CBRACE, 0); }
		public TerminalNode CLOSE_BLOCK() { return getToken(tsParser.CLOSE_BLOCK, 0); }
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public Block_of_codeContext block_of_code() {
			return getRuleContext(Block_of_codeContext.class,0);
		}
		public X_on_chain_separateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_on_chain_separate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterX_on_chain_separate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitX_on_chain_separate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitX_on_chain_separate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_on_chain_separateContext x_on_chain_separate() throws RecognitionException {
		X_on_chain_separateContext _localctx = new X_on_chain_separateContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_x_on_chain_separate);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(X_ON_CHAIN_ANNOTATION);
			setState(331);
			match(OPEN_BRACKET);
			setState(332);
			match(CLOSE_BRACKET);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(333);
				match(WHITE_SPACE);
				}
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(339);
			match(OPEN_BLOCK);
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(340);
				match(WHITE_SPACE);
				}
				}
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(346);
			match(FUNCTION);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(347);
				match(WHITE_SPACE);
				}
				}
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(353);
			controller_and_function();
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(354);
				match(WHITE_SPACE);
				}
				}
				setState(359);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(360);
			match(OPEN_BRACKET);
			setState(364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(361);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			setState(367);
			list_of_params();
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(368);
				match(WHITE_SPACE);
				}
				}
				setState(373);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(374);
			match(CLOSE_BRACKET);
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(375);
				match(WHITE_SPACE);
				}
				}
				setState(380);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(381);
			match(OPEN_CBRACE);
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(382);
				block_of_code();
				}
				break;
			}
			setState(385);
			match(CLOSE_CBRACE);
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(386);
				match(WHITE_SPACE);
				}
				}
				setState(391);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(392);
			match(CLOSE_BLOCK);
			setState(396);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(393);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(398);
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
			exitRule();
		}
		return _localctx;
	}

	public static class X_on_main_system_separateContext extends ParserRuleContext {
		public TerminalNode X_ON_MAIN_SYSTEM_ANNOTATION() { return getToken(tsParser.X_ON_MAIN_SYSTEM_ANNOTATION, 0); }
		public List<TerminalNode> OPEN_BRACKET() { return getTokens(tsParser.OPEN_BRACKET); }
		public TerminalNode OPEN_BRACKET(int i) {
			return getToken(tsParser.OPEN_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_BRACKET() { return getTokens(tsParser.CLOSE_BRACKET); }
		public TerminalNode CLOSE_BRACKET(int i) {
			return getToken(tsParser.CLOSE_BRACKET, i);
		}
		public TerminalNode OPEN_BLOCK() { return getToken(tsParser.OPEN_BLOCK, 0); }
		public TerminalNode FUNCTION() { return getToken(tsParser.FUNCTION, 0); }
		public Function_nameContext function_name() {
			return getRuleContext(Function_nameContext.class,0);
		}
		public List_of_paramsContext list_of_params() {
			return getRuleContext(List_of_paramsContext.class,0);
		}
		public TerminalNode OPEN_CBRACE() { return getToken(tsParser.OPEN_CBRACE, 0); }
		public TerminalNode CLOSE_CBRACE() { return getToken(tsParser.CLOSE_CBRACE, 0); }
		public TerminalNode CLOSE_BLOCK() { return getToken(tsParser.CLOSE_BLOCK, 0); }
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public Block_of_codeContext block_of_code() {
			return getRuleContext(Block_of_codeContext.class,0);
		}
		public X_on_main_system_separateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_on_main_system_separate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterX_on_main_system_separate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitX_on_main_system_separate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitX_on_main_system_separate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_on_main_system_separateContext x_on_main_system_separate() throws RecognitionException {
		X_on_main_system_separateContext _localctx = new X_on_main_system_separateContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_x_on_main_system_separate);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(X_ON_MAIN_SYSTEM_ANNOTATION);
			setState(400);
			match(OPEN_BRACKET);
			setState(401);
			match(CLOSE_BRACKET);
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(402);
				match(WHITE_SPACE);
				}
				}
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(408);
			match(OPEN_BLOCK);
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(409);
				match(WHITE_SPACE);
				}
				}
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(415);
			match(FUNCTION);
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(416);
				match(WHITE_SPACE);
				}
				}
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(422);
			function_name();
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(423);
				match(WHITE_SPACE);
				}
				}
				setState(428);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(429);
			match(OPEN_BRACKET);
			setState(433);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(430);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(435);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			}
			setState(436);
			list_of_params();
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(437);
				match(WHITE_SPACE);
				}
				}
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(443);
			match(CLOSE_BRACKET);
			setState(447);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(444);
				match(WHITE_SPACE);
				}
				}
				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(450);
			match(OPEN_CBRACE);
			setState(452);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(451);
				block_of_code();
				}
				break;
			}
			setState(454);
			match(CLOSE_CBRACE);
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(455);
				match(WHITE_SPACE);
				}
				}
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(461);
			match(CLOSE_BLOCK);
			setState(465);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(462);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(467);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,62,_ctx);
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

	public static class X_bothContext extends ParserRuleContext {
		public TerminalNode X_ON_MAIN_SYSTEM_ANNOTATION() { return getToken(tsParser.X_ON_MAIN_SYSTEM_ANNOTATION, 0); }
		public List<TerminalNode> OPEN_BRACKET() { return getTokens(tsParser.OPEN_BRACKET); }
		public TerminalNode OPEN_BRACKET(int i) {
			return getToken(tsParser.OPEN_BRACKET, i);
		}
		public List<TerminalNode> CLOSE_BRACKET() { return getTokens(tsParser.CLOSE_BRACKET); }
		public TerminalNode CLOSE_BRACKET(int i) {
			return getToken(tsParser.CLOSE_BRACKET, i);
		}
		public List<TerminalNode> OPEN_BLOCK() { return getTokens(tsParser.OPEN_BLOCK); }
		public TerminalNode OPEN_BLOCK(int i) {
			return getToken(tsParser.OPEN_BLOCK, i);
		}
		public TerminalNode FUNCTION() { return getToken(tsParser.FUNCTION, 0); }
		public Controller_and_functionContext controller_and_function() {
			return getRuleContext(Controller_and_functionContext.class,0);
		}
		public List_of_paramsContext list_of_params() {
			return getRuleContext(List_of_paramsContext.class,0);
		}
		public TerminalNode X_ON_CHAIN_ANNOTATION() { return getToken(tsParser.X_ON_CHAIN_ANNOTATION, 0); }
		public List<TerminalNode> CLOSE_BLOCK() { return getTokens(tsParser.CLOSE_BLOCK); }
		public TerminalNode CLOSE_BLOCK(int i) {
			return getToken(tsParser.CLOSE_BLOCK, i);
		}
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public Block_of_code_innerContext block_of_code_inner() {
			return getRuleContext(Block_of_code_innerContext.class,0);
		}
		public Block_of_code_outerContext block_of_code_outer() {
			return getRuleContext(Block_of_code_outerContext.class,0);
		}
		public X_bothContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x_both; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterX_both(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitX_both(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitX_both(this);
			else return visitor.visitChildren(this);
		}
	}

	public final X_bothContext x_both() throws RecognitionException {
		X_bothContext _localctx = new X_bothContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_x_both);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			match(X_ON_MAIN_SYSTEM_ANNOTATION);
			setState(469);
			match(OPEN_BRACKET);
			setState(470);
			match(CLOSE_BRACKET);
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(471);
				match(WHITE_SPACE);
				}
				}
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(477);
			match(OPEN_BLOCK);
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(478);
				match(WHITE_SPACE);
				}
				}
				setState(483);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(484);
			match(FUNCTION);
			setState(488);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(485);
				match(WHITE_SPACE);
				}
				}
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(491);
			controller_and_function();
			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(492);
				match(WHITE_SPACE);
				}
				}
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(498);
			match(OPEN_BRACKET);
			setState(502);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(499);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(504);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			}
			setState(505);
			list_of_params();
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(506);
				match(WHITE_SPACE);
				}
				}
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(512);
			match(CLOSE_BRACKET);
			setState(516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(513);
				match(WHITE_SPACE);
				}
				}
				setState(518);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(519);
			match(X_ON_CHAIN_ANNOTATION);
			setState(520);
			match(OPEN_BRACKET);
			setState(521);
			match(CLOSE_BRACKET);
			setState(525);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(522);
				match(WHITE_SPACE);
				}
				}
				setState(527);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(528);
			match(OPEN_BLOCK);
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(529);
				block_of_code_inner();
				}
				break;
			}
			setState(532);
			match(CLOSE_BLOCK);
			setState(534);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
			case 1:
				{
				setState(533);
				block_of_code_outer();
				}
				break;
			}
			setState(536);
			match(CLOSE_BLOCK);
			setState(540);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(537);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(542);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
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

	public static class Block_of_codeContext extends ParserRuleContext {
		public Block_of_codeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_of_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterBlock_of_code(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitBlock_of_code(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitBlock_of_code(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_of_codeContext block_of_code() throws RecognitionException {
		Block_of_codeContext _localctx = new Block_of_codeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block_of_code);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(544); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(543);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(546); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Block_of_code_innerContext extends ParserRuleContext {
		public Block_of_code_innerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_of_code_inner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterBlock_of_code_inner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitBlock_of_code_inner(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitBlock_of_code_inner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_of_code_innerContext block_of_code_inner() throws RecognitionException {
		Block_of_code_innerContext _localctx = new Block_of_code_innerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block_of_code_inner);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(549); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(548);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(551); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Block_of_code_outerContext extends ParserRuleContext {
		public Block_of_code_outerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_of_code_outer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterBlock_of_code_outer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitBlock_of_code_outer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitBlock_of_code_outer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_of_code_outerContext block_of_code_outer() throws RecognitionException {
		Block_of_code_outerContext _localctx = new Block_of_code_outerContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_block_of_code_outer);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(554); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(553);
					matchWildcard();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(556); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT_START() { return getToken(tsParser.COMMENT_START, 0); }
		public TerminalNode COMMENT_END() { return getToken(tsParser.COMMENT_END, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_comment);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			match(COMMENT_START);
			setState(562);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(559);
					matchWildcard();
					}
					} 
				}
				setState(564);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			}
			setState(565);
			match(COMMENT_END);
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

	public static class Function_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(tsParser.IDENTIFIER, 0); }
		public Function_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterFunction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitFunction_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitFunction_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_nameContext function_name() throws RecognitionException {
		Function_nameContext _localctx = new Function_nameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_function_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			match(IDENTIFIER);
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

	public static class Controller_and_functionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(tsParser.IDENTIFIER, 0); }
		public Controller_and_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controller_and_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterController_and_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitController_and_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitController_and_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Controller_and_functionContext controller_and_function() throws RecognitionException {
		Controller_and_functionContext _localctx = new Controller_and_functionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_controller_and_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			match(IDENTIFIER);
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

	public static class List_of_paramsContext extends ParserRuleContext {
		public List<Param_declarationContext> param_declaration() {
			return getRuleContexts(Param_declarationContext.class);
		}
		public Param_declarationContext param_declaration(int i) {
			return getRuleContext(Param_declarationContext.class,i);
		}
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(tsParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(tsParser.COMMA, i);
		}
		public List_of_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_of_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterList_of_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitList_of_params(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitList_of_params(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_of_paramsContext list_of_params() throws RecognitionException {
		List_of_paramsContext _localctx = new List_of_paramsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_list_of_params);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(571);
				param_declaration();
				}
			}

			setState(577);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(574);
					match(WHITE_SPACE);
					}
					} 
				}
				setState(579);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			}
			setState(602);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(583);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WHITE_SPACE) {
						{
						{
						setState(580);
						match(WHITE_SPACE);
						}
						}
						setState(585);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(586);
					match(COMMA);
					setState(590);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WHITE_SPACE) {
						{
						{
						setState(587);
						match(WHITE_SPACE);
						}
						}
						setState(592);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(593);
					param_declaration();
					setState(597);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(594);
							match(WHITE_SPACE);
							}
							} 
						}
						setState(599);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,82,_ctx);
					}
					}
					} 
				}
				setState(604);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
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

	public static class Param_declarationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(tsParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> WHITE_SPACE() { return getTokens(tsParser.WHITE_SPACE); }
		public TerminalNode WHITE_SPACE(int i) {
			return getToken(tsParser.WHITE_SPACE, i);
		}
		public Param_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterParam_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitParam_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitParam_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_declarationContext param_declaration() throws RecognitionException {
		Param_declarationContext _localctx = new Param_declarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_param_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			identifier();
			setState(609);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(606);
				match(WHITE_SPACE);
				}
				}
				setState(611);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(612);
			match(COLON);
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WHITE_SPACE) {
				{
				{
				setState(613);
				match(WHITE_SPACE);
				}
				}
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(619);
			type();
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(tsParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			match(IDENTIFIER);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(tsParser.TYPE, 0); }
		public GenericContext generic() {
			return getRuleContext(GenericContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type);
		try {
			setState(625);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(623);
				match(TYPE);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(624);
				generic();
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

	public static class GenericContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(tsParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(tsParser.IDENTIFIER, i);
		}
		public TerminalNode LESS_EQUAL() { return getToken(tsParser.LESS_EQUAL, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(tsParser.GREATER_EQUAL, 0); }
		public GenericContext generic() {
			return getRuleContext(GenericContext.class,0);
		}
		public GenericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).enterGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tsListener ) ((tsListener)listener).exitGeneric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tsVisitor ) return ((tsVisitor<? extends T>)visitor).visitGeneric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericContext generic() throws RecognitionException {
		GenericContext _localctx = new GenericContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_generic);
		try {
			setState(636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(627);
				match(IDENTIFIER);
				setState(628);
				match(LESS_EQUAL);
				setState(629);
				match(IDENTIFIER);
				setState(630);
				match(GREATER_EQUAL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(631);
				match(IDENTIFIER);
				setState(632);
				match(LESS_EQUAL);
				setState(633);
				generic();
				setState(634);
				match(GREATER_EQUAL);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0281\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\7\29\n\2\f\2\16\2<\13\2\3\2\3\2\7\2@\n\2"+
		"\f\2\16\2C\13\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\7\2L\n\2\f\2\16\2O\13"+
		"\2\3\2\7\2R\n\2\f\2\16\2U\13\2\3\2\7\2X\n\2\f\2\16\2[\13\2\3\2\3\2\7\2"+
		"_\n\2\f\2\16\2b\13\2\3\3\3\3\3\3\5\3g\n\3\3\4\3\4\7\4k\n\4\f\4\16\4n\13"+
		"\4\3\4\3\4\7\4r\n\4\f\4\16\4u\13\4\3\4\3\4\7\4y\n\4\f\4\16\4|\13\4\3\4"+
		"\3\4\7\4\u0080\n\4\f\4\16\4\u0083\13\4\6\4\u0085\n\4\r\4\16\4\u0086\3"+
		"\4\7\4\u008a\n\4\f\4\16\4\u008d\13\4\3\4\3\4\7\4\u0091\n\4\f\4\16\4\u0094"+
		"\13\4\3\5\3\5\7\5\u0098\n\5\f\5\16\5\u009b\13\5\3\5\3\5\7\5\u009f\n\5"+
		"\f\5\16\5\u00a2\13\5\3\5\3\5\7\5\u00a6\n\5\f\5\16\5\u00a9\13\5\3\5\3\5"+
		"\7\5\u00ad\n\5\f\5\16\5\u00b0\13\5\6\5\u00b2\n\5\r\5\16\5\u00b3\3\5\7"+
		"\5\u00b7\n\5\f\5\16\5\u00ba\13\5\3\5\3\5\7\5\u00be\n\5\f\5\16\5\u00c1"+
		"\13\5\3\6\3\6\7\6\u00c5\n\6\f\6\16\6\u00c8\13\6\3\6\3\6\7\6\u00cc\n\6"+
		"\f\6\16\6\u00cf\13\6\3\6\3\6\7\6\u00d3\n\6\f\6\16\6\u00d6\13\6\3\6\3\6"+
		"\7\6\u00da\n\6\f\6\16\6\u00dd\13\6\6\6\u00df\n\6\r\6\16\6\u00e0\3\6\7"+
		"\6\u00e4\n\6\f\6\16\6\u00e7\13\6\3\6\3\6\7\6\u00eb\n\6\f\6\16\6\u00ee"+
		"\13\6\3\7\3\7\3\7\7\7\u00f3\n\7\f\7\16\7\u00f6\13\7\3\7\3\7\7\7\u00fa"+
		"\n\7\f\7\16\7\u00fd\13\7\3\7\3\7\3\b\3\b\7\b\u0103\n\b\f\b\16\b\u0106"+
		"\13\b\3\b\3\b\7\b\u010a\n\b\f\b\16\b\u010d\13\b\3\b\3\b\7\b\u0111\n\b"+
		"\f\b\16\b\u0114\13\b\3\b\3\b\3\b\7\b\u0119\n\b\f\b\16\b\u011c\13\b\3\b"+
		"\3\b\7\b\u0120\n\b\f\b\16\b\u0123\13\b\3\b\3\b\5\b\u0127\n\b\3\t\3\t\3"+
		"\n\3\n\7\n\u012d\n\n\f\n\16\n\u0130\13\n\6\n\u0132\n\n\r\n\16\n\u0133"+
		"\3\13\3\13\3\f\5\f\u0139\n\f\3\f\7\f\u013c\n\f\f\f\16\f\u013f\13\f\3\f"+
		"\3\f\7\f\u0143\n\f\f\f\16\f\u0146\13\f\3\r\3\r\3\r\5\r\u014b\n\r\3\16"+
		"\3\16\3\16\3\16\7\16\u0151\n\16\f\16\16\16\u0154\13\16\3\16\3\16\7\16"+
		"\u0158\n\16\f\16\16\16\u015b\13\16\3\16\3\16\7\16\u015f\n\16\f\16\16\16"+
		"\u0162\13\16\3\16\3\16\7\16\u0166\n\16\f\16\16\16\u0169\13\16\3\16\3\16"+
		"\7\16\u016d\n\16\f\16\16\16\u0170\13\16\3\16\3\16\7\16\u0174\n\16\f\16"+
		"\16\16\u0177\13\16\3\16\3\16\7\16\u017b\n\16\f\16\16\16\u017e\13\16\3"+
		"\16\3\16\5\16\u0182\n\16\3\16\3\16\7\16\u0186\n\16\f\16\16\16\u0189\13"+
		"\16\3\16\3\16\7\16\u018d\n\16\f\16\16\16\u0190\13\16\3\17\3\17\3\17\3"+
		"\17\7\17\u0196\n\17\f\17\16\17\u0199\13\17\3\17\3\17\7\17\u019d\n\17\f"+
		"\17\16\17\u01a0\13\17\3\17\3\17\7\17\u01a4\n\17\f\17\16\17\u01a7\13\17"+
		"\3\17\3\17\7\17\u01ab\n\17\f\17\16\17\u01ae\13\17\3\17\3\17\7\17\u01b2"+
		"\n\17\f\17\16\17\u01b5\13\17\3\17\3\17\7\17\u01b9\n\17\f\17\16\17\u01bc"+
		"\13\17\3\17\3\17\7\17\u01c0\n\17\f\17\16\17\u01c3\13\17\3\17\3\17\5\17"+
		"\u01c7\n\17\3\17\3\17\7\17\u01cb\n\17\f\17\16\17\u01ce\13\17\3\17\3\17"+
		"\7\17\u01d2\n\17\f\17\16\17\u01d5\13\17\3\20\3\20\3\20\3\20\7\20\u01db"+
		"\n\20\f\20\16\20\u01de\13\20\3\20\3\20\7\20\u01e2\n\20\f\20\16\20\u01e5"+
		"\13\20\3\20\3\20\7\20\u01e9\n\20\f\20\16\20\u01ec\13\20\3\20\3\20\7\20"+
		"\u01f0\n\20\f\20\16\20\u01f3\13\20\3\20\3\20\7\20\u01f7\n\20\f\20\16\20"+
		"\u01fa\13\20\3\20\3\20\7\20\u01fe\n\20\f\20\16\20\u0201\13\20\3\20\3\20"+
		"\7\20\u0205\n\20\f\20\16\20\u0208\13\20\3\20\3\20\3\20\3\20\7\20\u020e"+
		"\n\20\f\20\16\20\u0211\13\20\3\20\3\20\5\20\u0215\n\20\3\20\3\20\5\20"+
		"\u0219\n\20\3\20\3\20\7\20\u021d\n\20\f\20\16\20\u0220\13\20\3\21\6\21"+
		"\u0223\n\21\r\21\16\21\u0224\3\22\6\22\u0228\n\22\r\22\16\22\u0229\3\23"+
		"\6\23\u022d\n\23\r\23\16\23\u022e\3\24\3\24\7\24\u0233\n\24\f\24\16\24"+
		"\u0236\13\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\5\27\u023f\n\27\3\27\7"+
		"\27\u0242\n\27\f\27\16\27\u0245\13\27\3\27\7\27\u0248\n\27\f\27\16\27"+
		"\u024b\13\27\3\27\3\27\7\27\u024f\n\27\f\27\16\27\u0252\13\27\3\27\3\27"+
		"\7\27\u0256\n\27\f\27\16\27\u0259\13\27\7\27\u025b\n\27\f\27\16\27\u025e"+
		"\13\27\3\30\3\30\7\30\u0262\n\30\f\30\16\30\u0265\13\30\3\30\3\30\7\30"+
		"\u0269\n\30\f\30\16\30\u026c\13\30\3\30\3\30\3\31\3\31\3\32\3\32\5\32"+
		"\u0274\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u027f\n"+
		"\33\3\33\6\u0224\u0229\u022e\u0234\2\34\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\2\3\3\2\24\30\2\u02c0\2\66\3\2\2\2\4f\3\2"+
		"\2\2\6h\3\2\2\2\b\u0095\3\2\2\2\n\u00c2\3\2\2\2\f\u00ef\3\2\2\2\16\u0126"+
		"\3\2\2\2\20\u0128\3\2\2\2\22\u0131\3\2\2\2\24\u0135\3\2\2\2\26\u0138\3"+
		"\2\2\2\30\u014a\3\2\2\2\32\u014c\3\2\2\2\34\u0191\3\2\2\2\36\u01d6\3\2"+
		"\2\2 \u0222\3\2\2\2\"\u0227\3\2\2\2$\u022c\3\2\2\2&\u0230\3\2\2\2(\u0239"+
		"\3\2\2\2*\u023b\3\2\2\2,\u023e\3\2\2\2.\u025f\3\2\2\2\60\u026f\3\2\2\2"+
		"\62\u0273\3\2\2\2\64\u027e\3\2\2\2\66:\7\5\2\2\679\7)\2\28\67\3\2\2\2"+
		"9<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=A\7&\2\2>@\7)\2\2?"+
		">\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BG\3\2\2\2CA\3\2\2\2DF\5\26\f\2"+
		"ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HM\3\2\2\2IG\3\2\2\2JL\7)\2\2"+
		"KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NS\3\2\2\2OM\3\2\2\2PR\5\4\3\2"+
		"QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TY\3\2\2\2US\3\2\2\2VX\7)\2\2"+
		"WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2\2\\`\7\'\2"+
		"\2]_\7)\2\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\3\3\2\2\2b`\3\2\2"+
		"\2cg\5\6\4\2dg\5\b\5\2eg\5\n\6\2fc\3\2\2\2fd\3\2\2\2fe\3\2\2\2g\5\3\2"+
		"\2\2hl\7\6\2\2ik\7)\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2"+
		"\2\2nl\3\2\2\2os\7\7\2\2pr\7)\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2"+
		"\2\2tv\3\2\2\2us\3\2\2\2vz\7\36\2\2wy\7)\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2"+
		"\2\2z{\3\2\2\2{\u0084\3\2\2\2|z\3\2\2\2}\u0081\5\f\7\2~\u0080\7)\2\2\177"+
		"~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0084}\3\2\2\2\u0085\u0086\3\2\2\2"+
		"\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u008b\3\2\2\2\u0088\u008a"+
		"\7)\2\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0092\7\37"+
		"\2\2\u008f\u0091\7)\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\7\3\2\2\2\u0094\u0092\3\2\2\2"+
		"\u0095\u0099\7\6\2\2\u0096\u0098\7)\2\2\u0097\u0096\3\2\2\2\u0098\u009b"+
		"\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u00a0\7\b\2\2\u009d\u009f\7)\2\2\u009e\u009d\3\2"+
		"\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a7\7\36\2\2\u00a4\u00a6\7"+
		")\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00b1\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ae\5\f"+
		"\7\2\u00ab\u00ad\7)\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b1\u00aa\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b8\3\2\2\2\u00b5\u00b7\7)\2\2\u00b6\u00b5\3\2"+
		"\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00bb\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bf\7\37\2\2\u00bc\u00be\7"+
		")\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\t\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c6\7\6\2\2"+
		"\u00c3\u00c5\7)\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00cd\7\t\2\2\u00ca\u00cc\7)\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2"+
		"\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00d0\u00d4\7\36\2\2\u00d1\u00d3\7)\2\2\u00d2\u00d1\3\2"+
		"\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"\u00de\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00db\5\f\7\2\u00d8\u00da\7)"+
		"\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00d7\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e5\3\2\2\2\u00e2\u00e4\7)\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e7\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00e5\3\2\2\2\u00e8\u00ec\7\37\2\2\u00e9\u00eb\7)\2\2\u00ea\u00e9\3\2"+
		"\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\13\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\5\22\n\2\u00f0\u00f4\7\20"+
		"\2\2\u00f1\u00f3\7)\2\2\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2"+
		"\2\2\u00f7\u00fb\5\16\b\2\u00f8\u00fa\7)\2\2\u00f9\u00f8\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fe\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\7!\2\2\u00ff\r\3\2\2\2\u0100\u0104"+
		"\7\16\2\2\u0101\u0103\7)\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2"+
		"\2\2\u0107\u010b\7\17\2\2\u0108\u010a\7)\2\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e\3\2"+
		"\2\2\u010d\u010b\3\2\2\2\u010e\u0112\7 \2\2\u010f\u0111\7)\2\2\u0110\u010f"+
		"\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0127\5\20\t\2\u0116\u011a\5"+
		"\60\31\2\u0117\u0119\7)\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a"+
		"\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2"+
		"\2\2\u011d\u0121\7\"\2\2\u011e\u0120\7)\2\2\u011f\u011e\3\2\2\2\u0120"+
		"\u0123\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0124\3\2"+
		"\2\2\u0123\u0121\3\2\2\2\u0124\u0125\5\62\32\2\u0125\u0127\3\2\2\2\u0126"+
		"\u0100\3\2\2\2\u0126\u0116\3\2\2\2\u0127\17\3\2\2\2\u0128\u0129\7\3\2"+
		"\2\u0129\21\3\2\2\2\u012a\u012e\5\24\13\2\u012b\u012d\7)\2\2\u012c\u012b"+
		"\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u012a\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\23\3\2\2\2\u0135\u0136"+
		"\t\2\2\2\u0136\25\3\2\2\2\u0137\u0139\5&\24\2\u0138\u0137\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u013d\3\2\2\2\u013a\u013c\7)\2\2\u013b\u013a\3\2"+
		"\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0144\5\30\r\2\u0141\u0143\7"+
		")\2\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145\27\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u014b\5\32\16"+
		"\2\u0148\u014b\5\34\17\2\u0149\u014b\5\36\20\2\u014a\u0147\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014a\u0149\3\2\2\2\u014b\31\3\2\2\2\u014c\u014d\7\22\2"+
		"\2\u014d\u014e\7$\2\2\u014e\u0152\7%\2\2\u014f\u0151\7)\2\2\u0150\u014f"+
		"\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0155\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u0159\7\36\2\2\u0156\u0158\7"+
		")\2\2\u0157\u0156\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u015c\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0160\7\n"+
		"\2\2\u015d\u015f\7)\2\2\u015e\u015d\3\2\2\2\u015f\u0162\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\u0163\3\2\2\2\u0162\u0160\3\2"+
		"\2\2\u0163\u0167\5*\26\2\u0164\u0166\7)\2\2\u0165\u0164\3\2\2\2\u0166"+
		"\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016a\3\2"+
		"\2\2\u0169\u0167\3\2\2\2\u016a\u016e\7$\2\2\u016b\u016d\7)\2\2\u016c\u016b"+
		"\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f"+
		"\u0171\3\2\2\2\u0170\u016e\3\2\2\2\u0171\u0175\5,\27\2\u0172\u0174\7)"+
		"\2\2\u0173\u0172\3\2\2\2\u0174\u0177\3\2\2\2\u0175\u0173\3\2\2\2\u0175"+
		"\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177\u0175\3\2\2\2\u0178\u017c\7%"+
		"\2\2\u0179\u017b\7)\2\2\u017a\u0179\3\2\2\2\u017b\u017e\3\2\2\2\u017c"+
		"\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2\2\2\u017e\u017c\3\2"+
		"\2\2\u017f\u0181\7&\2\2\u0180\u0182\5 \21\2\u0181\u0180\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0187\7\'\2\2\u0184\u0186\7)"+
		"\2\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189\u0187\3\2\2\2\u018a\u018e\7\37"+
		"\2\2\u018b\u018d\7)\2\2\u018c\u018b\3\2\2\2\u018d\u0190\3\2\2\2\u018e"+
		"\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\33\3\2\2\2\u0190\u018e\3\2\2"+
		"\2\u0191\u0192\7\23\2\2\u0192\u0193\7$\2\2\u0193\u0197\7%\2\2\u0194\u0196"+
		"\7)\2\2\u0195\u0194\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197"+
		"\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019e\7\36"+
		"\2\2\u019b\u019d\7)\2\2\u019c\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e"+
		"\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u019e\3\2"+
		"\2\2\u01a1\u01a5\7\n\2\2\u01a2\u01a4\7)\2\2\u01a3\u01a2\3\2\2\2\u01a4"+
		"\u01a7\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2"+
		"\2\2\u01a7\u01a5\3\2\2\2\u01a8\u01ac\5(\25\2\u01a9\u01ab\7)\2\2\u01aa"+
		"\u01a9\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2"+
		"\2\2\u01ad\u01af\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b3\7$\2\2\u01b0"+
		"\u01b2\7)\2\2\u01b1\u01b0\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2"+
		"\2\2\u01b3\u01b4\3\2\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6"+
		"\u01ba\5,\27\2\u01b7\u01b9\7)\2\2\u01b8\u01b7\3\2\2\2\u01b9\u01bc\3\2"+
		"\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc"+
		"\u01ba\3\2\2\2\u01bd\u01c1\7%\2\2\u01be\u01c0\7)\2\2\u01bf\u01be\3\2\2"+
		"\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c4"+
		"\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c6\7&\2\2\u01c5\u01c7\5 \21\2\u01c6"+
		"\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01cc\7\'"+
		"\2\2\u01c9\u01cb\7)\2\2\u01ca\u01c9\3\2\2\2\u01cb\u01ce\3\2\2\2\u01cc"+
		"\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cd\u01cf\3\2\2\2\u01ce\u01cc\3\2"+
		"\2\2\u01cf\u01d3\7\37\2\2\u01d0\u01d2\7)\2\2\u01d1\u01d0\3\2\2\2\u01d2"+
		"\u01d5\3\2\2\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\35\3\2\2"+
		"\2\u01d5\u01d3\3\2\2\2\u01d6\u01d7\7\23\2\2\u01d7\u01d8\7$\2\2\u01d8\u01dc"+
		"\7%\2\2\u01d9\u01db\7)\2\2\u01da\u01d9\3\2\2\2\u01db\u01de\3\2\2\2\u01dc"+
		"\u01da\3\2\2\2\u01dc\u01dd\3\2\2\2\u01dd\u01df\3\2\2\2\u01de\u01dc\3\2"+
		"\2\2\u01df\u01e3\7\36\2\2\u01e0\u01e2\7)\2\2\u01e1\u01e0\3\2\2\2\u01e2"+
		"\u01e5\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e6\3\2"+
		"\2\2\u01e5\u01e3\3\2\2\2\u01e6\u01ea\7\n\2\2\u01e7\u01e9\7)\2\2\u01e8"+
		"\u01e7\3\2\2\2\u01e9\u01ec\3\2\2\2\u01ea\u01e8\3\2\2\2\u01ea\u01eb\3\2"+
		"\2\2\u01eb\u01ed\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ed\u01f1\5*\26\2\u01ee"+
		"\u01f0\7)\2\2\u01ef\u01ee\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1\u01ef\3\2"+
		"\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01f1\3\2\2\2\u01f4"+
		"\u01f8\7$\2\2\u01f5\u01f7\7)\2\2\u01f6\u01f5\3\2\2\2\u01f7\u01fa\3\2\2"+
		"\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9\u01fb\3\2\2\2\u01fa\u01f8"+
		"\3\2\2\2\u01fb\u01ff\5,\27\2\u01fc\u01fe\7)\2\2\u01fd\u01fc\3\2\2\2\u01fe"+
		"\u0201\3\2\2\2\u01ff\u01fd\3\2\2\2\u01ff\u0200\3\2\2\2\u0200\u0202\3\2"+
		"\2\2\u0201\u01ff\3\2\2\2\u0202\u0206\7%\2\2\u0203\u0205\7)\2\2\u0204\u0203"+
		"\3\2\2\2\u0205\u0208\3\2\2\2\u0206\u0204\3\2\2\2\u0206\u0207\3\2\2\2\u0207"+
		"\u0209\3\2\2\2\u0208\u0206\3\2\2\2\u0209\u020a\7\22\2\2\u020a\u020b\7"+
		"$\2\2\u020b\u020f\7%\2\2\u020c\u020e\7)\2\2\u020d\u020c\3\2\2\2\u020e"+
		"\u0211\3\2\2\2\u020f\u020d\3\2\2\2\u020f\u0210\3\2\2\2\u0210\u0212\3\2"+
		"\2\2\u0211\u020f\3\2\2\2\u0212\u0214\7\36\2\2\u0213\u0215\5\"\22\2\u0214"+
		"\u0213\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0218\7\37"+
		"\2\2\u0217\u0219\5$\23\2\u0218\u0217\3\2\2\2\u0218\u0219\3\2\2\2\u0219"+
		"\u021a\3\2\2\2\u021a\u021e\7\37\2\2\u021b\u021d\7)\2\2\u021c\u021b\3\2"+
		"\2\2\u021d\u0220\3\2\2\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021f"+
		"\37\3\2\2\2\u0220\u021e\3\2\2\2\u0221\u0223\13\2\2\2\u0222\u0221\3\2\2"+
		"\2\u0223\u0224\3\2\2\2\u0224\u0225\3\2\2\2\u0224\u0222\3\2\2\2\u0225!"+
		"\3\2\2\2\u0226\u0228\13\2\2\2\u0227\u0226\3\2\2\2\u0228\u0229\3\2\2\2"+
		"\u0229\u022a\3\2\2\2\u0229\u0227\3\2\2\2\u022a#\3\2\2\2\u022b\u022d\13"+
		"\2\2\2\u022c\u022b\3\2\2\2\u022d\u022e\3\2\2\2\u022e\u022f\3\2\2\2\u022e"+
		"\u022c\3\2\2\2\u022f%\3\2\2\2\u0230\u0234\7\32\2\2\u0231\u0233\13\2\2"+
		"\2\u0232\u0231\3\2\2\2\u0233\u0236\3\2\2\2\u0234\u0235\3\2\2\2\u0234\u0232"+
		"\3\2\2\2\u0235\u0237\3\2\2\2\u0236\u0234\3\2\2\2\u0237\u0238\7\33\2\2"+
		"\u0238\'\3\2\2\2\u0239\u023a\7(\2\2\u023a)\3\2\2\2\u023b\u023c\7(\2\2"+
		"\u023c+\3\2\2\2\u023d\u023f\5.\30\2\u023e\u023d\3\2\2\2\u023e\u023f\3"+
		"\2\2\2\u023f\u0243\3\2\2\2\u0240\u0242\7)\2\2\u0241\u0240\3\2\2\2\u0242"+
		"\u0245\3\2\2\2\u0243\u0241\3\2\2\2\u0243\u0244\3\2\2\2\u0244\u025c\3\2"+
		"\2\2\u0245\u0243\3\2\2\2\u0246\u0248\7)\2\2\u0247\u0246\3\2\2\2\u0248"+
		"\u024b\3\2\2\2\u0249\u0247\3\2\2\2\u0249\u024a\3\2\2\2\u024a\u024c\3\2"+
		"\2\2\u024b\u0249\3\2\2\2\u024c\u0250\7#\2\2\u024d\u024f\7)\2\2\u024e\u024d"+
		"\3\2\2\2\u024f\u0252\3\2\2\2\u0250\u024e\3\2\2\2\u0250\u0251\3\2\2\2\u0251"+
		"\u0253\3\2\2\2\u0252\u0250\3\2\2\2\u0253\u0257\5.\30\2\u0254\u0256\7)"+
		"\2\2\u0255\u0254\3\2\2\2\u0256\u0259\3\2\2\2\u0257\u0255\3\2\2\2\u0257"+
		"\u0258\3\2\2\2\u0258\u025b\3\2\2\2\u0259\u0257\3\2\2\2\u025a\u0249\3\2"+
		"\2\2\u025b\u025e\3\2\2\2\u025c\u025a\3\2\2\2\u025c\u025d\3\2\2\2\u025d"+
		"-\3\2\2\2\u025e\u025c\3\2\2\2\u025f\u0263\5\60\31\2\u0260\u0262\7)\2\2"+
		"\u0261\u0260\3\2\2\2\u0262\u0265\3\2\2\2\u0263\u0261\3\2\2\2\u0263\u0264"+
		"\3\2\2\2\u0264\u0266\3\2\2\2\u0265\u0263\3\2\2\2\u0266\u026a\7\"\2\2\u0267"+
		"\u0269\7)\2\2\u0268\u0267\3\2\2\2\u0269\u026c\3\2\2\2\u026a\u0268\3\2"+
		"\2\2\u026a\u026b\3\2\2\2\u026b\u026d\3\2\2\2\u026c\u026a\3\2\2\2\u026d"+
		"\u026e\5\62\32\2\u026e/\3\2\2\2\u026f\u0270\7(\2\2\u0270\61\3\2\2\2\u0271"+
		"\u0274\7\4\2\2\u0272\u0274\5\64\33\2\u0273\u0271\3\2\2\2\u0273\u0272\3"+
		"\2\2\2\u0274\63\3\2\2\2\u0275\u0276\7(\2\2\u0276\u0277\7\34\2\2\u0277"+
		"\u0278\7(\2\2\u0278\u027f\7\35\2\2\u0279\u027a\7(\2\2\u027a\u027b\7\34"+
		"\2\2\u027b\u027c\5\64\33\2\u027c\u027d\7\35\2\2\u027d\u027f\3\2\2\2\u027e"+
		"\u0275\3\2\2\2\u027e\u0279\3\2\2\2\u027f\65\3\2\2\2Z:AGMSY`flsz\u0081"+
		"\u0086\u008b\u0092\u0099\u00a0\u00a7\u00ae\u00b3\u00b8\u00bf\u00c6\u00cd"+
		"\u00d4\u00db\u00e0\u00e5\u00ec\u00f4\u00fb\u0104\u010b\u0112\u011a\u0121"+
		"\u0126\u012e\u0133\u0138\u013d\u0144\u014a\u0152\u0159\u0160\u0167\u016e"+
		"\u0175\u017c\u0181\u0187\u018e\u0197\u019e\u01a5\u01ac\u01b3\u01ba\u01c1"+
		"\u01c6\u01cc\u01d3\u01dc\u01e3\u01ea\u01f1\u01f8\u01ff\u0206\u020f\u0214"+
		"\u0218\u021e\u0224\u0229\u022e\u0234\u023e\u0243\u0249\u0250\u0257\u025c"+
		"\u0263\u026a\u0273\u027e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}