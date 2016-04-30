package com.mvf314.escape.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class PausedInput {
	
	MenuInput menuInput;
	Vector2 mousePos;
	
	public PausedInput() {
		menuInput = new MenuInput();
	}
	
	public boolean isEscapePressed() {
		return Gdx.input.isKeyPressed(Input.Keys.ESCAPE);
	}
	
	public boolean isQuitClicked() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			if (mousePos.x > 1160 && mousePos.x < 1280 && mousePos.y > 420 && mousePos.y < 490) {
				return true;
			}
		}
		return false;
	}
	
}
