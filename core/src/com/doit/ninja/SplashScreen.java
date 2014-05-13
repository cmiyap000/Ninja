package com.doit.ninja;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SplashScreen implements Screen {
    // the main application
    private BushidoBlocks game;

    // Scene2d stage
    private Stage stage;

    // sandeel logo
    private Image splashImage;  

    // for timing out the logo
    private GameTimer timer;

    public SplashScreen(BushidoBlocks game) {
        this.game = game;
        this.stage=new Stage();
       // this.stage = new Stage(480,800,false);

        // create the logo
        Texture splashTexture = new Texture(Gdx.files.internal("splash.png"));
        splashImage = new Image(splashTexture);
        splashImage.addAction(Actions.fadeIn( 0.5f ));
        stage.addActor(splashImage);

        // time 4 seconds
        timer = new GameTimer(4000);
        timer.start();
    }

    @Override
    public void render(float delta) {
        // clear the screen with the given RGB color (black)
        Gdx.gl.glClearColor( 0f, 0f, 0f, 1f );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT );

        // draw the actors
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        // skip if screen touched (or clicked)
        if(Gdx.input.justTouched() || timer.getTimeRemaining() <= 0) {
            fadeOut();
        }
    }

    /*
     * darken the image and go to next main menu
     */
    public void fadeOut () {
        splashImage.addAction(Actions.sequence( Actions.fadeOut( 0.5f ),  new Action() {
              public boolean act(float delta) {
                   game.setScreen(new MainMenu(game));
                   return true; // returning true consumes the event
              }
        }));
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
