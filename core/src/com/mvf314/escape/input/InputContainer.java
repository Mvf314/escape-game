package com.mvf314.escape.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


// Goddammit again the inputcontainer NotLikeThis
public class InputContainer {

	public boolean w;
	public boolean a;
	public boolean s;
	public boolean d;
	
	public InputContainer() {
		w = false;
		a = false;
		s = false;
		d = false;
	}
	
	public InputContainer(boolean w, boolean a, boolean s, boolean d) {
		this.w = w;
		this.a = a;
		this.s = s;
		this.d = d;
	}
	
	public InputContainer update() {
		return new InputContainer(Gdx.input.isKeyPressed(Input.Keys.W), Gdx.input.isKeyPressed(Input.Keys.A), Gdx.input.isKeyPressed(Input.Keys.S), Gdx.input.isKeyPressed(Input.Keys.D));
	}

}
