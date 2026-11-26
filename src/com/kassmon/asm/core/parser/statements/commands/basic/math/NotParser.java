package com.kassmon.asm.core.parser.statements.commands.basic.math;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.arguments.ArgumentType;
import com.kassmon.asm.core.statement.commands.basic.math.Not;

public class NotParser extends CommandParser {

	public NotParser(Lexer lexer) {
		super(lexer, "not");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token StatementToken = getNextToken(false);
		Argument registerArg = parseArgument();
		if (registerArg.getType() != ArgumentType.REGISTER)
			throw new ParserException("Expected first argument for 'not' statment on line: " + StatementToken.getLine());
		return new Not(StatementToken.getLine(), registerArg);
	}

}
