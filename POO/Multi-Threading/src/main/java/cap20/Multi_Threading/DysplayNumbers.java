package cap20.Multi_Threading;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class DysplayNumbers extends Application {
	private boolean go;

	@Override
	public void start(final Stage stage) throws Exception {
		Button startButton = new Button("Start");
		Button stopButton = new Button("Stop");

		startButton.setOnAction(e -> {
			go = true;
			// create a separate thread
			Thread thread1 = new Thread(() -> {
				int count = 0;
				while (go) {
					System.out.print(count);
					try {
						Thread.sleep(10);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					count++;
					if (count > 9) {
						// reset the counter and start a newcount = 0;
						System.out.println();
					}
				}
			});
			thread1.start();

			Thread thread2 = new Thread(() -> {
				int count = 0;
				while(go) {
					System.out.print((char) (65 + count));
					count++;
					if(count > 9) {
						count = 0;
						System.out.println();
					}
				}
			});
			thread2.start();
		});
		stopButton.setOnAction(e -> go = false);

		HBox root = new HBox(10);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(startButton, stopButton);
		Scene scene = new Scene(root, 250, 100);
		stage.setScene(scene);
		stage.setTitle("Numbers");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
