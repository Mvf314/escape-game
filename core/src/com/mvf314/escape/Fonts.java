package com.mvf314.escape;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Color;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

import com.badlogic.gdx.utils.Disposable;

public class Fonts implements Disposable {
	
	public GlyphLayout gl;
	public BitmapFont menuText;
	public BitmapFont statText;
	
	private FreeTypeFontGenerator gen;
	
	/** Initialize fonts */
	public Fonts() {
		/*
		 * ----- MENU FONT -----
		 */
		gl = new GlyphLayout();
		gen = new FreeTypeFontGenerator(Gdx.files.internal("../res/font/OpenSans.ttf"));
		FreeTypeFontParameter p = new FreeTypeFontParameter();
		p.size = 28;
		p.borderWidth = 1;
		p.color = Color.SCARLET;
		p.borderColor = Color.RED;
		menuText = gen.generateFont(p);
		/*
		 * ----- STAT FONT -----
		 */
		p = new FreeTypeFontParameter();
		p.size = 18;
		p.borderWidth = 0;
		p.color = Color.WHITE;
		statText = gen.generateFont(p);
	}
	
	public float getHalfWidth(BitmapFont font, String text) {
		gl.setText(font, text);
		return gl.width / 2;
	}
	
	@Override
	/** Dispose of the bitmap font generator */
	public void dispose() {
		gen.dispose();
	}
}
