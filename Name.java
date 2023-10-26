public class Name extends Expr {
    private String identifier;
    private Expr expr;

    public Name(String identifier, Expr expr) {
        this.identifier = identifier;
        this.expr = expr;
    }

    public String toString(int t) {
        String prefix = "Identifier:";
        if (expr != null) {
            return prefix + identifier + "[" + expr.toString(0) + "]";
        } else {
            return prefix + identifier;
        }
    }

}
