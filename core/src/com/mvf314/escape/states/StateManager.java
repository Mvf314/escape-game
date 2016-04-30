package com.mvf314.escape.states;

import com.mvf314.escape.states.GameState;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mvf314.escape.rendering.MenuRenderer;

/**
 * This class manages game states;
 * @author Melvin
 */
public class StateManager implements Disposable {
	
	private GameState state;
	
	private MenuRenderer menuRenderer;
	
	/** Initialize game state and menu renderer */
	public StateManager() {
		state = GameState.MENU;
		menuRenderer = new MenuRenderer();
	}
	
	/**
	 * Render the current game stage
	 * @param batch	The open sprite batch
	 */
	public void render(SpriteBatch batch) {
		switch (state) {
		case MENU:
			menuRenderer.render(batch);
			break;
		case GAME:
			
			break;
		case PAUSED:
			
			break;
		}
	}
	
	/**
	 * Handle state input
	 * @return If the game can continue running
	 */
	public boolean handleInput() {
		switch (state) {
		case MENU:
			int menuChoice = menuRenderer.getInput();
			if (menuChoice == 1) {
				state = GameState.GAME;
			} else if (menuChoice == 2) {
				// options
			} else if (menuChoice == -1) {
				return false;
			}
			return true;
		case GAME:
			
			return true;
		case PAUSED:
			
			return true;
		default:
			
			return true;
		}
	}
	
	@Override
	public void dispose() {
		menuRenderer.dispose();
	}
	
}
