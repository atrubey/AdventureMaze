package adventureMaze;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemy extends GameObject {
	public Enemy(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
	}
	
	public void update() {
		if (canMove) {
		super.update();
		int r1 = new Random().nextInt(3); 
		int r2 = new Random().nextInt(10); 
		int r3 = new Random().nextInt(2); 
		
		y += r1; 
		
		if (r3 == 1) {
			x -= r2; 
		} else {
			x += r2; 
		}
		}
	}

	public void draw(Graphics g) {
	//	g.drawImage(GamePanel.enemyImg, x, y, width, height, null);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
	
}
