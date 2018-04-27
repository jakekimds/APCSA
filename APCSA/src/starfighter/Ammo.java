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

public class Ammo extends MovingThing {
	private int speed;
	private Color color;

	public Ammo() {
		this(0, 0, 0);
	}

	public Ammo(int x, int y) {
		this(x, y, 0);
	}

	public Ammo(int x, int y, int s) {
		this(x,y,s,Color.red);
	}
	public Ammo(int x, int y, int s, Color col) {
		super(x, y);
		setSpeed(s);
		color = col;
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(getX(), getY(), 10, 10);
	}

	public String toString() {
		return "";
	}
}
