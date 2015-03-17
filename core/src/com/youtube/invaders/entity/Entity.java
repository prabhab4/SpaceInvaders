package com.youtube.invaders.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {//has position and directions

	protected Texture texture;
	protected Vector2 pos, direction;
	
	public Entity(Texture texture, Vector2 pos, Vector2 direction) {
		this.texture = texture;
		this.pos = pos;
		this.direction = direction;
	}
	
	public abstract void update();
	
	public void render(SpriteBatch sb) {
		sb.draw(texture, pos.x, pos.y); //location of sprite
	}
	
	public Vector2 getPosition() {
		return pos;
	}
	
	public Rectangle getBounds() { //invisible rectangle for collision detection
		return new Rectangle(pos.x, pos.y, texture.getWidth(), texture.getHeight());
		//return new Rectangle(pos.x, pos.y - texture.getHeight(), texture.getWidth(), texture.getHeight());
	}
	
	public void setDirection(float x, float y){
		direction.set(x, y);
		//System.out.println("x: " + pos.x + ", y: " + pos.y);
		//System.out.println(Gdx.graphics.getDeltaTime());
		direction.scl(Gdx.graphics.getDeltaTime()); //keeps speed of frames(fps) same.
	}
}
