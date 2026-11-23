package com.kassmon.asm.parser.statements;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.statement.Statment;

public abstract class StatementParser {
	
	protected Lexer lexer;
	
	public StatementParser(Lexer lexer) {
		this.lexer = lexer;
	}
	
	public abstract Statment parse();
	
	
}
