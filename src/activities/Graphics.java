package activities;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import model.GameModel;

public class Graphics { 
	

    public static ImageIcon scale(Image src, double scale) {
        int w = (int)(scale*src.getWidth(null));
        int h = (int)(scale*src.getHeight(null));
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(w, h, type);
        Graphics2D g2 = dst.createGraphics();
        g2.drawImage(src, 0, 0, w, h, null);
        g2.dispose();
        return new ImageIcon(dst);
    }
    
    public static Image scale(Image src, int width, int height) {
        int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(width, height, type);
        Graphics2D g2 = dst.createGraphics();
        g2.drawImage(src, 0, 0, width, height, null);
        g2.dispose();
        return dst;
    }
    
    public static ArrayList<Image> subImage(Image img, int size, int width, int height){
    	int type = BufferedImage.TYPE_INT_RGB;
        BufferedImage dst = new BufferedImage(width, height, type);
        Graphics2D g2 = dst.createGraphics();
        g2.drawImage(img, 0, 0, width, height, null);
        g2.dispose();
        
        ArrayList<Image> returnPics = new ArrayList<Image>();
        
        int pices = 4;
        switch(size){
        	case GameModel.SIZE_6X6:
        		pices = 6;
        		break;
        	case GameModel.SIZE_8X8:
        		pices = 8;
        		break;
        }
        
        int pWith = width/pices;
        int pHeight = height/pices;
        
        int x = 0;
        int y = 0;
        
        for(int i=0; i<(pices); i++){
        	for(int j=0; j<(pices); j++){
            	
            }
        }
        
        dst.getSubimage(0, 0, 10, 10);
        
        
        return null;
    }
	
}
