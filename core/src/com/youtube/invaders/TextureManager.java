package com.youtube.invaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	
	//18 * 35
	//public static Texture PLAYER = new Texture(Gdx.files.internal("Batman_front.png"));
	public static Texture PLAYER = new Texture(Gdx.files.internal("Chris_small.png"));
	public static Texture MISSILE = new Texture(Gdx.files.internal("Missile_2.png"));
	public static Texture ENEMY = new Texture(Gdx.files.internal("enemy.png"));
	//public static Texture ENEMY = new Texture(Gdx.files.internal("Bart_front.png"));
	public static Texture GAME_WON = new Texture(Gdx.files.internal("gameWon.png"));
	public static Texture GAME_OVER = new Texture(Gdx.files.internal("gameOver.png"));
	
	public static Texture FIRE_BUTTON = new Texture(Gdx.files.internal("Fire_button2.png"));
}
