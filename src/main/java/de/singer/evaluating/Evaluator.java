package de.singer.evaluating;

import de.singer.SymbolTable;
import de.singer.parsing.Node;

import java.util.List;

public class Evaluator {
    public Node eval(Node node) {
        if (node.isLiteral())
            return node;
        else if (node.getValue() != null) {
            return SymbolTable.getSymbol((String) node.getValue());
        } else {
            List<Node> children = node.getChildren();
            for (int i = 0; i < node.getChildren().size(); i++) {
                children.set(i, eval(children.get(i)));
            }
            Function function = (Function) children.get(0).getValue();
            return function.apply(children.subList(1, children.size()));
        }
    }
}
