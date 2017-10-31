package adventureMaze;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Enemy> enemies;
	ArrayList<Player> players;
	ArrayList<Wall> walls;
	ArrayList<Projectile> projectiles;

	long enemyTimer = 0;
	int enemySpawnTime = 3000;

	public ObjectManager() {
		enemies = new ArrayList<Enemy>();
		players = new ArrayList<Player>();
		walls = new ArrayList<Wall>();
		projectiles = new ArrayList<Projectile>();
	}

	public void addEnemy(Enemy e) {
		enemies.add(e);
	}

	public void addPlayer(Player p) {
		players.add(p);
	}

	public void addWall(Wall w) {
		walls.add(w);
	}

	public void addProjectile(Projectile j) {
		projectiles.add(j);
	}

	public void update() {
		for (int j = 0; j < enemies.size(); j++) {
			Enemy e = enemies.get(j);
			e.update();
		}
		for (int k = 0; k < players.size(); k++) {
			Player p = players.get(k);
			p.update();
		}
		for (int l = 0; l < walls.size(); l++) {
			Wall w = walls.get(l);
			w.update();
		}
		for (int d = 0; d < projectiles.size(); d++) {
			Projectile c = projectiles.get(d);
			c.update();
		}

		purgeObjects();
	}

	public void draw(Graphics g) {

		for (int j = 0; j < enemies.size(); j++) {
			Enemy e = enemies.get(j);
			e.draw(g);
		}
		for (int k = 0; k < players.size(); k++) {
			Player p = players.get(k);
			p.draw(g);
		}
		for (int l = 0; l < walls.size(); l++) {
			Wall w = walls.get(l);
			w.draw(g);
		}
		for (int d = 0; d < projectiles.size(); d++) {
			Projectile c = projectiles.get(d);
			c.draw(g);
		}
	}

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

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			Random randGen = new Random(); 
			int r1 = randGen.nextInt(5);
			if (r1 == 0) {
				addEnemy(new Enemy(365, 295, 40, 40, GamePanel.enemySpeed));
				enemyTimer = System.currentTimeMillis();
			} else if (r1 == 1) {
				addEnemy(new Enemy(15, 15, 40, 40, GamePanel.enemySpeed));
				enemyTimer = System.currentTimeMillis();
			} else if (r1 == 2) {
				addEnemy(new Enemy(715, 715, 40, 40, GamePanel.enemySpeed));
				enemyTimer = System.currentTimeMillis();
			} else if (r1 == 3) {
				addEnemy(new Enemy(435, 15, 40, 40, GamePanel.enemySpeed));
				enemyTimer = System.currentTimeMillis();
			} else if (r1 >= 4) {
				addEnemy(new Enemy(715, 225, 40, 40, GamePanel.enemySpeed));
				enemyTimer = System.currentTimeMillis();
			}
		}
	}

	public void checkCollision() {
		for (int i = 0; i < enemies.size(); i++) {
			for (int j = 0; j < players.size(); j++) {
				Enemy e1 = enemies.get(i);
				Player p1 = players.get(j);

				if (e1.collisionBox.intersects(p1.collisionBox)) {
					p1.isAlive = false;
				}
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			for (int j = 0; j < projectiles.size(); j++) {
				Enemy e1 = enemies.get(i);
				Projectile p1 = projectiles.get(j);

				if (e1.collisionBox.intersects(p1.collisionBox)) {
					e1.isAlive = false;
				}
			}
		}
		
		for (int i = 0; i < walls.size(); i++) {
			for (int j = 0; j < projectiles.size(); j++) {
				Wall w1 = walls.get(i);
				Projectile p1 = projectiles.get(j);

				if (w1.collisionBox.intersects(p1.collisionBox)) {
					p1.isAlive = false;
				}
			}
		}

		for (int i = 0; i < enemies.size(); i++) {
			for (int j = 0; j < walls.size(); j++) {
				Enemy e1 = enemies.get(i);
				Wall w1 = walls.get(j);

				if (e1.collisionBox.intersects(w1.collisionBox)) {
					e1.canMove = false;
				}

			}
		}
		
		for (int i = 0; i < enemies.size(); i++) {
			for (int j = i+1; j < enemies.size(); j++) {
				Enemy e1 = enemies.get(i);
				Enemy e2 = enemies.get(j);

				if (e1.collisionBox.intersects(e2.collisionBox)) {
					e1.canMove = false;
					e2.canMove = false;
				}

			}
		}

		for (int i = 0; i < players.size(); i++) {
			for (int j = 0; j < walls.size(); j++) {
				Player p1 = players.get(i);
				Wall w1 = walls.get(j);

				if (p1.collisionBox.intersects(w1.collisionBox)) {
					p1.canMove = false;
				}
			}
		}

	}

	public void reset() {
		enemies.clear();
		players.clear();
		walls.clear();
		projectiles.clear();
	}
}
