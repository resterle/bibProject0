package controller;

import view.View;
import model.GameModel;

public class Controller {
	
	// The Model to store the Gamedata and the View to draw the GUI.
	
	private GameModel model;
	private View view;
	
	// Constructor
	
	public Controller(GameModel model, View view) {
		super();
		this.model = model;
		this.view = view;
	}
	
	public void start(){
		
	}
	
}
