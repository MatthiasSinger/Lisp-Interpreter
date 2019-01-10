package de.singer;

import de.singer.evaluating.Function;
import de.singer.evaluating.Functions;
import de.singer.parsing.Node;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    public static Map<String, Node> symbolTable = new HashMap<>();

    public static void init() {
        symbolTable.put("first", new Node<Function>(Functions::first, true));
        symbolTable.put("list", new Node<Function>(Functions::list, true));
        symbolTable.put("+", new Node<Function>(Functions::add, true));
        symbolTable.put("-", new Node<Function>(Functions::minus, true));
        symbolTable.put("*", new Node<Function>(Functions::multiply, true));
        symbolTable.put("/", new Node<Function>(Functions::divide, true));
    }

    public static Node getSymbol(String name) {
        Node node = symbolTable.get(name);
        if (node == null)
            throw new RuntimeException("Unbekanntes Symbol " + name);
        return node;
    }
}
