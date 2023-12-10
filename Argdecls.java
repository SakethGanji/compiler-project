import java.util.*;

public class Argdecls extends Token {
    private ArgdeclList argdeclList;

    public Argdecls(ArgdeclList argdeclList) {
        this.argdeclList = argdeclList;
    }

    public List<VariableSymbol> getParameterSymbols() {
        List<VariableSymbol> paramSymbols = new LinkedList<>();
        if (argdeclList != null) {
            for (Argdecl arg : argdeclList.getArgdecls()) {
                paramSymbols.add(arg.toVariableSymbol());
            }
        }
        return paramSymbols;
    }

    public String typeCheck() throws SemanticException {
        if (argdeclList != null) {
            for (Argdecl arg : argdeclList.getArgdecls()) {
                arg.typeCheck();
            }
        }
        return null;
    }

    public String toString(int t) {
        if (argdeclList != null) {
            return argdeclList.toString(t);
        } else {
            return "";
        }
    }

}
