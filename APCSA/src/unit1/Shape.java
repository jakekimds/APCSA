package unit1;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	// instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int girth;
	private int gap;
	private int xStart;
	private int bodyWidth;
	private Color color;

	public Shape(int x, int y, int wid, int ht, Color col) {
		xPos = x;
		// finish this constructor
		yPos = y;
		width = wid;
		height = ht;
		color = col;
		girth = (int) (width / 7.5);
		gap = (int) (width / 30);
		xStart = xPos + girth + gap;
		bodyWidth = girth * 5;
	}

	public void draw(Graphics window) {
		window.setColor(color);
		// call other methods
		upperBody(window);
		lowerBody(window);
		arms(window);
		head(window);

	}

	// BONUS
	// add in set and get methods for all instance variables

	public String toString() {
		return xPos + " " + yPos + " " + width + " " + height + " " + color;
	}

	public void head(Graphics window) {
		window.setColor(color);

		window.fillOval(xStart, yPos, bodyWidth, bodyWidth);
		window.setColor(Color.WHITE);
		window.fillRect(xStart, yPos + bodyWidth / 2, bodyWidth, gap);
		window.setColor(color);

		// add more code here

	}

	public void upperBody(Graphics window) {

		// add more code here
		window.fillRect(xStart, yPos + bodyWidth / 2, bodyWidth, bodyWidth);
	}

	public void lowerBody(Graphics window) {

		// add more code here
		window.fillRect(xStart + girth, yPos + bodyWidth * 3 / 2, girth, girth * 2);
		window.fillRect(xStart + girth * 3, yPos + bodyWidth * 3 / 2, girth, girth * 2);
	}

	public void arms(Graphics window) {

		// add more code here
		window.fillRect(xPos, yPos + bodyWidth / 2, girth, girth * 3);
		window.fillRect(xPos + girth + gap * 2 + bodyWidth, yPos + bodyWidth / 2, girth, girth * 3);

		window.fillOval(xPos, yPos + bodyWidth / 2 - girth / 2, girth, girth);
		window.fillOval(xPos + girth + gap * 2 + bodyWidth, yPos + bodyWidth / 2 - girth / 2, girth, girth);

		window.fillOval(xPos, yPos + bodyWidth / 2 + girth * 3 - girth / 2, girth, girth);
		window.fillOval(xPos + girth + gap * 2 + bodyWidth, yPos + bodyWidth / 2 + girth * 3 - girth / 2, girth, girth);
	}
}