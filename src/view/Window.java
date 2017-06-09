package view;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Window extends Application{
	
	private int _width;
	private int _height;
	private int _padding;
	
	public Window(){
		_width = 800;
		_height = 600;
		_padding = 25;
	}

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
    public void start(Stage window) {
        window.setTitle("Kindi Decrypt");
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(_padding, _padding, _padding, _padding));
        TextArea inputField = new TextArea();
        inputField.setMinSize(_width - (2*_padding), _height/2);
        Text initMessage = new Text("Please enter the ciphertext:");
        
        gridPane.add(initMessage, 0, 0);
        gridPane.add(inputField, 0, 1);
        
        Scene scene = new Scene(gridPane, _width, _height);
        window.setScene(scene);
        window.show();
    }
}