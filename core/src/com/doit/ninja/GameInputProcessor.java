package com.doit.ninja;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

public class GameInputProcessor implements InputProcessor {
	
	// reference to the game
	BushidoBlocks game;

	public GameInputProcessor(BushidoBlocks game) {
		this.game = game;
	}

	@Override
	public boolean keyDown (int keycode) {
		
		//if escape or back key pressed go to main menu
		if (keycode == (Keys.BACK) || keycode == (Keys.ESCAPE)){
			game.setScreen(new MainMenu(game));
		}   
		
		return false;
	}

	@Override
	public boolean keyUp (int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped (char character) {
		return false;
	}

	@Override
	public boolean touchDown (int x, int y, int pointer, int button) {
      return false;
   }

   @Override
   public boolean touchUp (int x, int y, int pointer, int button) {
      return false;
   }

   @Override
   public boolean touchDragged (int x, int y, int pointer) {
      return false;
   }

   public boolean touchMoved (int x, int y) {
      return false;
   }

   @Override
   public boolean scrolled (int amount) {
      return false;
   }

   @Override
   public boolean mouseMoved(int screenX, int screenY) {
	   return false;
   }
}