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
	
	public final static String RETURN_PATH = "path";
	
	JTextField playerName = new JTextField(30);
	
	public void start() {
		
		JButton okayB = new JButton("OK");
		
		JLabel nameL = new JLabel("Enter the path of the picture: ");
		
		JPanel pathP = new JPanel();
		
		
		pathP.add(nameL);
		pathP.add(playerName);
		
		setLayout(new GridLayout(2, 1));
		add(pathP);
		add(okayB);
		
		
		okayB.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			
				returnParams.addParameter(RETURN_PATH, playerName.getText());	
				
			}
		});
		
		
		
		
	}

}
