package activities;

import java.awt.GridLayout;

import javax.swing.JLabel;

import model.ParameterList;
import model.PicsMapper;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class LoadingActivity extends Activity{
	
	public static final String PARAM_MESSAGE = "message"; 
	
	public LoadingActivity(Controller controller) {
		super(controller);
	}
	
	@Override
	public void start() {
		setLayout(null);
		ImageButton loading = new ImageButton(PicsMapper.TEXT_LOADING);
		loading.setBounds(280, 225, 300, 300);
		add(loading);
	}
	
}
