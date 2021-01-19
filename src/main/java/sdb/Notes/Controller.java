package sdb.Notes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
        // try with resources is safer
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.append(fileContent.getText());
        }
        //new FileWriter(file,true).append(fileContent.getText()).close();
    }

    private static Stage getSaveDialogue() {
        Stage temp = new Stage();
        temp.setTitle("Save");
        temp.setAlwaysOnTop(true);
        return temp;
    }

    private static FileChooser getChooser() {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File("C:\\Users\\Samrat- Birat\\Desktop\\Portfolio\\Databases\\StudyDashBoard"));
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files",".txt"));
        return chooser;
    }
}
