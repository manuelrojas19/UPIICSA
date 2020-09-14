package cap16.Advanced_JavaFx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RedCircle extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		final double WIDTH = 400;
		final double HEIGHT = 400;

		Circle circle = new Circle(WIDTH / 2, HEIGHT / 2, 20, Color.RED);

		Text heading = new Text(WIDTH / 2 - 50, 20, "ññ");
		Text message = new Text(WIDTH / 2 - 40, HEIGHT - 20, "");

		Group root = new Group(heading, circle, message);
		Scene scene = new Scene(root, WIDTH, HEIGHT, Color.YELLOW);
		
		scene.setOnMouseMoved(e -> {
			circle.setCenterX(e.getX()-50);
			circle.setCenterY(e.getY()-50);
		});
		
		scene.setOnMouseDragged(e -> {
			circle.setCenterX(e.getX()-50);
			circle.setCenterY(e.getY()-50);
		});
		
		scene.setOnMousePressed(e -> message.setText("Keep trying!!!"));
		scene.setOnMouseReleased(e -> message.setText(""));


		primaryStage.setScene(scene);
		primaryStage.setTitle("Red Circle");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
