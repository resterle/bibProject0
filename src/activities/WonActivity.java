package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import view.Activity;

public class WonActivity extends Activity {

	public WonActivity(Controller controller) {
		super(controller);
	}
	
	public final static String PARAMS_NAME = "DefaultName";
	public final static String PARAMS_TIME = "time";
	
	public void start(){
		
		//Grid Layout
		setLayout(new GridLayout(2,1));
		
		//A JLabel for the username and time needed to win
		JLabel youWonL = new JLabel("You won " + PARAMS_NAME + ". You made it in " + PARAMS_TIME);
		add(youWonL);
		
		//Button with the Text: OK
		JButton newOkB = new JButton("OK");
		newOkB.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				returnData();
				
			}
		});
		add(newOkB);
		
		
		
	}

}
