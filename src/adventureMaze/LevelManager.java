package adventureMaze;

/**
 * The Class LevelManager.
 */
public class LevelManager {
	
	/**
	 * Instantiates a new level manager.
	 */
	public LevelManager() {
		
	}

	/**
	 * Creates the level 1 wall objects.
	 *
	 * @param manager the ObjectManager
	 */
	public void createLevel1(ObjectManager manager) {

		// Border Walls
		manager.addWall(new Wall(0, 0, 10, 780));
		manager.addWall(new Wall(770, 0, 10, 780));
		manager.addWall(new Wall(0, 0, 780, 10));
		manager.addWall(new Wall(0, 770, 780, 10));
		// Inside Walls (#1-5)
		manager.addWall(new Wall(70, 0, 10, 220));
		manager.addWall(new Wall(70, 210, 70, 10));
		manager.addWall(new Wall(140, 0, 10, 140));
		manager.addWall(new Wall(210, 0, 10, 70));
		manager.addWall(new Wall(350, 0, 10, 140));
		// (6-10)
		manager.addWall(new Wall(280, 70, 80, 10));
		manager.addWall(new Wall(560, 0, 10, 140));
		manager.addWall(new Wall(420, 70, 220, 10));
		manager.addWall(new Wall(420, 70, 10, 70));
		manager.addWall(new Wall(630, 70, 10, 70));
		// 11-15
		manager.addWall(new Wall(700, 0, 10, 70));
		manager.addWall(new Wall(700, 140, 80, 10));
		manager.addWall(new Wall(210, 140, 70, 10));
		manager.addWall(new Wall(210, 140, 10, 150));
		manager.addWall(new Wall(210, 210, 500, 10));
		// 16-20
		manager.addWall(new Wall(70, 280, 210, 10));
		manager.addWall(new Wall(70, 280, 10, 140));
		manager.addWall(new Wall(350, 210, 10, 80));
		manager.addWall(new Wall(350, 280, 70, 10));
		manager.addWall(new Wall(490, 140, 10, 220));
		// 21-25
		manager.addWall(new Wall(630, 210, 10, 140));
		manager.addWall(new Wall(700, 210, 10, 140));
		manager.addWall(new Wall(700, 280, 80, 10));
		manager.addWall(new Wall(490, 350, 80, 10));
		manager.addWall(new Wall(560, 280, 10, 210));
		// 26-30
		manager.addWall(new Wall(140, 350, 220, 10));
		manager.addWall(new Wall(140, 350, 10, 150));
		manager.addWall(new Wall(210, 350, 10, 80));
		manager.addWall(new Wall(210, 420, 70, 10));
		manager.addWall(new Wall(350, 350, 10, 150));
		// 31-35
		manager.addWall(new Wall(350, 420, 80, 10));
		manager.addWall(new Wall(420, 350, 10, 80));
		manager.addWall(new Wall(490, 420, 80, 10));
		manager.addWall(new Wall(560, 490, 80, 10));
		manager.addWall(new Wall(630, 420, 70, 10));
		// 36-40
		manager.addWall(new Wall(630, 420, 10, 150));
		manager.addWall(new Wall(350, 490, 150, 10));
		manager.addWall(new Wall(70, 490, 210, 10));
		manager.addWall(new Wall(490, 490, 10, 80));
		manager.addWall(new Wall(420, 490, 10, 80));
		// 41-45
		manager.addWall(new Wall(0, 560, 210, 10));
		manager.addWall(new Wall(280, 560, 150, 10));
		manager.addWall(new Wall(490, 560, 220, 10));
		manager.addWall(new Wall(700, 490, 10, 150));
		manager.addWall(new Wall(350, 560, 10, 70));
		// 46-50
		manager.addWall(new Wall(280, 560, 10, 150));
		manager.addWall(new Wall(420, 630, 290, 10));
		manager.addWall(new Wall(0, 630, 150, 10));
		manager.addWall(new Wall(210, 630, 10, 80));
		manager.addWall(new Wall(210, 700, 80, 10));
		// 51-55
		manager.addWall(new Wall(490, 630, 10, 80));
		manager.addWall(new Wall(490, 700, 70, 10));
		manager.addWall(new Wall(630, 630, 10, 80));
		manager.addWall(new Wall(630, 700, 70, 10));
		manager.addWall(new Wall(0, 700, 70, 10));
		// 56-58
		manager.addWall(new Wall(140, 630, 10, 70));
		manager.addWall(new Wall(350, 700, 10, 80));
		manager.addWall(new Wall(420, 700, 10, 80));

	}
	
