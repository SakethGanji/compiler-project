import java.util.LinkedList;
import java.util.List;

public class Methoddecl extends Token {
    private Returntype returntype;
    private String identifier;
    private Argdecls argdecls;
    private Fielddecls fielddecls;
    private Stmts stmts;
    private Boolean optionalsemi;

    public Methoddecl(Returntype returntype, String identifier, Argdecls argdecls, Fielddecls fielddecls, Stmts stmts, Boolean optionalsemi) {
        this.returntype = returntype;
        this.identifier = identifier;
        this.argdecls = argdecls;
        this.fielddecls = fielddecls;
        this.stmts = stmts;
        this.optionalsemi = optionalsemi;
    }
    String typeCheck() throws SemanticException {
        List<VariableSymbol> paramSymbols = new LinkedList<>();
        if (argdecls != null) {
            paramSymbols = argdecls.getParameterSymbols();
        }

        MethodVariableSymbol methodSymbol = new MethodVariableSymbol(identifier, returntype.toString(), paramSymbols);
        symbolTable.addMethod(identifier, methodSymbol);
        symbolTable.setCurrentMethod(methodSymbol);
        String errorLocation = "class<" + symbolTable.getCurrentClassName() + ">: " + symbolTable.getCurrentMethodReturnType() +  " " + symbolTable.getCurrentMethod().getName() + ": ";

        symbolTable.enterScope();
        for (VariableSymbol param : paramSymbols) {
            symbolTable.addVariable(param.getName(), param);
        }

        if (fielddecls != null) {
            fielddecls.typeCheck();
        }
        if (stmts != null) {
            stmts.typeCheck();
        }

        boolean requiresReturn = !returntype.toString().equals("void");
        boolean hasReturn = stmts != null && stmts.hasReturnStatement();

        if (requiresReturn && !hasReturn) {
            throw new SemanticException(errorLocation + "Missing return statement in method " + identifier);
        }

        symbolTable.exitScope();

        return null;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t));
        sb.append(returntype);
        sb.append(" ");
        sb.append(identifier);
        sb.append("(");
        sb.append(argdecls.toString(t));
        sb.append(") {\n");
        sb.append(fielddecls.toString(t + 1));
        sb.append(stmts.toString(t + 1));
        sb.append(getTabs(t)).append("}");

        if (optionalsemi) {
            sb.append(";");
        }

        sb.append("\n");
        return sb.toString();
    }

}
