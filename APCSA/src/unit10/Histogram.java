package unit10;


//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram {
	private ArrayList<Integer> count = new ArrayList<Integer>();
	private ArrayList<Character> letters = new ArrayList<Character>();
	private String fileName;

	public Histogram() {

	}

	public Histogram(char[] values, String fName) {
		for (int i = 0; i < values.length; i++) {
			letters.add(values[i]);
			count.add(0);
		}
		fileName = fName;
		out.println("search letters = " + letters);
	}

	public void loadAndAnalyzeFile() throws IOException {
		try {
			Scanner file = new Scanner(new File(fileName));
			String text;
			while (file.hasNextLine()) {
				text = file.nextLine();
				for (int i = 0; i < text.length(); i++) {
					int index = letters.indexOf(text.charAt(i));
					if (index != -1) {
						count.set(index, count.get(index) + 1);
					}
				}
			}

		} catch (Exception e) {
			out.println(e);
		}
	}

	public char mostFrequent() {
		int max = 0;
		char maxChar = '#';
		for (int i = 0; i < count.size(); i++) {
			if (count.get(i) > max) {
				max = count.get(i);
				maxChar = letters.get(i);
			}
		}
		return maxChar;
	}

	public char leastFrequent() {
		int min = count.get(0);
		char minChar = '#';
		for (int i = 0; i < count.size(); i++) {
			if (count.get(i) < min) {
				min = count.get(i);
				minChar = letters.get(i);
			}
		}
		return minChar;
	}

	public String toString() {
		return fileName + "\n" + letters + "\n" + count + "\n\n\n";
	}
}