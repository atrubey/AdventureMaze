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
		player = new Player(250, 700, 50, 50, 5);
		manager = new ObjectManager();
		manager.addObject(player);
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
			player = new Player(250, 700, 50, 50, 5);
			manager.addObject(player);
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
		g.drawString("Collect items to get different boosts", 325, 550);
	}
	
	void drawGameState(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, AdventureMaze.WIDTH, AdventureMaze.HEIGHT);
		Wall wall1 = new Wall(0, 0, 10, 1000);
		wall1.draw(g);
		manager.addObject(wall1);
		manager.draw(g);
	}
	
	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, AdventureMaze.WIDTH, AdventureMaze.HEIGHT);
		g.setFont(gameOverFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 100, 200);
		g.setFont(scoreFont);
		g.setColor(Color.BLACK);
		g.drawString("Press enter to try again", 150, 500);
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
			player.y -= player.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.y += player.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.x += player.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.x -= player.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && currentState == GAME_STATE) {
			manager.addObject(new Projectile(player.x + 20, player.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
