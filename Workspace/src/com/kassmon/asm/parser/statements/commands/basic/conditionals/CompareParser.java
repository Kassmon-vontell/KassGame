package com.kassmon.asm.parser.statements.commands.basic.conditionals;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.parser.statements.commands.CommandParser;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.commands.basic.conditionals.Compare;

public class CompareParser extends CommandParser {

	public CompareParser(Lexer lexer) {
		super(lexer, "cmp");
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token statmentToken = lexer.lex(false);
		Argument firstArgument = parseArgument();
		Argument secondArgument = parseArgument();
		return new Compare(statmentToken.getLine(), firstArgument, secondArgument);
	}
	
}
