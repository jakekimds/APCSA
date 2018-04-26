package BreakOut;

import java.awt.Color;
import java.awt.Graphics;

public class InvisibleBall extends Ball {
	int framesToChange = 0;
	boolean isInvisible = false;
	int maxVisibleDuration = 500; // Time in frames
	int maxInvisibleDuration = 100;

	public InvisibleBall() {
		super();
	}

	public InvisibleBall(int x, int y) {
		super(x, y);
	}

	public InvisibleBall(int x, int y, int wid, int ht) {
		super(x, y, wid, ht);
	}

	public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd) {
		super(x, y, wid, ht, Color.black, xSpd, ySpd);
	}

	public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd) {
		super(x, y, wid, ht, col, xSpd, ySpd);
	}

	private void updateInvisibility() {
		if (framesToChange <= 0) {
			isInvisible = !isInvisible;
			if (isInvisible) {
				framesToChange = (int) (Math.random() * maxInvisibleDuration);
			} else {
				framesToChange = (int) (Math.random() * maxVisibleDuration);
			}
		} else {
			framesToChange--;
		}
	}

	public void draw(Graphics window) {
		updateInvisibility();
		if (!isInvisible) {
			super.draw(window);
		}
	}
}
