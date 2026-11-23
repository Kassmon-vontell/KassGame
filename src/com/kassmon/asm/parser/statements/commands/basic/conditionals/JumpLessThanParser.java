package com.kassmon.asm.parser.statements.commands.basic.conditionals;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statements.commands.CommandParser;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.commands.basic.conditionals.JumpLessThan;

public class JumpLessThanParser extends CommandParser {

	public JumpLessThanParser(Lexer lexer) {
		super(lexer, "jlt");
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token statmentToken = lexer.lex(false);
		Token labelToken = lexer.lex(false);
		if (labelToken.getType() != TokenType.LABEL) 
			throw new com.kassmon.asm.exceptions.ParserException("Expected label after 'jlt' statment on line: " + labelToken.getLine());
		if (labelToken.getLexeme().startsWith(":"))
			throw new com.kassmon.asm.exceptions.ParserException("Label after 'jlt' statment on line: " + 
					labelToken.getLine() + " cannot start with ':'");
		return new JumpLessThan(statmentToken.getLine(), labelToken.getLexeme());
	}

}
