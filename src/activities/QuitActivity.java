package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.MainMenuModel;
import model.PicsMapper;

import controller.Controller;
import view.Activity;

public class QuitActivity extends Activity {
	
	public static final String RETURN_QUIT = "quit";
	
	public QuitActivity(Controller controller) {
		super(controller);
		
	}

	public void start() {
		
		//GridLayout with 2 Buttons
		setLayout(null);
	
		int posY = 400;
		int buttonHeight = 100;
		int buttonWidth = 250;
		
		
		//Button No
		JButton newNoB = new JButton(new ImageIcon(PicsMapper.NO_BUTTON));
		newNoB.setBounds(100, posY, buttonWidth, buttonHeight);
		newNoB.addActionListener(new ActionListener() {
			
			//The Button No returns a false
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(RETURN_QUIT, false);
				returnData();
			}
		});
		add(newNoB);
		
		//Button Yes
		JButton newYesB = new JButton(new ImageIcon(PicsMapper.YES_BUTTON));
		newYesB.setBounds(400, posY, buttonWidth, buttonHeight);
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
