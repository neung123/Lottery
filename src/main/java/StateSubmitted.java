import java.util.Random;

public class StateSubmitted extends State {

    public StateSubmitted(LotteryMachine machine){
        super(machine);

    }

    public String operate(){
        Random random = new Random();
        int first = random.nextInt((machine.getMax() - machine.getMin()) + 1) + machine.getMin();
        int second = random.nextInt((machine.getMax() - machine.getMin()) + 1) + machine.getMin();
        int third = random.nextInt((machine.getMax() - machine.getMin()) + 1) + machine.getMin();

        machine.setNumber(first, second, third);

        count++;
        String statement;
        if(machine.check(machine.getTicket())) statement = "You won! ";
        else statement = "You lose! ";

        if (count == LotteryMachine.COUNT){
            machine.setState(new StateInit(machine));
            count = 0;
            return statement + count + " time left";
        }
        return statement + (LotteryMachine.COUNT - count) + " times left";
    }

    public String submitTicket(Ticket ticket){
        return "You already submitted your ticket";
    }

    public String save() {
        machine.setMemento(machine.getTicket().save());
        return "Your ticket has been save";
    }

    public String restore(Memento memento){
        return "Please wait until another round you already submitted";
    }
}
