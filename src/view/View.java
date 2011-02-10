package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.PicsMapper;

public class View extends JFrame{
	
	
	private Container mainCon;
	
	private Image i;
	
	private JPanel jp;
	
	public View(String name){
		super(name);
		
		mainCon = getContentPane();
		jp = new JPanel();
		jp.setBackground(Color.RED);
		
		
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
	
}
