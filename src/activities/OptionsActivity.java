package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.GameModel;
import model.PicsMapper;

import controller.Controller;
import view.Activity;

public class OptionsActivity extends Activity {

	public OptionsActivity(Controller controller) {
		super(controller);
	}
	
	public void start(){
		
		setLayout(null);
		
		//Declaration of the Button
		JButton okayB = new JButton(new ImageIcon(PicsMapper.OKAY_BUTTON));
		
		okayB.setBounds(280, 450 , 250, 100 );

		//Declaration of the different Panels
		JPanel sizeP = new JPanel();
		JPanel sizeOptionsP = new JPanel();		
		JPanel diffP = new JPanel();
		JPanel diffOptionsP = new JPanel();
		
		
		//Declaration of the Labels
		JLabel youOptionsL = new JLabel("Options");
		JLabel youSizeL    = new JLabel("size");	
		JLabel youDiffL    = new JLabel("difficulty");
		
		
		//declare RadioButtons for the size
		final JRadioButton fourButton   = new JRadioButton("4x4", true);
		final JRadioButton sixButton    = new JRadioButton("6x6", false);
		final JRadioButton eightButton  = new JRadioButton("8x8", false);

		
		// Set radio buttons on the ButtonGroup 
		final ButtonGroup sizeRB = new ButtonGroup();
		sizeRB.add(fourButton);
		sizeRB.add(sixButton);
		sizeRB.add(eightButton);
		
		//declare RadioButtons for the difficulty
		final JRadioButton easyButton   = new JRadioButton("easy"  , true);
		final JRadioButton normalButton = new JRadioButton("normal", false);
		final JRadioButton hardButton   = new JRadioButton("hard"  , false);

		
		// Set radio buttons on the ButtonGroup 		 
		final ButtonGroup diffRB = new ButtonGroup();
		diffRB.add(easyButton);
		diffRB.add(normalButton);
		diffRB.add(hardButton);
		
		
		//The Order of the Panels, Labels and Radio Buttons are declared 	
		sizeP.setLayout(new GridLayout(2, 1));
		sizeP.add(youSizeL);
		sizeP.add(sizeOptionsP);
		sizeOptionsP.setLayout(new GridLayout(1, 3));
		sizeOptionsP.add(fourButton);
		sizeOptionsP.add(sixButton);
		sizeOptionsP.add(eightButton);
		
		diffP.setLayout(new GridLayout(2, 1));
		diffP.add(youDiffL);
		diffP.add(diffOptionsP);
		diffOptionsP.setLayout(new GridLayout(1, 3));
		diffOptionsP.add(easyButton);
		diffOptionsP.add(normalButton);
		diffOptionsP.add(hardButton);
		
		add(youOptionsL);
		add(sizeP);
		add(diffP);
		add(okayB);
		
		
		

		
		//returnData();
		
		
		
		//A new ACtion Listener is declared
		okayB.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//If questions to find out which both Radio Buttons are selected
				ButtonModel diffTest = diffRB.getSelection();
				if (easyButton.getModel() == diffTest) {
		            returnParams.addParameter("difficulty", GameModel.DIFF_EASY);
				}
				else
				{
					if(normalButton.getModel() == diffTest){
						returnParams.addParameter("difficulty", GameModel.DIFF_NORMAL);	
					}
					else{
						returnParams.addParameter("difficulty", GameModel.DIFF_HARD);
					}
				}
				
				
				ButtonModel sizeTest = sizeRB.getSelection();
				if (fourButton.getModel() == sizeTest) {
		            returnParams.addParameter("size", GameModel.SIZE_4X4);
				}
				else
				{
					if(sixButton.getModel() == sizeTest){
						returnParams.addParameter("size", GameModel.SIZE_6X6);	
					}
					else{
						returnParams.addParameter("size", GameModel.SIZE_8X8);
					}
				}
				
				returnData();
				
			}
		});
	
	}
	
	

}
