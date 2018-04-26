package starfighter;
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
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable {
	private Ship ship;
	private int score;
	private boolean gameOver;
	private Color bgColor;

	private Aliens aliens;
	private String direction;

	private ArrayList<Ammo> shots;

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace() {
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other stuff
		ship = new Ship(400, 400, 2);
		aliens = new Aliens(3, 5);
		shots = new ArrayList<Ammo>();
		direction = "LEFT";

		this.addKeyListener(this);
		new Thread(this).start();
		score = 0;
		gameOver = false;
		bgColor = Color.BLACK;

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(bgColor);
		graphToBack.fillRect(0, 0, 800, 600);


		//add code to move stuff
		if (!gameOver) {
			if (keys[0] == true) {
				ship.move("LEFT");
			}
			if (keys[1] == true) {
				ship.move("RIGHT");
			}
			if (keys[2] == true) {
				ship.move("TOP");
			}
			if (keys[3] == true) {
				ship.move("BOTTOM");
			}
			if (keys[4] == true) {
				shots.add(new Ammo(ship.getX() + 40, ship.getY(), 10));
				keys[4] = false;
			}
		}

		//add in collision detection
		if (aliens.edgeDetect()) {
			if (direction == "RIGHT") {
				direction = "LEFT";
			} else {
				direction = "RIGHT";
			}
			aliens.moveDown(10);
		}
		if (!gameOver) {
			if (aliens.didCollide(ship, 80, 80)) {
				gameOver = true;
				bgColor = Color.RED;
			}
			if (aliens.count() == 0) {
				bgColor = Color.GREEN;
			}
		}
		aliens.moveAndDraw(direction, graphToBack);

		for (int i = 0; i < shots.size(); i++) {
			shots.get(i).move("TOP");
			shots.get(i).draw(graphToBack);
			if (shots.get(i).getY() < 0) {
				shots.remove(i);
			} else if (aliens.didCollide(shots.get(i), 10, 10)) {
				shots.remove(i);
				score++;
			}
		}

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter\n" + "Score: " + score, 25, 50);
		ship.draw(graphToBack);
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {

	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(3);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}
