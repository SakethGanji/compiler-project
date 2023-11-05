public class Optionalexpr extends Token {
    private Expr expr;

    public Optionalexpr(Expr expr) {
        this.expr = expr;
    }

    public String toString(int t) {
        return (expr != null) ? " = " + expr.toString(t) : "";
    }
}
