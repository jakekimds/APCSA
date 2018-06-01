package javaProjectFortneetDylanChan;


import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;


public class Player extends Humanoid
{
	private List<Heart> health;
	private int jumpHeight;
	private boolean falling;
	private String moving;
	
	public Player()
	{
		this(490, 590, 20, 80, 0, 0, "RIGHT", new Color(255, 255, 180), Color.BLUE,
				new Color(153, 51, 0), 10, 15, false, "NONE");
	}
	
	public Player(int xPos, int yPos, int width, int height, int xSpeed, int ySpeed,
			String direction, Color headCol, Color torsoCol, Color legsCol, int h,
			int jHeight, boolean f, String m)
	{
		super(xPos, yPos, width, height, xSpeed, ySpeed, direction, headCol, torsoCol,
				legsCol);
		
		health = new ArrayList<Heart>();
		setHealth(h);
		setJumpHeight(jHeight);
		setFalling(f);
		setMoving(m);
	}
	
	public void setDirection(String d)
	{
		super.setDirection(d);
	}
	
	public void setHealth(int h)
	{
		health.clear();
		for (int num = 0; num < h; num++)
		{
			health.add(new Heart(5 + (num * 20), 720));
		}
	}
	
	public void setJumpHeight(int l)
	{
		jumpHeight = l;
	}
	
	public void setFalling(boolean f)
	{
		falling = f;
	}
	
	public void setMoving(String m)
	{
		moving = m;
	}
	
	public int getHealth()
	{
		return health.size();
	}
	
	public int getJumpHeight()
	{
		return jumpHeight;
	}
	
	public boolean getFalling()
	{
		return falling;
	}
	
	public String getMoving()
	{
		return moving;
	}
	
	public void draw(Graphics window)
	{
		super.draw(window);
		for (Heart heart: health)
		{
			heart.draw(window);
		}
	}
	
	public void replaceHearts(Graphics window, int h, Color background)
	{
		for (Heart heart: health)
		{
			heart.draw(window, background);
		}
		setHealth(h);
		for (Heart heart: health)
		{
			heart.draw(window);
		}
	}
	
	public void moveAndDraw(Graphics window, int xSpeed, int ySpeed, Color background)
	{
		super.moveAndDraw(window, xSpeed, ySpeed, background);
		for (Heart heart: health)
		{
			heart.draw(window);
		}
	}
	
	public void moveAndDraw(Graphics window, String dir, Color background)
	{
		super.moveAndDraw(window, dir, background);
		for (Heart heart: health)
		{
			heart.draw(window);
		}
	}
}
