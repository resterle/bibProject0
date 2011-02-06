package framework;

import javax.swing.JPanel;

public abstract class Activity extends JPanel{
	
	// The Activity Class represents a single Panel of the Game;
	
	// The Application witch starts the Activity
	protected View app;
	
	// Method to set the app
	public void setApp(View app){
		this.app = app;
	}
	
}
