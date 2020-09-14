package cap20.Multi_Threading;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BackgroundTask extends Application{

	@Override
	public void start(final Stage primaryStage) {
		// TODO Auto-generated method stub
		TextField pushMeTextField = new TextField();
		pushMeTextField.setMaxWidth(250);
		
		Label pushMeLabel = new Label();
		pushMeLabel.setTextFill(Color.RED);
		pushMeLabel.setFont(Font.font("Ariel", 14));
		
		Button pushMeButton = new Button();
		pushMeButton.setText("Ingresa algún texte y clickeame");
		pushMeButton.setOnAction(e -> pushMeLabel.setText("Ingresate: " + pushMeTextField.getText()));
	
		VBox root = new VBox();
		root.setSpacing(10);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(pushMeTextField, pushMeButton, pushMeLabel);
		
		Scene scene = new Scene(root, 350, 150);
		primaryStage.setScene(scene);
		
		primaryStage.setTitle("Actividad en segundo plano");
		primaryStage.show();
		createBackgroundTask(primaryStage);
	}
	
	private void createBackgroundTask(Stage primaryStage) {
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
		
		Stage stage = new Stage();
		
		stage.setScene(scene);
		stage.setHeight(300);
		stage.setWidth(250);
		stage.setTitle("Cara animada");
		
		stage.setX(primaryStage.getX() + 400);
		stage.setY(primaryStage.getY());
		
		stage.show();
		
		Thread thread1 = new Thread(new FaceTask(mouth, stage, caption));
		thread1.start();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
