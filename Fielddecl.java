public class Fielddecl extends Token {
    private String optionalfinal;;
    private String type;
    private String identifier;
    private Optionalexpr optionalexpr;
    private Integer arraySize;

    public Fielddecl(String optionalfinal, String type, String identifier, Optionalexpr optionalexpr, Integer arraySize) {
        this.optionalfinal = optionalfinal;
        this.type = type;
        this.identifier = identifier;
        this.optionalexpr = optionalexpr;
        this.arraySize = arraySize;
    }

    public String toString(int t) {
        StringBuilder sb = new StringBuilder();
        if (optionalfinal != null) {
            sb.append(optionalfinal.toString());
            sb.append(" ");
        }
        sb.append(type);
        sb.append(" ");
        sb.append(identifier);
        if (arraySize != null) {
            sb.append("[");
            sb.append(arraySize);
            sb.append("]");
        } else if (optionalexpr != null) {
            sb.append(" ");
            sb.append(optionalexpr.toString(t));
        }
        sb.append(";");
        return sb.toString();
    }
}
