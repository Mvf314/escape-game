package com.mvf314.escape.states;

import com.mvf314.escape.states.GameState;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mvf314.escape.rendering.MenuRenderer;

/**
 * This class manages game states;
 * @author Melvin
 */
public class StateManager {
	
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
	
	public void handleInput() {
		switch (state) {
		case MENU:
			menuRenderer.getInput();;
			break;
		case GAME:
			
			break;
		case PAUSED:
			
			break;
		}
	}
	
}
