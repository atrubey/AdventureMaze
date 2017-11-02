package adventureMaze;

import javax.swing.JFrame;

/**
 * The Class AdventureMaze.
 */
public class AdventureMaze {
	
	GamePanel panel;
	JFrame frame;

	// width and height of game panel
	static final int WIDTH = 780;
	static final int HEIGHT = 800;
	
	/**
	 * Constructor for the AdventureMaze class. Instantiates a new adventure maze.
	 */
	public AdventureMaze() {

		frame = new JFrame();
		panel = new GamePanel();
		setup();

	}

	/**
	 * Setup method. Sets up the GamePanel and JFrame.
	 */
	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);

		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel.startGame();
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		AdventureMaze advMaze = new AdventureMaze();

	}

	
}
