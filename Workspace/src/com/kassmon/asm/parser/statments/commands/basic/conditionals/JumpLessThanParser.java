package com.kassmon.asm.parser.statments.commands.basic.conditionals;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.basic.conditionals.JumpLessThan;
import com.kassmon.common.exceptions.ErrorException;

public class JumpLessThanParser extends StatmentParser {

	public JumpLessThanParser(Lexer lexer) {
		super(lexer, "jlt", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		int line = lexer.lex(false).getLine();
		String label = consumeStringLiteralValue();
		if (label != null) 
			return new JumpLessThan(line, label);
		throw new ErrorException("Invalid jump less than statement, expected a string literal on line " + line);
	}

}
