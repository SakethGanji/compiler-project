public class NumExpr extends Expr {
    private String value;

    // Constructor for each production
    public NumExpr(String i) {
        value = i;
    }

    public NumExpr(int n) {
        value = Integer.toString(n);
    }

    public String toString(int t) {
        return getTabs(t) + value;
    }

    // Utility function to generate tabs for indentation
    public String getTabs(int t) {
        return String.join("", java.util.Collections.nCopies(t, "\t"));
    }
}
