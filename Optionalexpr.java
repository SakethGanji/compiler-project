public class Optionalexpr extends Expr {
    private Expr expr;

    public Optionalexpr(Expr expr) {
        this.expr = expr;
    }

    String typeCheck() throws SemanticException {
        if (expr != null) {
            String exprType = expr.typeCheck();
            return mapType(exprType);
        }
        return "null";
    }

    public String toString(int t) {
        return (expr != null) ? " = " + expr.toString(t) : "";
    }
}
