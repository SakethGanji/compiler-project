import java.util.ArrayList;
import java.util.List;

public class ArgsList extends Token {
    private Expr expr;
    private ArgsList next;

    public ArgsList(Expr expr, ArgsList next) {
        this.expr = expr;
        this.next = next;
    }

    public String typeCheck() throws SemanticException {
        List<String> argTypes = new ArrayList<>();
        ArgsList current = this;
        while (current != null) {
            String type = current.expr.typeCheck();
            argTypes.add(type);
            current = current.next;
        }
        return argTypes.toString();
    }

    public String toString(int t) {
        String nextStr = (next != null) ? ", " + next.toString(0) : "";
        return expr.toString(0) + nextStr;
    }
}