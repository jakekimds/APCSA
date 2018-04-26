package BreakOut;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball {

	//instance variables
	int xAcc = 1, yAcc = 1;

	public SpeedUpBall() {
		super();
	}

	public SpeedUpBall(int x, int y) {
		super(x, y);
	}

	public SpeedUpBall(int x, int y, int wid, int ht) {
		super(x, y, wid, ht);
	}

	public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd) {
		super(x, y, wid, ht, Color.black, xSpd, ySpd);
	}

	public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
		super(x, y, wid, ht, col, xSpd, ySpd);
	}

	public void setXSpeed(int xSpd) {
		int sign = xSpd / Math.abs(xSpd);
		int newSpeed = sign * xAcc + xSpd;
		super.setXSpeed(newSpeed);
	}

	public void setYSpeed(int ySpd) {
		int sign = ySpd / Math.abs(ySpd);
		int newSpeed = sign * yAcc + ySpd;
		super.setYSpeed(newSpeed);
	}
}
