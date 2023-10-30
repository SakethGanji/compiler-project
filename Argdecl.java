public class Argdecl extends Token {
    private String type;
    private String identifier;
    private boolean isArray;

    public Argdecl(String type, String identifier, boolean isArray) {
        this.type = type;
        this.identifier = identifier;
        this.isArray = isArray;
    }

    public String toString(int t) {
        String arrayIndicator = isArray ? "[]" : "";
        String result = type + " " + identifier + arrayIndicator;
        return result;
    }


}
