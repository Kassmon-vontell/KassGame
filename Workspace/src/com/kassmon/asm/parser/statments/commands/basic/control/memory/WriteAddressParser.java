package com.kassmon.asm.parser.statments.commands.basic.control.memory;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.basic.control.memory.WriteAddress;
import com.kassmon.common.exceptions.ErrorException;

public class WriteAddressParser extends StatmentParser {

	public WriteAddressParser(Lexer lexer) {
		super(lexer, "wra", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token token = lexer.lex(false);
		int lineNumber = token.getLine();
		Integer registerPointer = consumeNumberLiteralValue();
		if (registerPointer != null) 
			return new WriteAddress(lineNumber, registerPointer);
		throw new ErrorException("Expected a register pointer after 'wra' statement on line " + lineNumber);
	}

}
