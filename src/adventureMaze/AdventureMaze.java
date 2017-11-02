package adventureMaze;

import javax.swing.JFrame;

public class AdventureMaze {
	
	GamePanel panel;
	JFrame frame;

	static final int WIDTH = 780;
	static final int HEIGHT = 800;
	
	public AdventureMaze() {

		frame = new JFrame();
		panel = new GamePanel();
		setup();

	}

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
