package com.kassmon.asm.core.parser.statements;

import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.statement.Statement;

public abstract class StatementParser {
	
	private final Lexer lexer;
	
	public StatementParser(Lexer lexer) {
		this.lexer = lexer;
	}
	
	public abstract Statement parse();
	
	protected Token getNextToken(boolean peak) {
		return lexer.lex(peak);
	}
	
}
