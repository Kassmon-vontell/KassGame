package com.kassmon.asm.core.parser.statements.commands.basic.math;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.arguments.ArgumentType;
import com.kassmon.asm.core.statement.commands.basic.math.Sub;

public class SubParser extends CommandParser {

	public SubParser(Lexer lexer) {
		super(lexer, "sub");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token StatementToken = getNextToken(false);
		Argument registerArg = parseArgument();
		Argument SecondArg = parseArgument();
		if (registerArg.getType() != ArgumentType.REGISTER)
			throw new ParserException("Expected first argument for 'sub' statment on line: " + StatementToken.getLine());
		return new Sub(StatementToken.getLine(), registerArg, SecondArg);
	}

}
