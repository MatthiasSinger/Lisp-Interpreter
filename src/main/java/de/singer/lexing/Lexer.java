package de.singer.lexing;

import de.singer.lexing.statemachine.Start;
import de.singer.lexing.statemachine.State;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    public List<Token> lex(String source) {
        List<Token> tokens = new ArrayList<>();
        State start = new Start();
        for (char c : source.toCharArray()) {
            System.out.println("d");
        }
        return tokens;
    }
}
