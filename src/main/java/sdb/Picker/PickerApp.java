package sdb.Picker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class PickerApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private Scene scene;

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    private FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/Picker.fxml"));


    public Set<String> getLisChosen() {
        return lisChosen;
    }

    public void setLisChosen(Set<String> lisChosen) {
        this.lisChosen = lisChosen;
    }

    private Set<String> lisChosen;
    @Override
    public void start(Stage primaryStage) throws IOException {
        scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e->{
            Controller controller = loader.getController();
            lisChosen = controller.getLis();
        });
    }
}

