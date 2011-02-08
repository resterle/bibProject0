package test;

import model.GameModel;
import controller.Controller;
import activities.MenuActivity;
import view.Activity;
import view.ParameterList;
import view.View;

public class Raphael{


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//View v = new View("TEST1");
		
		
		Controller con = new Controller(new GameModel(), new View("Test"));
		con.start();

	}

}
