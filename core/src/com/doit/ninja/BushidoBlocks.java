package com.doit.ninja;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.ApplicationListener;

public class BushidoBlocks extends Game implements ApplicationListener  {
    
    private ActionResolver actionResolver; // for platform-specific actions
    private Leaderboard leaderboard; // for Swarm leaderboard on Android
    
    public enum Tienda {
    	googlePlay, appleStore;
    }
    
    final public Tienda tiendactual;
    
    final public RequestHandler reqHandler;
    
    final public GoogleGameHandler gameHandler;
    
    public BushidoBlocks(Tienda tienda, RequestHandler reqHandler, GoogleGameHandler handler) {
    	
    	tiendactual=tienda;
    	this.reqHandler=reqHandler;
    	gameHandler = handler;
    	
    };
    /*
    public BushidoBlocks(Leaderboard leaderboard, ActionResolver ar) {
        this.leaderboard = leaderboard;
        this.actionResolver = ar;
    };
    */
    @Override
    public void create() {  
        // load the first screen - the splash screen
    	Assets.load();
        setScreen(new MainMenu(this));
    }

    @Override
    public void dispose() {
        super.dispose();
    }
    
//    public Leaderboard getLeaderboard() {
//        return leaderboard;
//    }
//    
//    public ActionResolver getActionResolver() {
//        return actionResolver;
//    }
}

