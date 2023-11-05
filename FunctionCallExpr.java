public class FunctionCallExpr extends Expr {
    private String functionName;
    private ArgsList args;

    public FunctionCallExpr(String functionName, ArgsList args) {
        this.functionName = functionName;
        this.args = args;
    }

    public String toString(int t) {
        String argStr = (args != null) ? args.toString(0) : "";
        return functionName + "(" + argStr + ")";
    }
}
