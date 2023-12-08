public class Returntype extends Token {
    private Type type;
    private boolean isVoid;

    public Returntype(Type type) {
        this.type = type;
        this.isVoid = false;
    }

    public Returntype() {
        this.type = null;
        this.isVoid = true;
    }

    @Override
    public String toString() {
        if (isVoid) {
            return "void";
        } else {
            return type.toString();
        }
    }
}
