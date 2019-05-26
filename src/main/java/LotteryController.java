import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LotteryController {
    @FXML
    Label lotteryFirst;
    @FXML
    Label lotterySecond;
    @FXML
    Label lotteryThird;
    @FXML
    Label systemLog;
    @FXML
    TextField ticketFirst;
    @FXML
    TextField ticketSecond;
    @FXML
    TextField ticketThird;
    @FXML
    Button operate;
    @FXML
    Button submit;
    @FXML
    Button save;
    @FXML
    Button restore;

    public static LotteryMachine lotteryMachine = LotteryMachine.getInstance();

    public void handleOperate(){
        setSystemLog(lotteryMachine.operate());
    }
    public void handleSubmit(){
        int f;
        int s;
        int t;
        try {
            f = Integer.parseInt(ticketFirst.getText());
            s = Integer.parseInt(ticketSecond.getText());
            t = Integer.parseInt(ticketThird.getText());
        }catch (NumberFormatException e){
            setSystemLog("Please, input a number");
            return;
        }

        setSystemLog(lotteryMachine.submitTicket(new Ticket(f, s, t)));
    }
    public void handleRestore(){
        String statement = lotteryMachine.restore();
        setSystemLog(statement);
        if(statement.contains("Your restored ticket numbers are")) setTicket();
    }
    public void handleSave(){
        setSystemLog(lotteryMachine.save());
    }

    public void setSystemLog(String log){
        systemLog.setText(log);
        setLottery();
    }

    public void setLottery(){
        lotteryFirst.setText(lotteryMachine.getStringFirst());
        lotterySecond.setText(lotteryMachine.getStringSecond());
        lotteryThird.setText(lotteryMachine.getStringThird());
    }

    public void setTicket(){
        ticketFirst.setText(String.valueOf(lotteryMachine.getTicket().getFirst()));
        ticketSecond.setText(String.valueOf(lotteryMachine.getTicket().getSecond()));
        ticketThird.setText(String.valueOf(lotteryMachine.getTicket().getThird()));
    }

}
