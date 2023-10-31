public class Memberdecls extends Token {
    private Fielddecls fieldDeclarations;
    private Methoddecls methodDeclarations;

    public Memberdecls(Fielddecls fd, Methoddecls md) {
        this.fieldDeclarations = fd;
        this.methodDeclarations = md;
    }

    public Memberdecls(Methoddecls md) {
        this.fieldDeclarations = null;
        this.methodDeclarations = md;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        if (fieldDeclarations != null) {
            sb.append("Field Declarations:\n");
            sb.append(fieldDeclarations.toString(t + 1));
        }
        if (methodDeclarations != null) {
            sb.append("Method Declarations:\n");
            sb.append(methodDeclarations.toString(t + 1));
        }
        return sb.toString();
    }
}

