package adventureMaze;

import java.awt.Graphics;

/**
 * The Class Projectile.
 */
public class Projectile extends GameObject {
	
	private int speed, move; 
	// last direction the player moved in, used to determine the traveling direction of the projectile
	public static int lastMove; 
	
	/**
	 * Constructor for Projectile class. Instantiates a new projectile, initializes member variables.
	 *
	 * @param X the x position value for the projectile
	 * @param Y the y position value for the projectile
	 * @param Width the width value for the projectile
	 * @param Height the height value for the projectile
	 */
	public Projectile(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		speed = 10; 
		move = lastMove;
	}

	/* (non-Javadoc)
	 * @see adventureMaze.GameObject#update()
	 */
	@Override
	public void update() {
		super.update();
		// shoot in the direction the player last moved
		if (move == 0) {
			y -= speed; 
		} else if (move == 2) {
			y += speed;
		} else if (move == 1) {
			x += speed;
		} else if (move == 3) {
			x -= speed;
		}
		if (y < 0) {
			isAlive = false;
		}
	}

	/* (non-Javadoc)
	 * @see adventureMaze.GameObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
	 	g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
	
}