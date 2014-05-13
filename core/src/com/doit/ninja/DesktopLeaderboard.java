package com.doit.ninja;

import com.badlogic.gdx.Gdx;

public class DesktopLeaderboard implements Leaderboard {
	public void submitScore(int score) {
		   Gdx.app.log("DesktopLeaderboard would have submitted score:", ":" + score);
		}

		public void showLeaderboards() {
		};

		public void showDash() {
		};
	}
