package com.mvf314.escape.game;

import com.mvf314.escape.game.Tile;

public class Player {

	public int x;
	public int y;
	
	public Player(Tile[][] tiles, int x, int y) {
		tiles[y][x] = Tile.PLAYER;
		this.x = x;
		this.y = y; 
	}
	
	public void update(Tile[][] tiles) {
		tiles[y][x] = Tile.PLAYER;
	}
	
	public void resetTile(Tile[][] tiles) {
		tiles[y][x] = Tile.SEA;
	}
	
	public void move(int x, int y, Tile[][] tiles) {
		resetTile(tiles);
		
		/*
		 * COLLISION DETECTION WITH THE BORDERS
		 * it doesnt look very well, but at least it works
		 * also just doing this for an easy commit OpieOP
		 */
		// if wanting to move to right
		if (x > 0) {
			// if x-position is not higher or equal to the width of the board - 1 
			// (because arrays start at index 0 and i am too lazy to implement anything else in my code)
			if (!(this.x >= tiles[0].length - 1)) {
				// move, else do nothing
				this.x += x;
			}
			// etc etc
			// collision detection in a nutshell
		} else if (x < 0) {
			if (this.x != 0) {
				this.x += x;
			}
		}
		
		// same for y axis
		if (y > 0) {
			if (!(this.y >= tiles.length - 1)) {
				this.y += y;
			}
		} else if (y < 0) {
			if (this.y != 0) {
				this.y += y;
			}
		}
		update(tiles);
	}

}
