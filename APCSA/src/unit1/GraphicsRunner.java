package unit1;

import java.awt.AWTError;
import java.awt.Color;
import javax.swing.JFrame;

public class GraphicsRunner extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 800;

	public GraphicsRunner() {
		super("MAKE YOUR OWN SHAPE");

		setSize(WIDTH, HEIGHT);

		getContentPane().add(new ShapePanel());

		setVisible(true);
	}

	public static void main(String args[]) {
		GraphicsRunner run = new GraphicsRunner();
	}
}