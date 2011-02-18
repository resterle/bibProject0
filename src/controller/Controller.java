package controller;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

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
import activities.WonActivity;
import view.ParameterList;
import view.View;
import model.Counter;
import model.GalleryModel;
import model.GameModel;
import model.Highscore;
import model.MainMenuModel;

public class Controller {
	
	// The Model to store the Gamedata.
	private GameModel model;
	
	// The View to start the Activitys and draw the GUI.
	private View view;
	
	// Model for the Gallery Activity.
	private GalleryModel galleryModel;
	private Counter counter;
	private GameActivity gameActivity;
	
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
	

	// This Method is called by the Activities when they want to return data.
	
	public void returnData(String activityClass, ParameterList params){
		
		// A new ParameterList for starting new Activitys
		ParameterList pl = new ParameterList();
		
		// If MenuActivity returns data.
		if(activityClass.equals(MenuActivity.class.getSimpleName())){
			
			// Switches based on the selected entry.
			switch((Integer)params.getValue(MenuActivity.PARAM_MENUITEM)){
				
				// When new game is clicked.
				case MainMenuModel.NEW_GAME:
					
					// Add the actual playername to the PArameters.
					pl.addParameter(PlayernameActivity.PARAMS_NAME, model.getPlayerName());
					
					// Start a new PlayernameActivity.
					view.startActivity(new PlayernameActivity(this), pl);
					
					break;
				
				// When new highscore is clicked.
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
					
				// When options is clicked.
				case MainMenuModel.OPTIONS:
					view.startActivity(new OptionsActivity(this), null);
					break;
					
				// When credits is clicked.
				case MainMenuModel.CREDITS:
					view.startActivity(new CreditsActivity(this), null);
					break;
					
				// When quit is clicked.
				case MainMenuModel.QUIT:
					view.startActivity(new QuitActivity(this), null);
					break;
			}
		}
		
		// If QuitActivity returns data. 
		else if(activityClass.equals(QuitActivity.class.getSimpleName())){
			if((Boolean)params.getValue(QuitActivity.RETURN_QUIT))
				System.exit(0);
			start();
		}
		
		// If HighscoreActivity returns data.
		else if(activityClass.equals(HighscoreActivity.class.getSimpleName()))
			start();
		
		// If CreditsActivity returns data.
		else if(activityClass.equals(CreditsActivity.class.getSimpleName()))
			start();
		
		// If ImageLoader returns data.
		else if(activityClass.equals(ImageLoder.class.getSimpleName())){
			
			pl.addParameter(GalleryActivity.PARAM_PICS, params.getValue(ImageLoder.RETURN_PICS));
			view.startActivity(new GalleryActivity(this), params);
		}
		
		// If PlayernameActivity returns data.
		else if(activityClass.equals(PlayernameActivity.class.getSimpleName())){
			
			model.setPlayerName((String) params.getValue(PlayernameActivity.RETURN_NAME));
			System.out.println((Boolean) params.getValue(PlayernameActivity.RETURN_BACK));
			if((Boolean) params.getValue(PlayernameActivity.RETURN_BACK))
				start();
			else if((Boolean) params.getValue(PlayernameActivity.RETURN_GALLARY)){
				pl.addParameter(LoadingActivity.PARAM_MESSAGE, "Loading Gallery");
				view.startActivity(new LoadingActivity(this), pl);
				ImageLoder il = new ImageLoder(this, galleryModel);
				il.start();
			}
			else{
				view.startActivity(new ChoosePicActivity(this), params);
			}

		}
		
		// If ChoosePicActivity returns data.
		else if(activityClass.equals(ChoosePicActivity.class.getSimpleName())){
			try {
				pl.addParameter(LoadingActivity.PARAM_MESSAGE, "Loading Image");
				view.startActivity(new LoadingActivity(this), pl);
				Image image = ImageIO.read(new File((String) params.getValue(ChoosePicActivity.RETURN_PATH)));
				model.setImage(Graphics.subImage(image, model.getSize(), 700, 400));
				startGame();
			} catch (IOException e) {
				view.startActivity(new MenuActivity(this), null);
			}
		}
		
		// If GalleryActivity returns data.
		else if(activityClass.equals(GalleryActivity.class.getSimpleName())){
			Image image = Graphics.scale((Image) params.getValue(GalleryActivity.RETURN_PIC), view.getWidth(), view.getHeight());
			model.setImage(Graphics.subImage(Graphics.scale(image, 800, 600), model.getSize(), 700, 400));
			startGame();
		}
		
		// If OptionsActivity returns data.
		else if(activityClass.equals(OptionsActivity.class.getSimpleName())){
			model.setDifficulty((Integer) params.getValue(OptionsActivity.RETURN_DIF));
			model.setSize((Integer) params.getValue(OptionsActivity.RETURN_SIZE));
			view.startActivity(new MenuActivity(this), null);
		}
		
		// If GameActivity returns data.
		else if(activityClass.equals(GameActivity.class.getSimpleName())){
			
			// if returnbutton ore shufflebutton is clicked.
			if(params.getValue(GameActivity.RETURN_SELECTED).equals(GameActivity.RETURN_BACK)){
				view.startActivity(new MenuActivity(this), null);
				return;
			}
			if(params.getValue(GameActivity.RETURN_SELECTED).equals(GameActivity.RETURN_SHUFFLE)){
				startGame();
				return;
			}
			
			// Change the black picture with the selected one.
			int[] sort = model.getSort();
			int temp = sort[model.getBlack()];
			sort[model.getBlack()]=sort[(Integer) params.getValue(GameActivity.RETURN_SELECTED)];
			sort[(Integer) params.getValue(GameActivity.RETURN_SELECTED)]=temp;
			
			// Set the new order to the model.
			model.setBlack((Integer) params.getValue(GameActivity.RETURN_SELECTED));
			model.setSort(sort);
			model.setNeighbors(getNeighbors());
			
			// Check if the pictures are in the correct order.
			boolean t = true;
			for(int i=0; i<sort.length; i++){
				if(i!=sort[i]){
					t=false;
					break;
				}
			}
			// If correct order.
			if(t){
				pl.addParameter(WonActivity.PARAMS_NAME, model.getPlayerName());
				pl.addParameter(WonActivity.PARAMS_TIME, model.getRoundTime());
				view.startActivity(new WonActivity(this), pl);
			}
			// If order is incorrect.
			else{
				
				// Set all the parameters needed for the new GameActivity.
				pl.addParameter(GameActivity.PARAMS_PIC, model.getImage());
				pl.addParameter(GameActivity.PARAMS_BLACK, model.getBlack());
				pl.addParameter(GameActivity.PARAMS_SORT, model.getSort());
				pl.addParameter(GameActivity.PARAMS_NEIGHBORS, model.getNeighbors());
				pl.addParameter(GameActivity.PARAMS_TIME, model.getRoundTime());
				
				view.startActivity(gameActivity, pl);
			}
			
		}
		
		// If WonActivity returns data.
		else if(activityClass.equals(WonActivity.class.getSimpleName()))
			start();
		
	}
	
