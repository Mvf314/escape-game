package com.mvf314.escape.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.math.Vector2;

public class DeadInput {
	
	Vector2 mousePos;

	public boolean isQuitClicked() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			if (mousePos.x > 1160 && mousePos.x < 1280 && mousePos.y > 350 && mousePos.y < 400) {
				return true;
			}
		}
		return false;
	}
	
}
