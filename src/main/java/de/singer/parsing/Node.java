package de.singer.parsing;

import de.singer.lexing.Token;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Token token;
    private List<Node> children;

    public Node() {
        this.children = new ArrayList<>();
    }

    public Node(Token token) {
        this.token = token;
        this.children = new ArrayList<>();
    }

    public void addNode(Node node) {
        children.add(node);
    }
}
