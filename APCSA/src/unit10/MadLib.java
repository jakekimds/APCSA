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

public class MadLib {
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	private ArrayList<String> story;

	public MadLib() {
		//load stuff
		story = new ArrayList<String>();
		String fileName = "src/unit10/story.dat";
		try {
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNext()) {
				story.add(file.next());
			}
			file.close();
		} catch (Exception e) {
			out.println("Houston we have a problem!");
		}
	}

	public MadLib(String fileName) {
		story = new ArrayList<String>();
		//load stuff
		try {
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNext()) {
				story.add(file.next());
			}
			file.close();
		} catch (Exception e) {
			out.println("Houston we have a problem!");
		}

	}

	public void loadNouns() {
		nouns = new ArrayList<String>();
		try {
			Scanner file = new Scanner(new File("src/unit10/nouns.dat"));
			while (file.hasNext()) {
				nouns.add(file.next());
			}
			file.close();
		} catch (Exception e) {
			out.println("Houston we have a problem!");
		}

	}

	public void loadVerbs() {
		verbs = new ArrayList<String>();
		try {
			Scanner file = new Scanner(new File("src/unit10/verbs.dat"));
			while (file.hasNext()) {
				verbs.add(file.next());
			}
			file.close();
		} catch (Exception e) {
			out.println("Houston we have a problem!");
		}
	}

	public void loadAdjectives() {
		adjectives = new ArrayList<String>();
		try {
			Scanner file = new Scanner(new File("src/unit10/adjectives.dat"));
			while (file.hasNext()) {
				adjectives.add(file.next());
			}
			file.close();
		} catch (Exception e) {
			out.println("Houston we have a problem!");
		}
	}

	public String getRandomVerb() {
		int randNum = (int) (Math.random() * verbs.size());
		return verbs.get(randNum);
	}

	public String getRandomNoun() {
		int randNum = (int) (Math.random() * nouns.size());
		return nouns.get(randNum);
	}

	public String getRandomAdjective() {
		int randNum = (int) (Math.random() * adjectives.size());
		return adjectives.get(randNum);
	}

	public String toString() {
		String madlib = "";
		String word;
		for (int i = 0; i < story.size(); i++) {
			word = story.get(i);
			if (word.equals("#")) {
				madlib += getRandomNoun();
			} else if (word.equals("@")) {
				madlib += getRandomVerb();
			} else if (word.equals("&")) {
				madlib += getRandomAdjective();
			} else {
				madlib += word;
			}
			madlib += " ";
		}
		return madlib;
	}
}