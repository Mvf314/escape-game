package com.mvf314.escape.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Board {
	
	public int[][] tiles;
	
	public Board() {
		tiles = new int[6][6];
		tiles[1][0] = 6;
		tiles[0][1] = 9;
		int c = 0;
		
		// prints the contents of the 2D array into a "table"
		for (int[] row : tiles) {
			for (int col : row) {
				c++;
				if (c % row.length == 0) {
					System.out.println(col);
				} else {
					System.out.print(col);
				}
			}
		}
	}
	
	public void render(SpriteBatch batch) {
		
	}
	
}
