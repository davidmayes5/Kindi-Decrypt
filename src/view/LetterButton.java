package view;

import javafx.scene.control.Button;

public class LetterButton extends Button {

	private String _letter;

	public LetterButton(String letter) {
		super(letter);
		_letter = letter;
	}

	public String getLetter() {
		return _letter;
	}
}
