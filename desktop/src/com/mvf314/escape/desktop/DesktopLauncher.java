package com.mvf314.escape.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mvf314.escape.Escape;

public class DesktopLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		cfg.title = "Escape";
		cfg.width = 1280;
		cfg.height = 720;
		
		new LwjglApplication(new Escape(), cfg);
	}
}
