package activities;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.GalleryModel;
import view.Activity;
import view.ImageButton;
import controller.Controller;

public class GalleryActivity extends Activity {

	public static final String PARAM_PICS = "pics";
	public static final String RETURN_PIC = "pic";
	
	// The Gallerymodel.
	
	private GalleryModel model;
	
	public GalleryActivity(Controller controller) {
		super(controller);
	}
	
	@Override
	public void start() {
		
		setLayout(new GridLayout(3, 3, 10, 10));
		
		// Get Pictures from params.
		
		ArrayList<Image> pics = (ArrayList<Image>)params.getValue(PARAM_PICS);
		
		// Add JButtons with the Pictures to the Activity.
		
		for(int i=0; i<9; i++){
			final Image image = pics.get(i);
			ImageButton ib = new ImageButton(Graphics.scale(image, 200, 100));
			ib.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					returnParams.addParameter(RETURN_PIC, image);
					returnData();
				}
			});
			add(ib);
		}
	}

}
