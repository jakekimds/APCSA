package BreakOut;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block() {
		xPos = 100;
		yPos = 150;
		width = 10;
		height = 10;
		color = Color.black;
	}

	//add other Block constructors - x , y , width, height, color
	public Block(int x, int y, int width, int height, Color col) {
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		color = col;
	}

	public Block(int x, int y, int width, int height) {
		xPos = x;
		yPos = y;
		this.width = width;
		this.height = height;
		color = Color.black;
	}

	public Block(int x, int y) {
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
		color = Color.black;
	}

	//add the other set methods

	public int getX() {
		return xPos;
	}

	public void setX(int xPos) {
		this.xPos = xPos;
	}

	public int getY() {
		return yPos;
	}

	public void setY(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setPos(int x, int y) {
		setX(x);
		setY(y);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(Graphics window) {
		//uncomment after you write the set and get methods
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void draw(Graphics window, Color col) {
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public boolean equals(Object obj) {
		Block block = (Block) obj;
		return block.getColor() == color && block.getHeight() == height && block.getWidth() == width
				&& block.getX() == xPos && block.getY() == yPos;
	}

	//add the other get methods

	//add a toString() method  - x , y , width, height, color
	public String toString() {
		return "" + xPos + ", " + yPos + ", " + width + ", " + height + ", " + color;
	}
}