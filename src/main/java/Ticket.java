public class Ticket {
    private int first;
    private int second;
    private int third;

    public Ticket(int first, int second, int third){
        if (first < 0) first = 0;
        if (second < 0) second = 0;
        if (third < 0) third = 0;

        this.first = first;
        this.second = second;
        this.third = third;
    }
    public Memento save(){
        return new Memento(first, second, third);
    }

    public void restore(Memento m){
        if (m == null) return;
        this.first = m.getFirst();
        this.second = m.getSecond();
        this.third = m.getThird();
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

    public String allNumbers(){
        return first + "," + second + "," + third;
    }

    @Override
    public String toString() {
        return "ticket: " + first + "," + second + "," + third;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj.getClass() != this.getClass()) return false;
        Ticket t = (Ticket) obj;

        return t.getFirst() == this.getFirst()&& t.getSecond() == this.getSecond() && t.getThird() == this.getThird();
    }
}
