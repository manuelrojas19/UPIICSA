package cap20.Multi_Threading;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AnimatedFace extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Circle face = new Circle(118, 125, 80);
		face.setFill(Color.YELLOW);
		face.setStroke(Color.RED);
		
		Circle righEye = new Circle(80, 100, 10);
		righEye.setFill(Color.YELLOW);
		righEye.setFill(Color.BLUE);
		
		Circle leftEye = new Circle(156, 100, 10);
		leftEye.setFill(Color.YELLOW);
		leftEye.setFill(Color.BLUE);
		
		Arc mouth = new Arc(118, 150, 45, 35, 0 ,-10);
		mouth.setFill(Color.YELLOW);
		mouth.setStroke(Color.BLUE);
		mouth.setType(ArcType.OPEN);
		
		Text caption = new Text(60, 240, "Cara animada");
		caption.setFont(Font.font("Verdana", 15));
		caption.setFill(Color.BLUE);
		
		Group root = new Group(face, righEye, leftEye, mouth, caption);
		
		Scene scene = new Scene(root, Color.YELLOW);
		
		stage.setScene(scene);
		stage.setHeight(300);
		stage.setWidth(250);
		stage.setTitle("Cara animada");
		stage.show();
		
		Thread thread1 = new Thread(new FaceTask(mouth, stage, caption));
		thread1.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
