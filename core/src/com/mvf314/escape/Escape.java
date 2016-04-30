package com.mvf314.escape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mvf314.escape.Fonts;

import com.mvf314.escape.states.StateManager;

import com.mvf314.escape.utils.Constants;

public class Escape extends ApplicationAdapter {
	
	OrthographicCamera cam;
	
	SpriteBatch batch;
	
	Fonts fonts;
	
	StateManager stateManager;
	
	@Override
	public void create() {
		// initialize all resources
		cam = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
		fonts = new Fonts();
		batch = new SpriteBatch();
		stateManager = new StateManager();
	}

	@Override
	public void render() {
		// clear screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		
		// render the current game state
		stateManager.render(batch);
		stateManager.getInput();
		
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
