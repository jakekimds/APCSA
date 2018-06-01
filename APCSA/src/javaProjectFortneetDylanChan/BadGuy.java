package javaProjectFortneetDylanChan;


import java.awt.Color;


public class BadGuy extends Humanoid
{
	private boolean falling;
	private String moving;
	
	public BadGuy(int x, int y)
	{
		this(x, y, 0, 0, "RIGHT", new Color(255, 255, 180), Color.RED,
				new Color(153, 51, 0), false, "NONE");
	}
	
	public BadGuy(int x, int y, int xS, int yS, String d, Color headCol, Color torsoCol,
			Color legsCol, boolean f, String m)
	{
		super(x, y, 20, 80, xS, yS, d, headCol, torsoCol, legsCol);
		setFalling(f);
		setMoving(m);
	}
	
	public void setFalling(boolean f)
	{
		falling = f;
	}
	
	public void setMoving(String m)
	{
		moving = m;
	}
	
	public boolean getFalling()
	{
		return falling;
	}
	
	public String getMoving()
	{
		return moving;
	}
}
