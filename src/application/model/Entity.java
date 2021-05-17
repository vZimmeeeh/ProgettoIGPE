package application.model;

import java.awt.Rectangle;

public abstract class Entity {
	int x;
	int y;
	int xspeed;
	int yspeed;
	int direction;
	boolean jump;

	Rectangle hitbox;
	public Entity(int x, int y, int hitboxWidht,int hitboxHeight) {
		xspeed = 10;
		yspeed = 16;
		hitbox = new Rectangle(x, y, hitboxWidht, hitboxHeight);
		this.x = x;
		this.y = y;
		direction = PlayerSettings.IDLE_RIGHT;
		jump = false;
	}
	public Rectangle getHitbox() {
		return hitbox;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDirection() {
		return direction;
	}
	
	public boolean isJumping() {
		return jump;
	}
	
	public abstract void move();
	public abstract void jump();
	public abstract void fall();
	
	/*public void update() {
		move();
	}*/
}
