package test;

import model.GameModel;
import controller.Controller;
import activities.CreditsActivity;
import activities.MenuActivity;
import activities.OptionsActivity;
import activities.PlayernameActivity;
import activities.QuitActivity;
import activities.WonActivity;
import view.Activity;
import view.ParameterList;
import view.View;

public class thomas {
	
public static void main(String[] args) {
		ParameterList params = new ParameterList();
		params.addParameter(PlayernameActivity.PARAMS_NAME, null);

	
	
		View v = new View("PlayerName");
		v.startActivity(new PlayernameActivity(null), params);
	}

}
