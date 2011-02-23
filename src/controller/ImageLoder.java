package controller;

import java.awt.Image;
import java.util.ArrayList;

import model.GalleryModel;
import model.ParameterList;

public class ImageLoder extends Thread{
	
	public static final String RETURN_PICS ="pics";
	
	private Controller controller;
	private GalleryModel model;
	
	public ImageLoder(Controller controller, GalleryModel galleryModel){
		this.controller = controller;
		model = galleryModel;
	}

	@Override
	public void run() {
		
		// ArrayList to store the leaden Images.
		
		ArrayList<Image> pics = new ArrayList<Image>(); 
		
		// Get images from model and store them in model.
		
		for(int i=0; i<model.getSize(); i++){
			pics.add(model.getImage(i));
		}
		
		// Create the ParameterList witch will be returned.
		
		ParameterList returnParams = new ParameterList();
		returnParams.addParameter(RETURN_PICS, pics);
		
		// Call the Controller to return the leaden Pictures.
		
		controller.returnData(this.getClass().getSimpleName(), returnParams);
	}
	

}
