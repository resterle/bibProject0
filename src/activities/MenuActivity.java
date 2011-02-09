package activities;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.MainMenuModel;
import model.PicsMapper;


import controller.Controller;

import view.Activity;

public class MenuActivity extends Activity {
	
	public static final String PARAM_MENUITEM = "menuitem";

	public MenuActivity(Controller controller) {
		super(controller);
	}

	@Override
	public void start() {
		
		setLayout(null);
		
		JButton newGameB = new JButton(new ImageIcon(PicsMapper.NEW_GAME_BUTTON));
		newGameB.setBounds(0, 0, 200, 50);
		newGameB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.NEW_GAME);
				returnData();
			}
		});
		add(newGameB);
		
		JButton highscoreB = new JButton(new ImageIcon(PicsMapper.HIGHSCORE_BUTTON));
		highscoreB.setBounds(0, 10, 200, 50);
		highscoreB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.HIGHSCORE);
				returnData();
			}
		});
		add(highscoreB);
		
		JButton optionsB = new JButton(new ImageIcon(PicsMapper.OPTIONS_BUTTON));
		optionsB.setBounds(0, 20, 200, 50);
		optionsB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.OPTIONS);
				returnData();
			}
		});
		add(optionsB);
		
		JButton creditsB = new JButton(new ImageIcon(PicsMapper.CREDITS_BUTTON));
		creditsB.setBounds(0, 30, 200, 50);
		creditsB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.CREDITS);
				returnData();
			}
		});
		add(creditsB);
		
		JButton quitB = new JButton(new ImageIcon(PicsMapper.QUIT_BUTTON));
		quitB.setBounds(0, 40, 200, 50);
		quitB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.QUIT);
				returnData();
			}
		});
		
		add(quitB);
			
	}
	
	
}