	/**
	 * Creates the level 3 wall objects.
	 *
	 * @param manager the ObjectManager
	 */
	public void createLevel3(ObjectManager manager) {
		// Border Walls
		manager.addWall(new Wall(0, 0, 10, 780));
		manager.addWall(new Wall(770, 0, 10, 780));
		manager.addWall(new Wall(0, 0, 780, 10));
		manager.addWall(new Wall(0, 770, 780, 10));
		// Inside Walls (#1-5)
		manager.addWall(new Wall(70, 70, 220, 10));
		manager.addWall(new Wall(350, 0, 10, 80));
		manager.addWall(new Wall(350, 70, 140, 10));
		manager.addWall(new Wall(630, 0, 10, 220));
		manager.addWall(new Wall(0, 140, 140, 10));
		// 6-10
		manager.addWall(new Wall(210, 70, 10, 360));
		manager.addWall(new Wall(280, 70, 10, 80));
		manager.addWall(new Wall(280, 140, 290, 10));
		manager.addWall(new Wall(560, 70, 10, 80));
		manager.addWall(new Wall(700, 70, 10, 80));
		// 11-15
		manager.addWall(new Wall(630, 140, 80, 10));
		manager.addWall(new Wall(560, 210, 80, 10));
		manager.addWall(new Wall(490, 140, 10, 80));
		manager.addWall(new Wall(350, 210, 150, 10));
		manager.addWall(new Wall(70, 210, 150, 10));
		// 16-20
		manager.addWall(new Wall(70, 210, 10, 70));
		manager.addWall(new Wall(280, 210, 10, 80));
		manager.addWall(new Wall(210, 280, 500, 10));
		manager.addWall(new Wall(700, 210, 10, 80));
		manager.addWall(new Wall(560, 280, 10, 140));
		// 21-25
		manager.addWall(new Wall(560, 350, 220, 10));
		manager.addWall(new Wall(280, 350, 220, 10));
		manager.addWall(new Wall(140, 280, 10, 80));
		manager.addWall(new Wall(70, 350, 80, 10));
		manager.addWall(new Wall(70, 350, 10, 150));
		// 26-30
		manager.addWall(new Wall(0, 490, 80, 10));
		manager.addWall(new Wall(140, 420, 80, 10));
		manager.addWall(new Wall(280, 350, 10, 150));
		manager.addWall(new Wall(490, 350, 10, 150));
		manager.addWall(new Wall(630, 420, 80, 10));
		// 31-35
		manager.addWall(new Wall(350, 420, 150, 10));
		manager.addWall(new Wall(350, 420, 10, 80));
		manager.addWall(new Wall(490, 490, 150, 10));
		manager.addWall(new Wall(350, 490, 80, 10));
		manager.addWall(new Wall(210, 490, 80, 10));
		// 36-40
		manager.addWall(new Wall(140, 420, 10, 150));
		manager.addWall(new Wall(210, 490, 10, 80));
		manager.addWall(new Wall(420, 490, 10, 80));
		manager.addWall(new Wall(560, 490, 10, 150));
		manager.addWall(new Wall(630, 490, 10, 70));
		// 41-45
		manager.addWall(new Wall(700, 420, 10, 280));
		manager.addWall(new Wall(350, 560, 140, 10));
		manager.addWall(new Wall(210, 560, 70, 10));
		manager.addWall(new Wall(70, 560, 80, 10));
		manager.addWall(new Wall(350, 560, 10, 80));
		// 46-50
		manager.addWall(new Wall(0, 630, 360, 10));
		manager.addWall(new Wall(420, 630, 290, 10));
		manager.addWall(new Wall(420, 630, 10, 80));
		manager.addWall(new Wall(70, 700, 490, 10));
		manager.addWall(new Wall(630, 700, 10, 80));
		
	}
	
