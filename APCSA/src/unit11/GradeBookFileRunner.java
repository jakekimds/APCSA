package unit11;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;
import java.io.FileNotFoundException;

public class GradeBookFileRunner {

	private static Scanner keyboard;

	private static int studentCount;

	public static void main(String args[]) throws FileNotFoundException {
		out.println("Welcome to the Class Stats program!\n");
		keyboard = new Scanner(new File("src/unit11/gradebook.dat"));
		Class gradebook = makeNewClass();
		addStudents(gradebook);
		System.out.println(gradebook);
		out.println("\nFailure List = " + gradebook.getFailureList(70));
		out.println("Highest Average = " + gradebook.getStudentWithHighestAverage());
		out.println("Lowest Average = " + gradebook.getStudentWithLowestAverage());

		out.println(String.format("Class Average = %.2f", gradebook.getClassAverage()));
		keyboard.close();

	}

	public static Class makeNewClass() {
		String className = keyboard.nextLine();
		int numOfStudents = Integer.parseInt(keyboard.nextLine());
		studentCount = numOfStudents;
		Class classGrades = new Class(className, numOfStudents);
		return classGrades;
	}

	public static void addStudent(Class gradeBook, int studentNum) {
		String studentName = keyboard.nextLine();
		String grades = keyboard.nextLine();
		Student student = new Student(studentName, grades);
		gradeBook.addStudent(studentNum, student);
	}

	public static void addStudents(Class gradeBook) {
		for (int i = 0; i < studentCount; i++) {
			addStudent(gradeBook, i);
		}
	}
}