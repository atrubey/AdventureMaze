package adventureMaze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * The Class GamePanel.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	/** Private Timer object. Used to call actionPerformed method at set intervals once game is started. */
	private Timer timer;
	// Creating objects of all the various classes needed
	public GameObject game;
	private LevelManager level;
	private Font titleFont, startFont, instructionsFont, gameOverFont, scoreFont;
	private Player player;
	public ObjectManager manager;
	// Variables to keep track of the various game states
	private final int MENU_STATE = 0, GAME_STATE = 1, END_STATE = 2, WIN_STATE = 3;
	private int currentState = MENU_STATE, currentLevel = 1;
	// Images for graphics
	public static BufferedImage playerImg, playerImgUp, playerImgDown, playerImgLeft, playerImgRight, enemyImg, bulletImg, menuBkgndImg, endBkgndImg, gameBkgndImg, wallImg,
			winBkgndImg;
	public static int playerX, playerY, enemySpeed;
	
	/**
	 * Constructor for the GamePanel class. Instantiates a new game panel, initializes all the member variables, gets images in a try/catch statement. 
	 */
	public GamePanel() {
	
		//initialize all the variables
		// timer is initialized at 60 updates a second (1000 milliseconds) or 1000 / 60
		timer = new Timer(1000 / 60, this);
		game = new GameObject();
		titleFont = new Font("Arial", Font.BOLD, 64);
		startFont = new Font("Arial", Font.PLAIN, 30);
		instructionsFont = new Font("Arial", Font.PLAIN, 20);
		gameOverFont = new Font("Arial", Font.BOLD, 48);
		scoreFont = new Font("Arial", Font.PLAIN, 20);
		player = new Player(11, 720, 35, 35, 5);
		manager = new ObjectManager();
		manager.addPlayer(player);
		playerX = player.x;
		playerY = player.y;
		enemySpeed = 3;
		level = new LevelManager();
		level.createLevel1(manager);

		// get images from files
		try {
			playerImgUp = ImageIO.read(this.getClass().getResourceAsStream("images/PlayerImg.png"));
			playerImgDown = ImageIO.read(this.getClass().getResourceAsStream("images/PlayerImgDown.png"));
			playerImgLeft = ImageIO.read(this.getClass().getResourceAsStream("images/PlayerImgLeft.png"));
			playerImgRight = ImageIO.read(this.getClass().getResourceAsStream("images/PlayerImgRight.png"));
			enemyImg = ImageIO.read(this.getClass().getResourceAsStream("images/EnemyImg.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("images/BulletImg.png"));
			wallImg = ImageIO.read(this.getClass().getResourceAsStream("images/WallImg.png"));
			menuBkgndImg = ImageIO.read(this.getClass().getResourceAsStream("images/MenuBackground.png"));
			endBkgndImg = ImageIO.read(this.getClass().getResourceAsStream("images/EndImg.png"));
			gameBkgndImg = ImageIO.read(this.getClass().getResourceAsStream("images/GameImg.png"));
			winBkgndImg = ImageIO.read(this.getClass().getResourceAsStream("images/WinImg.png"));

		} catch (IOException e) {
			// TODO: handle exceptions
			e.printStackTrace();
		}
		
		playerImg = playerImgUp; 

	}

	/**
	 * Update menu state.
	 */
	private void updateMenuState() {

	}

	/**
	 * Update game state. Updates the game objects, checks if the player is alive or has won. 
	 */
	private void updateGameState() {
		playerX = player.x;
		playerY = player.y;
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if (player.isAlive == false) {
			currentState = END_STATE;
			manager.reset();
			player = new Player(11, 720, 35, 35, 5);
			manager.addPlayer(player);
		}
		if (player.x > 700 && player.y < 40) {
			currentState = WIN_STATE;
		}
	}

	/**
	 * Update end state.
	 */
	private void updateEndState() {

	}

	/**
	 * Update win state.
	 */
	private void updateWinState() {

	}

	/**
	 * Draw menu state. Uses the Graphics object, g, and images initialized in the constructor to create the graphics for the menu state.
	 *
	 * @param g the Graphics object
	 */
	private void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 780, 780);
		g.drawImage(menuBkgndImg, 0, 0, 780, 780, null);
		g.setFont(titleFont);
		g.setColor(Color.BLACK);
		g.drawString("Adventure Maze", 50, 100);
		g.setFont(startFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to start", 160, 200);
		// Instructions header background box
		g.setColor(new Color(255, 215, 175));
		g.fillRect(350, 300, 200, 30);
		// Instructions header
		g.setColor(Color.BLACK);
		g.setFont(instructionsFont);
		g.drawString("Instructions:", 395, 320);
		// Instructions Background box
		g.setColor(new Color(255, 215, 175));
		g.fillRect(200, 340, 500, 200);
		// Instructions text
		g.setColor(Color.black);
		g.drawString("Use the ARROW KEYS to control your character", 230, 370);
		g.drawString("Press the SPACE BAR to shoot projectiles at enemies", 210, 395);
		g.drawString("Get to the end of the maze to win", 295, 445);
		g.drawString("If an enemy touches you, you lose", 290, 420);
		g.drawString("Press E, M, H, or L to choose the difficulty", 255, 470);
		g.drawString("E = Easy, M = Medium, H = Hard, or L = Ludicrus", 230, 495);
		g.drawString("Enter a number 1 to 4 to choose the level", 255, 520);

		g.setColor(Color.black);
		g.drawString("Current Level: " + currentLevel, 550, 650);
	}

	/**
	 * Draw game state. Uses the Graphics object, g, and images initialized in the constructor to create the graphics for the game state. Calls the draw method in ObjectManager to draw all game objects.
	 *
	 * @param g the Graphics object
	 */
	private void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 780, 780);
		g.drawImage(GamePanel.gameBkgndImg, 0, 0, 780, 780, null);
		g.setColor(Color.GREEN);
		g.fillRect(710, 10, 60, 60);
		g.setColor(Color.GRAY);
		g.fillRect(10, 710, 60, 60);
		g.setColor(Color.black);
		g.drawString("Level " + currentLevel, 720, 750);
		manager.draw(g);
	}

	/**
	 * Draw end state. Uses the Graphics object, g, and images initialized in the constructor to create the graphics for the end or game over state.
	 *
	 * @param g the Graphics object
	 */
	private void drawEndState(Graphics g) {
		g.setColor(new Color(216, 91, 91));
		g.fillRect(0, 0, 780, 780);
		g.drawImage(endBkgndImg, 0, 0, 780, 780, null);
		g.setFont(gameOverFont);
		g.setColor(Color.BLACK);
		g.drawString("Game Over", 255, 200);
		g.setFont(scoreFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to try again", 275, 420);
	}

	/**
	 * Draw win state. Uses the Graphics object, g, and images initialized in the constructor to create the graphics for the win state.
	 *
	 * @param g the Graphics object
	 */
	private void drawWinState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 780, 780);
		g.drawImage(winBkgndImg, 0, 0, 780, 780, null);
		g.setFont(gameOverFont);
		g.setColor(Color.BLACK);
		g.drawString("Congratulations!", 100, 110);
		g.drawString("You won!", 170, 170);
		g.setFont(scoreFont);
		g.setColor(Color.BLACK);
		g.drawString("Press ENTER to play again", 445, 630);
		g.setColor(new Color(142, 225, 255));
		g.fillRect(475, 475, 190, 40);
		g.setColor(Color.BLACK);
		g.drawString("You beat Level " + currentLevel, 495, 500);

	}

	/**
	 * Start game. Starts the timer object. 
	 */
	public void startGame() {
		timer.start();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 * 
	 * Calls the draw method for each state. 
	 */
	@Override
	public void paintComponent(Graphics g) {
		switch (currentState) {
		case MENU_STATE: 
			drawMenuState(g);
			break;
		case GAME_STATE:
			drawGameState(g);
			break;
		case END_STATE:
			drawEndState(g);
			break;
		case WIN_STATE:
			drawWinState(g);
			break;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 * 
	 * Sets different variables and controls different movements in each of the states depending on the key pressed. 
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// In menu state
		if (currentState == MENU_STATE) {
			// go to game state
			switch (e.getKeyCode()) {
			case KeyEvent.VK_ENTER:
				currentState++;
				// create the wall objects for the level
				switch (currentLevel) {
				case 1:
					level.createLevel1(manager);
					break;
				case 2:
					level.createLevel2(manager);
					break;
				case 3:
					level.createLevel3(manager);
					break;
				case 4:
					level.createLevel4(manager);
					break;
				}
				break;
			// set difficulty (enemy speed)
			case KeyEvent.VK_E:
				enemySpeed = 2;
				break;
			case KeyEvent.VK_M:
				enemySpeed = 3;
				break;
			case KeyEvent.VK_H:
				enemySpeed = 5;
				break;
			case KeyEvent.VK_L:
				enemySpeed = 8;
				break;
			// set level
			case KeyEvent.VK_1:
				currentLevel = 1;
				break;
			case KeyEvent.VK_2:
				currentLevel = 2;
				break;
			case KeyEvent.VK_3:
				currentLevel = 3;
				break;
			case KeyEvent.VK_4:
				currentLevel = 4;
				break;

			}
		}

		// In end state
		if (currentState == END_STATE) {
			// go to menu state
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				currentState = MENU_STATE;
			}
		}
		
		// In end state
		if (currentState == WIN_STATE) {
			// go to menu state
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				currentState = MENU_STATE;
			}
		}

		// in game state
		if (currentState == GAME_STATE) {
			switch (e.getKeyCode()) {
			// player movement, projectile creation and travel direction controls
			case KeyEvent.VK_UP:
				player.up = true;
				Projectile.lastMove = 0;
				playerImg = playerImgUp; 
				break;
			case KeyEvent.VK_RIGHT:
				player.right = true;
				Projectile.lastMove = 1;
				playerImg = playerImgRight; 
				break;
			case KeyEvent.VK_DOWN:
				player.down = true;
				Projectile.lastMove = 2;
				playerImg = playerImgDown; 
				break;
			case KeyEvent.VK_LEFT:
				player.left = true;
				Projectile.lastMove = 3;
				playerImg = playerImgLeft; 
				break;
			case KeyEvent.VK_SPACE:
				manager.addProjectile(new Projectile(player.x + 15, player.y + 15, 10, 10));
				break;
			}

		}

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// player movement controls
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: 
			player.up = false; 
			break; 
		case KeyEvent.VK_DOWN: 
			player.down = false; 
			break; 
		case KeyEvent.VK_RIGHT: 
			player.right = false; 
			break; 
		case KeyEvent.VK_LEFT: 
			player.left = false; 
			break; 
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// update states, reset objects if in win or end state
		switch (currentState) {
		case MENU_STATE: 
			updateMenuState();
			break;
		case GAME_STATE:
			updateGameState();
			break;
		case END_STATE:
			updateEndState();
			manager.reset();
			player = new Player(11, 720, 35, 35, 5);
			manager.addPlayer(player);
			break;
		case WIN_STATE:
			updateWinState();
			manager.reset();
			player = new Player(11, 720, 35, 35, 5);
			manager.addPlayer(player);
			break;
		}

		repaint();
		
	}

}
