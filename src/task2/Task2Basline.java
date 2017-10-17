package task2;

import java.util.Scanner;

import uNumberLibrary.UNumber;

/**
 * <p>
 * Title: Task2
 * </p>
 *
 * <p>
 * Description: A class to use to hold the mainline for Task 2
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2014
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1
 */

public class Task2Basline {
	public static void main (String [] args) {
		// Initialize key values
		int numberOfValues = 0;
		UNumber sum = new UNumber(0.0);
		
		// Set up keyboard as a Scanner object using the console keyboard for input
		Scanner keyboard = new Scanner(System.in);
		
		// Tell the user that an empty input line will cause the program to stop
		System.out.println("Enter an empty line to terminate the loop!");
		
		// Request a floating point value from the user
		System.out.print("Enter a floating point value or just press return (enter) to stop the loop: ");
		
		// Fetch the input from the user, removing leading and trailing white space characters
		String input = keyboard.nextLine().trim();
		
		// As long as the length of the input String is positive, continue processing the input
		while (input.length() > 0) {
			Scanner value = new Scanner(input);
			// Does this input line consist of a valid floating point value?
			if (value.hasNextDouble()) {
				
				// If so, convert it to a double, add it to the sum, and count it
				double inputValue = value.nextDouble();
				sum = new UNumber(Double.parseDouble(sum.toDecimalString()) + inputValue);
				numberOfValues++;
			}
			else
				
				// If not, say so
				System.out.println("Not a valid floating point value, try again");
			
			// Ask for more input
			System.out.print("Enter a floating point value or just press return (enter) to stop the loop: ");
			input = keyboard.nextLine().trim();
			value.close();
		}
		
		// An empty input line has been entered, so the tell the user we are stopping
		System.out.println("Empty line detected... the loop stops");
		System.out.println("The sum is: " + sum);
		System.out.println("The number of values is: " + numberOfValues);
		System.out.println("The average is: " + (Double.parseDouble(sum.toDecimalString()) / numberOfValues));
		keyboard.close();
	}
}
