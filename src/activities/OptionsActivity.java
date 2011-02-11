package activities;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
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
import view.ImageButton;

public class OptionsActivity extends Activity {
	
	public static final String REDURN_SIZE = "size";
	public static final String REDURN_DIF = "dif";
	
	public OptionsActivity(Controller controller) {
		super(controller);
	}
	
	public void start(){
		
		setLayout(null);  
		
		//Declaration of the Button
		ImageButton okayB = new ImageButton(PicsMapper.OKAY_BUTTON);
		okayB.setBounds(270, 450 , 250, 100 );

		//Declaration of the different Panels
		JPanel sizeP = new JPanel();
		JPanel sizeOptionsP = new JPanel();		
		JPanel diffP = new JPanel();
		JPanel diffOptionsP = new JPanel();
		
		//Declaration of the Labels
		JLabel youOptionsL = new JLabel(new ImageIcon(PicsMapper.TEXT_OPTION));
		youOptionsL.setBounds(260, 0 , 250, 100 );
		
		ImageIcon pic1 = new ImageIcon(PicsMapper.TEXT_SIZE);
		pic1 = Resize.scale(pic1.getImage(), 0.55);
 		JLabel youSizeL    = new JLabel(pic1);
 		youSizeL.setBounds(270, 100 , 250, 100 );
 		
 		ImageIcon pic2=new ImageIcon(PicsMapper.TEXT_DIFFICULTY);
 		pic2 = Resize.scale(pic2.getImage(), 0.55);
		JLabel youDiffL    = new JLabel(pic2);
		youDiffL.setBounds(270, 265 , 250, 100 );
		
		ImageIcon pic3  = new ImageIcon(PicsMapper.TEXT_4x4);
		pic3 = Resize.scale(pic3.getImage(), 0.35);
 		JLabel fourL  = new JLabel(pic3);
 		fourL.setBounds(60, 181 , 100, 100 );
 		
 		ImageIcon pic4 =new ImageIcon(PicsMapper.TEXT_6x6);
 		pic4 = Resize.scale(pic4.getImage(), 0.35);
		JLabel sixL    = new JLabel(pic4);
		sixL.setBounds(340, 181 , 100, 100 );
		
		ImageIcon pic5 =new ImageIcon(PicsMapper.TEXT_8x8);
 		pic5 = Resize.scale(pic5.getImage(), 0.35);
		JLabel eightL  = new JLabel(pic5);
		eightL.setBounds(610, 181 , 100, 100 );
		
		ImageIcon pic6  = new ImageIcon(PicsMapper.TEXT_ESAY);
		pic6 = Resize.scale(pic6.getImage(), 0.35);
 		JLabel easyL  = new JLabel(pic6);
 		easyL.setBounds(60, 341 , 100, 100 );
 		
 		ImageIcon pic7 =new ImageIcon(PicsMapper.TEXT_NORMAL);
 		pic7 = Resize.scale(pic7.getImage(), 0.35);
		JLabel normalL   = new JLabel(pic7);
		normalL .setBounds(340, 341 , 100, 100 );
		
		ImageIcon pic8 =new ImageIcon(PicsMapper.TEXT_HARD);
 		pic8 = Resize.scale(pic8.getImage(), 0.35);
		JLabel hardL  = new JLabel(pic8);
		hardL.setBounds(610, 341 , 100, 100 );
		
		//declare RadioButtons for the size
		final JRadioButton fourButton   = new JRadioButton("",true);
		fourButton.setBounds(100, 200 , 30, 14);
		final JRadioButton sixButton    = new JRadioButton("", false);
		sixButton.setBounds(380, 200 , 30, 14);
		final JRadioButton eightButton  = new JRadioButton("", false);
		 eightButton.setBounds(650, 200 , 30, 14);
		
		// Set radio buttons on the ButtonGroup 
		final ButtonGroup sizeRB = new ButtonGroup();
		sizeRB.add(fourButton);
		sizeRB.add(sixButton);
		sizeRB.add(eightButton);
		
		//declare RadioButtons for the difficulty
		final JRadioButton easyButton   = new JRadioButton("", true);
		easyButton.setBounds(100, 360 , 30, 14);
		final JRadioButton normalButton = new JRadioButton("", false);
		normalButton.setBounds(380, 360 , 30, 14);
		final JRadioButton hardButton   = new JRadioButton("", false);
		hardButton.setBounds(650, 360 , 30, 14);

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
	    add(youSizeL);
	    add(youDiffL);
	    add(fourL);
	    add(sixL);
	    add(eightL);
	    add(easyL);
	    add(normalL);
	    add(hardL);
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
				int dif = GameModel.DIFF_EASY;
				if (normalButton.getModel() == diffTest) {
		            dif = GameModel.DIFF_NORMAL;
				}
				else if(hardButton.getModel() == diffTest)
				{
					dif = GameModel.DIFF_HARD;	
					
				}
				
				returnParams.addParameter(REDURN_DIF, dif);
				
				ButtonModel sizeTest = sizeRB.getSelection();
				int size = GameModel.SIZE_4X4;
				if(sixButton.getModel() == sizeTest){
					size = GameModel.SIZE_6X6;	
				}
				else if(eightButton.getModel() == sizeTest){
					size = GameModel.SIZE_8X8;
				}
				
				returnParams.addParameter(REDURN_SIZE, size);
				
				returnData();
			}
		});
	}
}
