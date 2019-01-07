package de.singer;

import de.singer.lexing.Lexer;
import de.singer.lexing.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(args[args.length - 1]));
        Reader reader = new Reader();
        List<String> expressions = reader.read(lines);
        Lexer lexer = new Lexer();

        for (String exp : expressions) {
            List<Token> lex = lexer.lex(exp);

        }
    }
}
