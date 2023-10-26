public class FunctionCallStmt extends Stmt {
    private String functionName;
    private ArgsList args;

    public FunctionCallStmt(String functionName, ArgsList args) {
        this.functionName = functionName;
        this.args = args;
    }

    public String toString(int t) {
        String argStr = (args != null) ? args.toString(0) : "";
        return getTabs(t) + functionName + "(" + argStr + ");\n";
    }
}