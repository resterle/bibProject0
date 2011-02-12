package model;

public class Counter extends Thread {
	
	private int count = 0;
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(999);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
	}
	
	public int getCount(){
		return count;
	}
	
}
