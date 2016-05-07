package com.mvf314.escape.game;

import com.mvf314.escape.game.Tile;

public class Enemy {

	public int x;
	public int y;
	public Tile[][] tiles;
	
	public Enemy(Tile[][] tiles, int x, int y) {
		this.tiles = tiles;
		this.tiles[y][x] = Tile.ENEMY;
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		tiles[y][x] = Tile.ENEMY;
	}
	
	public void resetTile() {
		tiles[y][x] = Tile.SEA;
	}
	
	public void move(int x, int y) {
		resetTile();
		// shameless (collision detection) copy from game/Player.java
		if (x > 0) {
			if (!(this.x >= tiles[0].length - 1)) {
				this.x += x;
			}
		} else if (x < 0) {
			if (this.x != 0) {
				this.x += x;
			}
		}
		if (y > 0) {
			if (!(this.y >= tiles.length - 1)) {
				this.y += y;
			}
		} else if (y < 0) {
			if (this.y != 0) {
				this.y += y;
			}
		}
		update();
	}
	
	public void attackPlayer(Player player) {
		move(0, 1);
	}
}
