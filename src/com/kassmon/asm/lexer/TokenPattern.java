package com.kassmon.asm.lexer;

import java.util.regex.Pattern;

public class TokenPattern {
	
	private Pattern pattern;
	private TokenType type;
	
	public TokenPattern(String regex, TokenType type) {
		this.pattern = Pattern.compile(regex);
		this.type = type;
	}
	
	public Pattern getPattern() {
		return pattern;
	}
	
	public TokenType getType() {
		return type;
	}
	
}
