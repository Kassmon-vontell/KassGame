package com.kassmon.asm.core.parser.statements.commands;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.lexer.TokenType;
import com.kassmon.asm.core.parser.statements.StatementParser;
import com.kassmon.asm.core.statement.arguments.Argument;
import com.kassmon.asm.core.statement.arguments.ArgumentType;

public abstract class CommandParser extends StatementParser {

	protected String keyWord;

	public CommandParser(Lexer lexer, String keyWord) {
		super(lexer);
		this.keyWord = keyWord;
		lexer.addCommandParserKeyWord(this);
	}

	protected boolean matchesCurrentToken() {
		Token token = getNextToken(true);
		if (token.getType() != TokenType.STATEMENT) return false;
		return token.getLexeme().equals(keyWord);
	}
	
	protected Argument parseArgument() {
		Token t = getNextToken(false);
		switch (t.getType()) {
			case INTEGER -> {
				return new Argument(ArgumentType.LITERAL, 
						Integer.parseInt(t.getLexeme()));
			}
			case HEX -> {
				return new Argument(ArgumentType.LITERAL, 
						Integer.parseInt(t.getLexeme().substring(2), 16));
			}
			case CHARACTER -> {
				String character = t.getLexeme().substring(2);
				if (character.equals("spc"))
					return new Argument(ArgumentType.LITERAL, ' ');
				if (character.equals("lf"))
					return new Argument(ArgumentType.LITERAL, '\n');
				return new Argument(ArgumentType.LITERAL, character.charAt(0));
			}
			case REGISTER -> {
				return new Argument(ArgumentType.REGISTER, 
					Integer.parseInt(t.getLexeme().substring(1)));
			}
			default -> throw new ParserException("Unexpected token: " + t.getType());
		}
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	
}