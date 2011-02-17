package activities;

import model.GameModel;

public class Timer extends Thread{
	
	private GameActivity ga;
	private GameModel m;
	
	public Timer(GameActivity ga, GameModel m){
		this.ga = ga;
		this.m=m;
	}
	
	@Override
	public void run() {
		super.run();
		while(true){
			ga.setTime(m.getRoundTime());
			try {
				sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
