package adventureMaze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	public GamePanel() {

		timer = new Timer(1000 / 60, this);
		game = new GameObject();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		startFont = new Font("Arial", Font.PLAIN, 20);
		instructionsFont = new Font("Arial", Font.PLAIN, 20);
		gameOverFont = new Font("Arial", Font.BOLD, 48);
		scoreFont = new Font("Arial", Font.PLAIN, 20);
		player = new Player(11, 869, 35, 35, 5);
		manager = new ObjectManager();
		manager.addPlayer(player);
	}

	Timer timer;
	GameObject game;
	Font titleFont, startFont, instructionsFont, gameOverFont, scoreFont;
	Player player;
	ObjectManager manager;
	final int MENU_STATE = 0, GAME_STATE = 1, END_STATE = 2;
	int currentState = MENU_STATE;

	void updateMenuState() {

	}

	void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		if (player.isAlive == false) {
			currentState = END_STATE;
			manager.reset();
			player = new Player(50, 850, 35, 35, 5);
			manager.addPlayer(player);
		}
		if (player.x > 700 && player.y < 70) {
			player.ifWin = true;
			currentState = END_STATE;
		}
	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, AdventureMaze.WIDTH, AdventureMaze.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("ADVENTRUE MAZE", 275, 200);
		g.setFont(startFont);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("Press enter to start", 400, 300);
		g.drawString("Instructions:", 435, 400);
		g.drawString("Use the ARROW KEYS to control your character", 280, 450);
		g.drawString("Press the SPACE BAR to shoot projectiles at enemies", 260, 475);
		g.drawString("Get to the end of the maze to win", 335, 525);
		g.drawString("If an enemy touches your ship, you lose", 320, 500);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, AdventureMaze.WIDTH, AdventureMaze.HEIGHT);
		g.setColor(Color.GREEN);
		g.fillRect(700, 10, 60, 60);
		g.setColor(Color.GRAY);
		g.fillRect(10, 860, 60, 60);
		// Border Walls
		manager.addWall(new Wall(0, 0, 10, 1000));
		manager.addWall(new Wall(AdventureMaze.WIDTH-10, 0, 10, 1000));
		manager.addWall(new Wall(0, 0, AdventureMaze.WIDTH, 10));
		manager.addWall(new Wall(0, 920, AdventureMaze.WIDTH, 10));
		// Inside Walls
		manager.addWall(new Wall(0, 850, 70, 10));
		manager.addWall(new Wall(0, 780, 140, 10));
		manager.addWall(new Wall(130, 780, 10, 80));
		manager.addWall(new Wall(200, 780, 10, 80));
		manager.addWall(new Wall(0, 710, 210, 10));
		manager.addWall(new Wall(200, 850, 80, 10));
		manager.addWall(new Wall(270, 710, 10, 150));
		manager.addWall(new Wall(270, 710, 140, 10));
		manager.addWall(new Wall(340, 710, 10, 80));
		manager.addWall(new Wall(340, 860, 10, 70));
		manager.addWall(new Wall(410, 860, 10, 70));
		manager.addWall(new Wall(410, 780, 290, 10));
		manager.addWall(new Wall(480, 780, 10, 80));
		manager.addWall(new Wall(480, 850, 70, 10));
		manager.addWall(new Wall(620, 780, 10, 80));
		manager.addWall(new Wall(620, 850, 70, 10));
		manager.addWall(new Wall(690, 650, 10, 140));
		manager.addWall(new Wall(480, 710, 220, 10));


		manager.draw(g);
	}

	void drawEndState(Graphics g) {
		if (player.ifWin == false) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, AdventureMaze.WIDTH, AdventureMaze.HEIGHT);
			g.setFont(gameOverFont);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER", 100, 200);
			g.setFont(scoreFont);
			g.setColor(Color.BLACK);
			g.drawString("Press enter to try again", 150, 500);
		} else {
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, AdventureMaze.WIDTH, AdventureMaze.HEIGHT);
			g.setFont(gameOverFont);
			g.setColor(Color.BLACK);
			g.drawString("YOU WIN!", 100, 200);
			g.setFont(scoreFont);
			g.setColor(Color.BLACK);
			g.drawString("Press enter to play again", 150, 500);
		}
	}

	void startGame() {

		timer.start();

	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
		}
		if (currentState > END_STATE) {
			currentState = MENU_STATE;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
			Projectile.lastMove = 0; 
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true; 
			Projectile.lastMove = 2;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
			Projectile.lastMove = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
			Projectile.lastMove = 4;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME_STATE) {
			manager.addProjectile(new Projectile(player.x + 20, player.y + 20, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false; 
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}

		repaint();
	}

}
