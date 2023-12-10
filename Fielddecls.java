import java.util.LinkedList;
import java.util.List;

public class Fielddecls extends Token {
    private List<Fielddecl> fieldDeclarations;

    public Fielddecls() {
        fieldDeclarations = new LinkedList<>();
    }

    public Fielddecls(Fielddecl fd, Fielddecls fds) {
        this();
        fieldDeclarations.add(fd);
        fieldDeclarations.addAll(fds.fieldDeclarations);
    }

    String typeCheck() throws SemanticException {
        for (Fielddecl fd : fieldDeclarations) {
            fd.typeCheck();
        }

        return null;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (Fielddecl fd : fieldDeclarations) {
            sb.append(fd.toString(t));
            sb.append("\n");
        }
        if (!fieldDeclarations.isEmpty()) {
            sb.append("\n");
        }
        return sb.toString();
    }

}
