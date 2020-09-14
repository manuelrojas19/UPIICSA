package cap20.Multi_Threading;

import javafx.concurrent.Task;
import javafx.scene.shape.Arc;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FaceTask extends Task<Void> {
	
	private Arc arc;
	private Stage stage;
	private Text text;
	
	public FaceTask(Arc arc, Stage stage, Text text) {
		this.arc = arc;
		this.stage = stage;
		this.text = text;
	}

	@Override
	protected Void call() throws Exception {
		
		while(stage.isShowing()) {
			arc.setLength(-180);
			text.setText("Cara feliz");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			
			arc.setLength(180);
			text.setText("Cara triste");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		
		return null;
	}
 
}
