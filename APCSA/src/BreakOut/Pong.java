package BreakOut;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private Wall leftWall;
	private Wall rightWall;
	private Wall bottomWall;
	private Wall topWall;
	private int leftPoints;
	private int rightPoints;
	private boolean set;

	public Pong() {
		keys = new boolean[5];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); //starts the key thread to log key strokes

		//set up all game variables
		set = false;
		leftPoints = 0;
		rightPoints = 0;
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if (back == null) {
			back = (BufferedImage) (createImage(getWidth(), getHeight()));
		}
		if (!set) {
			bottomWall = new Wall(0, getHeight(), getWidth(), 0);
			ball = new BlinkyBall(50, 50, 20, 20);
			leftPaddle = new Paddle(100, 100, 10, 100);
			rightPaddle = new Paddle(getWidth() - 100, 100, 10, 100);
			leftWall = new Wall(0, 0, 0, getHeight());
			rightWall = new Wall(getWidth(), 0, 0, getHeight());
			topWall = new Wall(0, 0, getWidth(), 0);
			set = true;
		}

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		graphToBack.setColor(Color.WHITE);
		graphToBack.fillRect(0, 0, getWidth(), getHeight());

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		rightPaddle.setX(getWidth() - 100);

		//see if the paddles need to be moved
		if (keys[0]) {
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[1]) {
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if (keys[2]) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[3]) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		//see if ball hits left wall or right wall
		if (leftWall.didCollideRight(ball)) {
			rightPoints++;
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (rightWall.didCollideLeft(ball)) {
			leftPoints++;
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (bottomWall.didCollideTop(ball) || topWall.didCollideBottom(ball)) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.didCollideBottom(leftPaddle) || ball.didCollideBottom(rightPaddle) || ball.didCollideTop(leftPaddle)
				|| ball.didCollideTop(rightPaddle)) {
			ball.setYSpeed(-1 * ball.getYSpeed());
		}
		if (ball.didCollideLeft(leftPaddle) || ball.didCollideRight(rightPaddle) || ball.didCollideLeft(rightPaddle)
				|| ball.didCollideRight(leftPaddle)) {
			ball.setXSpeed(-1 * ball.getXSpeed());
		}
		graphToBack.drawString("Left: " + leftPoints, getWidth() / 2, getHeight() - 100);
		graphToBack.drawString("Right: " + rightPoints, getWidth() / 2, getHeight() - 80);
		//		rightPaddle.draw(graphToBack, Color.white);
		//		rightPaddle.setY(ball.getY() + ball.getHeight() / 2 - leftPaddle.getHeight() / 2);
		//		rightPaddle.draw(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
			case 'W':
				keys[0] = true;
				break;
			case 'Z':
				keys[1] = true;
				break;
			case 'I':
				keys[2] = true;
				break;
			case 'M':
				keys[3] = true;
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
			case 'W':
				keys[0] = false;
				break;
			case 'Z':
				keys[1] = false;
				break;
			case 'I':
				keys[2] = false;
				break;
			case 'M':
				keys[3] = false;
				break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void run() {
		try {
			while (true) {
				int fps = 125;
				Thread.currentThread().sleep((1000 / fps));
				repaint();
			}
		} catch (Exception e) {
		}
	}
}