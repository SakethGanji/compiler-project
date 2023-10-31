public class Returntype extends Token {
    private String type;

    public Returntype(String type) {
        this.type = type;
    }

    public String toString(int t) {
        return type;
    }
}
