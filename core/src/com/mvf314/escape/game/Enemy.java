package com.mvf314.escape.game;

import com.mvf314.escape.game.Tile;

public class Enemy {

	public int x;
	public int y;
	
	public Enemy(Tile[][] tiles, int x, int y) {
		tiles[y][x] = Tile.ENEMY;
		this.x = x;
		this.y = y;
	}
	
	public void update(Tile[][] tiles) {
		tiles[y][x] = Tile.ENEMY;
	}
	
	public void resetTile(Tile[][] tiles) {
		tiles[y][x] = Tile.SEA;
	}
	
	public void move(int x, int y, Tile[][] tiles) {
		
	}

}
