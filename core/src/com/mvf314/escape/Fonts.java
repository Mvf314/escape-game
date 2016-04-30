package com.mvf314.escape;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import com.badlogic.gdx.utils.Disposable;

public class Fonts implements Disposable {
	
	public BitmapFont menuText;
	
	private FreeTypeFontGenerator gen;
	
	/** Initialize fonts */
	public Fonts() {
		/*
		 * ----- MENU FONT -----
		 */
		gen = new FreeTypeFontGenerator(Gdx.files.internal("../res/font/OpenSans.ttf"));
		FreeTypeFontParameter menuTextP = new FreeTypeFontParameter();
		menuTextP.size = 28;
		menuTextP.borderWidth = 1;
		menuTextP.color = Color.SCARLET;
		menuTextP.borderColor = Color.RED;
		menuText = gen.generateFont(menuTextP);
	}
	
	@Override
	/** Dispose of the bitmap font generator */
	public void dispose() {
		gen.dispose();
	}
}
