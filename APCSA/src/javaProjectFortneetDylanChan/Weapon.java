package javaProjectFortneetDylanChan;


import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;


public class Weapon implements Locatable, Collidable
{
	private List<Block> gun;
	private int xPos, yPos, width, height;
	private Color color;
	private String direction;
	
	public Weapon()
	{
		this(490, 590, "RIGHT", Color.BLACK);
	}
	
	public Weapon(int x, int y, String d, Color c)
	{
		Block rightHand = new Block(x + 16, y + 26, 7, 7, new Color(255, 255, 180));
		Block leftHand = new Block(x + 25, y + 26, 5, 7, new Color(255, 255, 180));
		Block stock = new Block(x + 10, y + 20, 6, 10);
		Block topRail = new Block(x + 20, y + 18, 10, 2);
		Block reciever = new Block(x + 23, y + 26, 5, 10);
		Block foregrip = new Block(x + 16, y + 20, 34, 6);
		Block barrel = new Block(x + 50, y + 22, 10, 2);
		
		gun = new ArrayList<Block>();
		gun.add(rightHand);
		gun.add(stock);
		gun.add(topRail);
		gun.add(reciever);
		gun.add(leftHand);
		gun.add(foregrip);
		gun.add(barrel);
		
		setWidth(60);
		setHeight(8);
		direction = d;
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
		setPerspective();
	}
	
	public void setY(int y)
	{
		yPos = y;
		setPerspective();
	}
	
	public void setWidth(int w)
	{
		width = w;
	}
	
	public void setHeight(int h)
	{
		height = h;
	}
	
	public void setXSpeed(int xS)
	{
		for (Block part: gun)
		{
			part.setXSpeed(xS);
		}
	}
	
	public void setYSpeed(int yS)
	{
		for (Block part: gun)
		{
			part.setYSpeed(yS);
		}
	}
	
	public void setDirection(String d)
	{
		direction = d;
		setPerspective();
	}
	
	public void setColor(Color c)
	{
		color = c;
		for (Block part: gun)
		{
			if (!part.getColor().equals(new Color(255, 255, 180)))
			{
				part.setColor(c);
			}
		}
	}
	
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getXSpeed()
	{
		return gun.get(0).getXSpeed();
	}
	
	public int getYSpeed()
	{
		return gun.get(0).getYSpeed();
	}
	
	public String getDirection()
	{
		return direction;
	}
	
	public Color getColor()
	{
		return color;
	}
	
	public void draw(Graphics window)
	{
		for (Block part: gun)
		{
			part.draw(window);
		}
	}
	
	public void draw(Graphics window, Color background)
	{
		for (Block part: gun)
		{
			part.draw(window, background);
		}
	}
	
	public void move(int xS, int yS)
	{
		setX(this.getX() + xS);
		setY(this.getY() - yS);
	}
	
	public void moveAndDraw(Graphics window, int xS, int yS, Color background)
	{
		draw(window, background);
		move(xS, yS);
		draw(window);
	}
	
	public void moveAndDraw(Graphics window, String dir, Color background)
	{
		if (dir.equals("LEFT"))
		{
			draw(window, background);
			setPerspective(dir);
			setX(getX() - gun.get(0).getXSpeed());
			draw(window);
		}
		else if (dir.equals("RIGHT"))
		{
			draw(window, background);
			setPerspective(dir);
			setX(getX() + gun.get(0).getXSpeed());
			draw(window);
		}
		else if (dir.equals("UP"))
		{
			draw(window, background);
			setY(getY() - gun.get(0).getYSpeed());
			draw(window);
		}
		else
		{
			System.out.println("Movement Direction DNE");
		}
	}
	
	public void setPerspective(String dir)
	{
		setDirection(dir);
		setPerspective();
	}
	
	public void setPerspective()
	{
		if (getDirection().equals("LEFT"))
		{
			gun.get(0).setX(this.getX() - 3);
			gun.get(1).setX(this.getX() + 4);
			gun.get(2).setX(this.getX() - 10);
			gun.get(3).setX(this.getX() - 8);
			gun.get(4).setX(this.getX() - 10);
			gun.get(5).setX(this.getX() - 30);
			gun.get(6).setX(this.getX() - 40);
			
			gun.get(0).setY(this.getY() + 26);
			gun.get(1).setY(this.getY() + 20);
			gun.get(2).setY(this.getY() + 18);
			gun.get(3).setY(this.getY() + 26);
			gun.get(4).setY(this.getY() + 26);
			gun.get(5).setY(this.getY() + 20);
			gun.get(6).setY(this.getY() + 22);
			
		}
		else if (getDirection().equals("RIGHT"))
		{
			gun.get(0).setX(this.getX() + 16);
			gun.get(1).setX(this.getX() + 10);
			gun.get(2).setX(this.getX() + 20);
			gun.get(3).setX(this.getX() + 23);
			gun.get(4).setX(this.getX() + 25);
			gun.get(5).setX(this.getX() + 16);
			gun.get(6).setX(this.getX() + 50);
			
			gun.get(0).setY(this.getY() + 26);
			gun.get(1).setY(this.getY() + 20);
			gun.get(2).setY(this.getY() + 18);
			gun.get(3).setY(this.getY() + 26);
			gun.get(4).setY(this.getY() + 26);
			gun.get(5).setY(this.getY() + 20);
			gun.get(6).setY(this.getY() + 22);
			
		}
	}
	
	public boolean didCollide(Object obj, String side)
	{
		Block temp = (Block) obj;
		
		if (side.equals("LEFT") && this.getX() - this.getWidth() + 10 < temp.getX() + temp.getWidth()
				&& this.getX() - this.getWidth() + 10 >= temp.getX()
				&& this.getY() + 31 > temp.getY()
				&& this.getY() + 18 < temp.getY() + temp.getHeight())
		{
			return true;
		}
		else if (side.equals("RIGHT") && this.getX() + this.getWidth() > temp.getX()
				&& this.getX() + this.getWidth() <= temp.getX() + temp.getWidth()
				&& this.getY() + 31 > temp.getY()
				&& this.getY() + 18 < temp.getY() + temp.getHeight())
		{
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
}
