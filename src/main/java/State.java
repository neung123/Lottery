public abstract class State {

    protected LotteryMachine machine;
    protected int count = 0;

    public State(LotteryMachine machine){
        this.machine = machine;
    }
    public String operate(){
        return "";
    }

    public String submitTicket(Ticket ticket){
        return "";
    }

    public String save(){
        return "";
    }

    public String restore(Memento memento){
        return "";
    }

}
