package com.youtube.invaders.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.youtube.invaders.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "Space Invaders";
		config.useGL30 = false;
		config.width = MainGame.WIDTH;
		config.height = MainGame.HEIGHT;
		
		new LwjglApplication(new MainGame(), config);
		
	}
}
