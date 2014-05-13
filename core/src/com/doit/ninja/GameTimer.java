package com.doit.ninja;

public class GameTimer {
	
	long timeStarted;
	long timeToFinish;
	
	public GameTimer(long countDownTime) {
		// set initial time remaining
		this.timeToFinish = System.currentTimeMillis() + countDownTime;
	}

	public void start() {
		timeStarted = System.currentTimeMillis();
	}
	
	public void addTime(long timeToAdd) {
		timeToFinish += (timeToAdd * 1000);
	}
	
	public long getTimeRemaining() {
		return (timeToFinish - System.currentTimeMillis());
	}
	
	public int getTimeRemainingInSeconds() {
		return (int)((timeToFinish - System.currentTimeMillis()) / 1000);
	}
}
