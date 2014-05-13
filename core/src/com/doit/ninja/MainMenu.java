package com.doit.ninja;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.doit.ninja.BushidoBlocks.Tienda;

public class MainMenu implements Screen {
    //reference to the app
    private BushidoBlocks game;

    //Scene2D stage
    private Stage stage;

    //rendering stuff
    private OrthographicCamera camera;
    private SpriteBatch batch;

    ImageButton leadersButton;
    ImageButton playButton;
    ImageButton rateButton;
    ImageButton soundButton;
    ImageButton musicButton;
    //background image
    
   

    //the red "x" that shows sound or music button off
    private Texture buttonOff;
    private Texture no_music;
    private Texture no_sound;

    //game preferences
    private Preferences prefs;

    public MainMenu(final BushidoBlocks game) {
        this.game = game;
        stage=new Stage(new StretchViewport(480, 800));
        //stage = new Stage(480, 800, false);

        //let the stage handle input
        Gdx.input.setInputProcessor(stage);

        //back button should exit the app here
        Gdx.input.setCatchBackKey(false);

        //rendering stuff
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);
        batch = new SpriteBatch();
        
        leadersButton = new ImageButton(new TextureRegionDrawable(Assets.leaders));
        playButton = new ImageButton(new TextureRegionDrawable(Assets.play));
        rateButton = new ImageButton(new TextureRegionDrawable(Assets.rate));
        soundButton = new ImageButton(new TextureRegionDrawable(Assets.sonidos));
        musicButton = new ImageButton(new TextureRegionDrawable(Assets.musica));

        //load the background image
       /* background = new Texture(Gdx.files.internal("main_menu_background.png"));
        personaje = new Texture(Gdx.files.internal("personaje.png"));
        titulo = new Texture(Gdx.files.internal("Titulo.png"));
        musica = new Texture(Gdx.files.internal("btnMusic.png"));
        sonido = new Texture(Gdx.files.internal("btnSounds.png"));
        rate_bg = new Texture(Gdx.files.internal("btnRate.png"));
        leaders_bg = new Texture(Gdx.files.internal("btnLeaders.png"));
        play_bg = new Texture(Gdx.files.internal("btnPlay.png"));*/
        

        //button
        buttonOff = new Texture(Gdx.files.internal("button_off.png"));
        
        no_music = new Texture(Gdx.files.internal("NoMusic.png"));
        no_sound = new Texture(Gdx.files.internal("NoSounds.png"));

        /* the preferences */
        prefs = Gdx.app.getPreferences("My Preferences");

        // set all the prefs if they don't exist
        if (!prefs.contains("soundOn")) {
            prefs.putBoolean("soundOn", true);
            prefs.flush();
        }
        if (!prefs.contains("musicOn")) {
            prefs.putBoolean("musicOn", true);
            prefs.flush();
        }
        if (!prefs.contains("lastScore")) {
            prefs.putInteger("lastScore", 0);
            prefs.flush();
        }
        if (!prefs.contains("highScore")) {
            prefs.putInteger("highScore", 0);
            prefs.flush();
        }

        //skin needed for the buttons
       /* Skin skin;
        
        
        FileHandle skinFile = Gdx.files.internal("data/uiskin.json");
        skin = new Skin(skinFile);
        skin=new Skin();*/
    
       

        //textures for the buttons
      //  Texture textura_leaders = new Texture(Gdx.files.internal("Leaders.png"));
     //   Texture musicButtonDownTexture = new Texture(
       //         Gdx.files.internal("btnLeaders.png"));
        //TextureRegionDrawable leadersButtonUpRegion = new TextureRegionDrawable(new TextureRegion(textura_leaders));
      //  TextureRegionDrawable musicButtonDownRegion = new TextureRegionDrawable(
          //      new TextureRegion(musicButtonDownTexture));

