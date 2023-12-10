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
    String typeCheck() throws SemanticException {
        if (fieldDeclaration != null) {
            fieldDeclaration.typeCheck();
        } else if (methodDeclaration != null) {
            methodDeclaration.typeCheck();
        }
        return null;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        if (fieldDeclaration != null) {
            sb.append(fieldDeclaration.toString(t));
        } else if (methodDeclaration != null) {
            sb.append(methodDeclaration.toString(t));
        }
        return sb.toString();
    }
}
