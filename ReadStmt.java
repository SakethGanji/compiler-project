public class ReadStmt extends Stmt {
    private ReadList readList;

    public ReadStmt(ReadList readList) {
        this.readList = readList;
    }

    public String toString(int t) {
        return "read (" + readList.toString(0) + ");\n";
    }
}
