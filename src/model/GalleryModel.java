package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.management.ImmutableDescriptor;
import javax.swing.ImageIcon;

public class GalleryModel {
	
	// ArrayList to store the Imagepaths.
	
	private ArrayList<String> picturePaths;
	
	// Constructor.
	
	public GalleryModel(ArrayList<String> paths){
		picturePaths=paths;
	}
	
	// Returns the number Images stored in the Model.
	
	public int getSize(){
		return picturePaths.size();
	}
	
	// Add a Picture to the Gallery. 
	
	public void addImage(String path){
		picturePaths.add(path);
	}
	
	// Returns an Image at a specific index.
	
	public BufferedImage getImage(int index){
		if(index<getSize()){
			try {
				return ImageIO.read(new File(picturePaths.get(index)));
			} catch (IOException e) {
				System.out.println("INFO: Can't load Immage."+picturePaths.get(index));
			}
		}
			
		return null;
	}
	
}
