package com.mvf314.escape.utils;

public class Constants {
	
	/** The title of the application */
	public static final String APP_TITLE = 	"Escape";
	/** The width of the application in pixels */
	public static final int APP_WIDTH = 	1280;
	/** The height of the application in pixels */
	public static final int APP_HEIGHT =	720;
	/** The fps of the application when in foreground */
	public static final int APP_FG_FPS = 	60;
	/** The fps of the application when in background */
	// this is done to save processing power when in background
	public static final int APP_BG_FPS = 	20;
	
	/** Number of frames between steps */
	public static final int MOVE_COOLDOWN =	30;
	
}
