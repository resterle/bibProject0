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

	public HighscoreActivity(Controller controller) {
		super(controller);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void start() {
		
		ArrayList<String> users = (ArrayList<String>) params.getValue("users");
		ArrayList<Integer> scores = (ArrayList<Integer>) params.getValue("scores");
		
		setLayout(new GridLayout(3, 1));
		
		JLabel optionLabel = new JLabel("Options");
		JButton okButton = new JButton("ok");
		
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
