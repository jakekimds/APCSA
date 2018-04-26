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

public class Class {
	private String name;
	private Student[] studentList;

	public Class() {
		name = "";
		studentList = new Student[0];
	}

	public Class(String name, int stuCount) {
		this.name = name;
		studentList = new Student[stuCount];
	}

	public void addStudent(int stuNum, Student s) {
		studentList[stuNum] = s;
	}

	public String getClassName() {
		return name;
	}

	public double getClassAverage() {
		double sum = 0.0;
		for (int i = 0; i < studentList.length; i++) {
			sum += studentList[i].getAverage();
		}
		return sum / studentList.length;
	}

	public double getStudentAverage(int stuNum) {
		return studentList[stuNum].getAverage();
	}

	public double getStudentAverage(String stuName) {
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i].getName().equals(stuName)) {
				return studentList[i].getAverage();
			}
		}
		return 0;
	}

	public String getStudentName(int stuNum) {
		return studentList[stuNum].getName();
	}

	public String getStudentWithHighestAverage() {
		double high = Double.MIN_VALUE;
		String hName = "";
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i].getAverage() > high) {
				high = studentList[i].getAverage();
				hName = studentList[i].getName();
			}
		}
		return hName;
	}

	public String getStudentWithLowestAverage() {
		double low = Double.MAX_VALUE;
		String hName = "";
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i].getAverage() < low) {
				low = studentList[i].getAverage();
				hName = studentList[i].getName();
			}
		}

		return hName;
	}

	public String getFailureList(double failingGrade) {
		String output = "";
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i].getAverage() < failingGrade) {
				output += studentList[i].getName() + " ";
			}
		}
		return output;
	}

	public String toString() {
		String output = "" + getClassName();
		for (int i = 0; i < studentList.length; i++) {
			Student current = studentList[i];
			output += "\n";
			output += String.format("%s\t%.2f", current.toString(), current.getAverage());
		}

		return output;
	}
}