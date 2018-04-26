package unit0;

import java.util.Scanner;
/*
Fork this program and edit the name of your program Name_Unit0LabAssessment

Problem Description:

Write a program that reads in investment amount, annual interest rate, and number of years, and displays the future investment value using the following formula:

futureInvestmentValue  =  investmentAmount * (1 + monthlyInterestRate)numberOfYears*12

monthlyInterestRate = annualInterestRate / 1200;

For example, if you enter amount 1000, annual interest rate 3.25%, and number of years 1, the future investment value is 1032.98. 

Hint: Use the Math.pow(a, b) method to compute a raised to the power of b. 

Here is a sample run:

Sample 1:
Enter investment amount: 1000
Enter annual interest rate: 4.25
Enter number of years: 1
Accumulated value is 1043.34

Sample 2:
Enter investment amount: 1000
Enter annual interest rate: 4.25
Enter number of years: 2
Accumulated value is 1088.55
*/

/*
Design:  (Describe the major steps for solving the problem below.)
First, I wanted to get the initial values from the user, so I used the Scanner to do that. I used floats because they needed to be 
decimal values but not to a high precision. Then I converted annualInterestRate to monthlyInterestRate using the given formula. Then I 
calculated the final value using the given formula. I then displayed the value to the user. I had the use double for the final value 
because Math.pow returns a double and Java complains if I try to assign a double to a float. Then I tested the program with the examples
to make sure it worked as expected.
*/
class Unit0LabAssessment {
	public static void main(String[] args) {

		// use this scanner object to get user input
		Scanner keyboard = new Scanner(System.in);

		// Get the input values
		System.out.print("Enter Investment Amount: ");
		float investmentAmount = keyboard.nextFloat();

		System.out.print("Enter Annual Interest Rate: ");
		float annualInterestRate = keyboard.nextFloat();
		float monthlyInterestRate = annualInterestRate / 1200;

		System.out.print("Enter Number of Years: ");
		float numberOfYears = keyboard.nextFloat();

		// Calculate and display the accumulated value
		double futureInvestmentValue = investmentAmount * Math.pow(1 + monthlyInterestRate, numberOfYears * 12);
		System.out.println("Accumulated value is  " + futureInvestmentValue);
		keyboard.close();
	}
}
