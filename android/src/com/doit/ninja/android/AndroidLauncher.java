package com.doit.ninja.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.doit.ninja.BushidoBlocks;
import com.doit.ninja.BushidoBlocks.Tienda;
import com.doit.ninja.GoogleGameHandler;
import com.doit.ninja.MainMenu;
import com.doit.ninja.RequestHandler;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import com.startapp.android.publish.StartAppAd;

public class AndroidLauncher extends AndroidApplication implements RequestHandler, GoogleGameHandler, GameHelperListener {
	
	protected String admobIdBanner = "ca-app-pub-2933986338396699/8236846360";
	protected String admobIdInterstitial = "ca-app-pub-2933986338396699/9713579569";

	protected String StartppDeveloperId = "102752237";
	protected String StartappAppId = "204864434";
	
	protected BushidoBlocks game;
	
	InterstitialAd interAdmob;
	AdView bannerAdmob;
	AdRequest adRequest;
	StartAppAd interStartApp;
	
	FrameLayout layout;
	
	//Google game services
	private GameHelper gameHelper;
	
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		
		StartAppAd.init(this, StartppDeveloperId, StartappAppId);
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useWakelock=true;
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		
		//BushidoBlocks game =new BushidoBlocks();
		game = new BushidoBlocks(Tienda.googlePlay, this, this);
		View gameView = initializeForView(game, config);
		
		bannerAdmob = new AdView(this);
		bannerAdmob.setAdSize(AdSize.SMART_BANNER);
		bannerAdmob.setAdUnitId(admobIdBanner);
		bannerAdmob.setLayoutParams(new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.TOP));
		
		layout = new FrameLayout(this);

		layout.addView(gameView, new FrameLayout.LayoutParams(
				FrameLayout.LayoutParams.MATCH_PARENT,
				FrameLayout.LayoutParams.MATCH_PARENT));
		
		setContentView(layout);
		
		adRequest = new AdRequest.Builder()//
		//.addTestDevice("F4FEEC4355D8B3EDD2003AE0659C0776")
		.build();
		
		bannerAdmob.loadAd(adRequest);
		
		interStartApp = new StartAppAd(this);
		interAdmob = new InterstitialAd(this);
		interAdmob.setAdUnitId(admobIdInterstitial);
		interAdmob.loadAd(adRequest);
		
		
		gameHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
		gameHelper.setup(this);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		interStartApp.onResume();
		interStartApp.loadAd();
		bannerAdmob.resume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		bannerAdmob.pause();
		super.onPause();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		gameHelper.onStart(this);
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		gameHelper.onStop();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		gameHelper.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		bannerAdmob.destroy();
		super.onDestroy();
	}
	
	@Override
	public void showBanner() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				layout.addView(bannerAdmob);
			}
		});
		
	}

	@Override
	public void hideBanner() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				layout.removeView(bannerAdmob);
			}
		});
		
	}

	@Override
	public void showInterstitial() {
runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				showStartAppInterstitial();
				
			}
		});
		
		
	}
	
	public void showStartAppInterstitial() {
		if (interStartApp.isReady()) {
			interStartApp.showAd();
		}
		else {

			showGoogleInterstitial();
		}
		interStartApp.loadAd();
	}
	
	public void showGoogleInterstitial() {
		interAdmob.show();
		interAdmob.loadAd(adRequest);

	}

	@Override
	public void signIn() {
		try{
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					gameHelper.beginUserInitiatedSignIn();
					
				}
			});
		}
		catch(final Exception ex){
			
		}
	}

	@Override
	public boolean isSignedIn() {
		return gameHelper.isSignedIn();
	}

	@Override
	public void submitScore(long score) {
		if(!isSignedIn())
			return;
		Games.Leaderboards.submitScore(gameHelper.getApiClient(), "CgkI-K_h9IwZEAIQAA", score);
		
	}

	@Override
	public void getLeaderboards() {
		startActivityForResult(
				Games.Leaderboards.getLeaderboardIntent(
						gameHelper.getApiClient(), "CgkI-K_h9IwZEAIQAA"), 100);
		
		
	}

	@Override
	public void onSignInFailed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSignInSucceeded() {
		// TODO Auto-generated method stub
		
	}
}
