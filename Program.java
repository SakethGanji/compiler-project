public class Program extends Token {
  private Methoddecls methoddecls;

  public Program(Methoddecls methoddecls) {
    this.methoddecls = methoddecls;
  }

  public String toString(int t) {
    return "Program:\n" +
            "Methoddecls: " + methoddecls.toString(t + 1) + "\n";
  }
}

