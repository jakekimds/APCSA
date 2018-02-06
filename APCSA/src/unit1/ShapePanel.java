package unit1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ShapePanel extends JPanel {
	public ShapePanel() {
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	/*
	 * All of your test code should be placed in paint.
	 */
	public void paint(Graphics window) {
		window.setColor(Color.WHITE);
		window.fillRect(0, 0, getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
		window.setFont(new Font("TAHOMA", Font.BOLD, 18));
		window.drawString("CREATE YOUR OWN SHAPE!", 40, 40);

		// instantiate a Shape
		// tell your shape to draw
		Shape shape = new Shape(100, 100, 300, 300, Color.GREEN);
		shape.draw(window);

		// instantiate a Shape
		// tell your shape to draw

		// instantiate a Shape
		// tell your shape to draw
	}
}