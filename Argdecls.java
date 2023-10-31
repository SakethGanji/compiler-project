public class Argdecls extends Token {
    private ArgdeclList argdeclList;

    public Argdecls(ArgdeclList argdeclList) {
        this.argdeclList = argdeclList;
    }

    public String toString(int t) {
        if (argdeclList != null) {
            return argdeclList.toString(t);
        } else {
            return "";
        }
    }

}
