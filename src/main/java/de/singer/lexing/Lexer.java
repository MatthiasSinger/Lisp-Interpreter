package de.singer.lexing;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    public List<Token> lex(String source) {
        List<Token> tokens = new ArrayList<>();
        for (String symbol : splitIntoSymbols(source)) {
            Token token = getToken(symbol);
            if (token.getType() == TokenType.Failure) {
                throw new RuntimeException("Ungültiges Symbol: " + token.getLexeme());
            }
            tokens.add(token);
        }
        return tokens;
    }

    private List<String> splitIntoSymbols(String source) {
        List<String> symbols = new ArrayList<>();
        boolean inWord = false;
        StringBuilder currentWord = new StringBuilder();
        for (char c : source.toCharArray()) {
            if (inWord) {
                if (c == '(' || c == ')') {
                    symbols.add(currentWord.toString());
                    currentWord = new StringBuilder();
                    symbols.add(c + "");
                    inWord = false;
                } else if (c == ' ') {
                    symbols.add(currentWord.toString());
                    currentWord = new StringBuilder();
                    inWord = false;
                } else {
                    currentWord.append(c);
                }
            } else {
                if (c == '(' || c == ')') {
                    symbols.add(c + "");
                } else if (c != ' ') {
                    currentWord.append(c);
                    inWord = true;
                }
            }
        }
        return symbols;
    }

    private Token getToken(String symbol) {
        if (symbol.equals("true") || symbol.equals("false")) {
            return new Token(TokenType.Boolean, symbol);
        } else if (symbol.equals("(")) {
            return new Token(TokenType.Open, symbol);
        } else if (symbol.equals(")")) {
            return new Token(TokenType.Closed, symbol);
        } else if (symbol.matches("-?\\d+\\.?\\d*")) {
            return new Token(TokenType.Number, symbol);
        } else if (symbol.matches("\".*\"")) {
            return new Token(TokenType.Str, symbol);
        } else if (symbol.matches("[a-zA-Z_][a-zA-Z_\\d]*")) {
            return new Token(TokenType.Id, symbol);
        } else if (symbol.matches("[+\\-/*]")) {
            return new Token(TokenType.Op, symbol);
        } else {
            return new Token(TokenType.Failure, symbol);
        }
    }
}
