package activities;

import java.awt.GridLayout;
import java.awt.Image;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class GameActivity extends Activity {
	
	public static final String PARAMS_PIC = "pic";
	public static final String PARAMS_SIZE = "size";
	public static final String PARAMS_DIF = "dif";
	
	public GameActivity(Controller controller) {
		super(controller);
	}
	
	@Override
	public void start() {
		
		add(new ImageButton((Image) params.getValue(PARAMS_PIC)));
	}

}
