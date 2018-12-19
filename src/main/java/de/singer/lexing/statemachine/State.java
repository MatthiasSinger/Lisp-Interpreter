package de.singer.lexing.statemachine;

public interface State {
    State next(char input);
}
