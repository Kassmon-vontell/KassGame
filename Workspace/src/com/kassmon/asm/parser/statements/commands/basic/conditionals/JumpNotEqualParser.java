package com.kassmon.asm.parser.statements.commands.basic.conditionals;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statements.commands.CommandParser;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.commands.basic.conditionals.JumpNotEqual;

public class JumpNotEqualParser extends CommandParser {

	public JumpNotEqualParser(Lexer lexer) {
		super(lexer, "jne");
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token statmentToken = lexer.lex(false);
		Token labelToken = lexer.lex(false);
		if (labelToken.getType() != TokenType.LABEL) 
			throw new ParserException("Expected label after 'jne' statment on line: " + labelToken.getLine());
		if (labelToken.getLexeme().startsWith(":"))
			throw new ParserException("Label after 'jne' statment on line: " + 
					labelToken.getLine() + " cannot start with ':'");
		return new JumpNotEqual(statmentToken.getLine(), labelToken.getLexeme());
	}

}
