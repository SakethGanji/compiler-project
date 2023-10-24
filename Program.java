public class Program extends Token {
  private Stmts statements;

  public Program(Stmts statements) {
    this.statements = statements;
  }

  public String toString(int t) {
    return "Program:\n" + statements.toString(t + 1) + "\n";
  }
}
