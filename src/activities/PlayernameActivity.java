package activities;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import view.Activity;

public class PlayernameActivity extends Activity {

	public final static String RETURN_NAME = "DefaultName";
	public final static String RETURN_GALLARY = "gallary";

	public final static String PARAMS_NAME = "DefaultName";
	
	public PlayernameActivity(Controller controller) {
		super(controller);
	}
	
	public void start(){
		
		
		
		
		JButton gallaryB = new JButton("Gallary");
		JButton ownPicB = new JButton("Use own Picture");
		
		JLabel nameL = new JLabel("Enter your name: ");
		
		
		JTextField playerName = new JTextField(15);
		if (null == params.getValue(PARAMS_NAME)){			
			playerName.setText(PARAMS_NAME);
		}
		else{
			playerName.setText((String)params.getValue(PARAMS_NAME));
		}
		
		
		JPanel enterName = new JPanel();
		JPanel Buttons = new JPanel();
		
		enterName.add(nameL);
		enterName.add(playerName);
		
		Buttons.add(gallaryB);
		Buttons.add(ownPicB);
		
		setLayout(new GridLayout(2, 1));
		
		add(enterName);
		add(Buttons);
		
		
		
		
		
	}
	
	

}
