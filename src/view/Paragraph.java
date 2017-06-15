package view;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class Paragraph extends FlowPane{
	
	LetterWidget[] _letterWidgetArray;

	public Paragraph(LetterWidget[] letterWidgetArray, Pane pane) {
		this.setMinWidth(pane.getWidth() - (2 * Window.PADDING));
		for (LetterWidget letterWidget : letterWidgetArray) {
			this.getChildren().addAll(letterWidget);
			letterWidget.getButton().setOnAction(new LetterClickEvent(this, letterWidget));
		}

		_letterWidgetArray = letterWidgetArray;
	}

	public LetterWidget[] getLetterWidgetArray() {
		return _letterWidgetArray;
	}

}
