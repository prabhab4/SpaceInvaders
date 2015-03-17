package com.youtube.invaders;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.youtube.invaders.screen.GameScreen;
import com.youtube.invaders.screen.ScreenManager;

public class MainGame extends ApplicationAdapter {
	
	//private OrthographicCamera camera;
	//Sprite sprite;
	private SpriteBatch batch;
	
	public static int WIDTH = 480, HEIGHT = 800;
	
	@Override
	public void create () {
		//camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		batch = new SpriteBatch();
		//sprite = new Sprite(new Texture("badlogic.jpg"));//
		
		ScreenManager.setScreen(new GameScreen());
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void dispose () {
		if(ScreenManager.getCurrentScreen() != null) //
			ScreenManager.getCurrentScreen().dispose();//dispose the screen
		
		batch.dispose();		
	}
	
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 204, 0, 1); //(r,g,b,_)
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		//batch.setProjectionMatrix(camera.combined);
		//batch.begin();
		//sprite.draw(batch);
		//batch.end();

		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().update();
		
		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().render(batch);
		
	}
	
	@Override
	public void resize (int width, int height) {
		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(width, height);
	}
	
	@Override
	public void pause () {
		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();
	}
	
	@Override
	public void resume () {
		if(ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resume();
	}
}
