public class AssignmentStmt extends Stmt {
    private Name assignee;
    private Expr rhs;

    public AssignmentStmt(Name assignee, Expr rhs) {
        this.assignee = assignee;
        this.rhs = rhs;
    }

    String typeCheck() throws SemanticException {
        String rhsType = mapType(rhs.typeCheck());
        VariableSymbol assigneeSymbol = symbolTable.lookupVariable(assignee.getName());
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";

        if (assigneeSymbol == null) {
            throw new SemanticException(errorLocation + "Variable " + assignee.getName() + " not declared");
        }

        if (assigneeSymbol.isFinal()) {
            throw new SemanticException(errorLocation + "Cannot re-assign to final variable " + assignee.getName());
        }

        if (!isTypeCompatible(assigneeSymbol.getType(), rhsType)) {
            throw new SemanticException(errorLocation + "Type mismatch: Cannot assign " + rhsType + " to " + assigneeSymbol.getType() + " variable");
        }

        return null;
    }

    private boolean isTypeCompatible(String type1, String type2) {
        return type1.equals(type2);
    }


    public String toString(int t) {
        return assignee.toString(0) + " = " + rhs.toString(0) + ";\n";
    }
}
