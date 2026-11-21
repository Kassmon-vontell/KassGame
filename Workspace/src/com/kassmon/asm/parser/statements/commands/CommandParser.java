package com.kassmon.asm.parser.statements.commands;

import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statements.StatementParser;
import com.kassmon.asm.statement.arguments.Argument;
import com.kassmon.asm.statement.arguments.ArgumentType;

public abstract class CommandParser extends StatementParser {

	protected String keyWord;

	public CommandParser(Lexer lexer, String keyWord) {
		super(lexer);
		this.keyWord = keyWord;
		lexer.addCommandParserKeyWord(this);
	}

	protected boolean matchesCurrentToken() {
		Token token = lexer.lex(true);
		if (token.getType() != TokenType.STATEMENT) return false;
		if (!token.getLexeme().equals(keyWord)) return false;
		return true;
	}
	
	protected Argument parseArgument() {
		Token t = lexer.lex(false);
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
				if (character.equals("spc")) {
					return new Argument(ArgumentType.LITERAL, ' ');
				}
				if (character.equals("lf")) {
					return new Argument(ArgumentType.LITERAL, '\n');
				}
				return new Argument(ArgumentType.LITERAL, character.charAt(0));
			}
			case REGISTER -> {
				return new Argument(ArgumentType.REGISTER, 
					Integer.parseInt(t.getLexeme().substring(1)));
			}
			default -> {
				throw new ParserException("Expected first argument for 'cmp' statment on line: " + t.getLine());
			}
		}
	}
	
	public String getKeyWord() {
		return keyWord;
	}
	
}