        //final Button leadersButton = new Button(leadersButtonUpRegion);
        leadersButton.setPosition(30f, 220f);
        leadersButton.addListener(new InputListener() {

            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
            	//leadersButton.setY(leadersButton.getY()-3);
                return true;
            }

            public void touchUp(InputEvent event, float x, float y,
                    int pointer, int button) {
            	
            	if(game.gameHandler.isSignedIn())
            		game.gameHandler.getLeaderboards();
            	else
            		game.gameHandler.signIn();
            	/*leadersButton.setY(leadersButton.getY()+3);
                if (prefs.getBoolean("musicOn") == false) {
                    prefs.putBoolean("musicOn", true);
                    prefs.flush();
                } else if (prefs.getBoolean("musicOn") == true) {
                    prefs.putBoolean("musicOn", false);
                    prefs.flush();
                }*/
            }
        });
        stage.addActor(leadersButton);

     //   Texture rateButtonUpTexture = new Texture(
       //         Gdx.files.internal("Rate.png"));
        //Texture soundButtonDownTexture = new Texture(
          //      Gdx.files.internal("btnRate.png"));
        //TextureRegionDrawable rateButtonUpRegion = new TextureRegionDrawable(
          //      new TextureRegion(rateButtonUpTexture));
      //  TextureRegionDrawable soundButtonDownRegion = new TextureRegionDrawable(
        //        new TextureRegion(soundButtonDownTexture));

       // final Button rateButton = new Button(rateButtonUpRegion);
        
        
        rateButton.setPosition(360f, 220f);
        rateButton.addListener(new InputListener() {

            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
            	//rateButton.setY(rateButton.getY()-3);
                return true;
            }

            public void touchUp(InputEvent event, float x, float y,
                    int pointer, int button) {
            	
            	if(game.tiendactual==Tienda.googlePlay)
            		Gdx.net.openURI("https://play.google.com/store/apps/details?id=com.doit.pong");
            	else if(game.tiendactual==Tienda.appleStore)
            		Gdx.net.openURI("https://itunes.apple.com/us/app/tennis-master-hardest-game/id875626739?ls=1&mt=8");
            	
            	/*rateButton.setY(rateButton.getY()+3);
                if (prefs.getBoolean("soundOn") == false) {
                    prefs.putBoolean("soundOn", true);
                    prefs.flush();
                } else if (prefs.getBoolean("soundOn") == true) {
                    prefs.putBoolean("soundOn", false);
                    prefs.flush();
                }*/
            }
        });
        stage.addActor(rateButton);
        
