package starfighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Aliens {
	private Alien[][] aliens;

	public Aliens(int row, int col) {
		int startX = 400 - (col * 80) / 2;
		aliens = new Alien[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				aliens[r][c] = (new Alien(startX + c * 80, r * 80, 1));
			}
		}
	}
	
	public void moveDown(int amount){
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				Alien alien = aliens[r][c];
				if (alien != null) {
					alien.setY(alien.getY() + amount);
				}
			}
		}
	}

	public boolean edgeDetect() {
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				Alien alien = aliens[r][c];
				if (alien != null) {
					if (alien.getX() <= 0 || alien.getX() + 80 >= 800) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public int count() {
		int count = 0;
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				Alien alien = aliens[r][c];
				if (alien != null) {
					count++;
				}
			}
		}
		return count;
	}

	public boolean didCollide(Locatable bullet, int width, int height) {
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				Alien alien = aliens[r][c];
				if (alien != null) {
					if (alien.getX() < bullet.getX() + width && alien.getX() + 80 > bullet.getX()
							&& alien.getY() < bullet.getY() + height && alien.getY() + 80 > bullet.getY()) {
						aliens[r][c] = null;
						return true;
					}
				}
			}
		}
		return false;
	}

	public void moveAndDraw(String direction, Graphics graphToBack) {
		for (int r = 0; r < aliens.length; r++) {
			for (int c = 0; c < aliens[r].length; c++) {
				Alien alien = aliens[r][c];
				if (alien != null) {
					alien.move(direction);
					alien.draw(graphToBack);
				}
			}
		}
	}

}
