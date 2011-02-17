package model;

import activities.GameActivity;

public class Counter extends Thread {

	private int count;
	private GameModel m;
	GameActivity ga;
	
	public Counter(GameModel m, GameActivity ga){
		this.m=m;
		count = m.getRoundTime();
	}
	
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
			m.setRoundTime(count);
			System.out.println(ga);
			ga.setTime(count);
		}
	}
	
	public int getCount(){
		return count;
	}
	
}
