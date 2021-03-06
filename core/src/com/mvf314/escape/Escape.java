package com.mvf314.escape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;

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
	
	// tfw you realize your entry point is looking incredibly clean but the code behind looks like horseshit
	
	@Override
	public void create() {
		// initialize resources and some other shit
		cam = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
		fonts = new Fonts();
		batch = new SpriteBatch();
		stateManager = new StateManager();
	}

	@Override
	public void render() {
		//  set projection matrix (no shit)
		batch.setProjectionMatrix(cam.combined);
		
		batch.begin();
		
		// render the current game state
		stateManager.render(batch);
		
		// if "Quit" is pressed
		if (!stateManager.handleInput()) {
			Gdx.app.exit();
		}
		
		batch.end();
	}
	
	@Override
	public void resize(int w, int h) {
		Gdx.graphics.setWindowedMode(Constants.APP_WIDTH, Constants.APP_HEIGHT);
	}
	
	@Override
	public void pause() {
		
	}
	
	@Override
	public void resume() {
		
	}
	
	@Override
	public void dispose() {
		// dispose some shit
		// I dont even know why I'm writing these comments anymore
		batch.dispose();
		fonts.dispose();
		
	}
}
