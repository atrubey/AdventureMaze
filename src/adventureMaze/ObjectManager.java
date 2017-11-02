package adventureMaze;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

/**
 * The Class ObjectManager.
 */
public class ObjectManager {
	
	// Array lists for all the object types
	ArrayList<Enemy> enemies;
	ArrayList<Player> players;
	ArrayList<Wall> walls;
	ArrayList<Projectile> projectiles;
	// enemy timer & spawn time in milliseconds
	long enemyTimer = 0;
	int enemySpawnTime = 3000;
	// random generator
	private Random randGen = new Random();

	/**
	 * Constructor for ObjectManager class. Instantiates a new object manager, initializes the enemy, player, wall, and projectile array lists.
	 */
	public ObjectManager() {
		enemies = new ArrayList<Enemy>();
		players = new ArrayList<Player>();
		walls = new ArrayList<Wall>();
		projectiles = new ArrayList<Projectile>();
	}

	/**
	 * Adds an enemy to the array list.
	 *
	 * @param e the enemy being added
	 */
	public void addEnemy(Enemy e) {
		enemies.add(e);
	}

	/**
	 * Adds a player to the array list.
	 *
	 * @param p the player being added
	 */
	public void addPlayer(Player p) {
		players.add(p);
	}

	/**
	 * Adds a wall to the array list.
	 *
	 * @param w the wall being added
	 */
	public void addWall(Wall w) {
		walls.add(w);
	}

	/**
	 * Adds a projectile to the array list.
	 *
	 * @param j the projectile being added
	 */
	public void addProjectile(Projectile j) {
		projectiles.add(j);
	}

	/**
	 * Update method. Calls the update methods for all the game objects, purges objects that are no longer alive.
	 */
	public void update() {
		for (int j = 0; j < enemies.size(); j++) {
			enemies.get(j).update();
		}
		for (int k = 0; k < players.size(); k++) {
			players.get(k).update();
		}
		for (int l = 0; l < walls.size(); l++) {
			walls.get(l).update();
		}
		for (int d = 0; d < projectiles.size(); d++) {
			projectiles.get(d).update();
		}

		purgeObjects();
	}

	/**
	 * Draw method. Calls the draw methods for all the game objects. 
	 *
	 * @param g the Graphics object
	 */
	public void draw(Graphics g) {

		for (int j = 0; j < enemies.size(); j++) {
			enemies.get(j).draw(g);
			;
		}
		for (int k = 0; k < players.size(); k++) {
			players.get(k).draw(g);
			;
		}
		for (int l = 0; l < walls.size(); l++) {
			walls.get(l).draw(g);
		}
		for (int d = 0; d < projectiles.size(); d++) {
			projectiles.get(d).draw(g);
		}
	}

	/**
	 * Purge objects. Gets rid of all objects that are no longer alive
	 */
	private void purgeObjects() {
		for (int j = 0; j < enemies.size(); j++) {
			if (!enemies.get(j).isAlive) {
				enemies.remove(j);
			}
		}
		for (int k = 0; k < players.size(); k++) {
			if (!players.get(k).isAlive) {
				players.remove(k);
			}
		}
		for (int l = 0; l < walls.size(); l++) {
			if (!walls.get(l).isAlive) {
				walls.remove(l);
			}
		}
		for (int d = 0; d < projectiles.size(); d++) {
			if (!projectiles.get(d).isAlive) {
				projectiles.remove(d);
			}
		}
	}

	/**
	 * Manage enemies. Creates new enemies at one of 5 random locations every (enemySpawnTime) milliseconds. 
	 */
	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			int r1 = randGen.nextInt(5);
			enemyTimer = System.currentTimeMillis();
			switch (r1) {
			case 0:
				addEnemy(new Enemy(365, 295, 40, 40, GamePanel.enemySpeed));
				break;
			case 1:
				addEnemy(new Enemy(15, 15, 40, 40, GamePanel.enemySpeed));
				break;
			case 2:
				addEnemy(new Enemy(715, 715, 40, 40, GamePanel.enemySpeed));
				break;
			case 3:
				addEnemy(new Enemy(435, 15, 40, 40, GamePanel.enemySpeed));
				break;
			case 4:
				addEnemy(new Enemy(715, 225, 40, 40, GamePanel.enemySpeed));
				break;
			}
		}
	}

	/**
	 * Check collision. Checks collisions between all objects. 
	 */
	public void checkCollision() {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy e1 = enemies.get(i);
			for (int j = 0; j < players.size(); j++) {
				Player p1 = players.get(j);
				if (e1.collisionBox.intersects(p1.collisionBox)) {
					p1.isAlive = false;
				}
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			Enemy e1 = enemies.get(i);
			for (int j = 0; j < projectiles.size(); j++) {
				Projectile p1 = projectiles.get(j);
				if (e1.collisionBox.intersects(p1.collisionBox)) {
					e1.isAlive = false;
				}
			}
		}

		for (int i = 0; i < walls.size(); i++) {
			Wall w1 = walls.get(i);
			for (int j = 0; j < projectiles.size(); j++) {
				Projectile p1 = projectiles.get(j);
				if (w1.collisionBox.intersects(p1.collisionBox)) {
					p1.isAlive = false;
				}
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			Enemy e1 = enemies.get(i);
			for (int j = 0; j < walls.size(); j++) {
				Wall w1 = walls.get(j);
				if (e1.collisionBox.intersects(w1.collisionBox)) {
					e1.canMove = false;
				}

			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			Enemy e1 = enemies.get(i);
			for (int j = i + 1; j < enemies.size(); j++) {
				Enemy e2 = enemies.get(j);
				if (e1.collisionBox.intersects(e2.collisionBox)) {
					e1.canMove = false;
					e2.canMove = false;
				}

			}
		}

		for (int i = 0; i < players.size(); i++) {
			Player p1 = players.get(i);
			for (int j = 0; j < walls.size(); j++) {
				Wall w1 = walls.get(j);
				if (p1.collisionBox.intersects(w1.collisionBox)) {
					p1.canMove = false;
				}
			}
		}

	}

	/**
	 * Reset. Clears all objects out of the array lists. 
	 */
	public void reset() {
		enemies.clear();
		players.clear();
		walls.clear();
		projectiles.clear();
	}
}
