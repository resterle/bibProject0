package test;

import framework.Activity;
import framework.View;

public class Raphael {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Activity a = new Activity() {
		};
		
		View v = new View("nein");
		System.out.println(v.startActivity(a, null));

	}

}
