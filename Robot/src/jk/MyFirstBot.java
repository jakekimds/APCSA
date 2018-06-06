package jk;

import robocode.*;

public class MyFirstBot extends Robot {
	/**
	 * run: Robot's default behavior
	 */
	
	double lastHead;
	
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			//turnGunRight(1);
			//fire(3);
//			if(getEnergy() < 100){
//				System.out.println("Jake's robot cannot die");
//				long millis = System.currentTimeMillis();
//				while(true){
//					if(System.currentTimeMillis() - millis >= 2000){
//						break;
//					}
//				}
//			}
			turnRadarRight(1000);
			scan();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		double bear = e.getBearing();
		lastHead = bear;
		double rang = bear - getGunHeading() + getHeading();
		rang %= 360;
		double lang = 360 - rang;
		lang %= 360;
		if(lang > rang){
			turnGunRight(rang);
		}else{
			turnGunLeft(lang);
		}
		fire(3);
		
		turnRight(bear + 90);
		ahead(10000);
		
		
		//hitWall = false;
		//turnLeft(ang);
	}

	public void onDeath(DeathEvent e){
	//	while(true){}
	}
	
	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
//		turnRight(e.getBearing());
//		fire(e.getPower());
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		turnRight(lastHead);
		ahead(100);
	}	
}
