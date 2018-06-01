package javaProjectFortneetDylanChan;


import java.awt.Graphics;
import java.awt.Color;


public class Heart implements Locatable
{
	private int xPos, yPos;
	private Block[] heart;
	
	public Heart()
	{
		this(402, 403);
	}
	public Heart(int x, int y)
	{
		heart = new Block[4];
		heart[0] = new Block(x, y, 6, 5, Color.RED);
		heart[1] = new Block(x + 10, y, 6, 5, Color.RED);
		heart[2] = new Block(x + 2, y + 5, 12, 8, Color.RED);
		heart[3] = new Block(x + 6, y + 13, 4, 4, Color.RED);
		setPos(x, y);
	}
	
	public void setPos(int x, int y)
	{
		setX(x);
		setY(y);
	}
	
	public void setX(int x)
	{
		xPos = x;
	}
	
	public void setY(int y)
	{
		yPos = y;
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public void draw(Graphics window)
	{
		for (Block part: heart)
		{
			part.draw(window);
		}
	}
	
	public void draw(Graphics window, Color background)
	{
		for (Block part: heart)
		{
			part.draw(window, background);
		}
	}
}
