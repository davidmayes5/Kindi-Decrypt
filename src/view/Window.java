package view;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        
        BorderPane pane = new BorderPane();
        pane.setMinSize(_width, _height);
        
        GridPane topGrid = new GridPane();
        GridPane centerGrid = new GridPane();
        GridPane bottomGrid = new GridPane();
        topGrid.setMinSize(_width, 10);
        centerGrid.setMaxSize(_width, _height/2);
        bottomGrid.setMinSize(_width, 10);
        topGrid.setPadding(new Insets(_padding, _padding, _padding, _padding));
        centerGrid.setPadding(new Insets(_padding, _padding, _padding, _padding));
        bottomGrid.setPadding(new Insets(_padding, _padding, _padding, _padding));
        
        // title message
        Text initMessage = new Text("Please enter the ciphertext:");
        topGrid.setAlignment(Pos.CENTER_LEFT);
        topGrid.add(initMessage, 0, 0);
        
        // user input area for ciphertext
        TextArea inputField = new TextArea();
        inputField.setMinSize(_width - (2*_padding), _height/2);
        centerGrid.add(inputField, 0, 0);
        
        // button to format the ciphertext for user manipulation (i.e. decryption)
        Button continueButton = new Button("Continue");
        continueButton.setOnAction(new EventHandler<ActionEvent>(){
        	@Override
        	public void handle(ActionEvent event){
        		String ciphertext = inputField.getParagraphs().toString();
        		ciphertext = ciphertext.substring(1, ciphertext.length() - 1);
        		LetterWidget[] letterWidgetArray = new LetterWidget[ciphertext.length()];
        		for(int i = 0; i < ciphertext.length(); i++){
        			letterWidgetArray[i] = new LetterWidget(String.valueOf(ciphertext.charAt(i)), " ");
        		}
        		Paragraph paragraph = new Paragraph(letterWidgetArray);
        		centerGrid.getChildren().clear();
        		centerGrid.add(paragraph, 0, 0);
        	}
        });
        bottomGrid.setAlignment(Pos.BOTTOM_RIGHT);
        bottomGrid.add(continueButton, 0, 0);
        
        pane.setTop(topGrid);
        pane.setCenter(centerGrid);
        pane.setBottom(bottomGrid);
        
        Scene scene = new Scene(pane, _width, _height);
        window.setScene(scene);
        window.show();
    }
}