public class Solved {
    String original;
    String sorted;
    int transition;

    public Solved(String o, String s, int t) {
        original = o;
        sorted = s;
        transition = t;
    }

    public String toString() {
        return " original =  " + this.original + "\n sorted = " + this.sorted + "\n Transition = " + this.transition;
    }
}
