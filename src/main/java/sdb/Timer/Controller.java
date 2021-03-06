package sdb.Timer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

	@FXML
    public ProgressBar progressBar;
    boolean paused = true;
    public long start;

    public Button button;
    public AnchorPane pane;
    public TextField time;
    Timer t = new Timer();
    String rest = "05:00";
    String work = "25:00";

    @FXML
    public void startMouse(MouseEvent mouseEvent) {
        start = System.currentTimeMillis();
    }
    @FXML
    public void stopMouse(MouseEvent mouseEvent) {
        if(System.currentTimeMillis()-start>1000){
            restartTimer();
        }
        else{
            startTimer();
        }
    }

    /*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        time.setText(work);
        time.textProperty().addListener((observable)->{
            setProgress();
        });
    }
	*/

    @FXML
    private void initialize() {
    	// no point of using initializable
	    time.setText(work);
	    // WRONG LISTENER TYPE - this is an InvalidationListener not ChangeListener !!!!
//	    time.textProperty().addListener((observable) -> {
//		    setProgress();
//	    });
	    time.textProperty().addListener((obs, oldVal, newVal) -> {
	    	setProgress();
	    });
    }

    // no point splitting twice
    void setProgress(){
    	String[] arr = time.getText().split(":");
        String minute = arr[0];
        String seconds = arr[1];
        int min = Integer.parseInt(minute);
        int sec = Integer.parseInt(seconds);
        double percent = (25-(min+((double)sec/60)))/25;
        progressBar.setProgress(percent);
    }
    private void startTimer(){
        if(button.getText().equals("Start")){
            button.setText("Pause");
            t = new Timer();
            t.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    removeSecond();
                }
            },0,1000);
            paused = false;
        }
        else if (button.getText().equals("Pause")){
            button.setText("Start");
            System.out.println("Start");
            t.cancel();
            paused = true;
        }
    }


    private void restartTimer(){
        try{t.cancel();} catch (Exception ignored){}
        time.setText("25:00");
        button.setText("Start");
    }

    void setTime(String time){
        this.time.setText(time);
    }
    void removeSecond(){
        int[] arr = Arrays.stream(time.getText().split(":")).mapToInt(Integer::parseInt).toArray();
        if (arr[0] == 0 && arr[1] == 0) {
            paused = false;
        } else if (arr[1] == 0) {
            arr[1] = 59;
            arr[0] = arr[0] - 1;
        } else {
            arr[1] = arr[1] - 1;
        }
        String timeNow = String.format("%02d", arr[0]) +":"+ String.format("%02d", arr[1]);
        Platform.runLater(() -> {
            setTime(timeNow);
        });
    }



}
