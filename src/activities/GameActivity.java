package activities;

import java.awt.GridLayout;
import java.awt.Image;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class GameActivity extends Activity {
	
	public static final String PARAMS_PIC = "pic";
	
	public GameActivity(Controller controller) {
		super(controller);
	}
	
	@Override
	public void start() {
		setLayout(new GridLayout(1, 1));
		add(new ImageButton((Image)params.getValue(PARAMS_PIC)));
	}

}
