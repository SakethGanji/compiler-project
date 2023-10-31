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

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(returntype.toString(t));
        sb.append(" ");
        sb.append(identifier);
        sb.append("(");
        sb.append(argdecls.toString(t));
        sb.append(") {\n");
        sb.append(fielddecls.toString(t+1));
        sb.append(stmts.toString(t+1));
        sb.append("}\n");
        if (optionalsemi) {
            sb.append(";");
        }
        return sb.toString();
    }
}
