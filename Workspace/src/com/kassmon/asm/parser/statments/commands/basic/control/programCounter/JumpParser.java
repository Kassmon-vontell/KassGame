package com.kassmon.asm.parser.statments.commands.basic.control.programCounter;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.basic.control.programCounter.Jmp;

public class JumpParser extends StatmentParser {

	public JumpParser(Lexer lexer) {
		super(lexer, "jmp", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token token = lexer.lex(false);
		int lineNumber = token.getLine();
		String label = consumeStringLiteralValue();
		if (label != null) 
			return new Jmp(lineNumber, label);
		throw new RuntimeException("Expected label after jmp statement at line " + lineNumber);
	}

}
