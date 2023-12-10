public class Name extends Expr {
    private String identifier;
    private Expr expr;

    public Name(String identifier, Expr expr) {
        this.identifier = identifier;
        this.expr = expr;
    }

    public String getName() {
        return this.identifier;
    }
    public String getIdentifier() {
        return identifier;
    }

    public Expr getExpr() {
        return expr;
    }

    public String typeCheck() throws SemanticException {
        VariableSymbol variable = symbolTable.lookupVariable(identifier);
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";

        if (variable == null) {
            throw new SemanticException(errorLocation + "Variable " + identifier + " is not declared");
        }

        if (expr != null) {
            String indexType = expr.typeCheck();
            if (!indexType.equals("int")) {
                throw new SemanticException(errorLocation + "Array index must be an integer in " + identifier);
            }
            if (!variable.isArray()) {
                throw new SemanticException(errorLocation + "Variable " + identifier + " is not an array");
            }
            return variable.getType();
        } else {

            return variable.getType();
        }
    }

    public String toString(int t) {
        if (expr != null) {
            return identifier + "[" + expr.toString(0) + "]";
        } else {
            return identifier;
        }
    }

}
