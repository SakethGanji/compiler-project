public class OperandExpr extends Expr {
  String type;
  Object value;

  public OperandExpr(Object val, String t) {
    this.value = val;
    this.type = t;
  }

  public OperandExpr(Object val) {
    this.value = val;
    // You can set a default type here if you want,
    // or you can determine it based on the value's class
    this.type = val.getClass().getSimpleName();
  }

  public String toString(int t) {
    return type + ":" + value.toString();
  }
}
