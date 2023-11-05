public class Memberdecl extends Token {
    private Fielddecl fieldDeclaration;
    private Methoddecl methodDeclaration;

    public Memberdecl(Fielddecl fd) {
        this.fieldDeclaration = fd;
        this.methodDeclaration = null;
    }

    public Memberdecl(Methoddecl md) {
        this.fieldDeclaration = null;
        this.methodDeclaration = md;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        if (fieldDeclaration != null) {
            sb.append(fieldDeclaration.toString(t + 1));
        } else if (methodDeclaration != null) {
            sb.append(methodDeclaration.toString(t + 1));
        }
        return sb.toString();
    }
}
