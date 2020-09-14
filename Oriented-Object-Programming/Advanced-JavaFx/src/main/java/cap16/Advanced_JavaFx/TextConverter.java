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

public class TextConverter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
			TextField textField = new TextField();
			textField.setMaxWidth(250);
			
			Label label = new Label();
			label.setTextFill(Color.RED);
			label.setFont(Font.font("Ariel", 20));
			
			textField.setOnKeyReleased(e -> {
				label.setText(textField.getText().toUpperCase());
			});
			
			VBox root = new VBox();
			root.setSpacing(10);
			root.setAlignment(Pos.CENTER);
			
			root.getChildren().addAll(textField, label);
			
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Convertidor de texto");
			primaryStage.setHeight(150);
			primaryStage.setWidth(350);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
