class IfStmt extends Stmt {
    private Expr condition;
    private Stmts thenBlock;
    private Stmts elseBlock;

    public IfStmt(Expr condition, Stmts thenBlock, Stmts elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    public String toString(int t) {
        return getTabs(t) + "if (" + condition.toString(0) + ") {\n" +
                thenBlock.toString(t+1) +
                getTabs(t) + "} else {\n" +
                elseBlock.toString(t+1) +
                getTabs(t) + "}\n";
    }
}
