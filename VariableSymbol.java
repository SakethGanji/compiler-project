class VariableSymbol {
    private String name;
    String type;
    boolean isArray;
    boolean isFinal;

    public VariableSymbol(String name, String type, boolean isArray, boolean isFinal) {
        this.name = name;
        this.type = type;
        this.isArray = isArray;
        this.isFinal = isFinal;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isArray() {
        return isArray;
    }

    public void setArray(boolean array) {
        isArray = array;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }
}
