package com.mvf314.escape.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.Disposable;

import com.mvf314.escape.Fonts;

import com.mvf314.escape.input.MenuInput;

import com.mvf314.escape.utils.Constants;

public class MenuRenderer implements Disposable {
	
	Fonts fonts;
	MenuInput input;
	/** Initialize the menu renderer and the fonts */
	public MenuRenderer() {
		input = new MenuInput();
		fonts = new Fonts();
	}
	
	/**
	 * Render the menu
	 * @param batch	The open sprite batch
	 */
	public void render(SpriteBatch batch) {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		fonts.menuText.draw(batch, "Play", Constants.APP_WIDTH / 2 - 100, 100);
		fonts.menuText.draw(batch, "Options", Constants.APP_WIDTH / 2 - 150, 50);
		fonts.menuText.draw(batch, "Quit", Constants.APP_WIDTH / 2 - 100, 0);
	}
	
	/**
	 * Get input from the menu
	 * @return An int representing the button clicked
	 */
	public int getInput() {
		if (input.isPlayClicked()) {
			return 1;
		} else if (input.isOptionsClicked()) {
			return 2;
		} else if (input.isQuitClicked()) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public void dispose() {
		fonts.dispose();
	}
	
}
