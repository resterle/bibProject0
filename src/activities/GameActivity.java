package activities;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.GameModel;
import model.PicsMapper;

import controller.Controller;
import view.Activity;
import view.ImageButton;

public class GameActivity extends Activity {
	
	public static final String PARAMS_PIC = "pic";
	public static final String PARAMS_SORT = "sort";
	public static final String PARAMS_BLACK = "black";
	public static final String PARAMS_NEIGHBORS = "neighbors";
	
	public static final String RETURN_SELECTED = "selected";
	
	public GameActivity(Controller controller) {
		super(controller);
	}
	
	@Override
	public void start() {
		
		setLayout(null);
		
		JPanel bilder = new JPanel();		
		JPanel buttons = new JPanel();
		ImageButton back = new ImageButton(PicsMapper.BLACK_BACK_BUTTON);
		ImageButton mix = new ImageButton(PicsMapper.RESHUFFLE_BUTTON);
		JLabel time = new JLabel();
	
		
		ArrayList<Image> pics = (ArrayList<Image>) params.getValue(PARAMS_PIC);
		
		int black = (Integer)params.getValue(PARAMS_BLACK);
		int[] sort = (int[]) params.getValue(PARAMS_SORT);
		ArrayList<Integer> neighbors = (ArrayList<Integer>) params.getValue(PARAMS_NEIGHBORS);
		
		int size = (int) Math.sqrt(sort.length+1);
		
		bilder.setLayout(new GridLayout(size, size));
		buttons.setLayout(new GridLayout(1, 3));
		
		bilder.setBounds(0, 0, 800, 500);
		buttons.setBounds(0, 520, 800, 100);
		
		buttons.add(back);
		buttons.add(mix);
		buttons.add(time);
		
		int a = 0;
		Iterator z = neighbors.iterator();
		while(z.hasNext())
		
		for(int i=0; i<(size*size); i++){
			final Integer r = new Integer(i);
			ImageButton ib = null;
			if(black==i){
				bilder.add(new JLabel("X"));
			}
			else{
				ib = new ImageButton(pics.get(sort[i]));
				bilder.add(ib);
			}
			if(neighbors.contains(i)){
				ib.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						returnParams.addParameter(RETURN_SELECTED, r);
						returnData();
					}
				});
			}
		}
		
		add(bilder);
		add(buttons);
		
	}
	
	private void draw(){
		
	}

}
