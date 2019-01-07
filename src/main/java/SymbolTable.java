import de.singer.lexing.Token;
import de.singer.lexing.TokenType;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    public static Map<String, Token> symbolTable = new HashMap<>();

    public static void init() {
        symbolTable.put("PI", new Token(TokenType.Number, "10"));
    }
}
