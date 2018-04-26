package unit10;


//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab16d {
	public static void main(String args[]) {
		//make a new MadLib
		MadLib madlib = new MadLib();
		madlib.loadAdjectives();
		madlib.loadVerbs();
		madlib.loadNouns();
		System.out.println(madlib);
		out.println("\n");
	}
}