import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryStepdefs {
    LotteryMachine machine;
    Ticket ticket;
    Memento m;

    @Before
    public void setup() {
        machine = LotteryMachine.getInstance();
    }

    @Given("a ticket with numbers (.+) and (.+) and (.+)")
    public void a_ticket_with_number(int f, int s, int t) {
        ticket = new Ticket(f, s, t);
    }

    @When("set lotterry machine min = (.+) and max = (.+)")
    public void set_machine(int min, int max) {
        machine.setMin(min);
        machine.setMax(max);
    }

    @When("I save my ticket")
    public void i_save() {
        m = ticket.save();
    }

    @When("I buy ticket with numbers (.+) and (.+) and (.+)")
    public void i_buy_ticket(int f, int s, int t) {
        ticket = new Ticket(f, s, t);
    }

    @When("I restore an old ticket")
    public void i_restore_() {
        ticket.restore(m);
    }

    @When("I submit ticket")
    public void i_summit() {
        machine.submitTicket(ticket);
    }

    @When("I operate the machine")
    public void i_operate() {
        machine.operate();
    }

    @When("the machine numbers are (.+) and (.+) and (.+)")
    public void machine_result(int f, int s, int t) {
        machine.setNumber(f, s, t);
    }

    @Then("My ticket should be with numbers (.+) and (.+) and (.+)")
    public void current_ticket(int f, int s, int t) {
        Ticket temp = new Ticket(f, s, t);
        assertEquals(temp, ticket);
    }

    @Then("My victory is (.+)")
    public void check(boolean b) {
        assertEquals(b, machine.check(machine.getTicket()));
    }
}

