package adventureMaze;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;

public class AdventureMaze {
	public AdventureMaze() {

		frame = new JFrame();
		panel = new GamePanel();
		setup();

	}

	GamePanel panel;
	JFrame frame;

	static final int WIDTH = 780;
	static final int HEIGHT = 800;

	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);

		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.startGame();
	}

	public static void main(String[] args) {

		AdventureMaze advMaze = new AdventureMaze();

	}

	
}
