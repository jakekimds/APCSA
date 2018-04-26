package BreakOut;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class TheGame extends JFrame {
	private static final int WIDTH = 2000;
	private static final int HEIGHT = 1000;

	public TheGame() {
		super("PONG");
		setSize(WIDTH, HEIGHT);

		BreakOut game = new BreakOut();

		((Component) game).setFocusable(true);
		getContentPane().add(game);

		setVisible(true);
	}

	public static void main(String args[]) {
		TheGame run = new TheGame();
	}
}