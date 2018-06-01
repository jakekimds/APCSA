package javaProjectFortneetDylanChan;


import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.*;


public class Fortneet extends Canvas implements KeyListener, MouseListener,
		MouseMotionListener, MouseWheelListener, Runnable
{
	private List<Block> obstacles;
	private boolean existingBlock;
	private Block floor;
	private Player avatar;
	private List<BadGuy> enemies;
	private Weapon gun;
	private List<Ammo> bulletsFired;

	private int score;
	private boolean scrollX;
	private int spawnTimer;
	private int spawnLimit;

	private Mouse mouseOutline;
	private boolean[] keys;
	private boolean[] mouse;
	private int mouseX;
	private int mouseY;
	private int mouseXBox;
	private int mouseYBox;
	private int mouseWheelNum;

	private BufferedImage back;


	public Fortneet()
	{
		setBackground(Color.LIGHT_GRAY);

		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addMouseWheelListener(this);
		new Thread(this).start();

		setVisible(true);

		avatar = new Player(490, 600, 20, 80, 0, 0, "RIGHT", new Color(255, 255, 180),
				Color.BLUE, new Color(153, 51, 0), 10, 15, false, "NONE");
		gun = new Weapon(490, 590, "RIGHT", Color.BLACK);
		bulletsFired = new ArrayList<Ammo>();
		enemies = new ArrayList<BadGuy>();
		obstacles = new ArrayList<Block>();
		existingBlock = false;
		floor = new Block(-2280, 680, 5640, 20, 0, 0);
		obstacles.add(floor);


		/*
		 * for (int repeat = 0; repeat < 3; repeat++) { int x = floor.getX();
		 * int y = (int) (Math.random() * 17) * 40; while (x < floor.getX() +
		 * floor.getWidth()) { for (Block structure : obstacles) { while ((x ==
		 * structure.getX() && y == structure.getY()) || (avatar.getX() +
		 * avatar.getWidth() >= x && avatar.getX() <= y + 40 && avatar.getY() +
		 * avatar.getHeight() > y && avatar.getY() < y + 40)) { y = (int)
		 * (Math.random() * 17) * 40; } } obstacles.add(new Block(x, y, 40, 40,
		 * 0, 0)); int randint = (int) (Math.random() * 3) - 1;
		 * 
		 * y += 40 * randint;
		 * 
		 * if (y < 0 || y > 640) { y = (int) (Math.random() * 17) * 40; }
		 * 
		 * x += 40; } }
		 */


		for (int y = 200; y < 680; y += 240)
		{
			for (int x = floor.getX(); x < floor.getX() + floor.getWidth(); x += 40)
			{
				obstacles.add(new Block(x, y, 40, 40, 0, 0));
			}
		}

		score = 0;
		scrollX = false;


		keys = new boolean[4];
		mouse = new boolean[2];
		mouseX = 0;
		mouseY = 0;
		mouseXBox = 0;
		mouseYBox = 0;
		mouseWheelNum = 0;

		mouseOutline = new Mouse(mouseXBox - 20, mouseYBox - 20, Color.GREEN);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	public void paint(Graphics window)
	{
		// set up the double buffering to make the game animation nice and
		// smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.drawString("HEALTH", 75, 715);
		graphToBack.drawString("SCORE: " + score, 250, 715);


		avatar.setFalling(true);
		gun.setColor(Color.BLACK);

		if (spawnTimer == 100)
		{
			spawnTimer = 0;
			if (enemies.size() <= 100)
			{
				enemies.add(new BadGuy((int) (Math.random() * (floor.getWidth() - floor.getX())
						+ floor.getX()), 0));
			}
		}
		else
		{
			spawnTimer++;
		}

		for (BadGuy enemy : enemies)
		{
			enemy.setFalling(true);
		}

		// COLLISION DETECTION
		for (Block structure : obstacles)
		{
			if (avatar.didCollide(structure, "BOTTOM"))
			{
				if (avatar.getYSpeed() == -20)
				{
					avatar.replaceHearts(graphToBack, avatar.getHealth() - 1, getBackground());
					System.out.println(avatar.getHealth());
				}
				avatar.draw(graphToBack, getBackground());
				avatar.setY(structure.getY() - avatar.getHeight());
				avatar.setYSpeed(0);
				avatar.setFalling(false);
				avatar.draw(graphToBack);
				gun.draw(graphToBack, getBackground());
				gun.setY(avatar.getY());
				gun.setYSpeed(avatar.getYSpeed());
				gun.draw(graphToBack);
			}
			else if (avatar.didCollide(structure, "TOP"))
			{
				avatar.draw(graphToBack, getBackground());
				avatar.setY(structure.getY() + structure.getHeight());
				avatar.setYSpeed(0);
				avatar.setFalling(true);
				avatar.draw(graphToBack);
				gun.draw(graphToBack, getBackground());
				gun.setY(avatar.getY());
				gun.setYSpeed(avatar.getYSpeed());
				gun.draw(graphToBack);
			}
			else if (avatar.didCollide(structure, "LEFT")
					&& !avatar.didCollide(structure, "BOTTOM"))
			{
				avatar.draw(graphToBack, getBackground());
				gun.draw(graphToBack, getBackground());

				if (scrollX == true)
				{
					avatar.setXSpeed(structure.getXSpeed());
					gun.setXSpeed(avatar.getXSpeed());
				}
				else if (scrollX == false)
				{
					avatar.setXSpeed(0);
					gun.setXSpeed(avatar.getXSpeed());

				}

				avatar.setX(structure.getX() + structure.getWidth());
				avatar.draw(graphToBack);
				gun.setX(avatar.getX());
				gun.draw(graphToBack);
			}
			else if (avatar.didCollide(structure, "RIGHT")
					&& !avatar.didCollide(structure, "BOTTOM"))
			{
				avatar.draw(graphToBack, getBackground());
				gun.draw(graphToBack, getBackground());

				if (scrollX == true)
				{
					avatar.setXSpeed(structure.getXSpeed());
					gun.setXSpeed(avatar.getXSpeed());
				}
				else if (scrollX == false)
				{
					avatar.setXSpeed(0);
					gun.setXSpeed(avatar.getXSpeed());
				}

				avatar.setX(structure.getX() - avatar.getWidth());
				avatar.draw(graphToBack);
				gun.setX(avatar.getX());
				gun.draw(graphToBack);
			}

			// Weapon Collision
			if ((gun.didCollide(structure, "LEFT") == true
					&& gun.getDirection().equals("LEFT"))
					|| (gun.didCollide(structure, "RIGHT") == true
							&& gun.getDirection().equals("RIGHT")))
			{
				gun.setColor(getBackground());
			}

			// Enemy Collision

			for (BadGuy enemy : enemies)
			{
				if (enemy.didCollide(structure, "BOTTOM")
						&& !(enemy.didCollide(structure, "LEFT")
								|| enemy.didCollide(structure, "RIGHT")))
				{
					enemy.draw(graphToBack, getBackground());
					enemy.setY(structure.getY() - enemy.getHeight());
					enemy.setYSpeed(0);
					enemy.setFalling(false);
					enemy.draw(graphToBack);
				}
				else if (enemy.didCollide(structure, "TOP")
						&& !(enemy.didCollide(structure, "LEFT")
								|| enemy.didCollide(structure, "RIGHT")))
				{
					enemy.draw(graphToBack, getBackground());
					enemy.setY(structure.getY() + structure.getHeight());
					enemy.setYSpeed(0);
					enemy.setFalling(true);
					enemy.draw(graphToBack);
				}
				if (enemy.didCollide(structure, "LEFT")
						&& !enemy.didCollide(structure, "BOTTOM"))
				{
					enemy.draw(graphToBack, getBackground());

					if (scrollX == true)
					{
						enemy.setXSpeed(structure.getXSpeed());
					}
					else if (scrollX == false)
					{
						enemy.setXSpeed(0);

					}
					enemy.setX(structure.getX() + structure.getWidth());
					enemy.draw(graphToBack);

					for (Block thing : obstacles)
					{
						if (enemy.didCollide(thing, "BOTTOM") == true
								&& enemy.getFalling() == false)
						{
							enemy.setYSpeed(enemy.getYSpeed() + 15);
							enemy.setFalling(true);
						}
					}
				}
				else if (enemy.didCollide(structure, "RIGHT")
						&& !enemy.didCollide(structure, "BOTTOM"))
				{
					enemy.draw(graphToBack, getBackground());

					if (scrollX == true)
					{
						enemy.setXSpeed(structure.getXSpeed());
					}
					else if (scrollX == false)
					{
						avatar.setXSpeed(0);
					}

					enemy.setX(structure.getX() - enemy.getWidth());
					enemy.draw(graphToBack);

					for (Block thing : obstacles)
					{
						if (enemy.didCollide(thing, "BOTTOM") == true
								&& enemy.getFalling() == false)
						{
							enemy.setYSpeed(enemy.getYSpeed() + 15);
							enemy.setFalling(true);
						}
					}
				}
			}

			for (BadGuy enemy : enemies)
			{
				for (BadGuy other : enemies)
				{
					if ((enemy.getX() < other.getX() + other.getWidth()
							&& enemy.getX() >= other.getX() + (other.getWidth() - 15)
							&& enemy.getY() + enemy.getHeight() > other.getY()
							&& enemy.getY() < other.getY() + other.getHeight())
							|| enemy.getX() + enemy.getWidth() > avatar.getX()
									&& enemy.getX() + enemy.getWidth() <= other.getX() + 15
									&& enemy.getY() + enemy.getHeight() > other.getY()
									&& enemy.getY() < other.getY() + other.getHeight())
					{
						other.draw(graphToBack, getBackground());
						other.setPos((int) (Math.random() * (floor.getWidth() - floor.getX())
								+ floor.getX()), 0);
						break;
					}
				}
			}

			// Bullet Collisions
			for (Ammo bullet : bulletsFired)
			{
				boolean shot = false;
				if (bullet.didCollide(structure, "LEFT")
						|| bullet.didCollide(structure, "RIGHT"))
				{
					bullet.draw(graphToBack, getBackground());
					bulletsFired.remove(bullet);
					break;
				}
				for (BadGuy enemy : enemies)
				{
					if (enemy.didCollide(bullet, "LEFT") || enemy.didCollide(bullet, "RIGHT"))
					{
						enemy.draw(graphToBack, getBackground());
						enemies.remove(enemy);
						shot = true;
						graphToBack.setColor(getBackground());
						graphToBack.drawString("SCORE: " + score, 250, 715);
						score++;
						break;
					}
				}
				if (shot)
				{
					bullet.draw(graphToBack, getBackground());
					bulletsFired.remove(bullet);
					break;
				}
			}
		}

		for (BadGuy enemy : enemies)
		{
			if (enemy.getX() < avatar.getX() + avatar.getWidth()
					&& enemy.getX() >= avatar.getX() + (avatar.getWidth() - 15)
					&& enemy.getY() + enemy.getHeight() > avatar.getY()
					&& enemy.getY() < avatar.getY() + avatar.getHeight())
			{
				avatar.replaceHearts(graphToBack, avatar.getHealth() - 1, getBackground());
				enemy.draw(graphToBack, getBackground());
				enemies.remove(enemy);
				break;
			}
			else if (enemy.getX() + enemy.getWidth() > avatar.getX()
					&& enemy.getX() + enemy.getWidth() <= avatar.getX() + 15
					&& enemy.getY() + enemy.getHeight() > avatar.getY()
					&& enemy.getY() < avatar.getY() + avatar.getHeight())
			{
				avatar.replaceHearts(graphToBack, avatar.getHealth() - 1, getBackground());
				enemy.draw(graphToBack, getBackground());
				enemies.remove(enemy);
				break;
			}
		}


		// GRAVITY

		if (avatar.getFalling() == true)
		{
			if (scrollX == false && avatar.getYSpeed() < -20)
			{
				avatar.setYSpeed(-20);
				gun.setYSpeed(avatar.getYSpeed());
			}
			else if (scrollX == true && avatar.getYSpeed() < -15)
			{
				avatar.setYSpeed(-15);
				gun.setYSpeed(avatar.getYSpeed());
			}
			else
			{
				avatar.setYSpeed(avatar.getYSpeed() - 1);
				gun.setYSpeed(avatar.getYSpeed());
			}
		}
		for (BadGuy enemy : enemies)
		{
			if (scrollX == false && enemy.getYSpeed() < -20)
			{
				enemy.setYSpeed(-20);
			}
			else if (scrollX == true && enemy.getYSpeed() < -15)
			{
				enemy.setYSpeed(-15);
			}
			else
			{
				enemy.setYSpeed(enemy.getYSpeed() - 1);
			}
		}

		// Enemy Movement
		for (BadGuy enemy : enemies)
		{
			for (Block structure : obstacles)
			{
				if (avatar.getX() < enemy.getX() && !(enemy.didCollide(structure, "LEFT")
						|| enemy.didCollide(structure, "RIGHT")))
				{
					enemy.draw(graphToBack, getBackground());
					enemy.setDirection("LEFT");
					if (enemy.getMoving().equals("NONE"))
					{
						enemy.setXSpeed(enemy.getXSpeed() - 3);
						enemy.setMoving("LEFT");
					}
					else if (enemy.getMoving().equals("RIGHT"))
					{
						enemy.setXSpeed(enemy.getXSpeed() - 6);
						enemy.setMoving("LEFT");
					}
				}
				else if (avatar.getX() > enemy.getX() && !(enemy.didCollide(structure, "LEFT")
						|| enemy.didCollide(structure, "RIGHT")))
				{
					enemy.draw(graphToBack, getBackground());
					enemy.setDirection("RIGHT");
					if (enemy.getMoving().equals("NONE"))
					{
						enemy.setXSpeed(enemy.getXSpeed() + 3);
						enemy.setMoving("RIGHT");
					}
					else if (enemy.getMoving().equals("LEFT"))
					{
						enemy.setXSpeed(enemy.getXSpeed() + 6);
						enemy.setMoving("RIGHT");
					}
				}
				else
				{
					if (scrollX == true)
					{
						enemy.setXSpeed(floor.getXSpeed());
					}
					else if (scrollX == false)
					{
						enemy.setXSpeed(0);
					}

					enemy.setMoving("NONE");
				}

				if (avatar.getY() >= enemy.getY() + 240
						&& structure.getX() == enemy.getX()
								- ((enemy.getX() - floor.getX()) % 40)
						&& !structure.equals(floor))
				{
					structure.setColor(getBackground());
					structure.draw(graphToBack);
					obstacles.remove(structure);
					break;
				}
			}
		}


		// KEYBOARD FUNCTIONS
		// Movement Controls
		// Jump-"W"
		if (keys[0])
		{
			for (Block structure : obstacles)
			{
				if (avatar.didCollide(structure, "BOTTOM") == true
						&& avatar.getFalling() == false)
				{
					avatar.setYSpeed(avatar.getYSpeed() + avatar.getJumpHeight());
					avatar.setFalling(true);
					gun.setYSpeed(avatar.getYSpeed());
				}
			}
		}

		/*
		 * Fun Physics - Can change direction in mid-air
		 */

		// Move Left-"A"
		if (keys[1])
		{
			avatar.draw(graphToBack, getBackground());
			avatar.setDirection("LEFT");
			gun.draw(graphToBack, getBackground());
			gun.setDirection("LEFT");
			if (avatar.getMoving().equals("NONE"))
			{
				avatar.setXSpeed(avatar.getXSpeed() - 5);
				avatar.setMoving("LEFT");
				gun.setXSpeed(avatar.getXSpeed());
			}
			else if (avatar.getMoving().equals("RIGHT"))
			{
				avatar.setXSpeed(avatar.getXSpeed() - 10);
				avatar.setMoving("LEFT");
				gun.setXSpeed(avatar.getXSpeed());
			}
		}
		// Move Right-"D"
		else if (keys[2])
		{
			avatar.draw(graphToBack, getBackground());
			avatar.setDirection("RIGHT");
			gun.draw(graphToBack, getBackground());
			gun.setDirection("RIGHT");
			if (avatar.getMoving().equals("NONE"))
			{
				avatar.setXSpeed(avatar.getXSpeed() + 5);
				avatar.setMoving("RIGHT");
				gun.setXSpeed(avatar.getXSpeed());
			}
			else if (avatar.getMoving().equals("LEFT"))
			{
				avatar.setXSpeed(avatar.getXSpeed() + 10);
				avatar.setMoving("RIGHT");
				gun.setXSpeed(avatar.getXSpeed());
			}
		}
		else
		{
			if (scrollX == true)
			{
				avatar.setXSpeed(floor.getXSpeed());
				gun.setXSpeed(avatar.getXSpeed());
			}
			else if (scrollX == false)
			{
				avatar.setXSpeed(0);
				gun.setXSpeed(avatar.getXSpeed());
			}

			avatar.setMoving("NONE");
		}

		// MOUSE
		// Placing/Removing Blocks
		// Left Mouse Button
		if (mouse[0])
		{
			if (existingBlock == false
					&& !(avatar.getX() + avatar.getWidth() >= mouseXBox
							&& avatar.getX() <= mouseXBox + 40
							&& avatar.getY() + avatar.getHeight() > mouseYBox
							&& avatar.getY() < mouseYBox + 40)
					&& !(mouseYBox >= floor.getY())
					&& mouseOutline.getOutlineColor().equals(Color.GREEN) && scrollX == false
					&& mouseWheelNum == 1)
			{
				obstacles.add(new Block(mouseXBox, mouseYBox, 40, 40, floor.getXSpeed(), 0));
			}
			if (mouseWheelNum == 0)
			{
				if (!gun.getColor().equals(getBackground()))
				{
					if (gun.getDirection().equals("LEFT"))
					{
						bulletsFired.add(new Ammo(gun.getX() - 40 - 4, gun.getY() + 22, -20));
					}
					else if (gun.getDirection().equals("RIGHT"))
					{
						bulletsFired.add(new Ammo(gun.getX() + 50, gun.getY() + 22, 20));
					}
				}
			}

			mouse[0] = false;
		}
		// Right Mouse Button
		if (mouse[1])
		{
			for (Block structure : obstacles)
			{
				if (structure.getX() == mouseXBox && structure.getY() == mouseYBox
						&& !(mouseYBox >= floor.getY())
						&& mouseOutline.getOutlineColor().equals(Color.RED) && scrollX == false
						&& mouseWheelNum == 1)

				{
					structure.setColor(getBackground());
					structure.draw(graphToBack);
					obstacles.remove(structure);
					break;
				}
			}
			mouse[1] = false;
		}

		// RE-CENTER SCREEN & ARENA BOUNDARIES
		// One Re-Center moves the FOV by 320 pixels
		if (avatar.getX() > 750 && floor.getX() + floor.getWidth() > 985)
		{
			scrollX = true;
		}
		else if (avatar.getX() < 250 && floor.getX() < -2)
		{
			scrollX = true;
		}
		else if (avatar.getX() >= 470 && avatar.getX() <= 520)
		{
			scrollX = false;
		}
		// Boundary Limits
		else if (floor.getX() + floor.getWidth() <= 985)
		{
			scrollX = false;
			if (avatar.getX() + avatar.getWidth() >= 980
					&& avatar.getDirection().equals("RIGHT"))
			{
				avatar.draw(graphToBack, getBackground());
				avatar.setXSpeed(0);
				avatar.setX(980 - avatar.getWidth());
				avatar.draw(graphToBack);
				gun.draw(graphToBack, getBackground());
				gun.setXSpeed(avatar.getXSpeed());
				gun.setX(avatar.getX());
				gun.draw(graphToBack);
			}
		}
		else if (floor.getX() >= -2)
		{
			scrollX = false;
			if (avatar.getX() <= 10 && avatar.getDirection().equals("LEFT"))
			{
				avatar.draw(graphToBack, getBackground());
				avatar.setXSpeed(0);
				avatar.setX(5);
				avatar.draw(graphToBack);
				gun.draw(graphToBack, getBackground());
				gun.setXSpeed(avatar.getXSpeed());
				gun.setX(avatar.getX());
				gun.draw(graphToBack);
			}
		}
		else if (avatar.getY() < 0)
		{
			avatar.draw(graphToBack, getBackground());
			avatar.setYSpeed(0);
			avatar.setY(0);
			avatar.draw(graphToBack);
			gun.draw(graphToBack, getBackground());
			gun.setXSpeed(avatar.getXSpeed());
			gun.setX(avatar.getX());
			gun.draw(graphToBack);
		}


		if (scrollX)
		{
			if (avatar.getX() > 490 && Math.abs(avatar.getXSpeed()) <= 5)
			{
				avatar.setXSpeed(avatar.getXSpeed() - 1);
				gun.setXSpeed(avatar.getXSpeed());
				for (BadGuy enemy : enemies)
				{
					enemy.setXSpeed(enemy.getXSpeed() - 1);
				}
				for (Block structure : obstacles)
				{
					structure.setXSpeed(structure.getXSpeed() - 1);
				}
			}
			else if (avatar.getX() < 490 && Math.abs(avatar.getXSpeed()) <= 5)
			{
				avatar.setXSpeed(avatar.getXSpeed() + 1);
				gun.setXSpeed(avatar.getXSpeed());
				for (BadGuy enemy : enemies)
				{
					enemy.setXSpeed(enemy.getXSpeed() + 1);
				}
				for (Block structure : obstacles)
				{
					structure.setXSpeed(structure.getXSpeed() + 1);
				}
			}
		}
		else
		{
			if (avatar.getMoving().equals("LEFT"))
			{
				avatar.setXSpeed(-5);
				gun.setXSpeed(avatar.getXSpeed());
			}
			else if (avatar.getMoving().equals("RIGHT"))
			{
				avatar.setXSpeed(5);
				gun.setXSpeed(avatar.getXSpeed());
			}


			for (BadGuy enemy : enemies)
			{
				if (enemy.getMoving().equals("LEFT"))
				{
					enemy.setXSpeed(-3);
				}
				else if (enemy.getMoving().equals("RIGHT"))
				{
					enemy.setXSpeed(3);
				}
				else
				{
					enemy.setXSpeed(0);
				}
			}
			for (Block structure : obstacles)
			{
				structure.setXSpeed(0);
			}
		}

		for (Ammo bullet : bulletsFired)
		{
			if (bullet.getX() < 0 || bullet.getX() > 1000)
			{
				bullet.draw(graphToBack, getBackground());
				bulletsFired.remove(bullet);
				break;
			}
		}

		// MOVE & DRAW

		if (avatar.getHealth() <= 0)
		{
			scrollX = false;
			avatar.draw(graphToBack, getBackground());
			avatar.setXSpeed(0);
			avatar.setYSpeed(0);
			avatar.setY(-100);
			gun.draw(graphToBack, getBackground());
			gun.setXSpeed(0);
			gun.setYSpeed(0);
			gun.setY(-100);
			for (Block structure : obstacles)
			{
				structure.draw(graphToBack, getBackground());
			}
			obstacles.clear();
			for (Ammo bullet : bulletsFired)
			{
				bullet.draw(graphToBack, getBackground());
			}
			bulletsFired.clear();
			for (BadGuy enemy : enemies)
			{
				enemy.draw(graphToBack, getBackground());
			}
			enemies.clear();
			spawnLimit = 1000000000;
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("YOU LOST WITH A FINAL SCORE OF " + score, 450, 400);
			graphToBack.drawString("PRESS R TO RESET", 450, 420);
			graphToBack.setColor(getBackground());
			graphToBack.drawString("SCORE: " + score, 250, 715);

		}
		else
		{
			graphToBack.setColor(getBackground());
			graphToBack.drawString("YOU LOST WITH A FINAL SCORE OF " + score, 450, 400);
			graphToBack.drawString("PRESS R TO RESET", 450, 420);
		}

		if (mouseWheelNum == 1)
		{
			gun.setColor(getBackground());
		}

		gun.moveAndDraw(graphToBack, gun.getXSpeed(), gun.getYSpeed(), getBackground());
		avatar.moveAndDraw(graphToBack, avatar.getXSpeed(), avatar.getYSpeed(),
				getBackground());

		for (BadGuy enemy : enemies)
		{
			if (enemy.getX() >= -50 && enemy.getX() <= 1050)
			{
				enemy.moveAndDraw(graphToBack, enemy.getXSpeed(), enemy.getYSpeed(),
						getBackground());
			}
			else
			{
				enemy.draw(graphToBack, getBackground());
				enemy.move(enemy.getXSpeed(), enemy.getYSpeed());
			}
		}

		for (Block bullet : bulletsFired)
		{
			bullet.moveAndDraw(graphToBack, bullet.getXSpeed(), bullet.getYSpeed(),
					getBackground());
		}

		// Mouse Outline Drawn
		existingBlock = false;
		for (Block structure : obstacles)
		{
			if (structure.getX() == mouseXBox && structure.getY() == mouseYBox)
			{
				existingBlock = true;
			}
		}

		if (mouseWheelNum == 1)
		{
			if (existingBlock == true || (avatar.getX() + avatar.getWidth() >= mouseXBox
					&& avatar.getX() <= mouseXBox + 40
					&& avatar.getY() + avatar.getHeight() > mouseYBox
					&& avatar.getY() < mouseYBox + 40))
			{
				mouseOutline.setOutlineColor(Color.RED);
			}
			else if (mouseYBox >= floor.getY())
			{
				mouseOutline.setOutlineColor(getBackground());
			}
			else
			{
				mouseOutline.setOutlineColor(Color.GREEN);
			}

			if (scrollX == false)
			{
				mouseOutline.moveAndDraw(graphToBack, mouseXBox, mouseYBox, getBackground());
			}
			else
			{
				mouseOutline.draw(graphToBack, getBackground());
			}
			graphToBack.setColor(getBackground());
			graphToBack.drawString("WEAPON ENABLED", 500, 715);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("BUILDING TOOL ENABLED", 500, 715);
		}
		else
		{
			mouseOutline.setOutlineColor(getBackground());
			mouseOutline.draw(graphToBack);
			graphToBack.setColor(getBackground());
			graphToBack.drawString("BUILDING TOOL ENABLED", 500, 715);
			graphToBack.setColor(Color.BLACK);
			graphToBack.drawString("WEAPON ENABLED", 500, 715);
		}

		for (Block structure : obstacles)
		{
			if (structure.equals(floor)
					|| (structure.getX() >= -50 && structure.getX() <= 1050))
			{
				structure.moveAndDraw(graphToBack, structure.getXSpeed(),
						structure.getYSpeed(), getBackground());
			}
			else
			{
				structure.draw(graphToBack, getBackground());
				structure.move(structure.getXSpeed(), structure.getYSpeed());
			}
		}


		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void run()
	{
		try
		{
			while (true)
			{
				Thread.currentThread().sleep(15);
				repaint();
			}
		} catch (Exception e)
		{
			System.out.println(e);
		}

	}

	public void keyPressed(KeyEvent e)
	{
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			keys[0] = true;
			break;
		case KeyEvent.VK_A:
			keys[1] = true;
			break;
		case KeyEvent.VK_D:
			keys[2] = true;
			break;
		case KeyEvent.VK_R:
			keys[3] = true;
			if (avatar.getHealth() <= 0)
			{
				avatar.setHealth(10);
				avatar.setPos(490, 600);
				gun.setPos(490, 590);
				floor.setPos(-2280, 680);
				obstacles.add(floor);

				for (int y = 200; y < 680; y += 240)
				{
					for (int x = floor.getX(); x < floor.getX() + floor.getWidth(); x += 40)
					{
						obstacles.add(new Block(x, y, 40, 40, 0, 0));
					}
				}

				score = 0;
				scrollX = false;

			}
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			keys[0] = false;
			break;
		case KeyEvent.VK_A:
			keys[1] = false;
			break;
		case KeyEvent.VK_D:
			keys[2] = false;
			break;
		case KeyEvent.VK_R:
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent arg0)
	{

	}

	public void mouseClicked(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{
		mouseOutline.setOutlineColor(Color.GREEN);
	}

	public void mouseExited(MouseEvent arg0)
	{
		mouseOutline.setOutlineColor(getBackground());
	}

	public void mousePressed(MouseEvent e)
	{
		switch (e.getButton()) {
		case 1:
			mouse[0] = true;
			break;
		case 3:
			mouse[1] = true;
			break;
		}
	}

	public void mouseReleased(MouseEvent e)
	{

	}

	public void mouseDragged(MouseEvent e)
	{

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
		mouseXBox = e.getX() - ((e.getX() - floor.getX()) % 40);
		mouseYBox = e.getY() - (e.getY() % 40);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		mouseWheelNum = (mouseWheelNum + Math.abs(e.getWheelRotation())) % 2;
	}


}
