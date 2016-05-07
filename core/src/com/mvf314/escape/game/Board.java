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
	public Sprite enemySpr;
	
	public GameInput input;
	
	public Player player;
	public Enemy[] enemy;
	
	public Board() {
		enemy = new Enemy[10];
		input = new GameInput();
		
		sea = new Sprite(new Texture(Gdx.files.internal("../res/tile/sea.png")));
		playerSpr = new Sprite(new Texture(Gdx.files.internal("../res/tile/player.png")));
		enemySpr = new Sprite(new Texture(Gdx.files.internal("../res/tile/enemy.png")));
		
		tiles = new Tile[15][10];
		for (Tile[] tileArray : tiles) {
			Arrays.fill(tileArray, Tile.SEA);
		}
		
		player = new Player(tiles, 3, 4);
		enemy[0] = new Enemy(tiles, 5, 3);
	}
	
	public Enemy[] getEnemies() {
		return enemy;
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
				} else {
					render(tile, batch, x, y);
					x = x + 32;
				}
			}
		}
		handleInput(input.getInput());
		checkDeath(player);
	}
	
	public void handleInput(InputContainer input) {
		if (input.s) {
			player.move(0, 1);
		} else if (input.w) {
			player.move(0, -1);
		}
		if (input.a) {
			player.move(-1, 0);
		} else if (input.d) {
			player.move(1, 0);
		} else {
			// this line of code is so that move() gets executed every frame so that the cooldown works
			player.move(0, 0);
		}
	}
	
	public boolean checkDeath(Player player) {
		for (Enemy enemySingle : enemy) {
			try {
				// this line throws a nullptr exception when the whole enemy array is not filled
				if (enemySingle.x == player.x && enemySingle.y == player.y) {
					return true;
				}
			} catch (NullPointerException e) {
				// so a empty catch statement
				// fuck
			}
		}
		return false;
	}
	
	public void render(Tile tile, SpriteBatch batch, int x, int y) {
		if (tile == Tile.SEA) {
			sea.setPosition(x, y);
			sea.draw(batch);
		} else if (tile == Tile.ENEMY) {
			enemySpr.setPosition(x, y);
			enemySpr.draw(batch);
		} else if (tile == Tile.PLAYER) {
			playerSpr.setPosition(x, y);
			playerSpr.draw(batch);
		}
	}
	
}
