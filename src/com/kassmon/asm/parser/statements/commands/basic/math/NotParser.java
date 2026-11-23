package com.kassmon.asm.parser.statements.commands.basic.math;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.parser.statements.commands.CommandParser;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.arguments.ArgumentType;
import com.kassmon.asm.statement.commands.basic.math.Not;

public class NotParser extends CommandParser {

	public NotParser(Lexer lexer) {
		super(lexer, "not");
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token StatementToken = lexer.lex(false);
		Argument registerArg = parseArgument();
		if (registerArg.getType() != ArgumentType.REGISTER)
			throw new ParserException("Expected first argument for 'not' statment on line: " + StatementToken.getLine());
		return new Not(StatementToken.getLine(), registerArg);
	}

}
