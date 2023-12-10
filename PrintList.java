public class PrintList extends Token {
    private Expr expr;
    private PrintList next;


    public PrintList(Expr expr, PrintList next) {
        this.expr = expr;
        this.next = next;
    }

    public PrintList(Expr expr) {
        this.expr = expr;
        this.next = null;
    }

    public String typeCheck() throws SemanticException {
        String exprType = expr.typeCheck();
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";


        if (exprType.equals("void")) {
            throw new SemanticException(errorLocation + "Cannot print void type");
        }

        if (expr instanceof Name && ((Name) expr).getExpr() == null && exprType.endsWith("[]")) {
            throw new SemanticException(errorLocation + "Cannot print non-dereferenced array type");
        }

        if (next != null) {
            next.typeCheck();
        }
        return null;
    }



    public String toString(int t) {
        String s = expr.toString(0);
        if (next != null) {
            s += ", " + next.toString(0);
        }
        return s;
    }
}
