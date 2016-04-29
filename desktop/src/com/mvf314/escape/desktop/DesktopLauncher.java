package com.mvf314.escape.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mvf314.escape.Escape;
import com.mvf314.escape.utils.Constants;

public class DesktopLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		cfg.title = 	Constants.APP_TITLE;
		cfg.width = 	Constants.APP_WIDTH;
		cfg.height = 	Constants.APP_HEIGHT;
		
		new LwjglApplication(new Escape(), cfg);
	}
}
