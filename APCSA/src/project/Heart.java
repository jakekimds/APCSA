package project;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Heart extends MovingThing{
	private int speed;
	private Image image;

	public Heart()
	{
		this(0,0,0);
	}

	public Heart(int x, int y)
	{
		this(x,y,0);	
	}

	public Heart(int x, int y, int s)
	{
		super(x,y);
		setSpeed(s);

		try
		{
			image = ImageIO.read(new File("src\\project\\heart.jpg"));

		}
		catch(Exception e)
		{
			System.out.println("Cannot open heart");
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
		move("DOWN");	
}
}

