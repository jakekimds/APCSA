package project;

import javax.swing.JFrame;
import java.awt.Component;

public class Project extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Project()
	{
		super("FALLING SQUARES");
		setSize(WIDTH,HEIGHT);

		ProjectContent theGame = new ProjectContent();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		Project run = new Project();
	}
}