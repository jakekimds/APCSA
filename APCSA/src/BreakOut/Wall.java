package BreakOut;

public class Wall implements Collidable {
	private int x, y, width, height;

	public Wall(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public boolean didCollideLeft(Object obj) {
		Ball object = (Ball) obj;
		if ((getX() <= object.getX() + object.getWidth() + Math.abs(object.getXSpeed())
				&& (getY() + getHeight() >= object.getY() && getY() < object.getY() + object.getHeight()))) {
			if ((getX() <= (object.getX() + object.getWidth() - Math.abs(object.getXSpeed())))) {
				return true;
			}
		}
		return false;
	}

	public boolean didCollideRight(Object obj) {
		Ball object = (Ball) obj;
		if ((getX() + getWidth() >= object.getX() - Math.abs(object.getXSpeed())
				&& (getY() + getHeight() >= object.getY() && getY() < object.getY() + object.getHeight()))) {
			if ((getX() >= (object.getX() + Math.abs(object.getXSpeed())))) {
				return true;
			}
		}
		return false;
	}

	public boolean didCollideBottom(Object obj) {
		Ball object = (Ball) obj;
		if ((getY() + getHeight() >= object.getY() - Math.abs(object.getYSpeed())
				&& (getX() + getWidth() >= object.getX() && getX() < object.getX() + object.getWidth()))) {
			if ((getY() >= (object.getY() + Math.abs(object.getYSpeed())))) {
				return true;
			}
		}
		return false;
	}

	public boolean didCollideTop(Object obj) {
		Ball object = (Ball) obj;
		if ((getY() <= object.getY() + object.getHeight() + Math.abs(object.getYSpeed())
				&& (getX() + getWidth() >= object.getX() && getX() < object.getX() + object.getWidth()))) {
			if ((getY() <= (object.getY() + object.getHeight() - Math.abs(object.getYSpeed())))) {
				return true;
			}
		}
		return false;
	}
}
