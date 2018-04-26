package unit11.Extensions;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.util.ArrayList;

public class Grades {
	private ArrayList<Double> grades;

	public Grades() {
		setGrades("");
	}

	public Grades(String gradeList) {
		setGrades(gradeList);
	}

	public void setGrades(String gradeList) {
		Scanner scanner = new Scanner(gradeList);
		int len = scanner.nextInt();
		grades = new ArrayList<Double>(len);
		for (int i = 0; i < len; i++) {
			grades.add(0.0);
		}
		scanner.next();
		int i = 0;
		while (scanner.hasNextDouble()) {
			setGrade(i, scanner.nextDouble());
			i++;
		}
		scanner.close();
	}

	public void setGrade(int spot, double grade) {
		grades.set(spot, grade);
	}

	public double getSum() {
		double sum = 0.0;
		for (int i = 0; i < grades.size(); i++) {
			sum += grades.get(i);
		}
		return sum;
	}

	public double getLowGrade() {
		double low = Double.MAX_VALUE;
		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i) < low) {
				low = grades.get(i);
			}
		}
		return low;
	}

	public double getHighGrade() {
		double high = Double.MIN_VALUE;
		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i) > high) {
				high = grades.get(i);
			}
		}
		return high;
	}

	public int getNumGrades() {
		return grades.size();
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < grades.size(); i++) {
			output += grades.get(i) + " ";
		}
		return output;
	}
}