package com.kassmon.asm.lexer;

import java.util.ArrayList;
import java.util.regex.Matcher;

import com.kassmon.common.exceptions.ErrorException;

import static com.kassmon.asm.lexer.TokenType.*;

public class Lexer {
	
	private String input;
	private final ArrayList<TokenPattern> tokenPatterns;
	
	private int lineNumber = 1;
	
	public Lexer(String input) {
		this.input = input;
		this.tokenPatterns = new ArrayList<>();
	}
	
	public void initFixedTokens() {
		addTokenPattern("#[a-zA-Z]+", FLAG);
		
		addTokenPattern("0x[0-9a-f]+\\b",HEX);
		addTokenPattern("-?[0-9]+\\b",INTEGER);
		addTokenPattern("cxspc\\b",CHARACTER);
		addTokenPattern("cxlf", CHARACTER);
		addTokenPattern("cx[a-zA-Z0-9]\\b",CHARACTER);
		
		addTokenPattern(":[a-zA-Z_][a-zA-Z0-9_]*\\b",LABEL);
		
		addTokenPattern("!.*",COMMENT);
		
		addTokenPattern("[ \t]+",SPACE);
		addTokenPattern("(?:\r\n|\n|\r)", NEWLINE);
	}
	
	public void addTokenPattern(String regex, TokenType type) {
		this.tokenPatterns.add(new TokenPattern(regex, type));
	}
	
	public Token lex(boolean peak) {
		String errorMessage = "";
		while (true) {
			Token token = getToken(true);
			if (token == null) {
				errorMessage = errorMessage + input.charAt(0);
				input = input.substring(1);
				continue;
			}else {
				if (errorMessage.isEmpty())
					return getToken(peak);
				throw new ErrorException("Lexer error: Unexpected token '" + errorMessage + "'");
			}
		}
	}
	
	private Token getToken(boolean peak) {
		if (input.isEmpty()) return new Token(TokenType.EOF, "", lineNumber);
		
		for (TokenPattern tokenPattern : tokenPatterns) {
			Matcher matcher = tokenPattern.getPattern().matcher(input);
			if (matcher.lookingAt()) {
				String lexeme = matcher.group();
				if (!peak) 
					input = input.substring(lexeme.length());
				return new Token(tokenPattern.getType(), lexeme, lineNumber);
			}
		}
		
		return null;
	}
}