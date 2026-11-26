package com.kassmon.asm.core.parser.statements.commands.basic.conditionals;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.lexer.TokenType;
import com.kassmon.asm.core.parser.statements.commands.CommandParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.commands.basic.conditionals.JumpNotEqual;

public class JumpNotEqualParser extends CommandParser {

	public JumpNotEqualParser(Lexer lexer) {
		super(lexer, "jne");
	}

	@Override
	public Statement parse() {
		if (!matchesCurrentToken()) return null;
		Token statmentToken = getNextToken(false);
		Token labelToken = getNextToken(false);
		if (labelToken.getType() != TokenType.LABEL) 
			throw new ParserException("Expected label after 'jne' statment on line: " + labelToken.getLine());
		if (labelToken.getLexeme().startsWith(":"))
			throw new ParserException("Label after 'jne' statment on line: " + 
					labelToken.getLine() + " cannot start with ':'");
		return new JumpNotEqual(statmentToken.getLine(), labelToken.getLexeme());
	}

}
