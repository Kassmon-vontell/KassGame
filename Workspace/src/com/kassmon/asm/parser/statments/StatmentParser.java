package com.kassmon.asm.parser.statments;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.staments.Statment;

public abstract class StatmentParser {
	
	protected Lexer lexer;
	protected String keyWord = null;
	protected TokenType tokenType = null;
	
	public StatmentParser(Lexer lexer, String keyWord, TokenType tokenType) {
		this.lexer = lexer;
		this.keyWord = keyWord;
		this.tokenType = tokenType;
	}
	
	public StatmentParser(Lexer lexer, TokenType tokenType) {
		this.lexer = lexer;
		this.tokenType = tokenType;
	}
	
	public StatmentParser(Lexer lexer, String keyWord) {
		this.lexer = lexer;
		this.keyWord = keyWord;
	}
	
	public abstract Statment parse();
	
	public String getKeyWord() {
		return keyWord;
	}
	
	protected boolean matchesCurrentToken() {
		Token token = lexer.lex(true);
		if (tokenType != null && token.getType() != tokenType) return false;
		if (keyWord != null && !token.getLexeme().equals(keyWord)) return false;
		return true;
	}
	
	protected Integer consumeNumberLiteralValue() {
		Token token = lexer.lex(false);
		switch (token.getType()) {
			case INTEGER -> {
				return Integer.parseInt(token.getLexeme());
			}
			case HEX -> {
				return Integer.parseInt(token.getLexeme().substring(2), 16);
			}
			case CHARACTER -> {
				if (token.getLexeme().equals("cxspc")) return 32;
				if (token.getLexeme().equals("cxlf")) return 10;
				return (int) token.getLexeme().charAt(2);
			}
			default -> {
				return null;
			}
		}
	}
	
	protected String consumeStringLiteralValue() {
		Token token = lexer.lex(false);
		if (token.getType() == TokenType.LABEL) {
			return token.getLexeme().substring(1);
		}
		return null;
	}
	
}
