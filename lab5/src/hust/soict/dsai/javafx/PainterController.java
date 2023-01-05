package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

public class PainterController {
	private Color currentColor = Color.BLACK;//but ve mau den 
	
    @FXML
    private Pane drawingAreaPane; //khu vuc ve

    @FXML
    private RadioButton penOption;//chon ve

    @FXML
    private RadioButton eraserOption; //chon xoa

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle newCircle = new Circle(event.getX(), event.getY(), 4, currentColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }
    
    @FXML//doi den neu ve
    void selectPen(ActionEvent event) {
    	currentColor = Color.BLACK;
    	System.out.println(event);
    }
   
    @FXML//doi mau muc sang trang neu xoa
    void selectEraser(ActionEvent event) {
    	currentColor = Color.WHITE;
    	System.out.println(event);
    }
   
    @FXML//nhan clear xoa het
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }
}