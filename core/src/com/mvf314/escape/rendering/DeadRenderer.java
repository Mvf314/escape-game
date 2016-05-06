package com.mvf314.escape.rendering;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mvf314.escape.Fonts;
import com.mvf314.escape.game.Board;
import com.mvf314.escape.input.DeadInput;
import com.mvf314.escape.utils.Constants;

public class DeadRenderer {
	
	public DeadInput input;
	public Fonts fonts;
	public Board board;
	public boolean dead;
	
	public DeadRenderer(Board board) {
		input = new DeadInput();
		fonts = new Fonts();
		this.board = board;
		dead = false;
	}
	
	public void render(SpriteBatch batch) {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		fonts.statText.draw(batch, "Statistics", -fonts.getHalfWidth(fonts.statText, "Statistics"), Constants.APP_HEIGHT / 2 - 50);
		fonts.statText.draw(batch, "Tiles traversed: " + board.player.movedTiles, -fonts.getHalfWidth(fonts.statText, "Tiles traversed: " + board.player.movedTiles), Constants.APP_HEIGHT / 2 - 100);
		
		fonts.menuText.draw(batch, "Quit to menu", -fonts.getHalfWidth(fonts.menuText, "Quit to menu"), -Constants.APP_HEIGHT / 2 + 50);
	}
	
	public int getInput() {
		if (input.isQuitClicked()) {
			return -1;
		}
		return 0;
	}
}
