package com.youtube.invaders.screen;

public class ScreenManager {

	private static Screen currentScreen;
	
	public static void setScreen(Screen screen) { //set given screen
		if(currentScreen != null)
			currentScreen.dispose();
		currentScreen = screen;
		currentScreen.create();
	}
	
	public static Screen getCurrentScreen() {
		return currentScreen;
	}
	
}