	// Create all the Objects needed for a new Game and add them to the pl ParameterList.
	private void startGame(){
		
		mix();
		ParameterList pl = new ParameterList();
		pl.addParameter(GameActivity.PARAMS_PIC, model.getImage());
		pl.addParameter(GameActivity.PARAMS_BLACK, model.getBlack());
		pl.addParameter(GameActivity.PARAMS_SORT, model.getSort());
		pl.addParameter(GameActivity.PARAMS_NEIGHBORS, model.getNeighbors());
		pl.addParameter(GameActivity.PARAMS_TIME, model.getRoundTime());
		gameActivity = new GameActivity(this);
		model.setRoundTime(0);
		view.startActivity(gameActivity, pl);
		if(null==counter){
			counter = new Counter(model, gameActivity);
			counter.start();
		}
		else
			counter.setActivity(gameActivity);

	}
	
	// Mix the Picturepices in comparison to the preferred difficulty and set them to the model.
	private void mix(){
		
		
		int s = model.getSize();
		
		int[] mix = new int[s*s];
		int black = (s*s)-1;
		
		model.setBlack(black);
		
		for(int i=0; i<s*s; i++){
			mix[i]=i;
		}
		
		ArrayList<Integer> neighbors = null;
		
		for(int i=0; i<model.getDifficulty(); i++){
			
			neighbors = getNeighbors();
			int q = (int) (Math.random()*100);
			int r = 0;
			for(int j=0; j<q; j++){
				r = (int) (Math.random()*neighbors.size());
			}
			int n = neighbors.get(r);
			int temp = mix[black];
			mix[black]=mix[n];
			mix[n]=temp;
			black =n;
			model.setBlack(black);
		}
		
		model.setSort(mix);
		model.setBlack(black);
		model.setNeighbors(getNeighbors());
		
	}
	
	// returns the index of the movable pictures.
	private ArrayList<Integer> getNeighbors(){
		
		int s = model.getSize();
		
		int black = model.getBlack();
		
		ArrayList<Integer> neighbors = new ArrayList<Integer>();
		
		if((black%s)!=0){
				neighbors.add(black-1);
		}
		if(((black+1)%s)!=0){
				neighbors.add(black+1);
		}
		if(black+1>s){
				neighbors.add(black-s);
		}
		if(black<((s*s)-s)){
				neighbors.add(black+s);
		}
		
		return neighbors;
		
	}
	
	private ArrayList<Highscore> loadScore(){
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			doc = reader.read(GameModel.HIGHSCORE_FILE);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			System.out.println("INFO: Error while reading the highscore.");
		}
		if(null==doc){
			doc = DocumentHelper.createDocument();
			Node root = doc.addElement("highscore");
		}
		return null;
	} 
	
}
