package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import view.Activity;

public class ChoosePicActivity extends Activity {

	public ChoosePicActivity(Controller controller) {
		super(controller);
	}
	
	//Keys for returning Values to Controller
	public final static String RETURN_PATH = "path";
	
	//Text Field with the length of 30 chars
	JTextField playerName = new JTextField(30);
	
	public void start() {
		
		//Declaration of the "OK" Button
		JButton okayB = new JButton("OK");
		
		//JLabel declaration
		JLabel nameL = new JLabel("Enter the path of the picture: ");
		
		//JPanel Declaration
		JPanel pathP = new JPanel();
		
		
		//Layout declaration
		pathP.add(nameL);
		pathP.add(playerName);
		
		setLayout(new GridLayout(2, 1));
		add(pathP);
		add(okayB);
		
		
		//Action Listener to return the Value of the TextFiel to the Controller as soon as the "OK" Button is pressed
		okayB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
				returnParams.addParameter(RETURN_PATH, playerName.getText());	
				
			}
		});
		
		
		
		
	}

}
