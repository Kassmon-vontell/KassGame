package com.kassmon.asm.parser.statements.commands.basic.conditionals;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statements.commands.CommandParser;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.commands.basic.conditionals.JumpGreaterThan;

public class JumpGreaterThanParser extends CommandParser {

	public JumpGreaterThanParser(Lexer lexer) {
		super(lexer, "jgt");
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token statmentToken = lexer.lex(false);
		Token labelToken = lexer.lex(false);
		if (labelToken.getType() != TokenType.LABEL) 
			throw new ParserException("Expected label after 'jgt' statment on line: " + labelToken.getLine());
		if (labelToken.getLexeme().startsWith(":"))
			throw new ParserException("Label after 'jgt' statment on line: " + 
					labelToken.getLine() + " cannot start with ':'");
		return new JumpGreaterThan(statmentToken.getLine(), labelToken.getLexeme());
	}

}
