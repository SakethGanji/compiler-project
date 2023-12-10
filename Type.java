import java.util.*;

public class Type {
    private String basicType;
    private static final Set<String> validTypes = new HashSet<>(Arrays.asList("int", "char", "string", "bool", "float"));

    public Type(String basicType) throws SemanticException {
        if (!validTypes.contains(basicType.toLowerCase())) {
            throw new SemanticException("Invalid type: " + basicType);
        }
        this.basicType = basicType;
    }

    public String getBasicType() {
        return basicType;
    }

    public String toString() {
        return basicType;
    }

    public static boolean isValidType(String type) {
        return validTypes.contains(type.toLowerCase());
    }
}
