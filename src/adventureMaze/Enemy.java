package adventureMaze;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemy extends GameObject {
	public Enemy(int X, int Y, int Width, int Height, int Speed) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		collisionBox.setBounds(X, Y, Width, Height);
		speed = Speed;
	}
	
	int counter = 0, speed; 
	
	public void update() {
		
		if (counter > 80) {
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
		int r1 = new Random().nextInt(speed);
		int r2 = new Random().nextInt(speed);

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

	public void draw(Graphics g) {
		g.drawImage(GamePanel.enemyImg, x, y, width, height, null);
		//g.setColor(Color.black);
		//g.drawRect(x, y, width, height);
	}

}
