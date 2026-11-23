package com.kassmon.asm.parser.statements.commands.basic.control;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.parser.statements.commands.CommandParser;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.arguments.ArgumentType;
import com.kassmon.asm.statement.commands.basic.control.Move;

public class MoveParser extends CommandParser {

	public MoveParser(Lexer lexer) {
		super(lexer, "mov");
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token statementToken = lexer.lex(false);
		Argument register = parseArgument();
		Argument value = parseArgument();
		if (register.getType() != ArgumentType.REGISTER) 
			throw new ParserException("First argument must be a register on line: " + statementToken.getLine());
		return new Move(statementToken.getLine(), register, value);
	}

}
