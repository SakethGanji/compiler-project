public class ReturnStmt extends Stmt {
    private Expr expr;

    public ReturnStmt(Expr expr) {
        this.expr = expr;
    }

    public String toString(int t) {
        String exprStr = (expr != null) ? expr.toString(0) : "";
        return getTabs(t) + "return " + exprStr + ";\n";
    }
}
