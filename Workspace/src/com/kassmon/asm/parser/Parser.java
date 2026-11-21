package com.kassmon.asm.parser;

import java.util.ArrayList;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.parser.statements.StatementParser;
import com.kassmon.asm.parser.statements.commands.basic.conditionals.*;
import com.kassmon.asm.parser.statements.commands.basic.control.*;
import com.kassmon.asm.parser.statements.commands.basic.math.*;
import com.kassmon.asm.parser.statements.info.*;
import com.kassmon.asm.statement.Statment;

public class Parser {
	
	Lexer lexer;
	private ArrayList<StatementParser> statmentParsers;
	
	public Parser(Lexer lexer) {
		this.lexer = lexer;
		this.statmentParsers = new ArrayList<>();
		
		initParser();
	}
	
	private void initParser() {
		statmentParsers.add(new LabelParser(lexer));
		
		statmentParsers.add(new CompareParser(lexer));
		statmentParsers.add(new JumpEqualParser(lexer));
		statmentParsers.add(new JumpNotEqualParser(lexer));
		statmentParsers.add(new JumpGreaterThanParser(lexer));
		statmentParsers.add(new JumpLessThanParser(lexer));
		
		statmentParsers.add(new JumpParser(lexer));
		statmentParsers.add(new LoadParser(lexer));
		statmentParsers.add(new StoreParser(lexer));
		statmentParsers.add(new MoveParser(lexer));
		
		statmentParsers.add(new AddParser(lexer));
		statmentParsers.add(new SubParser(lexer));
		statmentParsers.add(new MulParser(lexer));
		statmentParsers.add(new DivParser(lexer));
		statmentParsers.add(new ModParser(lexer));
		statmentParsers.add(new AndParser(lexer));
		statmentParsers.add(new OrParser(lexer));
		statmentParsers.add(new XorParser(lexer));
		
	}
	
	public Statment parse() {
		for (StatementParser parser : statmentParsers) {
			Statment statment = parser.parse();
			if (statment != null) return statment;
			return statment;
		}
		return null;
	}
	
}
