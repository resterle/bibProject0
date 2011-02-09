package activities;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;
import view.Activity;

public class OptionsActivity extends Activity {

	public OptionsActivity(Controller controller) {
		super(controller);
	}
	
	public void start(){
		
		setLayout(new GridLayout(3, 1));
		
		
		JPanel sizeP = new JPanel();
		JPanel sizeOptionsP = new JPanel();		
		JPanel diffP = new JPanel();
		JPanel diffOptionsP = new JPanel();
		
		JLabel youOptionsL = new JLabel("Options");
		JLabel youSizeL = new JLabel("size");		
		JLabel fourL = new JLabel("4x4");
		JLabel sixL = new JLabel("6x6");
		JLabel eightL = new JLabel("8x8");
		JLabel youDiffL = new JLabel("difficulty");
		JLabel easy = new JLabel("easy");
		JLabel normal = new JLabel("normal");
		JLabel hard = new JLabel("hard");
		
		
		
		
		add(youOptionsL);
		add(sizeP);
		sizeP.setLayout(new GridLayout(2, 1));
		sizeP.add(youSizeL);
		sizeP.add(sizeOptionsP);
		sizeOptionsP.setLayout(new GridLayout(1, 3));
		sizeOptionsP.add(fourL);
		sizeOptionsP.add(sixL);
		sizeOptionsP.add(eightL);
		add(diffP);
		diffP.setLayout(new GridLayout(2, 1));
		diffP.add(youDiffL);
		diffP.add(diffOptionsP);
		
		diffOptionsP.add(easy);
		diffOptionsP.add(normal);
		diffOptionsP.add(hard);
		
	
	}
	
	

}
