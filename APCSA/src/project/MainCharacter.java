package project;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class MainCharacter extends MovingThing
{
	private int speed;
	private Image image;

	public MainCharacter()
	{
		this(0,0,0);
	}

	public MainCharacter(int x, int y)
	{
		this(x,y,0);
	}

	public MainCharacter(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			//image = ImageIO.read(new File("src\\project\\Square-Main.jpg"));
			image = ImageIO.read(new File("src\\project\\hero.png"));
		}
		catch(Exception e)
		{
System.out.println("Cannot open ship");
		}
	}


	public void setSpeed(int s)
	{
		speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),80,80,null);
	}

	public String toString()
	{
		return super.toString() + ","+getSpeed();
	}
}
