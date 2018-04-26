package unit8;
//� A+ Computer Science  -  www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
import java.lang.System;
import java.lang.Math;
import java.util.Arrays;
import java.util.Scanner;

public class Grades {
	// instance variables
	private int size;
	private float[] grades;

	// constructor
	public Grades() {
		setGrades(0, "");
	}

	public Grades(int size, String grds) {
		float[] tempGrades = new float[size];
		Scanner psr = new Scanner(grds);
		int i = 0;
		while (psr.hasNext()) {
			tempGrades[i++] = psr.nextFloat();
		}
		this.size = size;
		grades = tempGrades;
		psr.close();
	}

	public Grades(int size, float[] grds) {
		this.size = size;
		grades = grds;
	}

	public void setGrades(int size, String grds) {
		float[] tempGrades = new float[size];
		Scanner psr = new Scanner(grds);
		int i = 0;
		while (psr.hasNext()) {
			tempGrades[i++] = psr.nextFloat();
		}
		this.size = size;
		grades = tempGrades;
		psr.close();
	}

	// set method
	private double getSum() {
		double sum = 0.0;
		for (float grade : grades) {
			sum += grade;
		}
		return sum;
	}

	public double getAverage() {
		double average = 0.0;
		average = getSum() / size;
		return average;
	}
	// toString method

	public String toString() {
		String output = "";
		for (int i = 0; i < size; i++) {
			output += String.format("grade %d :: %.2f\n", i, grades[i]);
		}
		output += String.format("\naverage = %2.2f\n\n", getAverage());
		return output;
	}
}