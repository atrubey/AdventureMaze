package adventureMaze;

import java.awt.Graphics;
import java.util.Random;

/**
 * The Class Enemy.
 */
public class Enemy extends GameObject {

	/** The speed. */
	private int counter = 0, speed;
	
	/** The rand gen. */
	private Random randGen;

	/**
	 * Constructor for Enemy class. Instantiates a new enemy. In addition to what the parameters initialize it also initializes a Random object.
	 *
	 * @param X the x position value for the enemy
	 * @param Y the y position value for the enemy
	 * @param Width the width value for the enemy
	 * @param Height the height value for the enemy
	 * @param Speed the speed value for the enemy
	 */ 
	public Enemy(int X, int Y, int Width, int Height, int Speed) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		collisionBox.setBounds(X, Y, Width, Height);
		speed = Speed;
		randGen = new Random();
	}
	
	/* (non-Javadoc)
	 * @see adventureMaze.GameObject#update()
	 */
	/**
	 * Update method. Sets the collision box bounds & x, y position for enemy. Controls enemy movement.  
	 */
	@Override
	public void update() {
		// if the enemy cannot move for 180 updates, get rid of it. 
		if (counter > 180) {
			isAlive = false;
		}
		
		// if the collision box does not run into anything (using temp locations of collision box created on last update), move the enemy to that location.
		if (canMove) {
			x = (int) collisionBox.getX();
			y = (int) collisionBox.getY();
			counter = 0;
		} else {
			canMove = true;
			counter++;
		}
		
		// try to move the collision box to a new location
		int tempX = x, tempY = y;
		int r1 = randGen.nextInt(speed);
		int r2 = randGen.nextInt(speed);

		if (GamePanel.playerY > tempY) {
			tempY += r1;

		} else {
			tempY -= r1;

		}

		if (GamePanel.playerX < tempX) {
			tempX -= r2;

		} else {
			tempX += r2;

		}

		collisionBox.setBounds(tempX, tempY, width, height);

	}

	/* (non-Javadoc)
	 * @see adventureMaze.GameObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(GamePanel.enemyImg, x, y, width, height, null);
	}

}
