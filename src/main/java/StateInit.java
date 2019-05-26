/**
 * Doesn't create any ticket yet
 */
public class StateInit extends State {

    public StateInit(LotteryMachine machine){
        super(machine);

    }

    public String operate(){
        return "You have to submit your ticket first";
    }

    public String submitTicket(Ticket ticket){
        machine.setTicket(ticket);
        machine.setState(new StateSubmitted(machine));
        return "Your submitted ticket numbers are " + ticket.allNumbers();
    }

    public String save(){
        return "Can't save yet!";
    }

    public String restore(Memento memento){
        if(machine.getTicket() == null) return "Can't restore. You have to submit your ticket first!";
        if(memento == null) machine.setMemento(Memento.getNullMemento());
        machine.getTicket().restore(machine.getMemento());
        return "Your restored ticket numbers are " + machine.getTicket();
    }
}
