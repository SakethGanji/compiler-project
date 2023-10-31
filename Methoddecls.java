import java.util.LinkedList;
import java.util.List;

public class Methoddecls extends Token {
    private List<Methoddecl> methodDeclarations;
    private Methoddecls nextMethodDecls; // To hold the next Methoddecls

    public Methoddecls() {
        methodDeclarations = new LinkedList<>();
    }

    // Constructor for a single Methoddecl and another Methoddecls
    public Methoddecls(Methoddecl md, Methoddecls mds) {
        this();
        methodDeclarations.add(md);
        this.nextMethodDecls = mds;
        if (mds != null) {
            methodDeclarations.addAll(mds.methodDeclarations);
        }
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