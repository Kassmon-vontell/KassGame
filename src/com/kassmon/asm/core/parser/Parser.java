package com.kassmon.asm.core.parser;

import java.util.ArrayList;

import com.kassmon.asm.core.parser.statements.commands.basic.conditionals.*;
import com.kassmon.asm.core.parser.statements.commands.basic.control.*;
import com.kassmon.asm.core.parser.statements.commands.basic.math.*;
import com.kassmon.asm.core.parser.statements.info.LabelParser;
import com.kassmon.asm.exceptions.ParserException;
import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.parser.statements.StatementParser;
import com.kassmon.asm.core.parser.statements.commands.basic.conditionals.*;
import com.kassmon.asm.core.parser.statements.commands.basic.control.*;
import com.kassmon.asm.core.parser.statements.commands.basic.math.*;
import com.kassmon.asm.core.parser.statements.info.*;
import com.kassmon.asm.core.statement.Statement;

public class Parser {
	
	Lexer lexer;
	private final ArrayList<StatementParser> statementParsers;
	
	public Parser(Lexer lexer) {
		this.lexer = lexer;
		this.statementParsers = new ArrayList<>();
		
		initParser();
	}
	
	private void initParser() {
		statementParsers.add(new LabelParser(lexer));
		
		statementParsers.add(new CompareParser(lexer));
		statementParsers.add(new JumpEqualParser(lexer));
		statementParsers.add(new JumpNotEqualParser(lexer));
		statementParsers.add(new JumpGreaterThanParser(lexer));
		statementParsers.add(new JumpLessThanParser(lexer));
		
		statementParsers.add(new JumpParser(lexer));
		statementParsers.add(new LoadParser(lexer));
		statementParsers.add(new StoreParser(lexer));
		statementParsers.add(new MoveParser(lexer));
		
		statementParsers.add(new AddParser(lexer));
		statementParsers.add(new SubParser(lexer));
		statementParsers.add(new MulParser(lexer));
		statementParsers.add(new DivParser(lexer));
		statementParsers.add(new ModParser(lexer));
		statementParsers.add(new NotParser(lexer));
		statementParsers.add(new AndParser(lexer));
		statementParsers.add(new OrParser(lexer));
		statementParsers.add(new XorParser(lexer));
		
		statementParsers.add(new EofParser(lexer));
		
		lexer.initFixedTokens();
	}
	
	public Statement parse() {
		for (StatementParser parser : statementParsers) {
			Statement statement = parser.parse();
			if (statement != null) return statement;
		}
		throw new ParserException("Unexpected null statement");
	}
	
}
