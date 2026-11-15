package com.kassmon.asm.parser;

import java.util.ArrayList;

import com.kassmon.asm.lexer.Lexer;
import com.kassmon.asm.parser.statments.StatmentParser;

public class Parser {
	
	Lexer lexer;
	private ArrayList<StatmentParser> statmentParsers;
	
	public Parser(Lexer lexer) {
		this.lexer = lexer;
		this.statmentParsers = new ArrayList<>();
	}
	
	
	
}
