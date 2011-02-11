package activities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.PicsMapper;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class CreditsActivity extends Activity {

	public CreditsActivity(Controller controller) {
		super(controller);
	}

	public void start(){
		
		setLayout(null);
		
		ImageButton newBackB = new ImageButton(PicsMapper.CREDITS_BACKGROUNG);
		newBackB.setBounds(0, 0, 800, 600);
		
		
		add(newBackB);
		
		newBackB.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				returnData();
				
			}
		});
		add(newBackB);
		
		
	}
	
	
}
