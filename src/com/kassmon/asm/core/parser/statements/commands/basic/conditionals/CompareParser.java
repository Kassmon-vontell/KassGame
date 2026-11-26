package com.kassmon.asm.core.parser.statements.commands.basic.conditionals;

import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.commands.basic.conditionals.Compare;

public class CompareParser extends CommandParser {

	public CompareParser(Lexer lexer) {
		super(lexer, "cmp");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token statmentToken = getNextToken(false);
		Argument firstArgument = parseArgument();
		Argument secondArgument = parseArgument();
		return new Compare(statmentToken.getLine(), firstArgument, secondArgument);
	}
	
}
