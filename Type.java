public class Type {
    private String basicType;

    public Type(String basicType) {
        this.basicType = basicType;
    }

    public String getBasicType() {
        return basicType;
    }

    @Override
    public String toString() {
        return basicType;
    }
}
