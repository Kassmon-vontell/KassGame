package com.kassmon.asm.parser.statments.commands.control.memory;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.control.memory.StoreMemory;
import com.kassmon.common.exceptions.ErrorException;

public class StoreMemoryParser extends StatmentParser {

	public StoreMemoryParser(Lexer lexer) {
		super(lexer, "stm", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token token = lexer.lex(false);
		int lineNumber = token.getLine();
		Integer registerPointer = consumeNumberLiteralValue();
		if (registerPointer != null) 
			return new StoreMemory(lineNumber, registerPointer);
		throw new ErrorException("Expected a register pointer after 'stm' statement on line " + lineNumber);
	}

}
