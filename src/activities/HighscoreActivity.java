package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		ArrayList<String> users = (ArrayList<String>) params.getValue(PARAM_USERS);
		ArrayList<Integer> scores = (ArrayList<Integer>) params.getValue(PARAM_SCORES);
		
		setLayout(null);
		
		JLabel optionLabel = new JLabel("Options");
		JButton okButton = new JButton("ok");
		
		okButton.setBounds(280, 450 , 250, 100 );

		
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
