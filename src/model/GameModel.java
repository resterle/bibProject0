package model;

import java.awt.Image;
import java.util.ArrayList;

import view.ParameterList;

public class GameModel {
	
	// Path of the selected Picture.
	
	private String picturePath;
	
	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
	private ArrayList<Image> image;
	
	public ArrayList<Image> getImage() {
		return image;
	}

	public void setImage(ArrayList<Image> image) {
		this.image = image;
	}

	// The Player's name with geter's and setter's.
	private String playerName = "not Set"; 

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playersName) {
		this.playerName = playersName;
	}
	
	// The time in seconds the round takes. 
	
	private int time = 0;


	public int getRoundTime() {
		return time;
	}

	public void setRoundTime(int roundTime) {
		this.time = roundTime;
	} 
	
	// The difficulty influenced the mix of the pieces.
	
	public final static int DIFF_EASY = 50;
	public final static int DIFF_NORMAL = 100;
	public final static int DIFF_HARD = 500;
	
	private int difficulty = DIFF_EASY;


	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	//THe size influence the count of pieces in which the picture is sliced
	
	public final static int SIZE_4X4 = 2;
	public final static int SIZE_6X6 = 6;
	public final static int SIZE_8X8 = 8;
	
	private int size = SIZE_4X4;


	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	private ArrayList<Image> picPices;

	public ArrayList<Image> getPicPices() {
		return picPices;
	}

	public void setPicPices(ArrayList<Image> picPices) {
		this.picPices = picPices;
	}
	
	private int[] sort;

	public int[] getSort() {
		return sort;
	}

	public void setSort(int[] sort) {
		this.sort = sort;
	}
	
	private int black;

	public int getBlack() {
		return black;
	}

	public void setBlack(int black) {
		this.black = black;
	}
	
	private ArrayList<Integer> neighbors;

	public ArrayList<Integer> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(ArrayList<Integer> neighbors) {
		this.neighbors = neighbors;
	}
	
}
