public class NullMemento extends Memento {
    public NullMemento(int first, int second, int third) {
        super(first, second, third);
    }

    @Override
    public int getFirst() {
        return 0;
    }

    @Override
    public int getSecond() {
        return 0;
    }

    @Override
    public int getThird() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
