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

public class Ship extends MovingThing {
	private int speed;
	private Image image;
	private int shieldStrength = 0;
	
	public Ship() {
		this(0, 0, 0);
	}

	public Ship(int x, int y) {
		this(x, y, 0);
	}

	public Ship(int x, int y, int s) {
		super(x, y);
		speed = s;
		loadImage("src/starfighter/ship.jpg");
	}
	
	public void loadImage(String path){
		try {
			image = ImageIO.read(new File(path));
		} catch (Exception e) {
			//feel free to do something here
		}
	}
	
	public void activateShield(){
		loadImage("src/starfighter/ship.jpgWithShield.jpg");
		shieldStrength = 3;
	}
	
	public void attack(){
		if(isShielded()){
			shieldStrength--;
			if(shieldStrength <= 0){
				loadImage("src/starfighter/ship.jpg");
			}
		}
	}
	
	public boolean isShielded(){
		return shieldStrength > 0;
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), 80, 80, null);
	}

	public String toString() {
		return super.toString() + getSpeed();
	}
}
