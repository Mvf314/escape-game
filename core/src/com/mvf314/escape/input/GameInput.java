package com.mvf314.escape.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GameInput {
	
	public boolean isEscapePressed() {
		return Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE);
	}
	
}
