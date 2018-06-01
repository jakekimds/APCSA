package javaProjectFortneetDylanChan;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.JOptionPane.*;


public class OpenWorldRunner extends JFrame
{
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;

	public OpenWorldRunner()
	{
		super("Tareetria");
		setSize(WIDTH, HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		Fortneet game = new Fortneet();

		((Component) game).setFocusable(true);
		getContentPane().add(game);


		setVisible(true);
	}

	public static void main(String[] args)
	{
		JOptionPane.showConfirmDialog(null,
				"Use WASD to move. \"Tool Selected\" is shown at the bottom middle of the screen."
				+ "\nUse the SCROLL WHEEL to SWITCH between the rifle and the building tool."
				+ "\nWhen the rifle is selected click LMB TO FIRE. When the building tool is selected "
				+ "\nclick LMB on where you want to PLACE A BLOCK and click RMB on an existing "
				+ "\nblock to REMOVE it. Zombies will attack you. Falling damge is a thing.\n "
				+ "Try to survive for as long as possible by using a combination of building\n"
				+ " and shooting. Good luck!",
				"Instructions", JOptionPane.OK_OPTION);
		OpenWorldRunner run = new OpenWorldRunner();
	}
}
