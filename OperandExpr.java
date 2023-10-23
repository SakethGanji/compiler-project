class OperandExpr extends Expr {
  String type;
  Object value;

  public OperandExpr(Object val, String t) {
    this.value = val;
    this.type = t;
  }

  public String toString(int t) {
    return type + ":" + value.toString();
  }
}
