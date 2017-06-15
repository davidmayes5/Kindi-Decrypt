package view;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LetterWidget extends VBox{
	private String _letter;
	private Button _button;

	public LetterWidget(LetterButton button, String plaintextLetter) {
		super(button.getLetter().equals(" ") ? new Text("     ")
				: button,
				new Text(plaintextLetter), new Text(" "));
		_letter = button.getLetter();
		_button = button;
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

	public String getLetter() {
		return _letter;
	}

	public Button getButton() {
		return _button;
	}
}
