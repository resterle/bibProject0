package view;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.ParameterList;
import model.PicsMapper;

import controller.Controller;

public abstract class Activity extends JPanel{
	
	Image i;
	
	// The Activity Class represents a single Panel of the Game;
	
	protected ParameterList params;
	protected ParameterList returnParams;
	
	// The Controller who called the Activity;
	
	private Controller controller;
	
	// Constructor to set the controller.
	
	public Activity(Controller controller){
		this.controller = controller;
	}
	
	// The run method will be called from the View;
	public void run(ParameterList params){
		System.out.println("INFO: "+getClass().getSimpleName()+" started.");
		this.params=params;
		returnParams = new ParameterList();
		start();
	}
	
	// Overwrite this method with your own Code.
	public void start(){}
	
	protected void returnData() {
		controller.returnData(this.getClass().getSimpleName(), returnParams);
	}
	
	
}
