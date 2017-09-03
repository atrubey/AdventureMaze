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
		collisionBox.setBounds(X, Y, Width, Height);
	}

	public void update() {

		if (canMove) {
			x = (int) collisionBox.getX();
			y = (int) collisionBox.getY();
		} else {
			canMove = true;
		}
		int tempX = x, tempY = y;
		int r1 = new Random().nextInt(3);
		int r2 = new Random().nextInt(10);
		int r3 = new Random().nextInt(2);
		int r4 = new Random().nextInt(3);

		if (r4 >= 1) {
			tempY += r1;

		} else {
			tempY -= r1;

		}

		if (r3 == 1) {
			tempX -= r2;

		} else {
			tempX += r2;

		}

		collisionBox.setBounds(tempX, tempY, width, height);

	}

	public void draw(Graphics g) {
		// g.drawImage(GamePanel.enemyImg, x, y, width, height, null);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}

}
