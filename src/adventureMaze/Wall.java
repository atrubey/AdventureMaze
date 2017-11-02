package adventureMaze;

import java.awt.Graphics;

public class Wall extends GameObject {
	public Wall(int X, int Y, int Width, int Height) {
		super();
		x = X;
		y = Y;
		width = Width;
		height = Height;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void draw(Graphics g) {
	 	g.drawImage(GamePanel.wallImg, x, y, width, height, null);
	}
}
