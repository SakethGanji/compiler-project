public class UnaryExpr extends Expr {
    private String operator;
    private Expr operand;

    public UnaryExpr(String operator, Expr operand) {
        this.operator = operator;
        this.operand = operand;
    }
    public String typeCheck() throws SemanticException {
        String operandType = mapType(operand.typeCheck());
        String currentClassName = symbolTable.getCurrentClassName();
        String currentMethodName = symbolTable.getCurrentMethod() != null ? symbolTable.getCurrentMethod().getName() : "[Unknown Method]";
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";

        if (operator.equals("-")) {
            if (!operandType.equals("int") && !operandType.equals("float")) {
                throw new SemanticException(errorLocation + "Unary minus operator requires int or float operand, found: " + operandType + " line: " + this.toString(0));
            }
            return operandType;
        }

        if (operator.equals("!")) {
            if (!operandType.equals("bool")) {
                throw new SemanticException(errorLocation + "Logical NOT operator requires bool operand, found: " + operandType + " line: " + this.toString(0));
            }
            return "bool";
        }

        if (operator.equals("~")) {
            if (!operandType.equals("bool") && (!operandType.equals("int"))) {
                throw new SemanticException(errorLocation + "Bitwise NOT operator requires bool operand, found: " + operandType + " line: " + this.toString(0));
            }
            return "bool";
        }

        throw new SemanticException(errorLocation + "Unsupported unary operator: " + operator + " line: " + this.toString(0));
    }

    public String toString(int t) {
        return "(" + operator + operand.toString(0) + ")";
    }
}
