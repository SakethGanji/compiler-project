public class ReturnStmt extends Stmt {
    private Expr expr;

    public ReturnStmt(Expr expr) {
        this.expr = expr;
    }

    String typeCheck() throws SemanticException {
        String currentMethodReturnType = symbolTable.getCurrentMethodReturnType();
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";

        if (expr != null) {
            String exprType = mapType(expr.typeCheck());

            if (!isTypeCompatible(exprType, currentMethodReturnType)) {
                throw new SemanticException(errorLocation + "Type mismatch: Cannot return type " + exprType + " in a method returning " + currentMethodReturnType);
            }
        } else {
            if (!currentMethodReturnType.equals("void")) {
                throw new SemanticException(errorLocation + "Type mismatch: Missing return value in a non-void method");
            }
        }

        return currentMethodReturnType;
    }

    private boolean isTypeCompatible(String type1, String type2) {
        return type1.equals(type2);
    }

    public String toString(int t) {
        String exprStr = (expr != null) ? expr.toString(0) : "";
        return "return " + exprStr + ";\n";
    }
}
