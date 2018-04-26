package starfighter;
//© A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public abstract class MovingThing implements Locatable {
	private int xPos;
	private int yPos;

	public MovingThing() {
		//add more code
	}

	public MovingThing(int x, int y) {
		xPos = x;
		yPos = y;
	}

	public void setPos(int x, int y) {
		setX(x);
		setY(y);
	}

	public void setX(int x) {
		xPos = x;
	}

	public void setY(int y) {
		yPos = y;
	}

	public int getX() {
		return xPos;
	}

	public int getY() {
		return yPos;
	}

	public abstract void setSpeed(int s);

	public abstract int getSpeed();

	public abstract void draw(Graphics window);

	public void move(String direction) {
		if (direction.equals("LEFT")) {
			setX(getX() - getSpeed());
		} else if (direction.equals("RIGHT")) {
			setX(getX() + getSpeed());
		} else if (direction.equals("TOP")) {
			setY(getY() - getSpeed());
		} else if (direction.equals("BOTTOM")) {
			setY(getY() + getSpeed());
		}
	}

	public String toString() {
		return "";
	}
}