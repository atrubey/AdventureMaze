package adventureMaze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	public Player(int X, int Y, int Width, int Height, int Speed) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
		speed = Speed;
		tempX = x; 
		tempY = y;
		collisionBox = new Rectangle(x, y, width, height);

	}

	int speed, tempX, tempY;
	boolean up, down, left, right, ifWin = false; 

	public void update() {

		if (canMove) {
			x = (int) collisionBox.getX();
			y = (int) collisionBox.getY();
		} else {
			canMove = true;
		} 

		tempX = x; 
		tempY = y;
		
		if (up == true) {
			tempY -= speed;
		} 
		if (down == true) {
			tempY += speed;
		} 
		if (right == true) {
			tempX += speed;
		} 
		if (left == true){
			tempX -= speed;
		}
		
		collisionBox.setBounds(tempX, tempY, width, height);



	}

	public void draw(Graphics g) {
		// g.drawImage(GamePanel.playerImg, x, y, width, height, null);
		g.setColor(Color.BLUE);
		g.drawRect(x, y, width, height);
	}

}
