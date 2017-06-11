package view;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LetterWidget extends VBox{

	public LetterWidget(String cipherLetter, String plaintextLetter){
		super(new Button(cipherLetter), new Text(plaintextLetter));
	}
	
	public void changeLetter(String letter){
		this.getChildren().remove(this.lookup(".text"));
		this.getChildren().add(new Text(letter));
	}
	
	public void removeLetter(){
		try{
			this.getChildren().remove(this.lookup(".text"));
		}
		catch(Exception e){}
	}
}