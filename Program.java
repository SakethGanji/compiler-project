public class Program extends Token {
  private Expr expr;

  public Program(Expr expr) {
    this.expr = expr;
  }

  public String toString(int t) {
    return "Program:\n" + expr.toString(t + 1) + "\n";
  }

}
