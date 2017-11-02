package adventureMaze;

import java.awt.Graphics;

public class Projectile extends GameObject {
	
	private int speed, move; 
	public static int lastMove; 
	
	public Projectile(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		speed = 10; 
		move = lastMove;
	}

	@Override
	public void update() {
		super.update();
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

	@Override
	public void draw(Graphics g) {
	 	g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
	}
	
}