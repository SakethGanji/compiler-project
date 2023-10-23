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
        return getTabs(t) + "(" + left.toString(t) + " " + operator + " " + right.toString(t) + ")";
    }

    // Utility function to generate tabs for indentation
    public String getTabs(int t) {
        return String.join("", java.util.Collections.nCopies(t, "\t"));
    }
}
