public class ReadList extends Token {
    private Name name;
    private ReadList next;

    public ReadList(Name name, ReadList next) {
        this.name = name;
        this.next = next;
    }

    public String toString(int t) {
        String s = name.toString(0);
        if (next != null) {
            s += ", " + next.toString(0);
        }
        return s;
    }
}
