public class ParenthesizedExpr extends Expr {
    private Expr expr;

    public ParenthesizedExpr(Expr expr) {
        this.expr = expr;
    }
    String typeCheck() throws SemanticException {
        String exprType = expr.typeCheck();

        return exprType;
    }

    public String toString(int t) {
        return "(" + expr.toString(0) + ")";
    }
}
