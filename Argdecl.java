public class Argdecl extends Token {
    private Type type;
    private String identifier;
    private boolean isArray;

    public Argdecl(Type type, String identifier, boolean isArray) {
        this.type = type;
        this.identifier = identifier;
        this.isArray = isArray;
    }

    public VariableSymbol toVariableSymbol() {
        return new VariableSymbol(identifier, type.toString(), isArray, false);
    }


    public String typeCheck() throws SemanticException {
        String basicType = type.getBasicType();
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";
        if (!Type.isValidType(basicType)) {
            throw new SemanticException(errorLocation + "Invalid type: " + basicType);
        }

        if (symbolTable.lookupVariable(identifier) != null) {
            throw new SemanticException(errorLocation + "Argument " + identifier + " is already defined in scope");
        }

        VariableSymbol varSymbol = new VariableSymbol(basicType,type.toString(), isArray, false);
        symbolTable.addVariable(identifier, varSymbol);
        return basicType;
    }


    public String toString(int t) {
        String arrayIndicator = isArray ? "[]" : "";
        String result = type + " " + identifier + arrayIndicator;
        return result;
    }


}
