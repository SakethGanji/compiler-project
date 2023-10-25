public class PrintList extends Token {
    private Expr expr;
    private PrintList next;


    public PrintList(Expr expr, PrintList next) {
        this.expr = expr;
        this.next = next;
    }

    public String toString(int t) {
        String s = expr.toString(0);
        if (next != null) {
            s += ", " + next.toString(0);
        }
        return s;
    }
}
