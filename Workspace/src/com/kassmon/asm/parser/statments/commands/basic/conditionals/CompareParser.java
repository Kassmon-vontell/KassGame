package com.kassmon.asm.parser.statments.commands.basic.conditionals;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.commands.basic.conditionals.Compare;
import com.kassmon.common.exceptions.ErrorException;

public class CompareParser extends StatmentParser{

	public CompareParser(Lexer lexer) {
		super(lexer, "cmp", TokenType.STATEMENT);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		int line = lexer.lex(false).getLine();
		Integer left = consumeNumberLiteralValue();
		Integer right = consumeNumberLiteralValue();
		if (left != null && right != null) 
			return new Compare(line, left, right);
		throw new ErrorException("Invalid compare statement, expected two number literals on line " + line);
	}
	
	
	
}
