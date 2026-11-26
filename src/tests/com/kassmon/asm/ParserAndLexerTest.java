package tests.com.kassmon.asm;

import com.kassmon.asm.core.lexer.Lexer;
import com.kassmon.asm.core.lexer.Token;
import com.kassmon.asm.core.lexer.TokenType;

import com.kassmon.asm.core.parser.Parser;
import com.kassmon.asm.core.statement.commands.basic.conditionals.*;
import com.kassmon.asm.core.statement.commands.basic.control.*;
import com.kassmon.asm.core.statement.commands.basic.math.*;
import com.kassmon.asm.core.statement.info.Label;

import java.util.ArrayList;

public class ParserAndLexerTest{
	
	private static String testString = "";
	
	private static ArrayList<TokenType> expectedTokenTypes = new ArrayList<>();
	private static ArrayList<String> expectedTokenLexemes = new ArrayList<>();
	
	private static Boolean lexerTokenCheck(Token token, TokenType expectedType, String expectedValue) {
		if (token.getType() != expectedType) return false;
		return token.getLexeme().equals(expectedValue);
	}
	
	private static void addTestStringLine(String line) {
		testString += line + "\n";
	}
	
	private static void addTestTokenData(TokenType type, String lexeme) {
		expectedTokenTypes.add(type);
		expectedTokenLexemes.add(lexeme);
	}
	
	private static void initTextingString() {
		//test info for labels
		addTestStringLine(":testLabel");
		
		//test info for conditional commands
		addTestStringLine("cmp r1 r2");
		addTestStringLine("je testLabel");
		addTestStringLine("jgt testLabel");
		addTestStringLine("jlt testLabel");
		addTestStringLine("jne testLabel");
		
		//test info for control commands
		addTestStringLine("jmp testLabel");
		addTestStringLine("load r0 0x00");
		addTestStringLine("mov r0 0x00");
		addTestStringLine("store r0 0x00");
		
		//test info for math commands
		addTestStringLine("add r0 r1");
		addTestStringLine("and r0 r1");
		addTestStringLine("div r0 r1");
		addTestStringLine("mod r0 r1");
		addTestStringLine("mul r0 r1");
		addTestStringLine("not r0");
		addTestStringLine("or r0 r1");
		addTestStringLine("sub r0 r1");
		addTestStringLine("xor r0 r1");
		
	}
	
	private static void initTestingTokenData() {
		//test info for labels
		addTestTokenData(TokenType.LABEL,":testLabel");
		
		//test info for conditional commands
		addTestTokenData(TokenType.STATEMENT, "cmp");
		addTestTokenData(TokenType.REGISTER, "r1");
		addTestTokenData(TokenType.REGISTER, "r2");
		
		addTestTokenData(TokenType.STATEMENT, "je");
		addTestTokenData(TokenType.LABEL, "testLabel");
		
		addTestTokenData(TokenType.STATEMENT, "jgt");
		addTestTokenData(TokenType.LABEL, "testLabel");
		
		addTestTokenData(TokenType.STATEMENT, "jlt");
		addTestTokenData(TokenType.LABEL, "testLabel");
		
		addTestTokenData(TokenType.STATEMENT, "jne");
		addTestTokenData(TokenType.LABEL, "testLabel");
		
		//test info for control commands
		addTestTokenData(TokenType.STATEMENT, "jmp");
		addTestTokenData(TokenType.LABEL, "testLabel");
		
		addTestTokenData(TokenType.STATEMENT, "load");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.HEX, "0x00");
		
		addTestTokenData(TokenType.STATEMENT, "mov");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.HEX, "0x00");
		
		addTestTokenData(TokenType.STATEMENT, "store");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.HEX, "0x00");
		
		//test info for math commands
		addTestTokenData(TokenType.STATEMENT, "add");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.REGISTER, "r1");
		
		addTestTokenData(TokenType.STATEMENT, "and");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.REGISTER, "r1");
		
		addTestTokenData(TokenType.STATEMENT, "div");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.REGISTER, "r1");
		
		addTestTokenData(TokenType.STATEMENT, "mod");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.REGISTER, "r1");
		
		addTestTokenData(TokenType.STATEMENT, "mul");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.REGISTER, "r1");
		
		addTestTokenData(TokenType.STATEMENT, "not");
		addTestTokenData(TokenType.REGISTER, "r0");
		
		addTestTokenData(TokenType.STATEMENT, "or");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.REGISTER, "r1");
		
		addTestTokenData(TokenType.STATEMENT, "sub");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.REGISTER, "r1");
		
		addTestTokenData(TokenType.STATEMENT, "xor");
		addTestTokenData(TokenType.REGISTER, "r0");
		addTestTokenData(TokenType.REGISTER, "r1");
		
		addTestTokenData(TokenType.EOF, "");
	}
	
	private static void cleanTestingVars() {
		testString = "";
		expectedTokenTypes = new ArrayList<>();
		expectedTokenLexemes = new ArrayList<>();
	}
	
	public static boolean LexerTest() {
		initTextingString();
		initTestingTokenData();
		
		Lexer lexer = new Lexer(testString);
		@SuppressWarnings("unused")
		Parser parser = new Parser(lexer);
		
		System.out.println("Lexer test");
		
		ArrayList<Token> tokenList = new ArrayList<>();
		while (true) {
			Token token = lexer.lex(false);
			tokenList.add(token);
			if (token.getType() == TokenType.EOF) break;
		}
		
		for (int i = 0; i < tokenList.size(); i++) {
			Token token = tokenList.get(i);
			if (!lexerTokenCheck(token, expectedTokenTypes.get(i), expectedTokenLexemes.get(i))) {
				System.out.println("Expected: " + expectedTokenTypes.get(i) + " " + expectedTokenLexemes.get(i));
				System.out.println("Got: " + token.getType() + " " + token.getLexeme());
				return false;
			}
		}
		cleanTestingVars();
		return true;
	}
	
	public static boolean ParserTest() {
		initTextingString();
		Lexer lexer = new Lexer(testString);
		Parser parser = new Parser(lexer);
		System.out.println("Parser test");
		boolean passed = true;
		if (!(parser.parse() instanceof Label)){
			System.out.println("label test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Compare)){
			System.out.println("compare test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof JumpEqual)){
			System.out.println("jump equal test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof JumpGreaterThan)){
			System.out.println("jump greater than test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof JumpLessThan)){
			System.out.println("jump less than test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof JumpNotEqual)){
			System.out.println("jump not equal test failed");
			passed = false;
		}
		
		if (!(parser.parse() instanceof Jump)){
			System.out.println("jump test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Load)){
			System.out.println("load test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Move)){
			System.out.println("move test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Store)){
			System.out.println("store test failed");
			passed = false;
		}
		
		if (!(parser.parse() instanceof Add)){
			System.out.println("add test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof And)){
			System.out.println("and test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Div)){
			System.out.println("divide test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Mod)){
			System.out.println("mod test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Mul)){
			System.out.println("multiply test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Not)){
			System.out.println("not test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Or)){
			System.out.println("or test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Sub)){
			System.out.println("subtract test failed");
			passed = false;
		}
		if (!(parser.parse() instanceof Xor)){
			System.out.println("xor test failed");
			passed = false;
		}
		
		if  (!(parser.parse() instanceof Eof)){
			System.out.println("eof test failed");
			passed = false;
		}
		
		
		cleanTestingVars();
		return passed;
	}
	
}