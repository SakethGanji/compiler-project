import java.util.LinkedList;
import java.util.List;

public class Methoddecls extends Token {
    private List<Methoddecl> methodDeclarations;
    private Methoddecls nextMethodDecls;

    public Methoddecls() {
        methodDeclarations = new LinkedList<>();
    }

    public Methoddecls(Methoddecl md, Methoddecls mds) {
        this();
        methodDeclarations.add(md);
        this.nextMethodDecls = mds;
        if (mds != null) {
            methodDeclarations.addAll(mds.methodDeclarations);
        }
    }

    String typeCheck() throws SemanticException {
        for (Methoddecl md : methodDeclarations) {
            md.typeCheck();
        }
        if (nextMethodDecls != null) {
            nextMethodDecls.typeCheck();
        }
        return null;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (Methoddecl md : methodDeclarations) {

            sb.append(md.toString(t));
            sb.append("\n");
        }
        if (nextMethodDecls != null) {
            sb.append(nextMethodDecls.toString(t));
        }
        return sb.toString();
    }
}
