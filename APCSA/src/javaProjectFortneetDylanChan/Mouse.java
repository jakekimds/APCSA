package javaProjectFortneetDylanChan;


import java.awt.*;


public class Mouse implements Locatable
{
	private int xPos, yPos;
	private Color outlineColor;
	
	public Mouse()
	{
		this(0, 0, Color.GREEN);
	}
	
	public Mouse(int x, int y, Color c)
	{
		setPos(x, y);
		setOutlineColor(c);
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
	
	public void setOutlineColor(Color c)
	{
		outlineColor = c;
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public Color getOutlineColor()
	{
		return outlineColor;
	}
	
	public void draw(Graphics window)
	{
		window.setColor(getOutlineColor());
		window.drawRect(getX(), getY(), 40, 40);
	}
	
	public void draw(Graphics window, Color c)
	{
		window.setColor(c);
		window.drawRect(getX(), getY(), 40, 40);
	}
	
	public void moveAndDraw(Graphics window, int x, int y, Color background)
	{
		draw(window, background);
		setPos(x, y);
		draw(window);
	}
	
}
