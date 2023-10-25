public class PrintLineStmt extends Stmt {
    private PrintList printLineList;

    public PrintLineStmt(PrintList printLineList) {
        this.printLineList = printLineList;
    }

    public String toString(int t) {
        if (printLineList != null) {
            return getTabs(t) + "printline (" + printLineList.toString(0) + ");\n";
        } else {
            return getTabs(t) + "printline ();\n";
        }
    }
}
