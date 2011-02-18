package model;

import activities.GameActivity;

public class Counter extends Thread {

	private GameModel m;
	private GameActivity ga;
	private int count;
	
	public Counter(GameModel m, GameActivity ga){
		this.m=m;
		this.ga=ga;
		System.out.println(m);
	}
	
	public void setActivity(GameActivity ga){
		this.ga=ga;
		count=0;
	}
	
	@Override
	public void run() {
		while(true){
			 count = m.getRoundTime();
			ga.setTime(count);
			try {
				Thread.sleep(999);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.setRoundTime(count+1);
		}
	}
	
}
