public class BinaryExpr extends Expr {
    private Expr left;
    private Expr right;
    private String operator;

    public BinaryExpr(Expr left, String operator, Expr right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public String toString(int t) {
        return "(" + left.toString(0) + " " + operator + " " + right.toString(0) + ")";
    }

    public String getTabs(int t) {
        return String.join("", java.util.Collections.nCopies(t, "\t"));
    }
}