	/**
	 * Creates the level 2 wall objects.
	 *
	 * @param manager the ObjectManager
	 */
	public void createLevel2(ObjectManager manager) {
		// Border Walls
		manager.addWall(new Wall(0, 0, 10, 780));
		manager.addWall(new Wall(770, 0, 10, 780));
		manager.addWall(new Wall(0, 0, 780, 10));
		manager.addWall(new Wall(0, 770, 780, 10));
		// Inside Walls (#1-5)
		manager.addWall(new Wall(70, 0, 10, 420));
		manager.addWall(new Wall(280, 0, 10, 500));
		manager.addWall(new Wall(350, 0, 10, 140));
		manager.addWall(new Wall(630, 0, 10, 290));
		manager.addWall(new Wall(140, 70, 70, 10));
		// 6-10
		manager.addWall(new Wall(420, 70, 70, 10));
		manager.addWall(new Wall(700, 70, 10, 80));
		manager.addWall(new Wall(560, 70, 10, 220));
		manager.addWall(new Wall(140, 70, 10, 210));
		manager.addWall(new Wall(210, 140, 80, 10));
		// 11-15
		manager.addWall(new Wall(490, 140, 80, 10));
		manager.addWall(new Wall(630, 140, 80, 10));
		manager.addWall(new Wall(700, 210, 80, 10));
		manager.addWall(new Wall(350, 210, 140, 10));
		manager.addWall(new Wall(140, 210, 80, 10));
		// 16-20
		manager.addWall(new Wall(420, 70, 10, 430));
		manager.addWall(new Wall(350, 210, 10, 140));
		manager.addWall(new Wall(210, 210, 10, 290));
		manager.addWall(new Wall(490, 280, 80, 10));
		manager.addWall(new Wall(630, 280, 80, 10));
		// 21-25
		manager.addWall(new Wall(700, 280, 10, 70));
		manager.addWall(new Wall(490, 280, 10, 140));
		manager.addWall(new Wall(490, 350, 150, 10));
		manager.addWall(new Wall(630, 350, 10, 80));
		manager.addWall(new Wall(630, 420, 150, 10));
		// 26-30
		manager.addWall(new Wall(70, 350, 70, 10));
		manager.addWall(new Wall(280, 420, 70, 10));
		manager.addWall(new Wall(140, 420, 80, 10));
		manager.addWall(new Wall(560, 420, 10, 80));
		manager.addWall(new Wall(210, 490, 430, 10));
		// 31-35
		manager.addWall(new Wall(140, 420, 10, 80));
		manager.addWall(new Wall(70, 490, 80, 10));
		manager.addWall(new Wall(70, 490, 10, 150));
		manager.addWall(new Wall(490, 490, 10, 70));
		manager.addWall(new Wall(630, 490, 10, 210));
		// 36-40
		manager.addWall(new Wall(700, 490, 10, 80));
		manager.addWall(new Wall(630, 560, 80, 10));
		manager.addWall(new Wall(140, 560, 280, 10));
		manager.addWall(new Wall(280, 560, 10, 80));
		manager.addWall(new Wall(560, 560, 10, 140));
		// 41-45
		manager.addWall(new Wall(70, 630, 80, 10));
		manager.addWall(new Wall(280, 630, 290, 10));
		manager.addWall(new Wall(490, 630, 10, 150));
		manager.addWall(new Wall(700, 630, 10, 150));
		manager.addWall(new Wall(210, 630, 10, 80));
		// 46-48
		manager.addWall(new Wall(140, 630, 10, 80));
		manager.addWall(new Wall(140, 700, 280, 10));
		manager.addWall(new Wall(0, 700, 70, 10));

		
	}
	
