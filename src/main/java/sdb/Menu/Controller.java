package sdb.Menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Pair;
import sdb.Calculator.CalculatorApp;
import sdb.Dictionary.DictionaryApp;
import sdb.Notes.NotesApp;
import sdb.Picker.PickerApp;
import sdb.Timer.TimerApp;
import sdb.Whiteboard.WhiteboardApp;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Controller implements Initializable {
    public Button pickerButton;
    public Set<Application> getAppList() {
        return appList;
    }

    public void setAppList(Set<Application> appList) {
        this.appList = appList;
    }

    private Set<Application> appList = new HashSet<Application>();

    public HashMap<Application, Stage> getStageList() {
        return stageList;
    }

    public void setStageList(HashMap<Application, Stage> stageList) {
        this.stageList = stageList;
    }

    private HashMap<Application,Stage> stageList = new HashMap<>();
    /*
    List of all the features that the user is able to pick from the picker
     */
    private List<String> features = List
            .of("Calculator","Dictionary","Pomodoro Timer","Whiteboard","Notes");

    public void pickOptions(ActionEvent event) throws IOException {
        PickerApp picker = new PickerApp();
        Stage pick = new Stage();
        picker.start(pick);
        appList.clear();
        closeAllCurrentStages();
        pick.setOnCloseRequest(e->{
            sdb.Picker.Controller controller = (sdb.Picker.Controller)picker.getLoader().getController();
            Set<String> lisChosen = controller.getLis();
            lisChosen.forEach(feature ->{
                appList.add(getAppOfFeature(feature));
                pick.close();
            });
            Platform.runLater(()->refreshStages());
        });

    }

    private void closeAllCurrentStages() {

    }

    /*
    Everytime a new selection is made, this method refreshes the stageList Map
    The stageList Map assigns each application to its stage
     */
    private void refreshStages() {
        stageList.forEach((app,stage)->{
            stage.close();
        });
        stageList.clear();
        appList.forEach(app->{
            if(!stageList.containsKey(app)) {
                Stage stage = new Stage();
                stageList.put(app, stage);
            }
            System.out.println(app.toString());
        });
        stageList.forEach((app,stage)->{
                try {
                    app.start(stage);
                } catch (Exception e) {
                }
        });
    }

    private Application getAppOfFeature(String feature) {
        switch (feature) {
            case "Calculator":
                return new CalculatorApp();
            case "Dictionary":
                return new DictionaryApp();
            case "Pomodoro Timer":
                return new TimerApp();
            case "White Board":
                return new WhiteboardApp();
            case "Notetaking":
                return new NotesApp();
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
