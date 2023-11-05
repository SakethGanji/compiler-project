public class AssignmentStmt extends Stmt {
    private Name assignee;
    private Expr rhs;

    public AssignmentStmt(Name assignee, Expr rhs) {
        this.assignee = assignee;
        this.rhs = rhs;
    }

    public String toString(int t) {
        return  assignee.toString(0) + " = " + rhs.toString(0) + ";\n";
    }
}
