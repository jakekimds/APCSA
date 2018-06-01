package project;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Background {
	private Image image;
int xPos;
int yPos;
	public Background()
	{
		this(0,0,0);
	}

	public Background(int x, int y)
	{
		this(x,y,0);
	}

	public Background(int x, int y, int s)
	{
		xPos=x;
		yPos=y;
		try
		{
			image = ImageIO.read(new File("src\\project\\ground.png"));
		}
		catch(Exception e)
		{
System.out.println("Cannot open ship");
		}
	}
	public void draw( Graphics window )
	{
   	window.drawImage(image,xPos,yPos,800,200,null);
	}
}
