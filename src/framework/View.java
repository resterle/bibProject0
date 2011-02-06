package framework;

import java.awt.Dimension;

import javax.swing.JFrame;

import model.GameModel;

public class View extends JFrame{
	
	public View(String name){
		super(name);
		
		// Set default windowparameters.
	
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
