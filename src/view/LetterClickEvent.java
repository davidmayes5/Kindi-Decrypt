package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class LetterClickEvent implements EventHandler<ActionEvent> {

	private Paragraph _paragraph;
	private LetterWidget _letterWidget;

	public LetterClickEvent(Paragraph paragraph, LetterWidget letterWidget) {
		_paragraph = paragraph;
		_letterWidget = letterWidget;
	}

	@Override
	public void handle(ActionEvent event) {
		_letterWidget.getButton().setOnKeyPressed(new KeyPressEvent(_paragraph, _letterWidget));
	}

}
