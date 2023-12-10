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
    String typeCheck() throws SemanticException {
        for (Stmt statement : statements) {
            statement.typeCheck();
        }

        return null;
    }

    public boolean hasReturnStatement() {
        for (Stmt statement : statements) {
            if (statement instanceof ReturnStmt) {
                return true;
            }
        }
        return false;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (Stmt s : statements) {
            sb.append(getTabs(t));
            sb.append(s.toString(t));
        }
        return sb.toString();
    }
}
