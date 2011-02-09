package view;

import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Controller;

public abstract class Activity extends JPanel{
	
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

	public void start(Container pane) {
		// TODO Auto-generated method stub
		
	}
	
	
}
