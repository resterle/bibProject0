package test;

import java.util.ArrayList;
import java.util.Arrays;

import activities.ChoosePicActivity;
import activities.MenuActivity;
import activities.WonActivity;

import model.GalleryModel;
import model.GameModel;
import model.ParameterList;
import model.PicsMapper;
import view.View;
import controller.Controller;

public class Thomas {

public static void main(String[] args) {
		
	View v = new View("Test-Thomas");
//	ParameterList params = new ParameterList();
//	params.addParameter(WonActivity.PARAMS_NAME, "Thomas");
//	params.addParameter(WonActivity.PARAMS_TIME, "120");
//	
//	v.startActivity(new WonActivity(new Controller(null, null, null)), params);
//	
	GalleryModel gm = new GalleryModel(new ArrayList(Arrays.asList(PicsMapper.PUZZLE_PICS)));
	
	
	Controller con = new Controller(new GameModel(), v, gm);
	con.start();

	}
	
	
}
