package com.kassmon.asm.parser.statments.commands.basic.conditionals;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.basic.conditionals.JumpEqual;
import com.kassmon.common.exceptions.ErrorException;

public class JumpEqualParser extends StatmentParser {

	public JumpEqualParser(Lexer lexer) {
		super(lexer, "jeq", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		int line = lexer.lex(false).getLine();
		String label = consumeStringLiteralValue();
		if (label != null) 
			return new JumpEqual(line, label);
		throw new ErrorException("Invalid jump equal statement, expected a string literal on line " + line);
	}

}
