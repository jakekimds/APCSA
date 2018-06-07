package jk;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import robocode.*;

public class CheatBot extends Robot {
	
	double lastHead;
	
	public void run() {
		while(true) {
			if(getEnergy() < 50){
				waitForMs(2000);
				fire(.1);
			}else{
				turnRadarRight(1000);
				scan();
			}
			
		}
	}
	
	public void waitForMs(int mil){
		System.out.println("Jake's robot cannot die");
		long millis = System.currentTimeMillis();
		while(true){
			if(System.currentTimeMillis() - millis >= mil){
				break;
			}
		}
	}

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
	}	
}