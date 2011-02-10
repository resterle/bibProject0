package test;

import java.util.ArrayList;
import java.util.Arrays;

import activities.ChoosePicActivity;
import activities.MenuActivity;
import activities.OptionsActivity;
import activities.PlayernameActivity;

import model.GalleryModel;
import model.GameModel;
import model.PicsMapper;
import view.ParameterList;
import view.View;
import controller.Controller;

public class Thomas {


	public static void main(String[] args) {
		View v = new View("Test-Thomas");
		ParameterList params = new ParameterList();
		params.addParameter(PlayernameActivity.PARAMS_NAME, null);
		
		v.startActivity(new ChoosePicActivity(null), null);
	}

}
