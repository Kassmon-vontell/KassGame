package com.kassmon.asm.lexer;

import java.util.ArrayList;
import java.util.regex.Matcher;

import com.kassmon.asm.exceptions.LexerException;
import com.kassmon.asm.parser.statements.commands.CommandParser;

import static com.kassmon.asm.lexer.TokenType.*;

public class Lexer {

    private String input;
    private final ArrayList<TokenPattern> tokenPatterns = new ArrayList<>();
    private int lineNumber = 1;
    
    public Lexer(String input) {
        this.input = input;
    }
    
    public void initFixedTokens() {
    	addTokenPattern("\\/\\/.*", COMMENT);
        addTokenPattern("[ \\t]+", SPACE);
        addTokenPattern("(?:\\r\\n|\\n|\\r)", NEWLINE);
        
        addTokenPattern("-?[0-9]+\\b", INTEGER);
        addTokenPattern("0x[0-9a-f]+\\b", HEX);

        addTokenPattern("cxspc\\b", CHARACTER);
        addTokenPattern("cxlf\\b", CHARACTER);
        addTokenPattern("cx[a-zA-Z0-9]\\b", CHARACTER);

        addTokenPattern("r[0-9]+\\b", REGISTER);
        
        addTokenPattern(":[a-zA-Z_][a-zA-Z0-9_]*\\b", LABEL);
        addTokenPattern("[a-zA-Z_][a-zA-Z0-9_]*\\b", LABEL);
        
    }
    
    public void addCommandParserKeyWord(CommandParser parser) {
        addTokenPattern(parser.getKeyWord() +"\\b", STATEMENT);
    }
    
    public void addTokenPattern(String regex, TokenType type) {
        tokenPatterns.add(new TokenPattern(regex, type));
    }
    
    public Token lex(boolean peek) {
        StringBuilder unexpected = new StringBuilder();
        while (true) {
            Token token = getToken(peek);
            if (token != null) {
                if (unexpected.length() == 0) return token;
                throw new LexerException("Unexpected token '" + unexpected + "'");
            }
            if (!peek && !input.isEmpty()) input = input.substring(1);
            if (!input.isEmpty()) unexpected.append(input.charAt(0));
            else throw new LexerException("Unexpected end of input");
        }
    }
    
    private Token getToken(boolean peek) {
        if (input.isEmpty()) return new Token(EOF, "", lineNumber);
        for (TokenPattern tokenPattern : tokenPatterns) {
            Matcher matcher = tokenPattern.getPattern().matcher(input);
            if (!matcher.lookingAt()) continue;
            String lexeme = matcher.group();
            Token token = new Token(tokenPattern.getType(), lexeme, lineNumber);
            if (!peek) {
                input = input.substring(lexeme.length());
                if (token.getType() == NEWLINE) lineNumber++;
            }
            return token;
        }
        return null;
    }
    
    public ArrayList<LexerException> verifyInput() {
        String backupInput = input;
        int backupLine = lineNumber;
        ArrayList<LexerException> exceptions = new ArrayList<>();
        while (true) {
            try {
                Token token = lex(false);
                if (token.getType() == EOF) break;
            } catch (LexerException e) {
                exceptions.add(e);
            }
        }
        input = backupInput;
        lineNumber = backupLine;
        return exceptions;
    }
}
