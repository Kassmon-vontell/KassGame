package com.kassmon.asm.parser.statments.commands.control.memory;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.control.memory.LoadAddress;
import com.kassmon.common.exceptions.ErrorException;

public class LoadMemoryParser extends StatmentParser {

	public LoadMemoryParser(Lexer lexer) {
		super(lexer, "ldm", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token token = lexer.lex(false);
		int lineNumber = token.getLine();
		Integer registerPointer = consumeNumberLiteralValue();
		if (registerPointer != null) 
			return new LoadAddress(lineNumber, registerPointer);
		throw new ErrorException("Expected a register pointer after 'ldm' statement on line " + lineNumber);
	}

}
