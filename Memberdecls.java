public class Memberdecls extends Token {
    private Memberdecl memberDeclaration;
    private Memberdecls next;

    public Memberdecls(Memberdecl md, Memberdecls mds) {
        this.memberDeclaration = md;
        this.next = mds;
    }

    public Memberdecls() {
        this.memberDeclaration = null;
        this.next = null;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        if (memberDeclaration != null) {
            sb.append(memberDeclaration.toString(t + 1));
        }
        if (next != null) {
            sb.append("\n");
            sb.append(next.toString(t));
        }
        return sb.toString();
    }
}

