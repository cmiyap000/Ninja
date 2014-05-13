package com.doit.ninja;

public interface GoogleGameHandler {

	public void signIn();
	
	public boolean isSignedIn();
	
	public void submitScore(long score);
	
	public void getLeaderboards();
	
	
}
