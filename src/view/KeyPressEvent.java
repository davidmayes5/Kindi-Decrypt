package view;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

public class KeyPressEvent implements EventHandler<KeyEvent> {

	Paragraph _paragraph;
	LetterWidget _letterWidget;

	public KeyPressEvent(Paragraph paragraph, LetterWidget letterWidget) {
		_letterWidget = letterWidget;
		_paragraph = paragraph;
	}

	@Override
	public void handle(KeyEvent keyEvent) {
		String input = keyEvent.getText();
		LetterWidget[] letterWidgetArray = _paragraph.getLetterWidgetArray();
		for (LetterWidget letterWidget : letterWidgetArray) {
			if (letterWidget.getLetter().equals(_letterWidget.getLetter())) {
				letterWidget.getChildren().remove(1);
				letterWidget.getChildren().add(1, new Text("   " + input));
			}
		}
	}
}
