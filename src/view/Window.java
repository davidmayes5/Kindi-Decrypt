package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window extends Application{
	
	private int _width;
	private int _height;
	public static int PADDING;
	
	public Window(){
		_width = 800;
		_height = 600;
		PADDING = 25;
	}

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
    public void start(Stage window) {
        window.setTitle("Kindi Decrypt");
        
        BorderPane pane = new BorderPane();
        pane.setMinSize(_width, _height);
        
        GridPane topGrid = new GridPane();
        GridPane centerGrid = new GridPane();
        GridPane bottomGrid = new GridPane();
        topGrid.setMinSize(_width, 10);
        centerGrid.setMaxSize(_width, _height/2);
        bottomGrid.setMinSize(_width, 10);
		topGrid.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		centerGrid.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
		bottomGrid.setPadding(new Insets(PADDING, PADDING, PADDING, PADDING));
        
        // title message
        Text initMessage = new Text("Please enter the ciphertext:");
        topGrid.setAlignment(Pos.CENTER_LEFT);
        topGrid.add(initMessage, 0, 0);
        
        // user input area for ciphertext
        TextArea inputField = new TextArea();
		inputField.setMinSize(_width - (2 * PADDING), _height / 2);
        centerGrid.add(inputField, 0, 0);
        
        // button to format the ciphertext for user manipulation (i.e. decryption)
		Button formatButton = new Button("Format");
		formatButton.setId("populate");
		formatButton.setOnAction(
				new ButtonClickEvent(inputField, centerGrid, bottomGrid, topGrid));
        bottomGrid.setAlignment(Pos.BOTTOM_RIGHT);
		bottomGrid.add(formatButton, 0, 0);
        
        pane.setTop(topGrid);
        pane.setCenter(centerGrid);
        pane.setBottom(bottomGrid);
        
        Scene scene = new Scene(pane, _width, _height);
        window.setScene(scene);
        window.show();
    }

	public int getWidth() {
		return _width;
	}

	public int getHeight() {
		return _height;
	}

	public int getPadding() {
		return PADDING;
	}
}