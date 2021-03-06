package com.mvf314.escape.rendering;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mvf314.escape.Fonts;
import com.mvf314.escape.game.Board;
import com.mvf314.escape.input.GameInput;

public class GameRenderer {
	
	public GameInput input;
	public Fonts fonts;
	public Board board;
	public boolean dead;
	
	public GameRenderer() {
		input = new GameInput();
		fonts = new Fonts();
		board = new Board();
		dead = false;
	}
	
	public void render(SpriteBatch batch) {
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		board.update(batch);
		if (board.checkDeath(board.player)) {
			dead = true;
		}
	}
	
	public int getInput() {
		if (input.isEscapePressed()) {
			return -1;
		}
		if (dead) {
			return 1;
		}
		return 0;
	}
}
