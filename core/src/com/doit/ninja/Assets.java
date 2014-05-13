package com.doit.ninja;

import java.util.Locale;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;

public class Assets {

	public static AtlasRegion fondo;
	public static AtlasRegion titulo;
	public static AtlasRegion karateka;
	public static AtlasRegion jugar_bg;
	public static AtlasRegion calificar_bg;
	public static AtlasRegion tablas_bg;
	public static AtlasRegion play;
	public static AtlasRegion rate;
	public static AtlasRegion leaders;
	public static AtlasRegion jugar;
	public static AtlasRegion calificar;
	public static AtlasRegion tablas;
	public static AtlasRegion sonido_bg;
	public static AtlasRegion musica_bg;
	public static AtlasRegion sonidos;
	public static AtlasRegion musica;
	public static AtlasRegion no_sound;
	public static AtlasRegion no_music;
	public static AtlasRegion time;
	public static AtlasRegion score;
	public static AtlasRegion tiempo;
	public static AtlasRegion puntuacion;
	public static AtlasRegion azul;
	public static AtlasRegion rojo;
	public static AtlasRegion amarillo;
	public static AtlasRegion gris;
	public static AtlasRegion morado;
	public static AtlasRegion horizontal;
	public static AtlasRegion vertical;
	public static AtlasRegion ways;
	
	
	public static void load()
	{
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("data/Karate.txt"));
		
		horizontal = atlas.findRegion("super_horizontal");
		vertical = atlas.findRegion("super_vertical");
		ways = atlas.findRegion("super_2ways");
		
		fondo = atlas.findRegion("Fondo");
		titulo = atlas.findRegion("Titulo");
		karateka = atlas.findRegion("Personaje");
		jugar_bg = atlas.findRegion("BtnPlay");
		calificar_bg = atlas.findRegion("btnRate");
		tablas_bg = atlas.findRegion("btnLeaders");
		sonido_bg = atlas.findRegion("btnSounds");
		musica_bg = atlas.findRegion("btnMusic");
		sonidos = atlas.findRegion("Sounds");
		musica = atlas.findRegion("Music");
		no_sound = atlas.findRegion("NoSounds");
		no_music = atlas.findRegion("NoMusic");
		azul = atlas.findRegion("Azul");
		rojo = atlas.findRegion("Rojo");
		amarillo = atlas.findRegion("Amarillo");
		gris = atlas.findRegion("Gris");
		morado = atlas.findRegion("Morado");
		String idioma = Locale.getDefault().getLanguage();
		if (idioma.equals("es")){
			
			play = atlas.findRegion("Jugar");
			rate = atlas.findRegion("Calificar");
			leaders = atlas.findRegion("Tablas");
			time = atlas.findRegion("Tiempo");
			score= atlas.findRegion("Puntuacion");
		}
		
		else
		{
			play = atlas.findRegion("Play");
			rate = atlas.findRegion("Rate");
			leaders = atlas.findRegion("Leaders");
			time = atlas.findRegion("Time");
			score= atlas.findRegion("Score");
		}
			
	}
}
