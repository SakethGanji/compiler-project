class AssignmentStmt extends Stmt {
    private String assignee;
    private Expr rhs;

    public AssignmentStmt(String assignee, Expr rhs) {
        this.assignee = assignee;
        this.rhs = rhs;
    }

    public String toString(int t) {
        return getTabs(t) + assignee + " = " + rhs.toString(0) + ";\n";
    }
}
