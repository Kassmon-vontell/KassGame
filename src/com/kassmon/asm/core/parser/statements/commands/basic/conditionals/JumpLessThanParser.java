package com.kassmon.asm.core.parser.statements.commands.basic.conditionals;

import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.lexer.TokenType;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.commands.basic.conditionals.JumpLessThan;

public class JumpLessThanParser extends CommandParser {

	public JumpLessThanParser(Lexer lexer) {
		super(lexer, "jlt");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token statmentToken = getNextToken(false);
		Token labelToken = getNextToken(false);
		if (labelToken.getType() != TokenType.LABEL) 
			throw new com.kassmon.asm.exceptions.ParserException("Expected label after 'jlt' statment on line: " + labelToken.getLine());
		if (labelToken.getLexeme().startsWith(":"))
			throw new com.kassmon.asm.exceptions.ParserException("Label after 'jlt' statment on line: " + 
					labelToken.getLine() + " cannot start with ':'");
		return new JumpLessThan(statmentToken.getLine(), labelToken.getLexeme());
	}

}
