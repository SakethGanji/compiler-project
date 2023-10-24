public class UnaryExpr extends Expr {
    private String operator;
    private Expr operand;

    public UnaryExpr(String operator, Expr operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public String toString(int t) {
        return "(" + operator + operand.toString(0) + ")";
    }
}
