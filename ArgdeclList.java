import java.util.LinkedList;
import java.util.List;

public class ArgdeclList extends Token {
    private List<Argdecl> argdecls;

    public ArgdeclList() {
        argdecls = new LinkedList<>();
    }

    public ArgdeclList(Argdecl a, ArgdeclList al) {
        this();
        argdecls.add(a);
        if (al != null) {
            argdecls.addAll(al.argdecls);
        }
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        for (Argdecl a : argdecls) {
            sb.append(a.toString(t));
            sb.append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
