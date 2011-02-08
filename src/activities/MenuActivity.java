package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.MainMenuModel;

import controller.Controller;

import view.Activity;

public class MenuActivity extends Activity {
	
	

	public MenuActivity(Controller controller) {
		super(controller);
	}

	@Override
	public void start() {
		
		setLayout(new GridLayout(5, 1));
		
		JButton newGameB = new JButton("new Game");
		newGameB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("menu", MainMenuModel.NEW_GAME);
				returnData();
			}
		});
		add(newGameB);
		
		JButton highscoreB = new JButton("Highscore");
		highscoreB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("menu", MainMenuModel.HIGHSCORE);
				returnData();
			}
		});
		add(highscoreB);
		
		JButton optionsB = new JButton("Options");
		optionsB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("menu", MainMenuModel.OPTIONS);
				returnData();
			}
		});
		add(optionsB);
		
		JButton creditsB = new JButton("credits");
		creditsB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("menu", MainMenuModel.CREDITS);
				returnData();
			}
		});
		add(creditsB);
		
		JButton quitB = new JButton("Quit");
		quitB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter("menu", MainMenuModel.QUIT);
				returnData();
			}
		});
		
		add(quitB);
			
	}
	
	
}
