package view;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.GameModel;

public class View extends JFrame{
	
	
	private Container mainCon;
	
	public View(String name){
		
		super(name);
		
		mainCon = getContentPane();
		
		// Set default Windowparameters.
	
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public ParameterList startActivity(Activity activity, ParameterList params){
		
		ParameterList returnParams = activity.run(params);
		mainCon.removeAll();
		mainCon.add(activity);
		mainCon.validate();
		
		return returnParams;
		
	}
	
}
