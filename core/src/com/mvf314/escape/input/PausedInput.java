package com.mvf314.escape.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class PausedInput {
	
	public boolean isEscapePressed() {
		return Gdx.input.isKeyPressed(Input.Keys.ESCAPE);
	}
	
}
