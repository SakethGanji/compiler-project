public class PrintLineList extends Stmt {
    private PrintList printList;

    public PrintLineList(PrintList printList) {
        this.printList = printList;
    }

    public String toString(int t) {
        if (printList != null) {
            return getTabs(t) + "printline (" + printList.toString(0) + ");\n";
        } else {
            return getTabs(t) + "printline ();\n";
        }
    }
}
