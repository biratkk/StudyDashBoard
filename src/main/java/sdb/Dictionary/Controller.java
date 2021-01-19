package sdb.Dictionary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.paint.Paint;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Controller implements Initializable {
    public Label word;
    public Label definition;
    public TextField textField;

    public void enterReleased(KeyEvent keyEvent) throws IOException {
        if (keyEvent.getCode() == KeyCode.ENTER)
            doSearch();
    }

    private void doSearch() throws IOException {
        /*
        Using the unofficial google dictionary API in order to fetch data as a String JSON
         */
        Document doc = Jsoup.connect("https://api.dictionaryapi.dev/api/v2/entries/en/" + textField.getText())
                .ignoreContentType(true)
                .get();
        String json = doc.body().text();
        System.out.println(json);
        setDefinition(json);
    }

    private void setDefinition(String json) {
        json = json.substring(1,json.length()-1);
        JSONObject obj = new JSONObject(json);
        String word = obj.getString("word");
        JSONArray def =  obj.getJSONArray("meanings");
        JSONObject def1 = (JSONObject) def.get(0);
        JSONObject def2 = (JSONObject) def1.getJSONArray("definitions").get(0);
        String definition = def2.getString("definition");
        System.out.println(word+": "+definition);
        this.word.setText(word);
        this.definition.setText(definition);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        word.setText("");
        definition.setText("");
        word.setTextFill(Paint.valueOf("White"));
        definition.setTextFill(Paint.valueOf("White"));
    }
}
