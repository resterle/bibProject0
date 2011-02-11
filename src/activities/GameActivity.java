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
		setLayout(new GridLayout(1, 1));
		Image image = (Image)params.getValue(PARAMS_PIC);
		add(new ImageButton(image));
		System.out.println("size:"+params.getValue(PARAMS_SIZE));
		System.out.println("dif:"+params.getValue(PARAMS_DIF));
	}

}
