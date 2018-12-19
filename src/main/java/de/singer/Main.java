package de.singer;

import de.singer.lexing.Lexer;
import de.singer.lexing.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(args.length);
        String programm = "(+ 24 (* 2.5 52))";
        Lexer lexer = new Lexer();
        List<Token> tokens = lexer.lex(programm);
        System.out.println(tokens);
    }
}
