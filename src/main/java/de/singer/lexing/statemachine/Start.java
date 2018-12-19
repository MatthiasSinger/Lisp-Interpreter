package de.singer.lexing.statemachine;

public class Start implements State {
    @Override
    public State next(char input) {
        return null;
    }
}
