package model;

import java.util.ArrayList;

public class Highscore {
	
	private int seconds;
	private String name;
	
	public void addScore(String name, int seconds){
		this.name = name;
		this.seconds = seconds;
	}
 	
	
}
