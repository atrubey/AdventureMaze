package adventureMaze;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	public GameObject() {
		isAlive = true; 
		collisionBox = new Rectangle(x, y, width, height);
	}
	
	int x, y, width, height;
	Boolean isAlive = true, canMove = true; 
	Rectangle collisionBox; 

	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}
	
	public void draw(Graphics g) {
		
	}
}
