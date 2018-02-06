package unit1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

class Robot extends Canvas {
	public Robot() // constructor method - sets up the class
	{
		setSize(800, 800);
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void paint(Graphics window) {
		window.setColor(Color.BLUE);

		window.drawString("Robot LAB ", 35, 35);

		// call head method
		head(window);

		// call other methods
		upperBody(window);
		legs(window);
		arms(window);

	}

	public void head(Graphics window) {
		window.setColor(Color.GRAY);

		window.fillRect(285, 100, 150, 150);

	}

	public void upperBody(Graphics window) {

		// add more code here
		window.fillRect(210, 260, 300, 300);
	}

	public void legs(Graphics window) {

		// add more code here
		window.fillRect(210, 570, 100, 200);
		window.fillRect(410, 570, 100, 200);
	}

	public void arms(Graphics window) {

		// add more code here
		window.fillRect(100, 260, 100, 200);
		window.fillRect(520, 260, 100, 200);
	}
}