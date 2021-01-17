package sdb.Notes;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller implements Initializable {


    public TextArea fileContent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void writeToFile() throws IOException {
        FileChooser chooser = getChooser();
        SimpleDateFormat formatter = new SimpleDateFormat("DDyyMM-hhmmss");
        String date = formatter.format(new Date(System.currentTimeMillis()));
        Stage save = getSaveDialogue();
        File file = new File(String.valueOf(chooser.showSaveDialog(save)));
        file.createNewFile();
        new FileWriter(file,true).append(fileContent.getText()).close();
    }

    private Stage getSaveDialogue() {
        Stage temp = new Stage();
        temp.setTitle("Save");
        temp.setAlwaysOnTop(true);
        return temp;
    }

    private FileChooser getChooser() {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("C:\\Users\\Samrat- Birat\\Desktop\\Portfolio\\Databases\\StudyDashBoard"));
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files",".txt"));
        return chooser;
    }
}
