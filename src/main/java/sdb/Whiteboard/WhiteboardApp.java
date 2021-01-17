package sdb.Whiteboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WhiteboardApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Whiteboard.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
}
