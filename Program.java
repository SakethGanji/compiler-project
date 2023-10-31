public class Program extends Token {
  private String id;
  private Memberdecls memberDeclarations;

  public Program(String id, Memberdecls md) {
    this.id = id;
    this.memberDeclarations = md;
  }

  public String toString(int t) {
    return "Program: class " + id + " {\n" +
            memberDeclarations.toString(t + 1) +
            "}\n";
  }
}
