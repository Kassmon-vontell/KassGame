package com.kassmon.asm.parser.statments;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.staments.Statment;

public abstract class StatmentParser {
	
	protected Lexer lexer;
	
	public StatmentParser(Lexer lexer) {
		this.lexer = lexer;
	}
	
	public abstract Statment parse();
	
}
