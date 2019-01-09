package de.singer.evaluating;

import de.singer.parsing.Node;

import java.util.List;

public class Functions {
    public static Node first(List<Node> arguments) {
        if (arguments.size() != 1 || !(arguments.get(0).getValue() instanceof List))
            throw new RuntimeException("Funktion first erwartet einen Paramter vom Typ Liste");
        return ((List<Node>) arguments.get(0).getValue()).get(0);
    }

    public static Node add(List<Node> list) {
        if (list.isEmpty())
            throw new RuntimeException("Keine Argumente angegeben");
        if (list.stream().anyMatch(element -> !(element.getValue() instanceof Double)))
            throw new RuntimeException("Addition nur für Zahlen erlaubt");
        double result = 0.0;
        for (Node node : list) {
            result += (double) node.getValue();
        }
        return new Node<>(result, true);
    }

    public static Node multiply(List<Node> list) {
        if (list.isEmpty())
            throw new RuntimeException("Keine Argumente angegeben");
        if (list.stream().anyMatch(element -> !(element.getValue() instanceof Double)))
            throw new RuntimeException("Multiplikation nur für Zahlen erlaubt");
        double result = 0.0;
        for (Node node : list) {
            result *= (double) node.getValue();
        }
        return new Node<>(result, true);
    }

    public static Node minus(List<Node> list) {
        if (list.isEmpty())
            throw new RuntimeException("Keine Argumente angegeben");
        if (list.stream().anyMatch(element -> !(element.getValue() instanceof Double)))
            throw new RuntimeException("Subtraktion nur für Zahlen erlaubt");
        double result = (double) list.get(0).getValue();
        for (int i = 1; i < list.size(); i++) {
            result -= (double) list.get(i).getValue();
        }
        return new Node<>(result, true);
    }

    public static Node divide(List<Node> list) {
        if (list.isEmpty())
            throw new RuntimeException("Keine Argumente angegeben");
        if (list.stream().anyMatch(element -> !(element.getValue() instanceof Double)))
            throw new RuntimeException("Division nur für Zahlen erlaubt");
        double result = (double) list.get(0).getValue();
        for (int i = 1; i < list.size(); i++) {
            result /= (double) list.get(i).getValue();
        }
        return new Node<>(result, true);
    }
}
