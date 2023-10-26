public class BlockStmt extends Stmt {
    private Stmts stmts;
    private boolean optionalsemi;

    public BlockStmt(Stmts stmts, boolean optionalsemi) {
        this.stmts = stmts;
        this.optionalsemi = optionalsemi;
    }

    public String toString(int t) {
        String semi = optionalsemi ? ";" : "";
        return getTabs(t) + "{\n" + stmts.toString(t + 1) + getTabs(t) + "}" + semi + "\n";
    }
}
