package com.doit.ninja.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.doit.ninja.BushidoBlocks.Tienda;
import com.doit.ninja.DesktopLeaderboard;
import com.doit.ninja.GoogleGameHandler;
import com.doit.ninja.MainMenu;
import com.doit.ninja.RequestHandler;
import com.doit.ninja.desktop.ActionResolverDesktop;
import com.doit.ninja.BushidoBlocks;

/*
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new MainMenu(), config);
	}
}*/


public class DesktopLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Bushido Blocks";
		cfg.width = 480;
		cfg.height = 800;
		new LwjglApplication(new BushidoBlocks(Tienda.googlePlay, reqHandler, gameHandler), cfg);
	
		//new LwjglApplication(new BushidoBlocks(new DesktopLeaderboard(), new ActionResolverDesktop()), cfg);
	}
	
	static GoogleGameHandler gameHandler = new GoogleGameHandler() {
		
		@Override
		public void submitScore(long score) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void signIn() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean isSignedIn() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void getLeaderboards() {
			// TODO Auto-generated method stub
			
		}
	};
	
	static RequestHandler reqHandler = new RequestHandler() {
		
		@Override
		public void showInterstitial() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void showBanner() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void hideBanner() {
			// TODO Auto-generated method stub
			
		}
	};
}
