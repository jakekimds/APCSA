package unit14;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class AtCounter {
	private char[][] atMat;
	private boolean[][] beenMat;
	private int atCount;

	public AtCounter() {
		atCount = 0;
		atMat = new char[][] { { '@', '-', '@', '-', '-', '@', '-', '@', '@', '@' },
				{ '@', '@', '@', '-', '@', '@', '-', '@', '-', '@' },
				{ '-', '-', '-', '-', '-', '-', '-', '@', '@', '@' },
				{ '-', '@', '@', '@', '@', '@', '-', '@', '-', '@' },
				{ '-', '@', '-', '@', '-', '@', '-', '@', '-', '@' },
				{ '@', '@', '@', '@', '@', '@', '-', '@', '@', '@' },
				{ '-', '@', '-', '@', '-', '@', '-', '-', '-', '@' },
				{ '-', '@', '@', '@', '-', '@', '-', '-', '-', '-' },
				{ '-', '@', '-', '@', '-', '@', '-', '@', '@', '@' },
				{ '-', '@', '@', '@', '@', '@', '-', '@', '@', '@' } };
		beenMat = new boolean[atMat.length][atMat[0].length];
	}

	public int countAts(int r, int c) {

		if (r >= 0 && c >= 0 && r < atMat.length && c < atMat[r].length) {
			if (beenMat[r][c]) {
				return 0;
			} else {
				beenMat[r][c] = true;
				if (atMat[r][c] == '@') {
					atCount++;
					countAts(r + 1, c);
					countAts(r - 1, c);
					countAts(r, c + 1);
					countAts(r, c - 1);
				}
			}
		}

		return atCount;
	}

	public int getAtCount() {
		return atCount;
	}

	public String toString() {
		String output = "";
		output += getAtCount() + " @s connected.";
		return output;
	}
}