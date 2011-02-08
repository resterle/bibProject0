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
		// TODO Auto-generated constructor stub
	}

	public void start() {
		
		setLayout(new GridLayout(5, 1));
	
		JButton newNoB = new JButton("No");
		newNoB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("quit", false);
				returnData();
			}
		});
		
		JButton newYesB = new JButton("Yes");
		newYesB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("quit", true);
				returnData();
			}
		});
	}
	
	
}
