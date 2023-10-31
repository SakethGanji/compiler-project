public class Optionalfinal extends Token {
    private boolean isFinal;

    public Optionalfinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public String toString(int t) {
        return isFinal ? "final" : "";
    }
}
