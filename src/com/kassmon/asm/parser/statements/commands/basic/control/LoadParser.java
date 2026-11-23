package com.kassmon.asm.parser.statements.commands.basic.control;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.parser.statements.commands.CommandParser;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.commands.basic.control.Load;

public class LoadParser extends CommandParser {

	public LoadParser(Lexer lexer) {
		super(lexer, "load");
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token statementToken = lexer.lex(false);
		Argument value = parseArgument();
		Argument register = parseArgument();
		return new Load(statementToken.getLine(), value, register);
	}

}
