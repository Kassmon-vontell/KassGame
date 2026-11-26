package com.kassmon.asm.core.parser.statements.commands.basic.control;

import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.commands.basic.control.Load;

public class LoadParser extends CommandParser {

	public LoadParser(Lexer lexer) {
		super(lexer, "load");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token statementToken = getNextToken(false);
		Argument value = parseArgument();
		Argument register = parseArgument();
		return new Load(statementToken.getLine(), value, register);
	}

}
