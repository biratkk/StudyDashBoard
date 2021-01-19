package sdb.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class Controller implements Initializable {
    public Button pickerButton;
    public Button calculator;
    public Button dictionary;
    public Button notes;
    public Button timer;
    public Button whiteboard;
    // you shouldn't initialize the list here, calculator etc. will be all be null
    public List<Button> buttonList;
    public List<Image> imgList = new ArrayList<>();
    public Pane showScene;
    public AnchorPane rootPane;


    private FXMLLoader loader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonList = Arrays.asList(calculator, dictionary, notes, timer, whiteboard);
    }

    public void calcButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Calculator.fxml"));
        showScene.getChildren().clear();
        showScene.getChildren().add(loader.load());
    }

    public void dictButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Dictionary.fxml"));
        showScene.getChildren().clear();
        showScene.getChildren().add(loader.load());
    }

    public void notesButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Notes.fxml"));
        showScene.getChildren().clear();
        showScene.getChildren().add(loader.load());
    }

    public void timerButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Timer.fxml"));
        showScene.getChildren().clear();
        showScene.getChildren().add(loader.load());
    }

    public void boardButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Whiteboard.fxml"));
        showScene.getChildren().clear();
        showScene.getChildren().add(loader.load());
    }

    public void pickOptions(ActionEvent event) {
    }
}
