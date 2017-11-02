package adventureMaze;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {
	
	private int speed, tempX, tempY;
	public boolean up, down, left, right; 
	
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

	@Override
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

	@Override
	public void draw(Graphics g) {
		g.drawImage(GamePanel.playerImg, x, y, width, height, null);
	}

}
