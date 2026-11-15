package com.kassmon.asm.parser.statments.commands.basic.conditionals;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.basic.conditionals.JumpGreaterThan;
import com.kassmon.common.exceptions.ErrorException;

public class JumpGreaterThanParser extends StatmentParser {

	public JumpGreaterThanParser(Lexer lexer) {
		super(lexer, "jgt", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		int line = lexer.lex(false).getLine();
		String label = consumeStringLiteralValue();
		if (label != null) 
			return new JumpGreaterThan(line, label);
		throw new ErrorException("Invalid jump greater than statement, expected a string literal on line " + line);
	}

}
