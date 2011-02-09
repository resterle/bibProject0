package activities;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import model.GalleryModel;

import controller.Controller;
import view.Activity;

public class GalleryActivity extends Activity {

	public static final String PARAM_PICS = "pics";
	
	// The Gallerymodel.
	
	private GalleryModel model;
	
	public GalleryActivity(Controller controller) {
		super(controller);
	}
	
	@Override
	public void start() {
		
		setLayout(new GridLayout(3, 3));
		
		// Get Pictures from params.
		
		ArrayList<Image> pics = (ArrayList<Image>)params.getValue(PARAM_PICS);
		
		// Add JButtons with the Pictures to the Activity.
		
		for(int i=0; i<9; i++){
			add(new JButton(new ImageIcon(pics.get(i))));
		}
	}

}
