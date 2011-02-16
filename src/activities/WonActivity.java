package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.PicsMapper;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class WonActivity extends Activity {

	public WonActivity(Controller controller) {
		super(controller);
	}
	
	public final static String PARAMS_NAME = "DefaultName";
	public final static String PARAMS_TIME = "time";
	
	public void start(){
		
		//Grid Layout
		setLayout(null);
		
		ImageButton won = new ImageButton(PicsMapper.TEXT_WIN);
		won.setBounds(200, 50, 300, 300);
		
		//A JLabel for the username and time needed to win
		JLabel youWonL = new JLabel("You won " + params.getValue(PARAMS_NAME) + ". You made it in " + params.getValue(PARAMS_TIME) + " seconds!");
		youWonL.setBounds(270, 150, 300, 300);
		add(youWonL);
		
		//Button with the Text: OK
		ImageButton newOkB = new ImageButton(PicsMapper.OKAY_BUTTON);
		newOkB.setBounds(270, 450 , 250, 100 );
		newOkB.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				returnData();
				
			}
		});
		add(won);
		add(newOkB);
		
		
		
	}

}
