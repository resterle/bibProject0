package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Activity extends JPanel{
	
	// The Activity Class represents a single Panel of the Game;
	
	protected ParameterList params;
	
	// The run method will be called from the View;
	public final ParameterList run(ParameterList params){
		this.params=params;
		return start();
	}
	
	// Overwrite this method with your own Code.
	public ParameterList start(){
		
		String name = (String)params.getValue("name");
		
		JLabel jl = new JLabel(name);
		add(jl);
		
		params.addParameter("return", name+" ist cool.");
		
		return params;
	}
	
	
}
