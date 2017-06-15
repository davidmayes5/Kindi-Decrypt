package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LetterClickEvent implements EventHandler<ActionEvent> {

	private Paragraph _paragraph;

	public LetterClickEvent(Paragraph paragraph) {
		_paragraph = paragraph;
	}

	@Override
	public void handle(ActionEvent event) {

	}

}
