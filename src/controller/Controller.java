package controller;

import java.awt.Image;
import java.util.ArrayList;

import activities.ChoosePicActivity;
import activities.CreditsActivity;
import activities.GalleryActivity;
import activities.GameActivity;
import activities.Graphics;
import activities.HighscoreActivity;
import activities.LoadingActivity;
import activities.MenuActivity;
import activities.OptionsActivity;
import activities.PlayernameActivity;
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
		view.setVisible(true);
		
	}
	

	// This Method is called by the Activities when Activity wants to return data.
	
	public void returnData(String activityClass, ParameterList params){
		
		ParameterList pl = new ParameterList();
		
		if(activityClass.equals(MenuActivity.class.getSimpleName())){
			switch((Integer)params.getValue(MenuActivity.PARAM_MENUITEM)){
				case MainMenuModel.NEW_GAME:
					
					pl.addParameter(PlayernameActivity.PARAMS_NAME, model.getPlayerName());
					
					view.startActivity(new PlayernameActivity(this), pl);
					
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
					
					pl.addParameter(HighscoreActivity.PARAM_USERS, s);
					pl.addParameter(HighscoreActivity.PARAM_SCORES, i);
					
					view.startActivity(new HighscoreActivity(this), pl);
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
			
			pl.addParameter(GalleryActivity.PARAM_PICS, params.getValue(ImageLoder.RETURN_PICS));
			view.startActivity(new GalleryActivity(this), params);
		}
		
		else if(activityClass.equals(PlayernameActivity.class.getSimpleName())){
			
			model.setPlayerName((String) params.getValue(PlayernameActivity.RETURN_NAME));
			
			if((Boolean) params.getValue(PlayernameActivity.RETURN_GALLARY)){
				pl.addParameter(LoadingActivity.PARAM_MESSAGE, "Loading Gallery");
				view.startActivity(new LoadingActivity(this), pl);
				ImageLoder il = new ImageLoder(this, galleryModel);
				il.start();
			}
			else{
				view.startActivity(new ChoosePicActivity(this), params);
			}

		}
		
		else if(activityClass.equals(GalleryActivity.class.getSimpleName())){
			Image image = Graphics.scale((Image) params.getValue(GalleryActivity.RETURN_PIC), view.getWidth(), view.getHeight());
			pl.addParameter(GameActivity.PARAMS_PIC, image);
			pl.addParameter(GameActivity.PARAMS_DIF, model.getDifficulty());
			pl.addParameter(GameActivity.PARAMS_SIZE, model.getSize());
			view.startActivity(new GameActivity(this), pl);
			
		}
		
		else if(activityClass.equals(OptionsActivity.class.getSimpleName())){
			model.setDifficulty((Integer) params.getValue(OptionsActivity.RETURN_DIF));
			model.setSize((Integer) params.getValue(OptionsActivity.RETURN_SIZE));
			view.startActivity(new MenuActivity(this), null);
		}
		
	}
	
}
