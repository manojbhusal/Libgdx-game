package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.PlayScreen;

public class MarioMan extends Game {
	public static SpriteBatch batch;
public static final float ppm=100;
	Controller controller;
	@Override
	public void create () {
		batch = new SpriteBatch();
   setScreen(new PlayScreen(this));


	}

	@Override
	public void render () {
  super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}
}
