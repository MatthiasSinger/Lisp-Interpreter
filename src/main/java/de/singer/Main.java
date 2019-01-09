package de.singer;

import de.singer.evaluating.Evaluator;
import de.singer.lexing.Lexer;
import de.singer.lexing.Token;
import de.singer.parsing.Node;
import de.singer.parsing.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        Lexer lexer = new Lexer();
        Parser parser = new Parser();
        Evaluator evaluator = new Evaluator();
        SymbolTable.init();

        List<String> lines = Files.readAllLines(Paths.get(args[0]));
        List<String> expressions = reader.read(lines);

        for (String exp : expressions) {
            List<Token> tokens = lexer.lex(exp);
            System.out.println(tokens);
            Node root = parser.parse(tokens);
            System.out.println(root);
            evaluator.eval(root);
        }
    }
}
