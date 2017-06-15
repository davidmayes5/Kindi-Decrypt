package view;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Paragraph extends FlowPane{
	
	VBox[] _letterWidgetArray;

	public Paragraph(VBox[] letterWidgetArray, Pane pane) {
		this.setMinWidth(pane.getWidth() - (2 * Window.PADDING));
		for(VBox letterWidget : letterWidgetArray){
			this.getChildren().addAll(letterWidget);
		}

		_letterWidgetArray = letterWidgetArray;
	}

	public VBox[] getLetterWidgetArray() {
		return _letterWidgetArray;
	}

}