//        Texture startButtonUpTexture = new Texture(
//                Gdx.files.internal("Play.png"));
//        Texture startButtonDownTexture = new Texture(
//                Gdx.files.internal("Play.png"));
//        TextureRegionDrawable startButtonUpRegion = new TextureRegionDrawable(
//                new TextureRegion(startButtonUpTexture));
//        TextureRegionDrawable startButtonDownRegion = new TextureRegionDrawable(
//                new TextureRegion(startButtonDownTexture));

        //start button
       // Button startButton = new Button(startButtonUpRegion, startButtonDownRegion);
        
        //BOTON PLAY
        
        //playButton.setPosition(190f, 210f);
        playButton.setPosition(170f, 210f);
        playButton.addListener(new InputListener() {

            Sound slash = Gdx.audio.newSound(Gdx.files.internal("whoosh.wav"));

            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
                if (prefs.getBoolean("soundOn"))
                    slash.play();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y,
                    int pointer, int button) {
                game.setScreen(new PlayScreen(game));
                slash.dispose();
            }
        });
        stage.addActor(playButton);
        
        
        Texture textura_music = new Texture(
                Gdx.files.internal("Music.png"));
       Texture musicButtonDownTexture = new Texture(
                Gdx.files.internal("Music.png"));
        TextureRegionDrawable musicButtonUpRegion = new TextureRegionDrawable(
                new TextureRegion(textura_music));
        TextureRegionDrawable musicButtonDownRegion = new TextureRegionDrawable(
               new TextureRegion(musicButtonDownTexture));

        final Button musicButton = new Button(musicButtonUpRegion, musicButtonDownRegion);
        musicButton.setPosition(35, 60);
        musicButton.addListener(new InputListener() {

            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
            //	musicButton.setY(musicButton.getY()-3);
                return true;
            }

            public void touchUp(InputEvent event, float x, float y,
                    int pointer, int button) {
            	//musicButton.setY(musicButton.getY()+3);
                if (prefs.getBoolean("musicOn") == false) {
                    prefs.putBoolean("musicOn", true);
                    prefs.flush();
                } else if (prefs.getBoolean("musicOn") == true) {
                    prefs.putBoolean("musicOn", false);
                    prefs.flush();
                }
            }
        });
        stage.addActor(musicButton);
        
        
        
      //  Texture soundButtonUpTexture = new Texture(
       //         Gdx.files.internal("Sounds.png"));
        //Texture soundButtonDownTexture = new Texture(
          //      Gdx.files.internal("btnRate.png"));
     //   TextureRegionDrawable soundButtonUpRegion = new TextureRegionDrawable(
       //         new TextureRegion(soundButtonUpTexture));
      //  TextureRegionDrawable soundButtonDownRegion = new TextureRegionDrawable(
        //        new TextureRegion(soundButtonDownTexture));

       // final Button soundButton = new Button(soundButtonUpRegion);
        
        soundButton.setPosition(420, 70);
        soundButton.addListener(new InputListener() {

            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
            	//soundButton.setY(soundButton.getY()-3);
                return true;
            }

            public void touchUp(InputEvent event, float x, float y,
                    int pointer, int button) {
            	//soundButton.setY(soundButton.getY()+3);
                if (prefs.getBoolean("soundOn") == false) {
                    prefs.putBoolean("soundOn", true);
                    prefs.flush();
                } else if (prefs.getBoolean("soundOn") == true) {
                    prefs.putBoolean("soundOn", false);
                    prefs.flush();
                }
            }
        });
        stage.addActor(soundButton);
        

        //Leaderboards button
        
       /* BitmapFont font=new BitmapFont();

        TextureAtlas atlas = new TextureAtlas(
				Gdx.files.internal("data/atlasMap.txt"));
        TextureRegion boton=new TextureRegion(atlas.findRegion("plataforma"));
        
        TextButtonStyle skin = new TextButtonStyle(new TextureRegionDrawable(
				boton), null, null, font);
        
        TextButton swarmButton = new TextButton("Leaderboards",skin);
        swarmButton.setPosition(90, 70);
        swarmButton.addListener(new InputListener() {

            Sound slash = Gdx.audio.newSound(Gdx.files.internal("whoosh.wav"));

            public boolean touchDown(InputEvent event, float x, float y,
                    int pointer, int button) {
                if (prefs.getBoolean("soundOn"))
                    slash.play();
                return true;
            }

            public void touchUp(InputEvent event, float x, float y,
                    int pointer, int button) {
                game.getLeaderboard().showDash();
                slash.dispose();
            }
        });
        stage.addActor(swarmButton);*/
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);

        // rendering
        batch.begin();

        // draw background
        batch.draw(Assets.fondo, 0, 0);
        batch.draw(Assets.karateka, 90, 200);
        batch.draw(Assets.titulo, 40, 620);
        batch.draw(Assets.musica_bg, 20, 50);
        batch.draw(Assets.sonido_bg, 390, 50);
        batch.draw(Assets.calificar_bg, 320, 200);
        batch.draw(Assets.tablas_bg, 15, 200);
        batch.draw(Assets.jugar_bg, 120, 185);
        
        batch.end();

        // handle input
        if (Gdx.input.justTouched()) {

            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
        }

        // draw the actors
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

        
        /////TACHAS//////
       batch.begin();
        if (prefs.getBoolean("soundOn") == false) {
            batch.draw(no_sound, 420, 70);
        }
        if (prefs.getBoolean("musicOn") == false) {
            batch.draw(no_music, 32, 58);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
       // background.dispose();
        buttonOff.dispose();
        batch.dispose();
        stage.clear();
        stage.dispose();
    }
}


