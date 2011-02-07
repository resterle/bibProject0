package test;

import view.Activity;
import view.ParameterList;
import view.View;

public class Raphael {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Activity a = new Activity() {
		};
		
		ParameterList pl = new ParameterList();
		pl.addParameter("name", "Peter");
		
		View v = new View("nein");
		System.out.println(v.startActivity(a, pl).getValue("return"));

	}

}
