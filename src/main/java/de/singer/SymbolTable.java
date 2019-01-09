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
        symbolTable.put("+", new Node<Function>(Functions::add, true));
        symbolTable.put("-", new Node<Function>(Functions::minus, true));
        symbolTable.put("*", new Node<Function>(Functions::multiply, true));
        symbolTable.put("/", new Node<Function>(Functions::divide, true));
    }
}
