public class Name extends Expr {
    private String identifier;
    private Expr expr;

    public Name(String identifier, Expr expr) {
        this.identifier = identifier;
        this.expr = expr;
    }

    public String toString(int t) {
        if (expr != null) {
            return identifier + "[" + expr.toString(0) + "]";
        } else {
            return identifier;
        }
    }

}
