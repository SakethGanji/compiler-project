public class OperandExpr extends Expr {
  String type;
  Object value;

  public OperandExpr(int val) {
    this.value = val;
    this.type = "Integer";
  }

  public OperandExpr(char val) {
    this.value = val;
    this.type = "Character";
  }

  public OperandExpr(String val) {
    this.value = val;
    this.type = "String";
  }

  public OperandExpr(double val) {
    this.value = val;
    this.type = "Float";
  }

  public OperandExpr(boolean val) {
    this.value = val;
    this.type = "Boolean";
  }

  public String toString(int t) {
    return type + ":" + value.toString();
  }
}
