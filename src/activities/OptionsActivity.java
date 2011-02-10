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
		
		ImageIcon vv=new ImageIcon(url);

		setLayout(null);
		
		//Declaration of the Button
		JButton okayB = new JButton(new ImageIcon(PicsMapper.OKAY_BUTTON));
		
		okayB.setBounds(250, 450 , 250, 100 );

		//Declaration of the different Panels
		JPanel sizeP = new JPanel();
		JPanel sizeOptionsP = new JPanel();		
		JPanel diffP = new JPanel();
		JPanel diffOptionsP = new JPanel();
		
		
		//Declaration of the Labels
		JLabel youOptionsL = new JLabel(new ImageIcon(PicsMapper.TEXT_OPTION));
		youOptionsL.setBounds(250, 0 , 250, 100 );
 		JLabel youSizeL    = new JLabel(new ImageIcon(PicsMapper.TEXT_SIZE));
 		youSizeL.setBounds(250, 100 , 250, 100 );
		JLabel youDiffL    = new JLabel(new ImageIcon(PicsMapper.TEXT_DIFFICULTY));
		youDiffL.setBounds(250, 250 , 250, 100 );
		
		//declare RadioButtons for the size
		final JRadioButton fourButton   = new JRadioButton("4x4", true);
		fourButton.setBounds(100, 200 , 50, 50);
		final JRadioButton sixButton    = new JRadioButton("6x6", false);
		sixButton.setBounds(350, 200 , 50, 50 );
		final JRadioButton eightButton  = new JRadioButton("8x8", false);
		 eightButton.setBounds(550, 200 , 50, 50 );
		
		// Set radio buttons on the ButtonGroup 
		final ButtonGroup sizeRB = new ButtonGroup();
		sizeRB.add(fourButton);
		sizeRB.add(sixButton);
		sizeRB.add(eightButton);
		
		//declare RadioButtons for the difficulty
		final JRadioButton easyButton   = new JRadioButton("easy"  , true);
		easyButton.setBounds(100, 350 , 80, 50);
		final JRadioButton normalButton = new JRadioButton("normal", false);
		normalButton.setBounds(350, 350 , 80, 50);
		final JRadioButton hardButton   = new JRadioButton("hard"  , false);
		hardButton.setBounds(550, 350 , 80, 50);

		
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
		add( new JLabel(scale(youDiffL.getImage(), 0.75)));
		add(youSizeL);
		add(okayB);
		add(fourButton);
		add(sixButton);
		add(eightButton);
		add(easyButton);
		add(normalButton);
		add(hardButton);
		
		
		
		

		
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
