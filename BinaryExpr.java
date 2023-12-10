public class BinaryExpr extends Expr {
    private Expr left;
    private Expr right;
    private String operator;

    public BinaryExpr(Expr left, String operator, Expr right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public String typeCheck() throws SemanticException {
        String leftType = mapType(left.typeCheck());
        String rightType = mapType(right.typeCheck());
        String currentClassName = symbolTable.getCurrentClassName();
        String currentMethodName = symbolTable.getCurrentMethod() != null ? symbolTable.getCurrentMethod().getName() : "[Unknown Method]";
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";

        if (operator.equals("+")) {
            if (leftType.equals("String") || rightType.equals("String")) {
                return "String";
            }

            if (isNumericType(leftType) && isNumericType(rightType)) {
                return leftType.equals("float") || rightType.equals("float") ? "float" : "int";
            }
            throw new SemanticException(errorLocation + "Invalid operand types for +: " + leftType + " and " + rightType + " line: " + this.toString(0));
        }

        if (operator.equals("-") || operator.equals("*") || operator.equals("/")) {
            if (!isNumericType(leftType) || !isNumericType(rightType)) {
                throw new SemanticException(errorLocation + "Operands of " + operator + " must be int or float, found: " + leftType + " and " + rightType + " line: " + this.toString(0));
            }
            return leftType.equals("float") || rightType.equals("float") ? "float" : "int";
        }

        if (operator.equals("&&") || operator.equals("||")) {
            if (!leftType.equals("bool") || !rightType.equals("bool")) {
                throw new SemanticException(errorLocation + "Operands of " + operator + " must be of type bool, found: " + leftType + " and " + rightType + " line: " + this.toString(0));
            }
            return "bool";
        }

        if (operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">=") || operator.equals("==") || operator.equals("!=")) {
            if (!isNumericType(leftType) || !isNumericType(rightType)) {
                throw new SemanticException(errorLocation + "Operands of " + operator + " must be int or float, found: " + leftType + " and " + rightType + " line: " + this.toString(0));
            }
            return "bool";
        }

        throw new SemanticException(errorLocation + "Invalid operand types for +: " + leftType + " and " + rightType + " line: " + this.toString(0));

    }

    private boolean isNumericType(String type) {
        return type.equals("int") || type.equals("float");
    }
    public String toString(int t) {
        return "(" + left.toString(0) + " " + operator + " " + right.toString(0) + ")";
    }

}

