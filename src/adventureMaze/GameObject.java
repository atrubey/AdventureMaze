package adventureMaze;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	
	public int x, y, width, height;
	public boolean isAlive = true, canMove = true;
	public Rectangle collisionBox;
	
	public GameObject() {
		isAlive = true;
		collisionBox = new Rectangle(x, y, width, height);
	}

	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {

	}
}
