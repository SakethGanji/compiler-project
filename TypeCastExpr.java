public class TypeCastExpr extends Expr {
    private Type type;
    private Expr expr;

    public TypeCastExpr(Type type, Expr expr) {
        this.type = type;
        this.expr = expr;
    }
    public String typeCheck() throws SemanticException {
        String exprType = expr.typeCheck();
        String targetType = type.getBasicType();
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";


        if (exprType.equals("int") && targetType.equals("float")) {
            return "float";
        } else if (exprType.equals("float") && targetType.equals("int")) {
            return "int";
        }
        throw new SemanticException(errorLocation + "Invalid type cast from " + exprType + " to " + targetType);
    }


    public String toString(int t) {
        return "(" + type + ")" + expr.toString(0);
    }
}
