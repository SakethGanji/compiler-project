public class IncrementStmt extends Stmt {
    private Name name;

    public IncrementStmt(Name name) {
        this.name = name;
    }

    public String toString(int t) {
        return name.toString(0) + "++;\n";
    }
}

