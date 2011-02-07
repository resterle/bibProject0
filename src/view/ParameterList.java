package view;

import java.util.ArrayList;
import java.util.ListIterator;

public class ParameterList {
	
	// ArrayLists to store the key- value pairs.
	
	private ArrayList<String> keys;
	private ArrayList<Object> values;
	
	// Constructor without parameters
	
	public ParameterList(){
		keys = new ArrayList<String>();
		values = new ArrayList<Object>();
		
	}
	
	// Constructor with given ArrayLists
	
	public ParameterList(ArrayList<String> keys, ArrayList<Object> values) {
		
		// Create empty ArrayLists if keys and values don't have the same size.
		
		if(keys.size()!=values.size()){
			keys = new ArrayList<String>();
			values = new ArrayList<Object>();
			return;
		}
		
		// Set the ArrayLists.
		
		this.keys = keys;
		this.values = values;
	}
	
	// Add a new Key- Valuepair.
	
	public void addParameter(String key, Object value){
		
		keys.add(key);
		values.add(value);
		
	}
	
	// Get a Value.
	
	public Object getValue(String key){
		
		// Iterate over the Keys wile gets the right key and returns the linked Object. Returns null if the key is not known.
		
		ListIterator<String> i = keys.listIterator();
		while(i.hasNext()){
			String temp = i.next();
			System.out.println(temp);
			if(temp.equals(key))
				return values.get(i.previousIndex());
		}
		
		return null;
		
	}
	
	
}
