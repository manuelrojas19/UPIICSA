package cap16.Advanced_JavaFx;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SliderExample extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		final double horizSliderWidth = 300;
		final double vertSliderHeight = 300;
		
		Rectangle rectangle = new Rectangle(0, 0, Color.DARKBLUE);
		
		DecimalFormat df = new DecimalFormat("0.0");
		
		Slider vertSlider = new Slider(0, 20, 0);
		vertSlider.setMinHeight(vertSliderHeight);
		vertSlider.setShowTickMarks(true);
		vertSlider.setShowTickLabels(true);
		vertSlider.setSnapToTicks(true);
		vertSlider.setMajorTickUnit(5.0);
		vertSlider.setMinorTickCount(10);
		vertSlider.setOrientation(Orientation.VERTICAL);
		
		Slider horizSlider = new Slider(0, 10, 0);
		horizSlider.setMinWidth(horizSliderWidth);
		horizSlider.setShowTickMarks(true);
		horizSlider.setShowTickLabels(true);
		vertSlider.setSnapToTicks(true);
		vertSlider.setMajorTickUnit(1.0);
		vertSlider.setMinorTickCount(4);
		
		Label horizLabel = new Label("El ancho del cuadrado es: 0.0");
		Label vertLabel = new Label("El ancho del rectangulo es: 0.0");
		
		vertSlider.valueProperty().addListener((obsValue, oldValue, newValue) -> {
			vertLabel.setText("El ancho del rectangulo es: " + df.format(newValue));
			rectangle.setHeight((double) newValue * 12 );
		});
		
		horizSlider.valueProperty().addListener((obsValue, oldValue, newValue) -> {
			horizLabel.setText("El añcho del cuadrado es: " + df.format(newValue));
			rectangle.setWidth((double) newValue * 30);
		});
		
		VBox vertBox = new VBox(10);
		vertBox.setAlignment(Pos.BOTTOM_LEFT);
		vertBox.setMinWidth(horizSliderWidth/3);
		vertBox.getChildren().addAll(vertSlider, vertLabel);

		VBox horizBox = new VBox(10);
		horizBox.setAlignment(Pos.BOTTOM_LEFT);
		horizBox.getChildren().addAll(rectangle, horizSlider, horizLabel);
		
		HBox root = new HBox(30);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.getChildren().addAll(horizBox, vertBox);

		Scene scene = new Scene(root, 580, 380);
		stage.setScene(scene);
		stage.setTitle("Slider Example");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
