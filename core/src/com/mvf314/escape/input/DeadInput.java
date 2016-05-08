package com.mvf314.escape.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.math.Vector2;

public class DeadInput {
	
	Vector2 mousePos;

	public boolean isQuitClicked() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			if (mousePos.x > 540 && mousePos.x < 750 && mousePos.y > 650 && mousePos.y < 720) {
				return true;
			}
		} else if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			return true;
		}
		return false;
	}
	
}
