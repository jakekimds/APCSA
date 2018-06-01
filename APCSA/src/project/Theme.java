package project;


import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Theme {
	private Image image1;
	private Image image2;
	private Image image3;
	private Image image4;
int xPos;
int yPos;
	public Theme()
	{
		this(0,0);
	}


	public Theme(int x, int y)
	{
		xPos=x;
		yPos=y;
		try
		{
			image1 = ImageIO.read(new File("src\\project\\forest.png"));
			image2 = ImageIO.read(new File("src\\project\\city.jpg"));
			image3 = ImageIO.read(new File("src\\project\\eve.png"));
			image4 = ImageIO.read(new File("src\\project\\heal.png"));

		}
		catch(Exception e)
		{
			System.out.println("Cannot open background");
		}
	}
	public void draw( Graphics window, int num )
	{
	if(num==1)
		window.drawImage(image1,xPos,yPos,800,600,null);
	if(num==2)
		window.drawImage(image2,xPos,yPos,800,600,null);
	if(num==3)
		window.drawImage(image3,xPos,yPos,800,600,null);
	if(num==4)
		window.drawImage(image4,xPos,yPos,800,600,null);
	}
}

