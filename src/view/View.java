package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.GameModel;

public class View extends JFrame{
	
	
	private Container mainCon;
	
	private Image i;
	
	public View(String name){
		
		super(name);
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		i = toolkit.getImage("pics/puzzle.png");
		
		//Bild laden veranlassen
		MediaTracker tracker = new  MediaTracker(this);
		//Bild dem Mediatracker hinzufügen
		tracker.addImage(i,0);
		//Bild laden
		try {
			tracker.waitForID(0);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		mainCon = getContentPane();
		
		// Set default Windowparameters.
	
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	// Method to start an Activity.
	
	public void startActivity(Activity activity, ParameterList params){
		
		activity.run(params);
		mainCon.removeAll();
		mainCon.add(activity);
		mainCon.validate();
		
	}
	
	public void update(){
		mainCon.validate();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(i , 0, 0, getWidth(), getHeight(), this);
	}
	
}
