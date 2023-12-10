public class IfEnd extends Stmt {
    private Stmts elseBlock;

    public IfEnd(Stmts elseBlock) {
        this.elseBlock = elseBlock;
    }

    public IfEnd() {
        this.elseBlock = null;
    }

    public String typeCheck() throws SemanticException {
        if (elseBlock != null) {
            elseBlock.typeCheck();
        }
        return null;
    }

    public String toString(int t) {
        if (elseBlock != null) {
            return getTabs(t) + "else {\n" +
                    elseBlock.toString(t + 1) +
                    getTabs(t) + "}\n";
        } else {
            return "";
        }
    }
}
