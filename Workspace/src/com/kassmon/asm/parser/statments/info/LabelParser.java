package com.kassmon.asm.parser.statments.info;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.lexer.Token;
import com.kassmon.asm.lexer.TokenType;
import com.kassmon.asm.parser.statments.StatmentParser;
import com.kassmon.asm.staments.Statment;
import com.kassmon.asm.staments.info.Label;

public class LabelParser extends StatmentParser {

	public LabelParser(Lexer lexer) {
		super(lexer, TokenType.LABEL);
	}

	@Override
	public Statment parse() {
		if (!matchesCurrentToken()) return null;
		Token token = lexer.lex(true);
		String label = consumeStringLiteralValue();
		if (label != null) 
			return new Label(token.getLine(), label);
		return null;
	}

}
