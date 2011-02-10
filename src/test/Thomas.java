package test;

import java.util.ArrayList;
import java.util.Arrays;

import activities.ChoosePicActivity;
import activities.MenuActivity;

import model.GalleryModel;
import model.GameModel;
import model.PicsMapper;
import view.View;
import controller.Controller;

public class Thomas {

public static void main(String[] args) {
		
		View v = new View("Test-Thomas");
				
		GalleryModel gm = new GalleryModel(new ArrayList(Arrays.asList(PicsMapper.PUZZLE_PICS)));
		
		
		Controller con = new Controller(new GameModel(), v, gm);
		con.start();

	}
	
	
}
