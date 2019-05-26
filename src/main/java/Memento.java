public class Memento {
    private int first;
    private int second;
    private int third;

    public Memento(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public static Memento getNullMemento(){ return new NullMemento(0, 0, 0); }

    @Override
    public String toString() {
        return "memento: " + first + "," + second + "," + third;
    }
}
