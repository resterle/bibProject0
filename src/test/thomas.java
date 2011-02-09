package test;

import model.GameModel;
import controller.Controller;
import activities.CreditsActivity;
import activities.MenuActivity;
import activities.OptionsActivity;
import activities.QuitActivity;
import activities.WonActivity;
import view.Activity;
import view.ParameterList;
import view.View;

public class thomas {
	
public static void main(String[] args) {
		ParameterList params = new ParameterList();
		params.addParameter("name", "Thomas");
		params.addParameter("time", "120s");
	
	
		View v = new View("Options");
		v.startActivity(new OptionsActivity(null), null);
	}

}
