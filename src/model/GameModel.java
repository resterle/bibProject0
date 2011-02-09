package model;

public class GameModel {
	
	// The Model Class to store the Applicationdata.
	
	
	// Path of the selected Picture.
	
	private String picturePath;
	
	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	
	// The number of pieces.

	private int pieceCount;
	
	
	public int getPieceCount() {
		return pieceCount;
	}

	public void setPieceCount(int pieceCount) {
		this.pieceCount = pieceCount;
	}

	// The Player's name with geter's and setter's.
	private String playerName; 

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playersName) {
		this.playerName = playersName;
	}
	
	// The time in seconds the round takes. 
	
	private int starTime;


	public int getRoundTime() {
		return starTime;
	}

	public void setRoundTime(int roundTime) {
		this.starTime = roundTime;
	} 
	
	// The difficulty influenced the mix of the pieces.
	
	public final static int DIFF_EASY = 0;
	public final static int DIFF_NORMAL = 1;
	public final static int DIFF_HARD = 2;
	
	private int difficulty;


	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	//THe size influence the count of pieces in which the picture is sliced
	
	public final static int SIZE_4X4 = 0;
	public final static int SIZE_6X6 = 1;
	public final static int SIZE_8X8 = 2;
	
	private int size;


	public int getsize() {
		return size;
	}

	public void setsize(int size) {
		this.size = size;
	}
	
	
}
