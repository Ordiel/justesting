package task1;

import java.util.Scanner;

/**
 * <p>
 * Title: Task1
 * </p>
 *
 * <p>
 * Description: A class to use to hold the mainline for Task 1
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2014
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1
 */
public class Task1Mainline {
	
	public static void main (String [] args) {
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
			// Does this input line consist of a value floating point value?
			if (Recognizer.hasUNumber(input)) 
				
				// If so, say so
				System.out.println("Valid floating point value"); 
			else
				
				// If not, say so
				System.out.println("Not a valid floating point value");
			
			// Ask for more input
			System.out.print("Enter a floating point value or just press return (enter) to stop the loop: ");
			input = keyboard.nextLine().trim();
		}
		
		// An empty input line has been entered, so the tell the user we are stopping
		System.out.print("Empty line detected... the program stops");
		keyboard.close();
	}
}
