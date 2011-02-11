package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.PicsMapper;

public class ImageButton extends JButton {
	
	private Image image;
	
	public ImageButton(String file){
		setRolloverEnabled(false);
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			System.out.println("INFO: Can't load "+file);
		}
	}
	
	public ImageButton(Image image){
		this.image = image;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
	
	
	
}
