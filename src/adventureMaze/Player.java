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
	
	int speed; 
	
	public void update() {
		if (canMove) {
		super.update();
		}
	}

	public void draw(Graphics g) {
	//	g.drawImage(GamePanel.playerImg, x, y, width, height, null);
		g.setColor(Color.GRAY);
		g.drawRect(x, y, width, height);
	}

}
