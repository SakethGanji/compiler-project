public class TypeCastExpr extends Expr {
    private String type;
    private Expr expr;

    public TypeCastExpr(String type, Expr expr) {
        this.type = type;
        this.expr = expr;
    }

    public String toString(int t) {
        return "(" + type + ")" + expr.toString(0);
    }
}
