package starfighter;
//© A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Powerup extends MovingThing {
	private Image image;

	public Powerup() {
		this(0, 0, 0);
	}

	public Powerup(int x, int y) {
		this(x, y, 0);
	}

	public Powerup(int x, int y, int s) {
		super(x, y);
		try {
			image = ImageIO.read(new File("src/starfighter/pu.jpg"));
		} catch (Exception e) {
			//feel free to do something here
		}
	}

	public void setSpeed(int s) {
	}

	public int getSpeed() {
		return 0;
	}

	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), 80, 80, null);
	}

	public String toString() {
		return super.toString() + getSpeed();
	}
	
	public static Powerup getRandomPowerup(int startX, int endX, int startY, int endY){
		endX = endX - 80;
		endY = endY - 80;
		int x = (int)(Math.random()*(endX - startX) + startX);
		int y = (int)(Math.random()*(endY - startY) + startY);
		return new Powerup(x,y);
	}
}
