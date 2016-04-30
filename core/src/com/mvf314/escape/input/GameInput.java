package com.mvf314.escape.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class GameInput {
	
	InputContainer ic;
	
	public GameInput() {
		ic = new InputContainer();
	}
	
	public boolean isEscapePressed() {
		return Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE);
	}
	
	public InputContainer getInput() {
		return ic.update();
	}
	
}
