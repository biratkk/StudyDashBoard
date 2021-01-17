package sdb.Whiteboard;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ColorPicker colorPicker;
    public Canvas canvas;
    GraphicsContext gc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
        colorPicker.setValue(Color.BLACK);
        gc.setStroke(colorPicker.getValue());
    }

    public void mousePressed(MouseEvent mouseEvent) {
        gc.beginPath();
        gc.lineTo(mouseEvent.getSceneX(), mouseEvent.getSceneY());
        gc.stroke();
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        gc.lineTo(mouseEvent.getSceneX(), mouseEvent.getSceneY());
        gc.stroke();
    }

    public void changeColour(ActionEvent event) {
        gc.setStroke(colorPicker.getValue());
    }
}
