package sdb.Notes;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class NotesApp extends Application {

    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Notes.fxml"));
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Controller controller = loader.getController();
                try {
                    controller.writeToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
