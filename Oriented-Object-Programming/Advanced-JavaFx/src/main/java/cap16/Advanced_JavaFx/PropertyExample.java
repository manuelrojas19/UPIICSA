package cap16.Advanced_JavaFx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyExample extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		TextField top = new TextField();
		TextField bottom = new TextField();
		top.setMaxWidth(420);
		bottom.setMaxWidth(420);
		
		bottom.textProperty().bindBidirectional(top.textProperty());
		
		VBox root = new VBox(10);
		root.getChildren().addAll(top, bottom);
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 480, 200);
		stage.setScene(scene);
		stage.setTitle("Property Example");
		stage.show();


	}

	public static void main(String[] args) {
		launch(args);

	}

}
