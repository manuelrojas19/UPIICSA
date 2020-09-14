package cap16.Advanced_JavaFx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TextRepeater extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextField textField = new TextField();
		textField.setMaxWidth(250);
		
		Label repeatLabel = new Label();
		repeatLabel.setTextFill(Color.RED);
		repeatLabel.setFont(Font.font("Ariel", 20));
		
		textField.setOnKeyTyped(e -> {
			if(e.getCharacter().equals("\r")) {
				repeatLabel.setText("Tu escribiste: " + textField.getText());
				textField.setText("");
			} else {
				repeatLabel.setText("Ultimo caracter escrito: " + e.getCharacter());
			}
		});
		
		VBox root = new VBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		
		root.getChildren().addAll(textField, repeatLabel);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Repeat");
		primaryStage.setHeight(150);
		primaryStage.setWidth(350);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
