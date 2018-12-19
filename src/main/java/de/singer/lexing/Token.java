package de.singer.lexing;

enum TokenType {
    Open,
    Closed,
    Id,
    Op,
    Number,
    String,
    Bool
}

public class Token {
    private TokenType type;
    private String lexeme;
}
