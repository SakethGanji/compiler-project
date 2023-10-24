import java.util.LinkedList;
import java.util.List;

class Stmts extends Token {
    private List<Stmt> statements;

    public Stmts() {
        statements = new LinkedList<>();
    }

    public Stmts(Stmt s, Stmts ss) {
        this();
        statements.add(s);
        statements.addAll(ss.statements);
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (Stmt s : statements) {
            sb.append(s.toString(t));
        }
        return sb.toString();
    }
}
