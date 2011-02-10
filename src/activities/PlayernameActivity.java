package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.PicsMapper;

import controller.Controller;
import view.Activity;

public class PlayernameActivity extends Activity {

	//Keys for returning Values to Controller
	public final static String RETURN_NAME = "DefaultName";
	public final static String RETURN_GALLARY = "gallary";

	//Keys for receiving Values from Controller
	public final static String PARAMS_NAME = "DefaultName";
	
	
	//Text Field with the length of 15 chars
	JTextField playerName = new JTextField(15);
	
	
	public PlayernameActivity(Controller controller) {
		super(controller);
	}
	
	public void start(){
		
		
		
		
		//Buttons declaration
		JButton gallaryB = new JButton("Gallary");
		gallaryB.setBounds(100, 100 , 250, 100 );
		JButton ownPicB = new JButton("Use own Picture");
		ownPicB.setBounds(100, 250 , 250, 100 );
		JButton backB = new JButton(new ImageIcon(PicsMapper.OKAY_BUTTON));
		backB.setBounds(280, 450 , 250, 100 );
		//Label declaration
		JLabel nameL = new JLabel("Enter your name: ");
		
		
		//If player name is null it's setting it to a Default
		//Else it puts the Name of the last player in
		if (null == params.getValue(PARAMS_NAME)){			
			playerName.setText(PARAMS_NAME);
		}
		else{
			playerName.setText((String)params.getValue(PARAMS_NAME));
		}
		
		
		//Layout declaration
		JPanel enterName = new JPanel();
		JPanel Buttons = new JPanel();
		
		enterName.add(nameL);
		enterName.add(playerName);
		
		Buttons.add(gallaryB);
		Buttons.add(ownPicB);
		
		
		add(enterName);
		add(Buttons);
		add(backB);
		
		
		//Action what the Buttons shall return to Controller as soon as they are pushed
		gallaryB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
				returnParams.addParameter(RETURN_GALLARY, true);
				returnName();	
				
			}
		});
		
		ownPicB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
				returnParams.addParameter(RETURN_GALLARY, false);
				returnName();
				
			}
		});
		
		//Button to get Back
		backB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				returnData();
				
			}
		});
		
		
		
		
		
	}
	
	
	//Method to return the players name to the Controller
	private void returnName(){
		
		returnParams.addParameter(RETURN_NAME, playerName.getText());
		returnData();
		
	}
	
	

}
