public class Program extends Token {
  private NumExpr numexpr;

  public Program(NumExpr n) {
    numexpr = n;
  }

  public String toString(int t) {
    return "Program:\n" + numexpr.toString(t + 1) + "\n";
  }

}
