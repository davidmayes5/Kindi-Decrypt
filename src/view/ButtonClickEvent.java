package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ButtonClickEvent implements EventHandler<ActionEvent>{

	private String _ciphertext;
	private TextArea _inputField;
	private Pane _pane;
	private Pane _titlePane;
	private Pane _buttonPane;

	public ButtonClickEvent(TextArea inputField, Pane pane, Pane buttonPane, Pane titlePane) {
		_inputField = inputField;
		_pane = pane;
		_buttonPane = buttonPane;
		_titlePane = titlePane;
	}

	public ButtonClickEvent(String ciphertext, Pane pane, Pane buttonPane, Pane titlePane) {
		_ciphertext = ciphertext;
		_pane = pane;
		_buttonPane = buttonPane;
		_titlePane = titlePane;
	}

	@Override
	public void handle(ActionEvent event) {
		if(_buttonPane != null){
			if (((Control) event.getSource()).getId().equals("populate") && _pane != null
					&& _inputField != null) {
				String ciphertext = _inputField.getParagraphs().toString();
				ciphertext = ciphertext.substring(1, ciphertext.length() - 1);
				LetterWidget[] letterWidgetArray = new LetterWidget[ciphertext.length()];
				for (int i = 0; i < ciphertext.length(); i++) {
					letterWidgetArray[i] = new LetterWidget(String.valueOf(ciphertext.charAt(i)),
							" ");
				}
				_pane.getChildren().clear();
				Paragraph paragraph = new Paragraph(letterWidgetArray, _pane);
				_pane.getChildren().add(paragraph);
				_titlePane.getChildren().clear();
				_buttonPane.getChildren().clear();
				Button clear = new Button("Clear");
				clear.setId("clear");
				clear.setOnAction(new ButtonClickEvent(ciphertext, _pane, _buttonPane, _titlePane));
				_buttonPane.getChildren().add(clear);
			}
			else if (((Control) event.getSource()).getId().equals("clear") && _ciphertext != null
					&& _pane != null) {
				_pane.getChildren().clear();
				TextArea inputField = new TextArea(_ciphertext);
				inputField.setMinWidth(_pane.getWidth() - (2 * Window.PADDING));
				_pane.getChildren().add(inputField);
				_titlePane.getChildren().add(new Text("Please enter the ciphertext:"));
				_buttonPane.getChildren().clear();
				Button format = new Button("Format");
				format.setId("populate");
				format.setOnAction(
						new ButtonClickEvent(inputField, _pane, _buttonPane, _titlePane));
				_buttonPane.getChildren().add(format);
			}
		}
	}

}
