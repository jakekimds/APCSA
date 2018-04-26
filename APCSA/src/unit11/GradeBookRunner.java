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

public class GradeBookRunner {

	private static Scanner keyboard = new Scanner(System.in);

	private static int studentCount;

	public static void main(String args[]) {
		out.println("Welcome to the Class Stats program!");

		Class gradebook = makeNewClass();
		addStudents(gradebook);
		System.out.println(gradebook);
		out.println("Failure List = " + gradebook.getFailureList(70));
		out.println("Highest Average = " + gradebook.getStudentWithHighestAverage());
		out.println("Lowest Average = " + gradebook.getStudentWithLowestAverage());

		out.println(String.format("Class Average = %.2f", gradebook.getClassAverage()));
		keyboard.close();

	}

	public static Class makeNewClass() {
		System.out.print("What is the name of this class? ");
		String className = keyboard.nextLine();
		System.out.print("How many students are in this class? ");
		int numOfStudents = Integer.parseInt(keyboard.nextLine());
		studentCount = numOfStudents;
		Class classGrades = new Class(className, numOfStudents);
		return classGrades;
	}

	public static void addStudent(Class gradeBook, int studentNum) {
		System.out.print("Enter the name of student " + (studentNum + 1) + " : ");
		String studentName = keyboard.nextLine();
		System.out.println("enter the grades for " + studentName);
		System.out.print("Use the format x - grades (2 - 100 100) : ");
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