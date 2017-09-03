package adventureMaze;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	public Player(int X, int Y, int Width, int Height, int Speed) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		speed = Speed;
	}

	int speed, tempX = x, tempY = y;

	public void update() {
		if (canMove) {
			tempX = (int) collisionBox.getX();
			tempY = (int) collisionBox.getY();
		} else {
			canMove = true;
		}

		int tempX = x, tempY = y;

		collisionBox.setBounds(tempX, tempY, width, height);

	}

	public void draw(Graphics g) {
		// g.drawImage(GamePanel.playerImg, x, y, width, height, null);
		g.setColor(Color.GRAY);
		g.drawRect(x, y, width, height);
	}

}
