package adventureMaze;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {
	public Projectile(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		speed = 10; 
		move = lastMove;
	}
	
	int speed, move; 
	static int lastMove; 
	
	public void update() {
		super.update();
		
		if (move == 0) {
			y -= speed; 
		} else if (move == 2) {
			y += speed;
		} else if (move == 1) {
			x += speed;
		} else if (move == 4) {
			x -= speed;
		}
		if (y < 0) {
			isAlive = false;
		}
	}

	public void draw(Graphics g) {
	//	g.drawImage(GamePanel.bulletImg, x, y, width, height, null);
		g.setColor(Color.blue);
		g.drawRect(x, y, width, height);

	}
	
}