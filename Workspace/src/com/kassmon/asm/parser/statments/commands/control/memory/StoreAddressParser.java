package com.kassmon.asm.parser.statments.commands.control.memory;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.control.memory.StoreAddress;
import com.kassmon.common.exceptions.ErrorException;

public class StoreAddressParser extends StatmentParser {

	public StoreAddressParser(Lexer lexer) {
		super(lexer, "sta", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token token = lexer.lex(false);
		int lineNumber = token.getLine();
		Integer registerPointer = consumeNumberLiteralValue();
		if (registerPointer != null) 
			return new StoreAddress(lineNumber, registerPointer);
		throw new ErrorException("Expected a register pointer after 'sta' statement on line " + lineNumber);
	}

}
