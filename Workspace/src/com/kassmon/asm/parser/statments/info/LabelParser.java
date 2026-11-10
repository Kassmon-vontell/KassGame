package com.kassmon.asm.parser.statments.info;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.info.Label;

public class LabelParser extends StatmentParser {

	public LabelParser(Lexer lexer) {
		super(lexer);
	}

	@Override
	public Statment parse() {
		Token token = lexer.lex(true);
		if (token.getType() != TokenType.LABEL) return null;
		lexer.lex(false);
		return new Label(token.getLine(), token.getLexeme().substring(1));
	}

}
