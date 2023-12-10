abstract class Expr extends Token {
    abstract String typeCheck() throws SemanticException;

}
