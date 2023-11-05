class WhileStmt extends Stmt {
    private Expr condition;
    private Stmts block;

    public WhileStmt(Expr condition, Stmts block) {
        this.condition = condition;
        this.block = block;
    }

    public String toString(int t) {
        return "while (" + condition.toString(0) + ") {\n" +
                block.toString(t+1) +
                 "}\n";
    }
}
