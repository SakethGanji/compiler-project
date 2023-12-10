public class Program extends Token {
  private String id;
  private Memberdecls memberDeclarations;

  public Program(String id, Memberdecls md) {
    this.id = id;
    this.memberDeclarations = md;
  }

  String typeCheck() throws SemanticException {
    symbolTable.setCurrentClassName(id);

    if (memberDeclarations != null) {
      memberDeclarations.typeCheck();
    }
    return null;
  }


  public String toString(int t) {
    return "class " + id + " {\n" +
            memberDeclarations.toString(t + 1) +
          "}" + "\n";
  }
}
