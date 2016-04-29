package com.mvf314.escape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mvf314.escape.Fonts;

import com.mvf314.escape.states.StateManager;

public class Escape extends ApplicationAdapter {
	
	SpriteBatch batch;
	
	Fonts fonts;
	
	StateManager stateManager;
	
	@Override
	public void create() {
		// initialize all resources
		fonts = new Fonts();
		batch = new SpriteBatch();
		stateManager = new StateManager();
	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		batch.begin();
		
		// render the current game state
		stateManager.render(batch);
		
		batch.end();
	}
	
	@Override
	public void resize(int w, int h) {
		
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		fonts.dispose();
	}
}
