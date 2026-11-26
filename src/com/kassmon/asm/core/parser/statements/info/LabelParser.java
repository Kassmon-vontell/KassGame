package com.kassmon.asm.core.parser.statements.info;

import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.lexer.TokenType;
import com.kassmon.asm.core.parser.statements.StatementParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.info.Label;

public class LabelParser extends StatementParser {

	public LabelParser(Lexer lexer) {
		super(lexer);
	}

	@Override
	public Statement parse() {
		Token token = getNextToken(true);
		if (token.getType() != TokenType.LABEL) return null;
		getNextToken(false);
		return new Label(token.getLine(), token.getLexeme().substring(1));
	}

}
