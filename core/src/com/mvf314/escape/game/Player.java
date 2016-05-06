package com.mvf314.escape.game;

import com.mvf314.escape.Fonts;
import com.mvf314.escape.game.Tile;
import com.mvf314.escape.utils.Constants;

public class Player {

	public int x;
	public int y;
	public Tile[][] tiles;
	private Fonts font;
	
	public int moveCD;
	public int movedTiles;
	
	public Player(Tile[][] tiles, int x, int y) {
		this.tiles = tiles;
		tiles[y][x] = Tile.PLAYER;
		this.x = x;
		this.y = y;
		moveCD = 0;
		movedTiles = 0;
		font = new Fonts();
	}
	
	public void update() {
		tiles[y][x] = Tile.PLAYER;
	}
	
	public void resetTile() {
		tiles[y][x] = Tile.SEA;
	}
	
	public void move(int x, int y) {
		/*
		 * COLLISION DETECTION WITH THE BORDERS
		 * it doesnt look very well, but at least it works
		 * cooldown is so you dont move super fast
		 */
		if (moveCD == 0) {
			resetTile();
			// if wanting to move to right
			if (x > 0) {
				// if x-position is not higher or equal to the width of the board - 1 
				// (because arrays start at index 0 and i am too lazy to implement anything else in my code)
				if (!(this.x >= tiles[0].length - 1)) {
					// move, else do nothing
					this.x += x;
				}
				movedTiles++;
				moveCD = Constants.MOVE_COOLDOWN;
				// etc etc
				// collision detection in a nutshell
			} else if (x < 0) {
				if (this.x != 0) {
					this.x += x;
				}
				movedTiles++;
				moveCD = Constants.MOVE_COOLDOWN;
			}
			
			// same for y axis
			if (y > 0) {
				if (!(this.y >= tiles.length - 1)) {
					this.y += y;
				}
				movedTiles++;
				moveCD = Constants.MOVE_COOLDOWN;
			} else if (y < 0) {
				if (this.y != 0) {
					this.y += y;
				}
				movedTiles++;
				moveCD = Constants.MOVE_COOLDOWN;
			}
			update();
		} else {
			moveCD -= 1;
		}
	}

}
