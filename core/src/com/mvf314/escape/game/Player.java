package com.mvf314.escape.game;

import com.mvf314.escape.game.Tile;

public class Player {

	public int x;
	public int y;
	
	public Player(Tile[][] tiles, int x, int y) {
		tiles[y - 1][x - 1] = Tile.PLAYER;
		this.x = x;
		this.y = y; 
	}
	
	public void update(Tile[][] tiles) {
		tiles[y - 1][x - 1] = Tile.PLAYER;
	}
	
	public void resetTile(Tile[][] tiles) {
		tiles[y - 1][x - 1] = Tile.SEA;
	}
	
	public void move(int x, int y, Tile[][] tiles) {
		resetTile(tiles);
		this.y += y;
		this.x += x;
		update(tiles);
	}

}
