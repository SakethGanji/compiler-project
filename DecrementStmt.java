public class DecrementStmt extends Stmt {
    private Name name;

    public DecrementStmt(Name name) {
        this.name = name;
    }

    public String toString(int t) {
        return name.toString(0) + "--;\n";
    }
}
