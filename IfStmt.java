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
        return  "if (" + condition.toString(0) + ") {\n" +
                thenBlock.toString(t + 1) +
                 "}\n" +
                ifEnd.toString(t);  // Updated to use IfEnd's toString
    }
}
