package test;

import java.util.ArrayList;
import java.util.Arrays;

import model.GalleryModel;
import model.GameModel;
import model.picsMapper;
import view.View;
import controller.Controller;

public class Raphael{


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		View v = new View("Test-Raphael");
		
		GalleryModel gm = new GalleryModel(new ArrayList(Arrays.asList(PicsMapper.PUZZLE_PICS)));
		
		
		Controller con = new Controller(new GameModel(), v, gm);
		con.start();

	}

}
