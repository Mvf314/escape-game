package com.mvf314.escape.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.math.Vector2;

public class MenuInput {
	
	Vector2 mousePos;
	
	public boolean isPlayClicked() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			if (mousePos.x > 1160 && mousePos.x < 1280 && mousePos.y > 250 && mousePos.y < 300) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isOptionsClicked() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			if (mousePos.x > 1110 && mousePos.x < 1280 && mousePos.y > 300 && mousePos.y < 350) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isQuitClicked() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			mousePos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
			if (mousePos.x > 1160 && mousePos.x < 1280 && mousePos.y > 350 && mousePos.y < 400) {
				return true;
			}
		} else if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			return true;
		}
		return false;
	}
	
}
