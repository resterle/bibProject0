package activities;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageFilter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import model.PicsMapper;
import model.Utils;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class ChoosePicActivity extends Activity {

	public ChoosePicActivity(Controller controller) {
		super(controller);
	}
	
	//Keys for returning Values to Controller
	public final static String RETURN_PATH = "path";
	
	//Text Field with the length of 30 chars
	//JTextField playerName = new JTextField(30);
	
	public void start() {
		
		
		setLayout(null);
		
		//playerName.setBounds(380, 200, 300, 20);
		
		//Declaration of the "OK" Button
		ImageButton okayB = new ImageButton(PicsMapper.OKAY_BUTTON);
		okayB.setBounds(200, 200 , 250, 100 );
		
		//JLabel declaration
		//JLabel nameL = new JLabel("Enter the path of the picture: ");
		final JFileChooser jfc = new JFileChooser();
		jfc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return true;
				    }

				    String extension = Utils.getExtension(f);
				    if (extension != null) {
					if (extension.equals(Utils.tiff) ||
					    extension.equals(Utils.tif) ||
					    extension.equals(Utils.gif) ||
					    extension.equals(Utils.jpeg) ||
					    extension.equals(Utils.jpg) ||
					    extension.equals(Utils.png)) {
					        return true;
					} else {
					    return false;
					}
				    }

				    return false;

			}
		});
		//nameL.setFont(new Font("Times New Roman",1,20));
		jfc.setBounds(50, 50, 700, 500);
				
		
		//Layout declaration
		add(jfc);
		
		if (jfc.showOpenDialog(this) == JFileChooser.OPEN_DIALOG){
		System.out.println(jfc.getSelectedFile().toString());
		returnParams.addParameter(RETURN_PATH, jfc.getSelectedFile().toString());
		returnData();
		}
		
		
	}
		

}
