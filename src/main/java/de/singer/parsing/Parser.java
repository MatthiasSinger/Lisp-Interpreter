package de.singer.parsing;

import de.singer.lexing.Token;
import de.singer.lexing.TokenType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static de.singer.lexing.TokenType.*;

public class Parser {

    public Node parse(List<Token> tokens) {
        Stack<Node> currentHead = new Stack<>();
        List<Character> grammar = new ArrayList<>();
        grammar.add('S');
        String input = createInput(tokens);
        Node result = null;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char g;

            while (c != (g = grammar.remove(0))) {
                if (Character.isLowerCase(g)) {
                    throw new RuntimeException("Syntaxfehler bei " + tokens.get(i));
                } else {
                    grammar.addAll(0, translate(c, g));
                }
            }

            if (c == '(') {
                if (currentHead.isEmpty()) {
                    currentHead.add(new Node());
                } else {
                    Node n = new Node();
                    currentHead.peek().addNode(n);
                    currentHead.push(n);
                }
            } else if (c == 'a') {
                Node node;
                Token currentToken = tokens.get(i);
                if (currentToken.getType() == TokenType.Number) {
                    node = new Node<Double>(Double.parseDouble(currentToken.getLexeme()), true);
                } else if (currentToken.getType() == Str) {
                    node = new Node<String>(currentToken.getLexeme(), true);
                } else if (currentToken.getType() == TokenType.Boolean) {
                    if (currentToken.getLexeme().equals("true"))
                        node = new Node<Boolean>(true, true);
                    else
                        node = new Node<Boolean>(false, true);
                } else {
                    node = new Node<String>(currentToken.getLexeme(), false);
                }
                currentHead.peek().addNode(node);
            } else {
                result = currentHead.pop();
            }
        }
        if (!grammar.isEmpty()) throw new RuntimeException("Ungueltige Syntax, nicht vollstaending uebersetzt!");
        return result;
    }

    private List<Character> translate(char c, char g) {
        if (g == 'S') {
            if (c == '(') {
                return List.of('(', 'A', ')');
            }
        } else if (g == 'A') {
            if (c == '(') {
                return List.of('(', 'A', ')');
            } else if (c == 'a') {
                return List.of('a', 'B');
            }
        } else if (g == 'B') {
            if (c == '(' || c == 'a') {
                return List.of('A');
            } else if (c == ')') {
                return Collections.emptyList();
            }
        }
        throw new RuntimeException("Ungueltige Syntax!");
    }


    private String createInput(List<Token> tokens) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Token t : tokens) {
            if (t.getType() == Open) stringBuilder.append('(');
            else if (t.getType() == Closed) stringBuilder.append(')');
            else stringBuilder.append('a');
        }
        return stringBuilder.toString();
    }
}
