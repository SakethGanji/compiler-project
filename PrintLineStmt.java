public class PrintLineStmt extends Stmt {
    private PrintLineList printLineList;

    public PrintLineStmt(PrintLineList printLineList) {
        this.printLineList = printLineList;
    }

    public String toString(int t) {
        if (printLineList != null) {
            return "printline (" + printLineList.toString(0) + ");\n";
        } else {
            return "printline ();\n";
        }
    }
}
