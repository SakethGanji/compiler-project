abstract class Token {
    protected static SymbolTable symbolTable = new SymbolTable();

    protected String getTabs(int t) {
        StringBuilder tabs = new StringBuilder();
        for (int i = 0; i < t; i++) {
            tabs.append("\t");
        }
        return tabs.toString();
    }

    abstract String typeCheck() throws SemanticException;

    protected String mapType(String exprType) {
        switch (exprType) {
            case "Integer": return "int";
            case "Character": return "char";
            case "Boolean": return "bool";
            case "Float": return "float";
            case "null": return "null";
            default: return exprType;
        }
    }
    protected boolean canBeCoerced(String fromType, String toType) {
        if ("int".equals(fromType)) {
            if ("bool".equals(toType) || "float".equals(toType)) {
                return true;
            }
        }

        if ("Integer".equals(fromType) && "float".equals(toType)) {
            return true;
        }

        if ("String".equals(toType) && !fromType.endsWith("[]")) {
            return true;
        }

        return fromType.equals(toType);
    }




    public String toString(int t)
    {
        return "";
    }
}