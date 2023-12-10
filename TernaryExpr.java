public class TernaryExpr extends Expr {
    private Expr condition;
    private Expr trueExpr;
    private Expr falseExpr;

    public TernaryExpr(Expr condition, Expr trueExpr, Expr falseExpr) {
        this.condition = condition;
        this.trueExpr = trueExpr;
        this.falseExpr = falseExpr;
    }

    public String typeCheck() throws SemanticException {
        String conditionType = mapType(condition.typeCheck());
        String trueExprType = mapType(trueExpr.typeCheck());
        String falseExprType = mapType(falseExpr.typeCheck());
        String currentClassName = symbolTable.getCurrentClassName();
        String currentMethodName = symbolTable.getCurrentMethod() != null ? symbolTable.getCurrentMethod().getName() : "[Unknown Method]";
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";


        if (!conditionType.equals("bool")) {
            throw new SemanticException(errorLocation + "Condition in ternary expression must be a boolean or coercible to boolean, found: " + conditionType + " line: " + this.toString(0));
        }

        if (!trueExprType.equals(falseExprType)) {
            throw new SemanticException(errorLocation + "Types of true and false expressions in ternary operator must match, found: " + trueExprType + " and " + falseExprType + " line: " + this.toString(0));
        }

        return trueExprType;
    }

    public String toString(int t) {
        return "(" + condition.toString(0) + " ? " + trueExpr.toString(0) + " : " + falseExpr.toString(0) + ")";
    }
}
