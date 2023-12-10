public class DecrementStmt extends Stmt {
    private Name name;

    public DecrementStmt(Name name) {
        this.name = name;
    }

    String typeCheck() throws SemanticException {
        VariableSymbol variableSymbol = symbolTable.lookupVariable(name.getName());
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";


        if (variableSymbol == null) {
            throw new SemanticException("Variable " + name.getName() + " not declared");
        }

        if (!isIncrementDecrementType(variableSymbol.getType()) || variableSymbol.isFinal()) {
            String currentClassName = symbolTable.getCurrentClassName();
            String currentMethodName = symbolTable.getCurrentMethod() != null ? symbolTable.getCurrentMethod().getName() : "[Unknown Method]";
            throw new SemanticException(errorLocation + ":Cannot decrement variable of type: " + variableSymbol.getType() + " line: " + this.toString(0));
        }

        return null;
    }

    private boolean isIncrementDecrementType(String type) {
        return type.equals("int") || type.equals("float");
    }


    public String toString(int t) {
        return name.toString(0) + "--;\n";
    }
}
