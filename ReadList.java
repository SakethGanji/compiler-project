public class ReadList extends Token {
    private Name name;
    private ReadList next;

    public ReadList(Name name, ReadList next) {
        this.name = name;
        this.next = next;
    }

    public String typeCheck() throws SemanticException {
        VariableSymbol variable = symbolTable.lookupVariable(name.getIdentifier());
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";
        if (variable == null) {
            throw new SemanticException("Variable " + name.getIdentifier() + " is not declared");
        }

        if (symbolTable.lookupMethod(name.getIdentifier()) != null) {
            throw new SemanticException(errorLocation + "Cannot read function " + name.getIdentifier());
        }

        if (variable.isFinal()) {
            throw new SemanticException(errorLocation + "Cannot read final variable " + name.getIdentifier());
        }

        if (variable.isArray()) {
            if (name.getExpr() == null) {
                throw new SemanticException(errorLocation + "Cannot read non-dereferenced array " + name.getIdentifier());
            } else {
                String indexType = name.getExpr().typeCheck();
                if (!indexType.equals("int")) {
                    throw new SemanticException(errorLocation + "Array index must be an integer in " + name.toString(0));
                }
            }
        }

        if (next != null) {
            next.typeCheck();
        }
        return null;
    }

    public String toString(int t) {
        String s = name.toString(0);
        if (next != null) {
            s += ", " + next.toString(0);
        }
        return s;
    }
}
