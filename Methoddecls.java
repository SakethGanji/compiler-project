import java.util.LinkedList;
import java.util.List;

public class Methoddecls extends Token {
    private List<Methoddecl> methodDeclarations;

    public Methoddecls() {
        methodDeclarations = new LinkedList<>();
    }

    public Methoddecls(Methoddecl md, Methoddecls mds) {
        this();
        methodDeclarations.add(md);
        methodDeclarations.addAll(mds.methodDeclarations);
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (Methoddecl md : methodDeclarations) {
            sb.append(md.toString(t));
            sb.append("\n");
        }
        return sb.toString();
    }
}
