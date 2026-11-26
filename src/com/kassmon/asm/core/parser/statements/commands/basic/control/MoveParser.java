package com.kassmon.asm.core.parser.statements.commands.basic.control;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.arguments.ArgumentType;
import com.kassmon.asm.core.statement.commands.basic.control.Move;

public class MoveParser extends CommandParser {

	public MoveParser(Lexer lexer) {
		super(lexer, "mov");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token statementToken = getNextToken(false);
		Argument register = parseArgument();
		Argument value = parseArgument();
		if (register.getType() != ArgumentType.REGISTER) 
			throw new ParserException("First argument must be a register on line: " + statementToken.getLine());
		return new Move(statementToken.getLine(), register, value);
	}

}
