package test;

import model.GameModel;
import controller.Controller;
import activities.CreditsActivity;
import activities.MenuActivity;
import activities.QuitActivity;
import view.Activity;
import view.ParameterList;
import view.View;

public class thomas {
	
public static void main(String[] args) {
		
	
	
		View v = new View("Credits");
		v.startActivity(new CreditsActivity(null), null);
	}

}
