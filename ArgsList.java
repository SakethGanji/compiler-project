public class ArgsList extends Token {
    private Expr expr;
    private ArgsList next;

    public ArgsList(Expr expr, ArgsList next) {
        this.expr = expr;
        this.next = next;
    }

    public String toString(int t) {
        String nextStr = (next != null) ? ", " + next.toString(0) : "";
        return expr.toString(0) + nextStr;
    }
}