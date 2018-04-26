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

public class BreakOut extends Canvas implements KeyListener, Runnable {
	private Ball ball;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private int points;
	private boolean[][] bricks; // Keeps track of which blocks as active
	private Block[][] brickObjs; // Holds the actual block objects
	private boolean set; // If false, the variables need to be initialized
	private int rows = 10;
	private int cols = 10;

	public BreakOut() {
		keys = new boolean[2];
		bricks = new boolean[rows][cols];
		brickObjs = new Block[rows][cols];

		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); //starts the key thread to log key strokes
		System.out.println("Jake Kim - 4/4/2018 - Computer #10");
		//set up all game variables
		set = false;
		points = 0;
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
			/*
			 * I've chosen to initialize inside the loop because getWidth() doesn't seem to work in the constructor
			 */
			ball = new Ball(getWidth() / 2, getHeight() / 2, 20, 20);
			rightPaddle = new Paddle(getWidth() - 100, getHeight() - 100, 10, 100);

			int horSpace = 10;
			int vertSpace = 10;
			int blockW = 10;
			int blockH = (getHeight() - vertSpace * (cols + 1)) / cols;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					bricks[i][j] = true;
					brickObjs[i][j] = new Block((i) * (blockW + horSpace) + horSpace,
							(j) * (blockH + vertSpace) + vertSpace, blockW, blockH);
				}
			}
			set = true;
		}

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		graphToBack.setColor(Color.WHITE);
		graphToBack.fillRect(0, 0, getWidth(), getHeight());

		ball.moveAndDraw(graphToBack);
		rightPaddle.draw(graphToBack);
		rightPaddle.setX(getWidth() - 100);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (bricks[i][j]) {
					brickObjs[i][j].draw(graphToBack);
					if (ball.didCollideBottom(brickObjs[i][j]) || ball.didCollideTop(brickObjs[i][j])) {
						ball.setYSpeed(-1 * ball.getYSpeed());
						bricks[i][j] = false;
						points++;
					}
					if (ball.didCollideRight(brickObjs[i][j]) || ball.didCollideLeft(brickObjs[i][j])) {
						ball.setXSpeed(-1 * ball.getXSpeed());
						bricks[i][j] = false;
						points++;
					}
				}
			}
		}

		//see if the paddles need to be moved
		if (keys[0]) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[1]) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		//see if ball hits left wall or right wall
		if (ball.getX() <= 0) {
			ball.setXSpeed(-ball.getXSpeed());
		}
		if (ball.getX() + ball.getWidth() >= getWidth()) {
			points = 0;
			set = false;
		}
		if (ball.getY() <= 0 || ball.getY() + ball.getHeight() >= getHeight()) {
			ball.setYSpeed(-ball.getYSpeed());
		}
		if (ball.didCollideBottom(rightPaddle) || ball.didCollideTop(rightPaddle)) {
			ball.setYSpeed(-1 * ball.getYSpeed());
		}
		if (ball.didCollideRight(rightPaddle) || ball.didCollideLeft(rightPaddle)) {
			ball.setXSpeed(-1 * ball.getXSpeed());
		}
		graphToBack.drawString("Points: " + points, getWidth() / 2, getHeight() - 100);
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