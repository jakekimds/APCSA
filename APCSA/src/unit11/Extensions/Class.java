package unit11.Extensions;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class {
	private String name;
	private ArrayList<Student> studentList;

	public Class() {
		name = "";
		studentList = new ArrayList<Student>();
	}

	public Class(String name, int stuCount) {
		this.name = name;
		studentList = new ArrayList<Student>(stuCount);
		for (int i = 0; i < stuCount; i++) {
			studentList.add(new Student());
		}
	}

	public void addStudent(int stuNum, Student s) {
		studentList.set(stuNum, s);
	}

	public String getClassName() {
		return name;
	}

	public double getClassAverage() {
		double sum = 0.0;
		for (int i = 0; i < studentList.size(); i++) {
			sum += studentList.get(i).getAverage();
		}
		return sum / studentList.size();
	}

	public double getStudentAverage(int stuNum) {
		return studentList.get(stuNum).getAverage();
	}

	public double getStudentAverage(String stuName) {
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getName().equals(stuName)) {
				return studentList.get(i).getAverage();
			}
		}
		return 0;
	}

	public String getStudentName(int stuNum) {
		return studentList.get(stuNum).getName();
	}

	public String getStudentWithHighestAverage() {
		double high = Double.MIN_VALUE;
		String hName = "";
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getAverage() > high) {
				high = studentList.get(i).getAverage();
				hName = studentList.get(i).getName();
			}
		}
		return hName;
	}

	public String getStudentWithLowestAverage() {
		double low = Double.MAX_VALUE;
		String hName = "";
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getAverage() < low) {
				low = studentList.get(i).getAverage();
				hName = studentList.get(i).getName();
			}
		}

		return hName;
	}

	public String getFailureList(double failingGrade) {
		String output = "";
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getAverage() < failingGrade) {
				output += studentList.get(i).getName() + " ";
			}
		}
		return output;
	}

	public String toString() {
		String output = "" + getClassName();
		for (int i = 0; i < studentList.size(); i++) {
			Student current = studentList.get(i);
			output += "\n";
			output += String.format("%s\t%.2f", current.toString(), current.getAverage());
		}

		return output;
	}

	public void sort() {
		Collections.sort(studentList);
	}
}