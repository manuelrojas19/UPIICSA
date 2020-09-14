package cap20.Multi_Threading;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.TextArea;

public class NumbersService extends Service<Void> {

	private TextArea display;
	private boolean go;

	public NumbersService(TextArea displayIn) {
		display = displayIn;
	}

	@Override
	protected Task<Void> createTask() {
		return new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				go = true;
				int count = 0;

				while (go) {
					display.appendText("" + count);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {

					}

					count++;
					if (count > 9) {
						count = 0;
						display.appendText("\n");
					}
				}
				return null;
			};

		};
	}
	
	public void finish() {
		
		display.appendText("\n");
		go = false;
	}

}