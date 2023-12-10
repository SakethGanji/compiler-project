public class OperandExpr extends Expr {
  String type;
  Object value;

  public OperandExpr(Object val, String t) {
    this.value = val;
    this.type = t;
  }

  public OperandExpr(Object val) {
    this.value = val;
    this.type = val.getClass().getSimpleName();
  }

  public String typeCheck() throws SemanticException {
    switch ((mapType(this.type)).toLowerCase()) {
      case "int":
      case "char":
      case "string":
      case "bool":
      case "float":
        return this.type;
      default:
        throw new SemanticException( (mapType(this.type)).toLowerCase());
    }
  }

  public String toString(int t) {
    return value.toString();
  }
}
