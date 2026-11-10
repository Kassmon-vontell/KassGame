package com.kassmon.asm.lexer;

public class Token {
	
	private TokenType type;
	private String lexeme;
	private int line;
	
	public Token(TokenType type, String lexeme, int line) {
		this.type = type;
		this.lexeme = lexeme;
		this.line = line;
	}
	
	public TokenType getType() {
		return type;
	}
	
	public String getLexeme() {
		return lexeme;
	}
	
	public int getLine() {
		return line;
	}
	
	@Override
	public String toString() {
		return switch (type) {
			case STATMENT -> "STATMENT: " + lexeme + " (line: " + line + ")";
			case INTEGER -> "INTEGER: " + lexeme + " (line: " + line + ")";
			case HEX -> "HEX: " + lexeme + " (line: " + line + ")";
			case CHARACTER -> "CHARACTER: " + lexeme + " (line: " + line + ")";
			case LABEL -> "LABEL: " + lexeme + " (line: " + line + ")";
			case COMMENT -> "COMMENT: " + lexeme + " (line: " + line + ")";
			case FLAG -> "FLAG: " + lexeme + " (line: " + line + ")";
			case SPACE -> "SPACE: " + lexeme + " (line: " + line + ")";
			case NEWLINE -> "NEWLINE: " + lexeme + " (line: " + line + ")";
			case ERROR -> "ERROR: " + lexeme + " (line: " + line + ")";
			case EOF -> "EOF: " + lexeme + " (line: " + line + ")";
		};
	}
	
	
	
}