	/**
	 * Creates the level 4 wall objects.
	 *
	 * @param manager the ObjectManager
	 */
	public void createLevel4(ObjectManager manager) {
		// Border Walls
		manager.addWall(new Wall(0, 0, 10, 780));
		manager.addWall(new Wall(770, 0, 10, 780));
		manager.addWall(new Wall(0, 0, 780, 10));
		manager.addWall(new Wall(0, 770, 780, 10));
		// Inside Walls (#1-5)
		manager.addWall(new Wall(210, 0, 10, 80));
		manager.addWall(new Wall(350, 0, 10, 80));
		manager.addWall(new Wall(490, 0, 10, 70));
		manager.addWall(new Wall(700, 0, 10, 70));
		manager.addWall(new Wall(70, 70, 150, 10));
		// 6-10
		manager.addWall(new Wall(350, 70, 70, 10));
		manager.addWall(new Wall(560, 70, 10, 220));
		manager.addWall(new Wall(630, 70, 10, 140));
		manager.addWall(new Wall(420, 70, 10, 80));
		manager.addWall(new Wall(280, 70, 10, 80));
		// 11-15
		manager.addWall(new Wall(70, 70, 10, 220));
		manager.addWall(new Wall(140, 140, 220, 10));
		manager.addWall(new Wall(420, 140, 80, 10));
		manager.addWall(new Wall(630, 140, 150, 10));
		manager.addWall(new Wall(140, 140, 10, 80));
		// 16-20
		manager.addWall(new Wall(350, 140, 10, 80));
		manager.addWall(new Wall(490, 140, 10, 80));
		manager.addWall(new Wall(140, 210, 140, 10));
		manager.addWall(new Wall(350, 210, 80, 10));
		manager.addWall(new Wall(490, 210, 80, 10));
		// 21-25
		manager.addWall(new Wall(420, 210, 10, 80));
		manager.addWall(new Wall(700, 210, 10, 150));
		manager.addWall(new Wall(210, 210, 10, 220));
		manager.addWall(new Wall(70, 280, 80, 10));
		manager.addWall(new Wall(420, 280, 220, 10));
		// 26-30
		manager.addWall(new Wall(280, 280, 70, 10));
		manager.addWall(new Wall(490, 280, 10, 70));
		manager.addWall(new Wall(630, 280, 10, 80));
		manager.addWall(new Wall(630, 350, 80, 10));
		manager.addWall(new Wall(280, 280, 10, 80));
		// 31-35
		manager.addWall(new Wall(140, 280, 10, 80));
		manager.addWall(new Wall(70, 350, 80, 10));
		manager.addWall(new Wall(280, 350, 150, 10));
		manager.addWall(new Wall(420, 350, 10, 80));
		manager.addWall(new Wall(560, 350, 10, 80));
		// 36-40
		manager.addWall(new Wall(70, 350, 10, 290));
		manager.addWall(new Wall(140, 420, 150, 10));
		manager.addWall(new Wall(420, 420, 280, 10));
		manager.addWall(new Wall(490, 420, 10, 70));
		manager.addWall(new Wall(630, 420, 10, 80));
		// 41-45
		manager.addWall(new Wall(350, 420, 10, 220));
		manager.addWall(new Wall(280, 490, 80, 10));
		manager.addWall(new Wall(280, 420, 10, 80));
		manager.addWall(new Wall(140, 420, 10, 140));
		manager.addWall(new Wall(630, 490, 80, 10));
		// 46-50
		manager.addWall(new Wall(210, 490, 10, 210));
		manager.addWall(new Wall(420, 490, 10, 80));
		manager.addWall(new Wall(560, 490, 10, 80));
		manager.addWall(new Wall(700, 490, 10, 80));
		manager.addWall(new Wall(700, 560, 80, 10));
		// 51-55
		manager.addWall(new Wall(420, 560, 220, 10));
		manager.addWall(new Wall(210, 560, 70, 10));
		manager.addWall(new Wall(70, 630, 150, 10));
		manager.addWall(new Wall(280, 630, 360, 10));
		manager.addWall(new Wall(630, 560, 10, 150));
		// 56-60
		manager.addWall(new Wall(280, 630, 10, 70));
		manager.addWall(new Wall(490, 630, 10, 70));
		manager.addWall(new Wall(630, 700, 80, 10));
		manager.addWall(new Wall(700, 630, 10, 80));
		manager.addWall(new Wall(560, 700, 10, 80));
		// 61-64
		manager.addWall(new Wall(350, 700, 70, 10));
		manager.addWall(new Wall(350, 700, 10, 80));
		manager.addWall(new Wall(140, 700, 10, 80));
		manager.addWall(new Wall(70, 700, 80, 10));
		
	}

}
