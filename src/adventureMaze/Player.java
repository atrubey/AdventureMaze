package adventureMaze;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * The Class Player.
 */
public class Player extends GameObject {
	
	private int speed, tempX, tempY;
	// movement directions
	public boolean up, down, left, right; 
	
	/**
	 * Constructor for Player class. Instantiates a new player, intializes all the member variables, also initializes a collision box.
	 *
	 * @param X the x position value for the player
	 * @param Y the y position value for the player
	 * @param Width the width value for the player
	 * @param Height the height value for the player
	 * @param Speed the speed value for the player
	 */
	public Player(int X, int Y, int Width, int Height, int Speed) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		speed = Speed;
		tempX = x; 
		tempY = y;
		collisionBox = new Rectangle(x, y, width, height);
	}

	/* (non-Javadoc)
	 * @see adventureMaze.GameObject#update()
	 */
	/**
	 * Update method. Sets the collision box bounds & x, y position for player. Controls enemy movement.  
	 */
	@Override
	public void update() {
		// if the collision box does not run into anything (using temp locations of collision box created on last update), move the player to that location.
		if (canMove) {
			x = (int) collisionBox.getX();
			y = (int) collisionBox.getY();
		} else {
			canMove = true;
		} 

		// try to move the collision box to a new location
		tempX = x; 
		tempY = y;
		
		// these booleans are set in GamePanel in method KeyPressed
		if (up == true) {
			tempY -= speed;
		} 
		if (down == true) {
			tempY += speed;
		} 
		if (right == true) {
			tempX += speed;
		} 
		if (left == true){
			tempX -= speed;
		}
		
		collisionBox.setBounds(tempX, tempY, width, height);


	}

	/* (non-Javadoc)
	 * @see adventureMaze.GameObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(GamePanel.playerImg, x, y, width, height, null);
	}

}
