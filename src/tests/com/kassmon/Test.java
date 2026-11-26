package tests.com.kassmon;

import tests.com.kassmon.asm.ParserAndLexerTest;

public class Test{
	
	static void main(String[] args) {
		System.out.println("Lexer test Passed: " + ParserAndLexerTest.LexerTest());
		System.out.println("Parser test Passed: " + ParserAndLexerTest.ParserTest());
		System.out.println("Runtime test Passed: " + tests.com.kassmon.asm.ScriptTests.runtimeTest());
		System.out.println("all tests done");
	}
	
}
