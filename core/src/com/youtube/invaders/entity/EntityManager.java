package com.youtube.invaders.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.youtube.invaders.MainGame;
import com.youtube.invaders.TextureManager;
import com.youtube.invaders.camera.OrthoCamera;
import com.youtube.invaders.screen.GameOverScreen;
import com.youtube.invaders.screen.ScreenManager;

public class EntityManager {
	
	private final Array<Entity> entities = new Array<Entity>();
	private Player player;
	
	public EntityManager(int amount, OrthoCamera camera) { //amount= number of enemies at screen
		player = new Player(new Vector2(230, 20), new Vector2(0, 0), this, camera);//player(pos,dir))
		for (int i = 0; i < amount; i++) {
			float x = MathUtils.random(0, MainGame.WIDTH - TextureManager.ENEMY.getWidth());
			float y = MathUtils.random(MainGame.HEIGHT, MainGame.HEIGHT * 3);
			// x = making sure that enemies does not go outside the screen,
			// y = creating enemies above the screen and starts falling.
			float speed = MathUtils.random(2, 5);
			addEntity(new Enemy(new Vector2(x, y), new Vector2(0, -speed)));
		}
	}
	
	public void update() {
		for (Entity e: entities)
			e.update();
		
		for (Missile m: getMissiles()) {//check if missile is off the screen
			if (m.checkEnd())
				entities.removeValue(m,  false);
		}
		player.update();
		checkCollisions();
	}
	
	public void render(SpriteBatch sb) {
		for (Entity e: entities)
			e.render(sb);
		player.render(sb);
	}
	
	private void checkCollisions() {
		for (Enemy e: getEnemies()) { //check every enemy
			for (Missile m: getMissiles()) {
				if (e.getBounds().overlaps(m.getBounds())) { //if collision, remove missile+enemy
					//similar to array.equals(b)
					entities.removeValue(e, false);
					entities.removeValue(m, false);
					if (gameOver())
						ScreenManager.setScreen(new GameOverScreen(true));
						//Game Won.
				}
			}
			if (e.getBounds().overlaps(player.getBounds())) { //Game Over
				ScreenManager.setScreen(new GameOverScreen(false));
			}
		}
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	private Array<Enemy> getEnemies() { //checks how many enemies there are on screen
		Array<Enemy> ret = new Array<Enemy>();
		for(Entity e: entities) {
			if(e instanceof Enemy)
				ret.add((Enemy) e);
		}
		return ret;
	}
	
	private Array<Missile> getMissiles() { //checks how many enemies there are on screen
		Array<Missile> ret = new Array<Missile>();
		for(Entity e: entities) {
			if(e instanceof Missile)
				ret.add((Missile) e);
		}
		return ret;
	}
	
	public boolean gameOver() {
		return getEnemies().size <= 0; //if less than of = 0, then TRUE
	}
}
