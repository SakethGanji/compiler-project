import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionCallExpr extends Expr {
    private String functionName;
    private ArgsList args;

    public FunctionCallExpr(String functionName, ArgsList args) {
        this.functionName = functionName;
        this.args = args;
    }

    public String typeCheck() throws SemanticException {
        MethodVariableSymbol method = symbolTable.lookupMethod(functionName);
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";

        if (method == null) {
            throw new SemanticException(errorLocation + "Function " + functionName + " is not defined");
        }

        List<String> providedArgTypes = args != null ? parseArgTypes(args.typeCheck()) : new ArrayList<>();
        List<VariableSymbol> expectedArgTypes = method.getParameters();

        if (providedArgTypes.size() != expectedArgTypes.size()) {
            throw new SemanticException(errorLocation + "Incorrect number of arguments for function " + functionName);
        }

        for (int i = 0; i < providedArgTypes.size(); i++) {
            String providedType = providedArgTypes.get(i);
            String expectedType = expectedArgTypes.get(i).getType();

            if (!canBeCoerced(providedType, expectedType)) {
                throw new SemanticException(errorLocation + "Type mismatch in arguments for function " + functionName +
                        ". Cannot coerce " + providedType + " to " + expectedType);
            }
        }

        return method.getReturnType();
    }

    private List<String> parseArgTypes(String argTypesStr) {
        return Arrays.asList(argTypesStr.replaceAll("[\\[\\]]", "").split(", "));
    }

    public String toString(int t) {
        String argStr = (args != null) ? args.toString(0) : "";
        return functionName + "(" + argStr + ")";
    }
}
