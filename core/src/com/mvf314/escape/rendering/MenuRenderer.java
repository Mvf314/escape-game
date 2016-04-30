package com.mvf314.escape.rendering;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mvf314.escape.Fonts;
import com.mvf314.escape.input.MenuInput;
import com.mvf314.escape.utils.Constants;

public class MenuRenderer {
	
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
		fonts.menuText.draw(batch, "Play", Constants.APP_WIDTH / 2 - 100, 100);
		fonts.menuText.draw(batch, "Options", Constants.APP_WIDTH / 2 - 150, 50);
		fonts.menuText.draw(batch, "Quit", Constants.APP_WIDTH / 2 - 100, 0);
	}
	
	public void getInput() {
		input.isPlayClicked();
		input.isOptionsClicked();
	}
	
}
