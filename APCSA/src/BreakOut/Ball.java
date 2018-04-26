package BreakOut;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable {
	private int xSpeed;
	private int ySpeed;

	public Ball() {
		super(200, 200);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	public Ball(int x, int y) {
		super(x, y);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int x, int y, int width, int height, Color color) {
		super(x, y, height, width, color);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(int x, int y, int width, int height, Color color, int xSpd, int ySpd) {
		super(x, y, height, width, color);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
	}

	//add the set methods

	public int getXSpeed() {
		return xSpeed;
	}

	public void setXSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public int getYSpeed() {
		return ySpeed;
	}

	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	public void moveAndDraw(Graphics window) {
		//draw a white ball at old ball location
		draw(window, Color.white);

		setX(getX() + xSpeed);
		setY(getY() + ySpeed);

		//draw the ball at its new location
		draw(window);
	}

	public boolean equals(Object obj) {
		Ball ball = (Ball) obj;
		return super.equals(obj) && xSpeed == getXSpeed() && ySpeed == getYSpeed();
	}

	public boolean didCollideLeft(Object obj) {
		Block leftPaddle = (Block) obj;
		if ((getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(getXSpeed())
				&& (getY() + getHeight() >= leftPaddle.getY()
						&& getY() < leftPaddle.getY() + leftPaddle.getHeight()))) {
			if (!(getX() <= (leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(getXSpeed())))) {
				return true;
			}
		}
		return false;
	}

	public boolean didCollideRight(Object obj) {
		Block rightPaddle = (Block) obj;
		if ((getX() + getWidth() >= rightPaddle.getX() + Math.abs(getXSpeed())
				&& (getY() + getHeight() >= rightPaddle.getY()
						&& getY() < rightPaddle.getY() + rightPaddle.getHeight()))) {
			if (!(getX() >= (rightPaddle.getX() + Math.abs(getXSpeed())))) {
				return true;
			}
		}
		return false;
	}

	public boolean didCollideBottom(Object obj) {
		Block bottomPaddle = (Block) obj;
		if ((getY() + getHeight() >= bottomPaddle.getY() + Math.abs(getYSpeed())
				&& (getX() + getWidth() >= bottomPaddle.getX()
						&& getX() < bottomPaddle.getX() + bottomPaddle.getWidth()))) {
			if (!(getY() >= (bottomPaddle.getY() + Math.abs(getYSpeed())))) {
				return true;
			}
		}
		return false;
	}

	public boolean didCollideTop(Object obj) {
		Block topPaddle = (Block) obj;
		if ((getY() <= topPaddle.getY() + topPaddle.getHeight() + Math.abs(getYSpeed())
				&& (getX() + getWidth() >= topPaddle.getX() && getX() < topPaddle.getX() + topPaddle.getWidth()))) {
			if (!(getY() <= (topPaddle.getY() + topPaddle.getHeight() - Math.abs(getYSpeed())))) {
				return true;
			}
		}
		return false;
	}
	//add the get methods

	//add a toString() method
	public String toString() {
		return super.toString() + ", " + ySpeed + ", " + xSpeed;
	}
}