package com.mvf314.escape.game;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mvf314.escape.game.Tile;
import com.mvf314.escape.game.Player;

import com.mvf314.escape.input.GameInput;
import com.mvf314.escape.input.InputContainer;

public class Board {
	
	public Tile[][] tiles;
	
	public Sprite sea;
	public Sprite playerSpr;
	
	public GameInput input;
	
	public Player player;
	
	public Board() {
		
		input = new GameInput();
		
		sea = new Sprite(new Texture(Gdx.files.internal("../res/tile/sea.png")));
		playerSpr = new Sprite(new Texture(Gdx.files.internal("../res/tile/player.png")));
		
		tiles = new Tile[15][10];
		for (Tile[] tileArray : tiles) {
			Arrays.fill(tileArray, Tile.SEA);
		}
		
		player = new Player(tiles, 3, 4);
	}
	
	public void update(SpriteBatch batch) {
		// x and y position of where to draw sprites, will change while drawing
		int x = -tiles.length * 16;
		int y = tiles[0].length * 16;
		// counter for loop, will update x and y etc
		int c = 0;
		for (Tile[] tileArray : tiles) {
			for (Tile tile : tileArray) {
				c++;
				if (c % tileArray.length == 0) {
					render(tile, batch, x, y);
					x = x - (32 * (tileArray.length - 1));
					y = y - 32;
					//System.out.println(tile);
				} else {
					render(tile, batch, x, y);
					x = x + 32;
					//System.out.print(tile);
				}
			}
		}
		handleInput(input.getInput());
	}
	
	public void handleInput(InputContainer input) {
		if (input.s) {
			player.move(0, 1, tiles);
		} else if (input.w) {
			player.move(0, -1, tiles);
		}
		if (input.a) {
			player.move(-1, 0, tiles);
		} else if (input.d) {
			player.move(1, 0, tiles);
		}
	}
	
	public void render(Tile tile, SpriteBatch batch, int x, int y) {
		if (tile == Tile.SEA) {
			sea.setPosition(x, y);
			sea.draw(batch);
		} else if (tile == Tile.PLAYER) {
			playerSpr.setPosition(x, y);
			playerSpr.draw(batch);
		}
	}
	
}
