package adventureMaze;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<Enemy> enemies;
	ArrayList<Player> players;
	ArrayList<Wall> walls;
	ArrayList<Item> items;
	ArrayList<Projectile> projectiles;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public ObjectManager() {
		enemies = new ArrayList<Enemy>();
		players = new ArrayList<Player>();
		walls = new ArrayList<Wall>();
		items = new ArrayList<Item>();
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

	public void addItem(Item i) {
		items.add(i);
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
		for (int x = 0; x < items.size(); x++) {
			Item i = items.get(x);
			i.update();
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
		for (int m = 0; m < items.size(); m++) {
			Item i = items.get(m);
			i.draw(g);
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
		for (int m = 0; m < items.size(); m++) {
			if (!items.get(m).isAlive) {
				items.remove(m);
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
			addEnemy(new Enemy(new Random().nextInt(AdventureMaze.WIDTH - 50), 50, 50, 50));
			enemyTimer = System.currentTimeMillis();
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

		for (int i = 0; i < enemies.size(); i++) {
			for (int j = 0; j < walls.size(); j++) {
				Enemy e1 = enemies.get(i);
				Wall w1 = walls.get(j);

				if (e1.collisionBox.intersects(w1.collisionBox)) {
					e1.canMove = false;
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
		items.clear();
		projectiles.clear();
	}
}
