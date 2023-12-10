public class Fielddecl extends Token {
    private String optionalfinal;
    private Type type;
    private String identifier;
    private Optionalexpr optionalexpr;
    private Integer arrayLength;

    public Fielddecl(String optionalfinal, Type type, String identifier, Optionalexpr optionalexpr, Integer arrayLength) {
        this.optionalfinal = optionalfinal;
        this.type = type;
        this.identifier = identifier;
        this.optionalexpr = optionalexpr;
        this.arrayLength = arrayLength;
    }
    String typeCheck() throws SemanticException {
        boolean isFinal = "final".equals(optionalfinal);
        boolean isArray = arrayLength != null;
        VariableSymbol variableSymbol = new VariableSymbol(identifier, type.toString(), isArray, isFinal);
        symbolTable.addVariable(identifier, variableSymbol);
        String currentClassName = symbolTable.getCurrentClassName();
        String currentMethodName = symbolTable.getCurrentMethod() != null ? symbolTable.getCurrentMethod().getName() : "[Unknown Method]";
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: ";

        if (isArray && arrayLength != null && arrayLength < 0) {
            throw new SemanticException(errorLocation + "Array size must be a non-negative integer in declaration of " + identifier);
        }

        if (optionalexpr != null) {
            String exprType = mapType(optionalexpr.typeCheck());

            if (!"null".equals(exprType)) {
                if (isArray) {
                } else {
                    if (exprType.endsWith("[]")) {
                        throw new SemanticException(errorLocation + "Cannot assign array type to non-array field " + identifier);
                    }
                    if (!type.toString().equals(exprType) && !checkImplicitCoercion(type.toString(), exprType)) {
                        throw new SemanticException(errorLocation + "Type mismatch in field declaration '" + identifier + "': Cannot assign " + exprType + " to " + type.toString());
                    }
                }
            }
        }
        return null;
    }

    private boolean checkImplicitCoercion(String targetType, String sourceType) {
        if ("float".equals(targetType) && "int".equals(sourceType)) {
            return true;
        }
        if ("bool".equals(targetType) && "int".equals(sourceType)) {
            return true;
        }
        return false;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t));
        if (optionalfinal != null) {
            sb.append(optionalfinal).append(" ");
        }
        sb.append(type).append(" ").append(identifier);
        if (arrayLength != null) {
            sb.append("[").append(arrayLength).append("]");
        } else if (optionalexpr != null) {
            sb.append(optionalexpr.toString(t));
        }
        sb.append(";");
        return sb.toString();
    }
}
