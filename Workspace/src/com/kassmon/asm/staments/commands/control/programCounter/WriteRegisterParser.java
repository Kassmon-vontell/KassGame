package com.kassmon.asm.staments.commands.control.programCounter;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.control.register.WriteRegister;
import com.kassmon.common.exceptions.ErrorException;

public class WriteRegisterParser extends StatmentParser {

	public WriteRegisterParser(Lexer lexer, String keyWord, TokenType tokenType) {
		super(lexer, "wrr", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		int lineNumber = lexer.lex(false).getLine();
		Integer value = consumeNumberLiteralValue();
		Integer registerPointer = consumeNumberLiteralValue();
		if (value != null && registerPointer != null) 
			return new WriteRegister(lineNumber, value, registerPointer);
		throw new ErrorException("Expected two number literals after wrr statement at line " + lineNumber);
	}

}
