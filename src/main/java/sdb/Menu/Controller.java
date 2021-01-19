package sdb.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class Controller implements Initializable {

    public Button calculator;
    public Button dictionary;
    public Button notes;
    public Button timer;
    public Button whiteboard;
    public List<Button> buttonList;
    public List<Image> imgList = new ArrayList<>();
    public StackPane showScene;
    public AnchorPane rootPane;


    private FXMLLoader loader;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonList = Arrays.asList(calculator, dictionary, notes, timer, whiteboard);
        showScene.alignmentProperty().setValue(Pos.CENTER);
    }

    public void calcButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Calculator.fxml"));
        Node temp = loader.load();
        showScene.getChildren().clear();
        showScene.getChildren().add(temp);
    }

    public void dictButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Dictionary.fxml"));
        Node temp = loader.load();
        showScene.getChildren().clear();
        showScene.getChildren().add(temp);
    }

    public void notesButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Notes.fxml"));
        Node temp = loader.load();
        showScene.getChildren().clear();
        showScene.getChildren().add(temp);
    }

    public void timerButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Timer.fxml"));
        Node temp = loader.load();
        showScene.getChildren().clear();
        showScene.getChildren().add(temp);
    }

    public void boardButton(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Views/Whiteboard.fxml"));
        Node temp = loader.load();
        showScene.getChildren().clear();
        showScene.getChildren().add(temp);
    }
}
