package controller;

import java.util.ArrayList;

import activities.CreditsActivity;
import activities.GalleryActivity;
import activities.HighscoreActivity;
import activities.LoadingActivity;
import activities.MenuActivity;
import activities.OptionsActivity;
import activities.QuitActivity;
import view.ParameterList;
import view.View;
import model.GalleryModel;
import model.GameModel;
import model.MainMenuModel;

public class Controller {
	
	// The Model to store the Gamedata and the View to draw the GUI.
	
	private GameModel model;
	private View view;
	private GalleryModel galleryModel;
	
	// Constructor
	
	public Controller(GameModel model, View view, GalleryModel galleryModel) {
		super();
		this.model = model;
		this.view = view;
		this.galleryModel=galleryModel;
	}
	
	// This Method is called to start the Controller
	
	public void start(){
		
		// Start the menuActivity.
		
		view.startActivity(new MenuActivity(this), null);
		
	}
	

	// This Method is called by the Activities when Activity wants to return data.
	
	public void returnData(String activityClass, ParameterList params){
		
		if(activityClass.equals(MenuActivity.class.getSimpleName())){
			switch((Integer)params.getValue(MenuActivity.PARAM_MENUITEM)){
				case MainMenuModel.NEW_GAME:
					
					ImageLoder il = new ImageLoder(this, galleryModel);
					il.start();
					
					ParameterList pl = new ParameterList();
					pl.addParameter(LoadingActivity.PARAM_MESSAGE, "Loading Gallery...");
					
					view.startActivity(new LoadingActivity(this), pl);
					
					break;
				case MainMenuModel.HIGHSCORE:
					ArrayList<String> s = new ArrayList<String>();
					s.add("Hans");
					s.add("Peter");
					s.add("Olaf");
					
					ArrayList<Integer> i = new ArrayList<Integer>();
					i.add(20);
					i.add(30);
					i.add(120);
					
					ParameterList p = new ParameterList();
					p.addParameter(HighscoreActivity.PARAM_USERS, s);
					p.addParameter(HighscoreActivity.PARAM_SCORES, i);
					
					view.startActivity(new HighscoreActivity(this), p);
					break;
				case MainMenuModel.OPTIONS:
					view.startActivity(new OptionsActivity(this), null);
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
			if((Boolean)params.getValue(QuitActivity.RETURN_QUIT))
				System.exit(0);
			start();
		}
		
		else if(activityClass.equals(HighscoreActivity.class.getSimpleName()))
			start();
		
		else if(activityClass.equals(CreditsActivity.class.getSimpleName()))
			start();
		
		else if(activityClass.equals(ImageLoder.class.getSimpleName())){
			ParameterList pl = new ParameterList();
			pl.addParameter(GalleryActivity.PARAM_PICS, params.getValue(ImageLoder.RETURN_PICS));
			view.startActivity(new GalleryActivity(this), params);
		}
		
	}
	
}
