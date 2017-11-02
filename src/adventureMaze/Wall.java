package adventureMaze;

import java.awt.Graphics;

/**
 * The Class Wall.
 */
public class Wall extends GameObject {
	
	/**
	 * Constructor for the Wall class. Instantiates a new wall, initializes all member variables.
	 *
	 * @param X the x position value for the wall
	 * @param Y the y position value for the wall
	 * @param Width the width value for the wall
	 * @param Height the height value for the wall
	 */
	public Wall(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
	}

	/* (non-Javadoc)
	 * @see adventureMaze.GameObject#update()
	 */
	@Override
	public void update() {
		super.update();
	}

	/* (non-Javadoc)
	 * @see adventureMaze.GameObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
	 	g.drawImage(GamePanel.wallImg, x, y, width, height, null);
	}
}
