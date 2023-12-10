public class ReadStmt extends Stmt {
    private ReadList readList;

    public ReadStmt(ReadList readList) {
        this.readList = readList;
    }

    public String typeCheck() throws SemanticException {
        if (readList != null) {
            readList.typeCheck();
        }
        return null;
    }


    public String toString(int t) {
        return "read (" + readList.toString(0) + ");\n";
    }
}
