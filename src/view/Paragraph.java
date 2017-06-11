package view;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Paragraph extends FlowPane{
	
	public Paragraph(VBox[] letterWidgetArray){
		for(VBox letterWidget : letterWidgetArray){
			this.getChildren().addAll(letterWidget);
		}
	}

}
