package view;

import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.PicsMapper;

public class View extends JFrame{
	
	
	private Container mainCon;
	
	private Image i;
	
	private JPanel bg;
	
	private JLayeredPane jp;
	
	private BufferedImage background;
	
	public View(String name){
		
		super(name);
		
		try {
			 background= ImageIO.read(new File(PicsMapper.BACKGROUND));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mainCon = getContentPane();
		
		// Set default Windowparameters.
	
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
	}
	
	// Method to start an Activity.
	
	public void startActivity(Activity activity, ParameterList params){
		
		activity.run(params);
		mainCon.removeAll();
		mainCon.add(activity);
		mainCon.validate();
		
	}
	
//	@Override
//	public void paint(Graphics g) {
//		super.paint(g);
//		g.drawImage(background, 0, 0, this);
//	}
	
	public void update(){
		mainCon.validate();
	}
	
	
	
}
