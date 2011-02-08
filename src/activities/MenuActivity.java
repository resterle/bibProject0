package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.MainMenuModel;
import model.picsMapper;

import controller.Controller;

import view.Activity;

public class MenuActivity extends Activity {
	
	public static final String PARAM_MENUITEM = "menuitem";

	public MenuActivity(Controller controller) {
		super(controller);
	}

	@Override
	public void start() {
		
		setLayout(new GridLayout(5, 1));
		
		JButton newGameB = new JButton(new ImageIcon(picsMapper.NEW_GAME_BUTTON));
		newGameB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.NEW_GAME);
				returnData();
			}
		});
		add(newGameB);
		
		JButton highscoreB = new JButton(new ImageIcon(picsMapper.HIGHSCORE_BUTTON));
		highscoreB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.HIGHSCORE);
				returnData();
			}
		});
		add(highscoreB);
		
		JButton optionsB = new JButton(new ImageIcon(picsMapper.OPTIONS_BUTTON));
		optionsB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.OPTIONS);
				returnData();
			}
		});
		add(optionsB);
		
		JButton creditsB = new JButton(new ImageIcon(picsMapper.CREDITS_BUTTON));
		creditsB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnParams.addParameter(PARAM_MENUITEM, MainMenuModel.CREDITS);
				returnData();
			}
		});
		add(creditsB);
		
		JButton quitB = new JButton(new ImageIcon(picsMapper.QUIT_BUTTON));
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
