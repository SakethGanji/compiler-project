public class IfStmt extends Stmt {
    private Expr condition;
    private Stmts thenBlock;
    private IfEnd ifEnd;

    public IfStmt(Expr condition, Stmts thenBlock, IfEnd ifEnd) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.ifEnd = ifEnd;
    }

    public String typeCheck() throws SemanticException {
        String condType = mapType(condition.typeCheck());
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";


        if (!condType.equals("bool") && !canBeCoercedToBoolean(condType)) {
            throw new SemanticException(errorLocation + "Type mismatch: Condition in if statement must be boolean or coercible to boolean, got " + condType);
        }

        thenBlock.typeCheck();
        if (ifEnd != null) {
            ifEnd.typeCheck();
        }

        return null;
    }

    private boolean canBeCoercedToBoolean(String type) {
        return "int".equals(type) || "Integer".equals(type);
    }


    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append("if (").append(condition.toString(0)).append(") {\n");
        sb.append(thenBlock.toString(t + 1));
        sb.append(getTabs(t)).append("}");
        if (ifEnd != null) {
            sb.append("\n").append(ifEnd.toString(t));
        } else {
            sb.append("\n");
        }
        return sb.toString();
    }

}
