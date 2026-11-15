package com.kassmon.asm.parser.statments.commands.basic.control.register;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.basic.control.register.Move;
import com.kassmon.common.exceptions.ErrorException;

public class MoveParser extends StatmentParser {

	public MoveParser(Lexer lexer) {
		super(lexer, "mov", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		int lineNumber = lexer.lex(false).getLine();
		Integer registerPointer1 = consumeNumberLiteralValue();
		Integer registerPointer2 = consumeNumberLiteralValue();
		if (registerPointer1 != null && registerPointer2 != null) 
			return new Move(lineNumber, true, registerPointer1, registerPointer2);
		throw new ErrorException("Expected two register pointers after mov statement at line " + lineNumber);
	}

}
