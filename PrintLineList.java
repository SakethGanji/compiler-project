public class PrintLineList extends Stmt {
    private PrintList printList;

    public PrintLineList(PrintList printList) {
        this.printList = printList;
    }

    public String toString(int t) {
        if (printList != null) {
            return printList.toString(0) + ");";
        } else {
            return "";
        }
    }
}
