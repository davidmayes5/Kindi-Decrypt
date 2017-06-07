package model;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Window extends Application{

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
    public void start(Stage window) {
        window.setTitle("Kindi Decrypt");
        StackPane root = new StackPane();
        window.setScene(new Scene(root, 800, 600));
        window.show();
    }
}