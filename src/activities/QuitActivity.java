package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MainMenuModel;

import controller.Controller;
import view.Activity;

public class QuitActivity extends Activity {

	public QuitActivity(Controller controller) {
		super(controller);
		
	}

	public void start() {
		
		//GridLayout with 2 Buttons
		setLayout(new GridLayout(2, 1));
	
		//Button No
		JButton newNoB = new JButton("No");
		newNoB.addActionListener(new ActionListener() {
			
			//The Button No returns a false
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("quit", false);
				returnData();
			}
		});
		add(newNoB);
		
		//Button Yes
		JButton newYesB = new JButton("Yes");
		newYesB.addActionListener(new ActionListener() {
			
			//The Button Yes returns a true
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("quit", true);
				returnData();
			}
		});
		add(newYesB);
	}
	
	
}
