public class IfEnd extends Stmt {
    private Stmts elseBlock;

    public IfEnd(Stmts elseBlock) {
        this.elseBlock = elseBlock;
    }

    public IfEnd() {
        this.elseBlock = null;
    }

    public String toString(int t) {
        if (elseBlock != null) {
            return  "else {\n" +
                    elseBlock.toString(t + 1) +
                     "}\n";
        } else {
            return "";
        }
    }
}
