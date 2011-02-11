package activities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.PicsMapper;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class ChoosePicActivity extends Activity {

	public ChoosePicActivity(Controller controller) {
		super(controller);
	}
	
	//Keys for returning Values to Controller
	public final static String RETURN_PATH = "path";
	
	//Text Field with the length of 30 chars
	JTextField playerName = new JTextField(30);
	
	public void start() {
		
		
		setLayout(null);
		
		playerName.setBounds(380, 200, 300, 20);
		
		//Declaration of the "OK" Button
		ImageButton okayB = new ImageButton(PicsMapper.OKAY_BUTTON);
		okayB.setBounds(275, 450 , 250, 100 );
		
		//JLabel declaration
		JLabel nameL = new JLabel("Enter the path of the picture: ");
		nameL.setFont(new Font("Times New Roman",1,20));
		nameL.setBounds(130, 200, 300, 20);
				
		
		//Layout declaration
		add(nameL);
		add(playerName);
		
		add(okayB);
		
		
		//Action Listener to return the Value of the TextFiel to the Controller as soon as the "OK" Button is pressed
		okayB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
				returnParams.addParameter(RETURN_PATH, playerName.getText());	
				returnData();
				
			}
		});
		
		
		
		
	}

}
