package unit14;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze {
	private char[][] maze;
	private boolean[][] beenMat;
	private boolean exitFound;

	public Maze() {
		exitFound = false;
	}

	public Maze(int size, String line) {
		maze = new char[size][size];
		beenMat = new boolean[size][size];
		String[] lineArr = line.split(" ");
		int ind = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				maze[i][j] = (lineArr[ind].charAt(0));
				ind++;
			}
		}
		exitFound = false;
	}

	public boolean hasExitPath(int r, int c) {
		if (r >= 0 && c >= 0 && r < maze.length && c < maze[r].length) {
			if (beenMat[r][c]) {
				return false;
			} else {
				beenMat[r][c] = true;
				if (maze[r][c] == '1') {
					if (c == maze[r].length - 1) {
						exitFound = true;
					} else {
						hasExitPath(r + 1, c);
						hasExitPath(r - 1, c);
						hasExitPath(r, c + 1);
						hasExitPath(r, c - 1);
					}
				}
			}
		}

		return false;
	}

	public String toString() {
		if (exitFound) {
			return "exit found";
		}
		return "exit not found";
	}
}