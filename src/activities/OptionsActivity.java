package activities;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.GameModel;
import model.PicsMapper;
import view.Activity;
import view.ImageButton;
import controller.Controller;

public class OptionsActivity extends Activity {
	
	public static final String RETURN_SIZE = "size";
	public static final String RETURN_DIF = "dif";
	
	public static final String PARAMS_SIZE = "psize";
	public static final String PARAMS_DIF = "pdif";

	
	public OptionsActivity(Controller controller) {
		super(controller);
	}
	
	public void start(){
		
		final JRadioButton fourButton   = new JRadioButton("",false);
		fourButton.setBounds(100, 200 , 30, 14);
		final JRadioButton sixButton    = new JRadioButton("", false);
		sixButton.setBounds(380, 200 , 30, 14);
		final JRadioButton eightButton  = new JRadioButton("", false);
		eightButton.setBounds(650, 200 , 30, 14);
		
		final JRadioButton easyButton   = new JRadioButton("", false);
		easyButton.setBounds(100, 360 , 30, 14);
		final JRadioButton normalButton = new JRadioButton("", false);
		normalButton.setBounds(380, 360 , 30, 14);
		final JRadioButton hardButton   = new JRadioButton("", false);
		hardButton.setBounds(650, 360 , 30, 14);
		
		
		setLayout(null);  
		
		//Declaration of the Button
		ImageButton okayB = new ImageButton(PicsMapper.OKAY_BUTTON);
		okayB.setBounds(270, 450 , 250, 100 );

		//Declaration of the Labels
		JLabel youOptionsL = new JLabel(new ImageIcon(PicsMapper.TEXT_OPTION));
		youOptionsL.setBounds(260, 0 , 250, 100 );
		
		ImageIcon pic1 = new ImageIcon(PicsMapper.TEXT_SIZE);
		pic1 = Graphics.scale(pic1.getImage(), 0.55);
 		JLabel youSizeL    = new JLabel(pic1);
 		youSizeL.setBounds(270, 100 , 250, 100 );
 		
 		ImageIcon pic2=new ImageIcon(PicsMapper.TEXT_DIFFICULTY);
 		pic2 = Graphics.scale(pic2.getImage(), 0.55);
		JLabel youDiffL    = new JLabel(pic2);
		youDiffL.setBounds(270, 265 , 250, 100 );
		
		ImageIcon pic3  = new ImageIcon(PicsMapper.TEXT_4x4);
		pic3 = Graphics.scale(pic3.getImage(), 0.35);
 		JLabel fourL  = new JLabel(pic3);
 		fourL.setBounds(60, 181 , 100, 100 );
 		
 		ImageIcon pic4 =new ImageIcon(PicsMapper.TEXT_6x6);
 		pic4 = Graphics.scale(pic4.getImage(), 0.35);
		JLabel sixL    = new JLabel(pic4);
		sixL.setBounds(340, 181 , 100, 100 );
		
		ImageIcon pic5 =new ImageIcon(PicsMapper.TEXT_8x8);
 		pic5 = Graphics.scale(pic5.getImage(), 0.35);
		JLabel eightL  = new JLabel(pic5);
		eightL.setBounds(610, 181 , 100, 100 );
		
		ImageIcon pic6  = new ImageIcon(PicsMapper.TEXT_ESAY);
		pic6 = Graphics.scale(pic6.getImage(), 0.35);
 		JLabel easyL  = new JLabel(pic6);
 		easyL.setBounds(60, 341 , 100, 100 );
 		
 		ImageIcon pic7 =new ImageIcon(PicsMapper.TEXT_NORMAL);
 		pic7 = Graphics.scale(pic7.getImage(), 0.35);
		JLabel normalL   = new JLabel(pic7);
		normalL .setBounds(340, 341 , 100, 100 );
		
		ImageIcon pic8 =new ImageIcon(PicsMapper.TEXT_HARD);
 		pic8 = Graphics.scale(pic8.getImage(), 0.35);
		JLabel hardL  = new JLabel(pic8);
		hardL.setBounds(610, 341 , 100, 100 );
		
		//declare RadioButtons for the size
		switch((Integer)params.getValue(PARAMS_SIZE)){
		
		case 4:	fourButton.setSelected(true);
				sixButton.setSelected(false);
				eightButton.setSelected(false);
				break;
				
		case 6: fourButton.setSelected(false);
				sixButton.setSelected(true);
				eightButton.setSelected(false);
				break;
				
		case 8: fourButton.setSelected(false);
				sixButton.setSelected(false);
				eightButton.setSelected(true);
				break;	
		}
		
		
		// Set radio buttons on the ButtonGroup 
		final ButtonGroup sizeRB = new ButtonGroup();
		sizeRB.add(fourButton);
		sizeRB.add(sixButton);
		sizeRB.add(eightButton);
		
		//declare RadioButtons for the difficulty		
		switch((Integer)params.getValue(PARAMS_DIF)){
		
		case 25:easyButton.setSelected(true);
				normalButton.setSelected(false);
				hardButton.setSelected(false);
				break;
				
		case 50:easyButton.setSelected(false);
				normalButton.setSelected(true);
				hardButton.setSelected(false);
				break;
				
		case 200:easyButton.setSelected(false);
				normalButton.setSelected(false);
				hardButton.setSelected(true);
				break;
		}
		

		// Set radio buttons on the ButtonGroup 		 
		final ButtonGroup diffRB = new ButtonGroup();
		diffRB.add(easyButton);
		diffRB.add(normalButton);
		diffRB.add(hardButton);
		
		
		//adding all buttons and texts
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
				
				returnParams.addParameter(RETURN_DIF, dif);
				
				ButtonModel sizeTest = sizeRB.getSelection();
				int size = GameModel.SIZE_4X4;
				if(sixButton.getModel() == sizeTest){
					size = GameModel.SIZE_6X6;	
				}
				else if(eightButton.getModel() == sizeTest){
					size = GameModel.SIZE_8X8;
				}
				
				returnParams.addParameter(RETURN_SIZE, size);
				
				returnData();
			}
		});
	}
}
