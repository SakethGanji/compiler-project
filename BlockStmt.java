public class BlockStmt extends Stmt {
    private Fielddecls fielddecls;
    private Stmts stmts;
    private boolean optionalsemi;

    public BlockStmt(Fielddecls fielddecls, Stmts stmts, boolean optionalsemi) {
        this.fielddecls = fielddecls;
        this.stmts = stmts;
        this.optionalsemi = optionalsemi;
    }

    public String toString(int t) {
        String semi = optionalsemi ? ";" : "";
        return  "{\n" + fielddecls.toString(t + 1) + stmts.toString(t + 1) +  "}" + semi + "\n";
    }
}
