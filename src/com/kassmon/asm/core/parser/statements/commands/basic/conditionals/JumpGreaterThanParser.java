package com.kassmon.asm.core.parser.statements.commands.basic.conditionals;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.lexer.TokenType;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.commands.basic.conditionals.JumpGreaterThan;

public class JumpGreaterThanParser extends CommandParser {

	public JumpGreaterThanParser(Lexer lexer) {
		super(lexer, "jgt");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token statmentToken = getNextToken(false);
		Token labelToken = getNextToken(false);
		if (labelToken.getType() != TokenType.LABEL) 
			throw new ParserException("Expected label after 'jgt' statment on line: " + labelToken.getLine());
		if (labelToken.getLexeme().startsWith(":"))
			throw new ParserException("Label after 'jgt' statment on line: " + 
					labelToken.getLine() + " cannot start with ':'");
		return new JumpGreaterThan(statmentToken.getLine(), labelToken.getLexeme());
	}

}
