package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.PicsMapper;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class PlayernameActivity extends Activity {

	//Keys for returning Values to Controller
	public final static String RETURN_NAME = "DefaultName";
	public final static String RETURN_GALLARY = "gallary";
	public final static String RETURN_BACK = "back";

	//Keys for receiving Values from Controller
	public final static String PARAMS_NAME = "DefaultName";
	
	
	//Text Field with the length of 15 chars
	JTextField playerName = new JTextField(15);
	
	
	public PlayernameActivity(Controller controller) {
		super(controller);
	}
	
	public void start(){
		
		returnParams.addParameter(RETURN_GALLARY, true);
		
		setLayout(null);
		
		
		//Buttons declaration
		ImageButton gallaryB = new ImageButton(PicsMapper.GALLERY_BUTTON);
		gallaryB.setBounds(150, 150 , 250, 100 );
		ImageButton ownPicB = new ImageButton(PicsMapper.OWN_PICS);
		ownPicB.setBounds(420, 145 , 250, 100 );
		ImageButton backB = new ImageButton(PicsMapper.BLACK_BACK_BUTTON);
		backB.setBounds(150, 450 , 300, 300 );
		//Label declaration
		JLabel nameL = new JLabel("Enter your name: ");
		nameL.setBounds(250, 50 , 200, 20);
		ImageButton howto = new ImageButton(PicsMapper.TEXT_HOW_TO);
		howto.setBounds(500, 280 , 600, 600);
		
		playerName.setBounds(350, 50, 200, 20);
		
		
		
		//If player name is null it's setting it to a Default
		//Else it puts the Name of the last player in
		if (null == params.getValue(PARAMS_NAME)){			
			playerName.setText(PARAMS_NAME);
		}
		else{
			playerName.setText((String)params.getValue(PARAMS_NAME));
		}
		
		
		//Layout declaration

		
		add(nameL);
		add(playerName);
		
		add(gallaryB);
		add(ownPicB);
		
		add(howto);
		
		add(backB);
		
		
		//Action what the Buttons shall return to Controller as soon as they are pushed
		gallaryB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(RETURN_BACK, false);
				returnName();	
			}
		});
		
		ownPicB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
				returnParams.addParameter(RETURN_GALLARY, false);
				returnParams.addParameter(RETURN_BACK, false);
				returnName();
				
			}
		});
		
		//Button to get Back
		backB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(RETURN_BACK, true);
				returnName();
			}
		});
		
		
		
		
		
	}
	
	
	//Method to return the players name to the Controller
	private void returnName(){
		
		returnParams.addParameter(RETURN_NAME, playerName.getText());
		returnData();
		
	}
	
	

}
