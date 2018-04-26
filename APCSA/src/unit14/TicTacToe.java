package unit14;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe {
	private char[][] mat;
	private String mode = "";

	public TicTacToe() {
	}

	public TicTacToe(String game) {
		int ind = 0;
		mat = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				mat[i][j] = game.charAt(ind++);
			}
		}
	}

	public boolean isWinner(char player) {
		for (int i = 0; i < 3; i++) {
			if (mat[i][0] == player && mat[i][1] == player && mat[i][2] == player) {
				mode = "horizontally!";
				return true;
			}
			if (mat[0][i] == player && mat[1][i] == player && mat[2][i] == player) {
				mode = "vertically!";
				return true;
			}

		}
		if (mat[0][0] == player && mat[1][1] == player && mat[2][2] == player) {
			mode = "diagonally!";
			return true;
		}
		if (mat[0][2] == player && mat[1][1] == player && mat[0][2] == player) {
			mode = "diagonally!";
			return true;
		}
		return false;
	}

	public String getWinner() {
		if (isWinner('O')) {
			return "O wins";
		}
		if (isWinner('X')) {
			return "X wins";
		}
		return "cat's game - no winner!";
	}

	public String toString() {
		String output = "";
		output += getWinner();
		output += " " + mode;
		return output + "";
	}
}