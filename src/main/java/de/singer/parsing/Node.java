package de.singer.parsing;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private T value;
    private List<Node> children;
    private boolean isLiteral;

    public Node() {
        this.value = null;
        this.children = new ArrayList<>();
        this.isLiteral = false;
    }

    public Node(T t, boolean isLiteral) {
        this.value = t;
        this.children = new ArrayList<>();
        this.isLiteral = isLiteral;
    }

    public T getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean isLiteral() {
        return isLiteral;
    }

    public void addNode(Node node) {
        children.add(node);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value= " + value +
                ", children=" + children +
                ", isLiteral=" + isLiteral +
                '}';
    }
}
