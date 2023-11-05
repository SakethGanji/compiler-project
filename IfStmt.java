public class IfStmt extends Stmt {
    private Expr condition;
    private Stmts thenBlock;
    private IfEnd ifEnd;

    public IfStmt(Expr condition, Stmts thenBlock, IfEnd ifEnd) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.ifEnd = ifEnd;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(condition.toString(0)).append(") {\n");
        sb.append(thenBlock.toString(t + 1));
        sb.append(getTabs(t)).append("}");
        if (ifEnd != null) {
            sb.append("\n").append(ifEnd.toString(t));
        } else {
            sb.append("\n");
        }
        return sb.toString();
    }

}
