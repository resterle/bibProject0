package activities;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import model.GameModel;

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
		
		int size = 4;
		
		switch((Integer)params.getValue(PARAMS_SIZE)){
			case GameModel.SIZE_6X6:
				size = 6;
			break;
			case GameModel.SIZE_8X8:
				size = 8;
			break;
		}
		
		ArrayList<Image> pics = Graphics.subImage((Image) params.getValue(PARAMS_PIC), (Integer)params.getValue(PARAMS_SIZE), 790, 550);
		
		setLayout(new GridLayout(size, size));
		
		for(int i=0; i<(size*size); i++){
			add(new ImageButton(pics.get(i)));
		}
		
	}

}
