package com.youtube.invaders.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.youtube.invaders.camera.OrthoCamera;
import com.youtube.invaders.entity.EntityManager;

public class GameScreen extends Screen{

	private OrthoCamera camera; //resizes screen to match different screen sizes
	private EntityManager entityManager;
	
	@Override
	public void create() {
		camera = new OrthoCamera();
		entityManager = new EntityManager(10, camera); //(number of enemies)
		//System.out.println("MenuScreen Created");
	}
	
	@Override
	public void update() {
		camera.update();
		entityManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		sb.begin();
		entityManager.render(sb);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		//System.out.println("MenuScreen Resized");
		camera.resize();
	}

	@Override
	public void dispose() {	
		System.out.println("MenuScreen Disposed");
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
