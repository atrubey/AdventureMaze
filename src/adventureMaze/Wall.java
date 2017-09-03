package adventureMaze;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends GameObject {
	public Wall(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
	}

	public void update() {
		super.update();

	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect(x, y, width, height);
	}
}
