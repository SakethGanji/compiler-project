class WhileStmt extends Stmt {
    private Expr condition;
    private Stmts block;

    public WhileStmt(Expr condition, Stmts block) {
        this.condition = condition;
        this.block = block;
    }
    String typeCheck() throws SemanticException {
        String conditionType = mapType(condition.typeCheck());
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";

        if (!conditionType.equals("bool") && !canBeCoercedToBoolean(conditionType)) {
            throw new SemanticException(errorLocation + "Type mismatch: Condition in while statement must be boolean, got " + conditionType);
        }

        block.typeCheck();

        return null;
    }

    private boolean canBeCoercedToBoolean(String type) {
        return "int".equals(type) || "Integer".equals(type);
    }

    public String toString(int t) {
        return "while (" + condition.toString(0) + ") {\n" +
                block.toString(t+1) +
                getTabs(t) + "}\n";
    }
}
