package de.singer.evaluating;

import de.singer.parsing.Node;

import java.util.List;

public interface Function {
    Node apply(List<Node> arguments);
}
