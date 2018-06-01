package javaProjectFortneetDylanChan;

import java.awt.Color;

public class Ammo extends Block
{
	public Ammo()
	{
		super(500, 400, 4, 4, 0, 0, Color.YELLOW);
	}
	public Ammo(int x, int y)
	{
		super(x, y, 4, 4, 0, 0, Color.YELLOW);
	}
	public Ammo(int x, int y, int xS)
	{
		super(x, y, 4, 4, xS, 0, Color.YELLOW);
	}
}
