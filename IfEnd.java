public class IfEnd extends Token {
    private Stmts elseBlock;

    public IfEnd(Stmts elseBlock) {
        this.elseBlock = elseBlock;
    }

    public IfEnd() {
        this.elseBlock = null;
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
