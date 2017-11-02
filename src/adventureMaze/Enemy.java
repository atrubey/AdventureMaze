package adventureMaze;

import java.awt.Graphics;
import java.util.Random;

public class Enemy extends GameObject {

	private int counter = 0, speed;
	private Random randGen;

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
	
	@Override
	public void update() {

		if (counter > 180) {
			isAlive = false;
		}

		if (canMove) {
			x = (int) collisionBox.getX();
			y = (int) collisionBox.getY();
			counter = 0;
		} else {
			canMove = true;
			counter++;
		}
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

	@Override
	public void draw(Graphics g) {
		g.drawImage(GamePanel.enemyImg, x, y, width, height, null);
	}

}
