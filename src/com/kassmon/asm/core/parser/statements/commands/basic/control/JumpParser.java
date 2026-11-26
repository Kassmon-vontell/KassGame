package com.kassmon.asm.core.parser.statements.commands.basic.control;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.lexer.TokenType;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.commands.basic.control.Jump;

public class JumpParser extends CommandParser {

	public JumpParser(Lexer lexer) {
		super(lexer, "jmp");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token statementToken = getNextToken(false);
		Token labelToken = getNextToken(false);
		if (labelToken.getType() != TokenType.LABEL) 
			throw new ParserException("Expected label for 'jmp' statment on line: " + statementToken.getLine());
		if (labelToken.getLexeme().startsWith(":")) 
			throw new ParserException("Label cannot start with ':' for 'jmp' statment on line: " + statementToken.getLine());
		return new Jump(statementToken.getLine(), labelToken.getLexeme());
	}

}
