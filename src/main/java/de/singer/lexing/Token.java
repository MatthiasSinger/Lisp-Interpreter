package de.singer.lexing;

enum TokenType {
    Open,
    Closed,
    Id,
    Op,
    Str,
    Number,
    Boolean,
    Failure
}

public class Token {
    private TokenType type;
    private String lexeme;

    Token(TokenType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    TokenType getType() {
        return type;
    }

    String getLexeme() {
        return lexeme;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", lexeme='" + lexeme + '\'' +
                '}';
    }
}
