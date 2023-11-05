public class Fielddecl extends Token {
    private String optionalfinal;
    private String type;
    private String identifier;
    private Optionalexpr optionalexpr;
    private Integer arrayLength;

    public Fielddecl(String optionalfinal, String type, String identifier, Optionalexpr optionalexpr, Integer arrayLength) {
        this.optionalfinal = optionalfinal;
        this.type = type;
        this.identifier = identifier;
        this.optionalexpr = optionalexpr;
        this.arrayLength = arrayLength;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        sb.append(getTabs(t));
        if (optionalfinal != null) {
            sb.append(optionalfinal).append(" ");
        }
        sb.append(type).append(" ").append(identifier);
        if (arrayLength != null) {
            sb.append("[").append(arrayLength).append("]");
        } else if (optionalexpr != null) {
            sb.append(optionalexpr.toString(t));
        }
        sb.append(";");
        return sb.toString();
    }
}
