package unit14;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i {
	public static void main(String args[]) throws IOException {
		Scanner file = new Scanner(new File("src/unit14/lab21i.dat"));
		while (file.hasNextLine()) {
			int size = Integer.parseInt(file.nextLine());
			String line = file.nextLine();
			Maze maze = new Maze(size, line);
			maze.hasExitPath(0, 0);
			System.out.println(maze);
		}
	}
}