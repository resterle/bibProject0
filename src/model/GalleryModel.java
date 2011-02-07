package model;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GalleryModel {
	
	// ArrayList to store the Imagepaths.
	
	private ArrayList<String> picturePaths;
	
	// Returns the number Images stored in the Model.
	
	public int getSize(){
		return picturePaths.size();
	}
	
	// Add a Picture to the Gallery. 
	
	public void addImage(String path){
		picturePaths.add(path);
	}
	
	// Returns an Image at a specific index.
	
	public ImageIcon getImage(int index){
		if(index<getSize())
			return new ImageIcon(picturePaths.get(index));
		return null;
	}
	
}
