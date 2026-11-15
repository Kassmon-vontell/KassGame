package com.kassmon.asm.parser.statments.commands.basic.conditionals;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.basic.conditionals.JumpNotEqual;
import com.kassmon.common.exceptions.ErrorException;

public class JumpNotEqualParser extends StatmentParser {

	public JumpNotEqualParser(Lexer lexer) {
		super(lexer, "jne", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		int line = lexer.lex(false).getLine();
		String label = consumeStringLiteralValue();
		if (label != null) 
			return new JumpNotEqual(line, label);
		throw new ErrorException("Invalid jump not equal statement, expected a string literal on line " + line);
	}

}
