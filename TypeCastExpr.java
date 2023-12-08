public class TypeCastExpr extends Expr {
    private Type type;
    private Expr expr;

    public TypeCastExpr(Type type, Expr expr) {
        this.type = type;
        this.expr = expr;
    }

    public String toString(int t) {
        return "(" + type + ")" + expr.toString(0);
    }
}
