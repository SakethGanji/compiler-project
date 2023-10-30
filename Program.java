public class Program extends Token {
  private Argdecls argdecls;

  public Program(Argdecls argdecls) {
    this.argdecls = argdecls;
  }

  public String toString(int t) {
    return "Program:\n" +
            "Argdecls:\n" + argdecls.toString(t + 1) + "\n";
  }

}
