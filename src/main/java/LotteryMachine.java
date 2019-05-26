import java.util.Random;

public class LotteryMachine {
    public static LotteryMachine machine = null;
    private int first;
    private int second;
    private int third;
    private int min = 0;
    private int max = 999;
    private State state;
    private Ticket ticket;
    private Memento memento;
    public static final int COUNT = 3;

    private LotteryMachine(){
        state = new StateInit(this);
    }

    public static LotteryMachine getInstance(){
        if(machine == null) machine = new LotteryMachine();

        return machine;
    }

    public String operate(){
        return state.operate();
    }

    public String submitTicket(Ticket ticket){
        return state.submitTicket(ticket);
    }

    public String save(){
        return state.save();
    }

    public String restore(){
        return state.restore(memento);
    }

    public String getStringFirst() {
        return getString(first);
    }

    public String getStringSecond() {
        return getString(second);
    }

    public String getStringThird() {
        return getString(third);
    }

    private String getString(int num) {
        String temp = "";
        int maxDigit = getDigit(max);
        int numDigit = getDigit(num);

        for (int i = 0; i < maxDigit-numDigit; i++){
            temp = temp + "0";
        }

        return temp + num;
    }

    public int getDigit(int num){
        int count = 0;

        if(num == 0) return 1;

        while (num > 0){
            num = num/10;
            count++;
        }
        return count;
    }

    public void setMin(int min) {
        if(min >= 0) this.min = min;
    }

    public void setMax(int max) {
        if(max >= min)this.max = max;
    }

    public boolean check(Ticket ticket){
        if(ticket.getFirst() == first ||
        ticket.getFirst() == second ||
        ticket.getFirst() == third ||
            ticket.getSecond() == first ||
            ticket.getSecond()== second ||
            ticket.getSecond() == third ||
                ticket.getThird() == first ||
                ticket.getThird() == second ||
                ticket.getThird() == third ) return true;
        return false;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setNumber(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Memento getMemento() {
        if(memento == null) return Memento.getNullMemento();

        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }

    @Override
    public String toString() {
        return "machine: " + first + "," + second + "," + third;
    }

}
