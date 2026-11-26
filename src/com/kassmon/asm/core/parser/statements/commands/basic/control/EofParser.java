package com.kassmon.asm.core.parser.statements.commands.basic.control;

import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.lexer.TokenType;
import com.kassmon.asm.core.parser.statements.StatementParser;
import com.kassmon.asm.core.statement.Statement;
import com.kassmon.asm.core.statement.commands.basic.control.Eof;

public class EofParser extends StatementParser{
	
	public EofParser(Lexer lexer){
		super(lexer);
	}
	
	@Override
	public Statement parse(){
		Token token = getNextToken(false);
		if (token.getType() != TokenType.EOF)
			return null;
		return new Eof(token.getLine());
	}
}
