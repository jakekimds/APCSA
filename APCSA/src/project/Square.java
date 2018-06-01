package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Square extends MovingThing{
	private int speed;
	/*private Image image;
	private Image image2;*/
	public Square()
	{
		this(0,0,0);
	}

	public Square(int x, int y)
	{
		this(x,y,0);	
	}

	public Square(int x, int y, int s)
	{
		super(x,y);
		setSpeed(s);
	/*	try
		{
			image = ImageIO.read(new File("src\\project\\goodSquare.png"));
			image2 = ImageIO.read(new File("src\\project\\badSquare.png"));

		}
		catch(Exception e)
		{
			System.out.println("Cannot open ship");
		}*/
	}

	public void setSpeed(int s)
	{
		speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}
	public void draw(Graphics window){};

}
