public class ParenthesizedExpr extends Expr {
    private Expr expr;

    public ParenthesizedExpr(Expr expr) {
        this.expr = expr;
    }

    public String toString(int t) {
        return getTabs(t) + "(" + expr.toString(0) + ")";
    }
}
