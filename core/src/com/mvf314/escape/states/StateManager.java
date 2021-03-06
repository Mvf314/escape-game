package com.mvf314.escape.states;

import com.mvf314.escape.states.GameState;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mvf314.escape.rendering.GameRenderer;
import com.mvf314.escape.rendering.MenuRenderer;
import com.mvf314.escape.rendering.PausedRenderer;
import com.mvf314.escape.game.Board;
import com.mvf314.escape.rendering.DeadRenderer;

/**
 * This class manages game states;
 * @author Melvin
 */
public class StateManager implements Disposable {
	
	private GameState state;
	
	private MenuRenderer menuRenderer;
	private GameRenderer gameRenderer;
	private PausedRenderer pausedRenderer;
	private DeadRenderer deadRenderer;
	
	/** Initialize game state and menu renderer */
	public StateManager() {
		state = GameState.MENU;
		menuRenderer = new MenuRenderer();
		gameRenderer = new GameRenderer();
		pausedRenderer = new PausedRenderer();
		deadRenderer = new DeadRenderer(gameRenderer.board);
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
			gameRenderer.render(batch);
			break;
		case PAUSED:
			pausedRenderer.render(batch);
			break;
		case DEAD:
			deadRenderer.render(batch);
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
			int gameChoice = gameRenderer.getInput();
			if (gameChoice == -1) {
				state = GameState.PAUSED;
			} else if (gameChoice == 1) {
				state = GameState.DEAD;
			}
			return true;
		case PAUSED:
			int pausedChoice = pausedRenderer.getInput();
			if (pausedChoice == -1) {
				state = GameState.MENU;
			} else if (pausedChoice != 1) {
				state = GameState.GAME;
			}
			return true;
		case DEAD:
			int deadChoice = deadRenderer.getInput();
			if (deadChoice == -1) {
				state = GameState.MENU;
			}
			return true;
		default:
			// I have no idea why this is needed but it is, so its staying
			// Crashing code gets fixed, crappy code stays
			return true;
		}
	}
	
	@Override
	public void dispose() {
		menuRenderer.dispose();
	}
	
}
