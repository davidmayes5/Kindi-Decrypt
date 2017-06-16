package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window extends Application{
	
	private int _width;
	private int _height;
	public static int PADDING;
	
	public Window(){
		_width = 1600;
		_height = 900;
		PADDING = 25;
	}

	public static void main(String[] args){
		launch(args);
	}
	
	@Override
    public void start(Stage window) {
		// Title of the window
        window.setTitle("Kindi Decrypt");
        
		// Menu bar stuff
		MenuBar menuBar = new MenuBar();

		Menu options = new Menu("Options");
		menuBar.getMenus().addAll(options);

		MenuItem countDigraphs = new MenuItem("Count Digraphs");
		options.getItems().addAll(countDigraphs);

		// Interior window stuff
        BorderPane pane = new BorderPane();
		pane.setMinSize(_width, _height - 100);
		pane.setMaxSize(_width, _height - 50);
        
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
        
		// Create the background image
		BackgroundImage backgroundImage = new BackgroundImage(
				new Image("Images/Kindi_Decrypt_Background.png", 1600, 900, false, true),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);

		// Format all this previous stuff into a nice, pretty window
		VBox sceneVBox = new VBox();
		sceneVBox.setBackground(new Background(backgroundImage));
		sceneVBox.getChildren().addAll(menuBar, pane);
		Scene scene = new Scene(sceneVBox, _width, _height);
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