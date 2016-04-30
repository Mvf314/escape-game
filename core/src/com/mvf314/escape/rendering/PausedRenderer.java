package com.mvf314.escape.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mvf314.escape.Fonts;
import com.mvf314.escape.input.PausedInput;

public class PausedRenderer {
	
	public PausedInput input;
	public Fonts fonts;
	
	public PausedRenderer() {
		input = new PausedInput();
		fonts = new Fonts();
	}
	
	public void render(SpriteBatch batch) {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		fonts.menuText.draw(batch, "Paused", 100, 20);
	}
	
	public int getInput() {
		if (input.isEscapePressed()) {
			return 1;
		}
		
		
		return 0;
	}
	
}
