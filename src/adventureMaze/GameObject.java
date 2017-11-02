package adventureMaze;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * The Class GameObject.
 */
public class GameObject {

	public int x, y, width, height;
	public boolean isAlive = true, canMove = true;
	public Rectangle collisionBox;
	
	/**
	 * Constructor for GameObject class, instantiates a new game object. Sets isAlive to true and creates a new collision box. 
	 */
	public GameObject() {
		isAlive = true;
		collisionBox = new Rectangle(x, y, width, height);
	}

	/**
	 * Update method. Sets the collision box bounds. 
	 */
	public void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	/**
	 * Draw method. Creates the graphics for the game object. 
	 * 
	 * @param g Graphics object
	 */
	public void draw(Graphics g) {

	}
}
