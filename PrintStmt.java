public class PrintStmt extends Stmt {
    private PrintList printList;

    public PrintStmt(PrintList printList) {
        this.printList = printList;
    }

    public String toString(int t) {
        return "print (" + printList.toString(0) + ");\n";
    }
}
