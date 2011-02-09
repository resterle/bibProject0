package activities;

import java.awt.GridLayout;

import javax.swing.JLabel;

import controller.Controller;
import view.Activity;
import view.ParameterList;

public class LoadingActivity extends Activity{
	
	public static final String PARAM_MESSAGE = "message"; 
	
	public LoadingActivity(Controller controller) {
		super(controller);
	}
	
	@Override
	public void start() {
		setLayout(new GridLayout(1, 1));
		add(new JLabel((String) params.getValue(PARAM_MESSAGE)));
	}
	
}
