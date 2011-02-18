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
	
	// The Model to store the Gamedata and the View to draw the GUI.
	
	private GameModel model;
	private View view;
	private GalleryModel galleryModel;
	private Counter counter;
	
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
		
		else if(activityClass.equals(ChoosePicActivity.class.getSimpleName())){
			try {
				Image image = ImageIO.read(new File((String) params.getValue(ChoosePicActivity.RETURN_PATH)));
				model.setImage(Graphics.subImage(image, model.getSize(), 700, 500));
				startGame();
			} catch (IOException e) {
				view.startActivity(new MenuActivity(this), null);
			}
		}
		
		else if(activityClass.equals(GalleryActivity.class.getSimpleName())){
			Image image = Graphics.scale((Image) params.getValue(GalleryActivity.RETURN_PIC), view.getWidth(), view.getHeight());
			model.setImage(Graphics.subImage(Graphics.scale(image, 800, 600), model.getSize(), 700, 500));
			startGame();
		}
		
		else if(activityClass.equals(OptionsActivity.class.getSimpleName())){
			model.setDifficulty((Integer) params.getValue(OptionsActivity.RETURN_DIF));
			model.setSize((Integer) params.getValue(OptionsActivity.RETURN_SIZE));
			view.startActivity(new MenuActivity(this), null);
		}
		
		else if(activityClass.equals(GameActivity.class.getSimpleName())){
			int[] sort = model.getSort();
			int temp = sort[model.getBlack()];
			sort[model.getBlack()]=sort[(Integer) params.getValue(GameActivity.RETURN_SELECTED)];
			sort[(Integer) params.getValue(GameActivity.RETURN_SELECTED)]=temp;
			model.setBlack((Integer) params.getValue(GameActivity.RETURN_SELECTED));
			model.setSort(sort);
			model.setNeighbors(getNeighbors());
			pl.addParameter(GameActivity.PARAMS_PIC, model.getImage());
			pl.addParameter(GameActivity.PARAMS_BLACK, model.getBlack());
			pl.addParameter(GameActivity.PARAMS_SORT, model.getSort());
			pl.addParameter(GameActivity.PARAMS_NEIGHBORS, model.getNeighbors());
			boolean t = true;
			for(int i=0; i<sort.length; i++){
				if(i!=sort[i]){
					t=false;
					break;
				}
			}
			if(t){
				model.setRoundTime(counter.getCount());
				pl.addParameter(WonActivity.PARAMS_NAME, model.getPlayerName());
				pl.addParameter(WonActivity.PARAMS_TIME, model.getRoundTime());
				view.startActivity(new WonActivity(this), pl);
			}
			else
				view.startActivity(new GameActivity(this), pl);
			
		}
		
		else if(activityClass.equals(WonActivity.class.getSimpleName()))
			start();
		
	}
	
	private void startGame(){
		mix();
		ParameterList pl = new ParameterList();
		pl.addParameter(GameActivity.PARAMS_PIC, model.getImage());
		pl.addParameter(GameActivity.PARAMS_BLACK, model.getBlack());
		pl.addParameter(GameActivity.PARAMS_SORT, model.getSort());
		pl.addParameter(GameActivity.PARAMS_NEIGHBORS, model.getNeighbors());
		counter = new Counter();
		counter.start();
		view.startActivity(new GameActivity(this), pl);
	}
	
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
			System.out.println(black);
		}
		
		model.setSort(mix);
		model.setBlack(black);
		model.setNeighbors(getNeighbors());
		
	}
	
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
