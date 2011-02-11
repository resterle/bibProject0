package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.PicsMapper;

import controller.Controller;
import view.Activity;

public class HighscoreActivity extends Activity{

	public static final String PARAM_USERS = "users";
	public static final String PARAM_SCORES = "scores";
	
	public HighscoreActivity(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void start() {
		
		setLayout(null);
		
		JLabel optionLabel = new JLabel(new ImageIcon(PicsMapper.TEXT_HIGHSCORE));
		optionLabel.setBounds(260, 0 , 250, 100 );
		JButton okButton = new JButton(new ImageIcon(PicsMapper.OKAY_BUTTON));
		okButton.setBounds(270, 450 , 250, 100 );
		
		ArrayList<String> users = (ArrayList<String>) params.getValue(PARAM_USERS);
		ArrayList<Integer> scores = (ArrayList<Integer>) params.getValue(PARAM_SCORES);
		
		
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				returnData();
			}
		});
		
		if(users.size()==scores.size()){
			JPanel highscoreLabel = new JPanel(new GridLayout(users.size(), 2));
			for(int i=0; i<users.size(); i++){
				highscoreLabel.add(new JLabel(users.get(i)));
				highscoreLabel.add(new JLabel(String.valueOf(scores.get(i))));
			}
			add(optionLabel);
			add(highscoreLabel);
			add(okButton);
		}
	
	}

}
