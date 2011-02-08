package controller;

import activities.CreditsActivity;
import activities.MenuActivity;
import activities.QuitActivity;
import view.ParameterList;
import view.View;
import model.GameModel;
import model.MainMenuModel;

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
		
		// Start the menuActivity.
		
		view.startActivity(new MenuActivity(this), null);
		
	}
	
	public void returnData(String activityClass, ParameterList params){
		
		if(activityClass.equals(MenuActivity.class.getSimpleName())){
			switch((Integer)params.getValue("menu")){
				case MainMenuModel.NEW_GAME:
					break;
				case MainMenuModel.HIGHSCORE:
					break;
				case MainMenuModel.OPTIONS:
					break;
				case MainMenuModel.CREDITS:
					view.startActivity(new CreditsActivity(this), null);
					break;
				case MainMenuModel.QUIT:
					view.startActivity(new QuitActivity(this), null);
					break;
			}
		}
		
		else if(activityClass.equals(QuitActivity.class.getSimpleName())){
			if((Boolean)params.getValue("quit"))
				System.exit(0);
			start();
		}
		
		else if(activityClass.equals(CreditsActivity.class.getSimpleName()))
			start();
		
	}
	
}
