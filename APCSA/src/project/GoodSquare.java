package project;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class GoodSquare extends Square {
	private Image image;
	public GoodSquare(int x, int y, int s)
	{
		super(x,y,s);
		setSpeed(s);
		try
		{
			image = ImageIO.read(new File("src\\project\\goodSquare.png"));
		}
		catch(Exception e)
		{
			System.out.println("Cannot open ship");
		}
	}
	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),80,80,null);
		move("DOWN");	

	}
}
