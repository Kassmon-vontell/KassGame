package com.kassmon.asm.parser.statements.commands.basic.control;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statements.commands.CommandParser;
import com.kassmon.asm.statement.Statment;
import com.kassmon.asm.statement.commands.basic.control.Jump;

public class JumpParser extends CommandParser {

	public JumpParser(Lexer lexer) {
		super(lexer, "jmp");
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token statementToken = lexer.lex(false);
		Token labelToken = lexer.lex(false);
		if (labelToken.getType() != TokenType.LABEL) 
			throw new ParserException("Expected label for 'jmp' statment on line: " + statementToken.getLine());
		if (labelToken.getLexeme().startsWith(":")) 
			throw new ParserException("Label cannot start with ':' for 'jmp' statment on line: " + statementToken.getLine());
		return new Jump(statementToken.getLine(), labelToken.getLexeme());
	}

}
