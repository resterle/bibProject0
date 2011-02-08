package activities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controller.Controller;
import view.Activity;

public class CreditsActivity extends Activity {

	public CreditsActivity(Controller controller) {
		super(controller);
	}

	public void start(){
		
		JButton newBackB = new JButton(new ImageIcon("pics/credits.png"));
		newBackB.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				returnData();
				
			}
		});
		add(newBackB);
		
		
	}
	
	
}
