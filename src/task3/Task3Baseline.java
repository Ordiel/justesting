package task3;
/**********
 * <p> Title: Compute Square Root of Two </p>
 * 
 * <p> Description: A sample program to show how to compute square root of two using doubles </p>
 * 
 * <p> Copyright: Copyright © 2014 </p>
 * 
 * @author Lynn Robert Carter
 * @version 2.00	The initial version
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task3Baseline
{
	/* Holds a recognized accurate representation of the square root of 2 from NASA */
	private static String checkNumber = "";		

	/* A set of routine to format the output */
	private static String blank1(int v) {
		if(v < 10) return "     ";
		else return "    ";
	};

	private static String blank2(int v) {
		if (v < 10) return "\t\t        ";
		else if (v < 100) return "\t\t       ";
		else if (v < 1000) return "\t\t      ";
		else if (v < 10000) return "\t\t     ";
		else if (v < 100000) return "\t\t    ";
		else if (v < 1000000) return "\t\t   ";
		else                   return "\t\t  ";
	};

	/*****
	 * This method computes square root using Newton's Method. This iterative approach starts with an
	 * estimate of the square root of x (one half of the value of x), and then uses that to compute
	 * a new estimate by averaging the old estimate with the value divided by the old estimate.
	 * 
	 * The initial estimate of dividing by two only works well when dealing with values in the the range of
	 * -100 to +100. A better estimate for arbitrary values needs to take into account the characteristic.
	 * 
	 * @param value
	 * @return
	 */
	public static double computeSquareRoot (double value) {

		long computeStartTime = System.nanoTime();
		long computeStopTime = 0;
		long duration = 0;

		// Convert the computed value to a string
		String answer = "";


		// This is the initial guess
		double oldGuess = value/2.0;

		// We set up the newGuess to be the same as the guess
		double newGuess = oldGuess;

		// Initialize the loop iteration counter
		int iteration = 0;
		int diff = 16;
		System.out.println("Interation\tSig. Digits\t   Approximation");

		do {	// This is the implementation of Newton's method for finding square root
			iteration++;						// Keep track of the number of iterations

			oldGuess = newGuess;				// The oldGuess was the previous newGuess

			newGuess = (value/oldGuess + oldGuess) / 2;

			// Compare the NASA value with what we have produced so far
			answer = ((Double)newGuess).toString();
			diff = answer.length();
			if (diff > checkNumber.length()) diff = checkNumber.length();
			for (int i = 0; i < answer.length() && i < checkNumber.length(); i++)
				if (checkNumber.charAt(i) != answer.charAt(i)){
					diff = i;
					break;
				}
			diff = diff-1;						// Remove one for the decimal point (not a digit)
			System.out.println(blank1(iteration) + iteration + blank2(diff)+ diff + "\t   " + answer);

		} while (diff < 16 && iteration < 20);	// number of iterations is not too large

		computeStopTime = System.nanoTime();
		duration = computeStopTime - computeStartTime;
		double durrationInSeconds = duration/1000000000.0;

		// Display the calculated square root
		System.out.println();
		System.out.println("Computation time (in seconds): " + durrationInSeconds);
		System.out.println();
		System.out.println();

		return newGuess;
	}


	/**********
	 * This is the mainline that reads in the square root of two from NASA, prints out the first 30 digits, 
	 * and computes the square root of 2.
	 * 
	 * @param args		These arguments are ignored
	 */
	public static void main (String [] args) {
		// Read in the square root that NASA has computed from a file 
		try {
			Scanner checkReader = new Scanner(new File("SquareRootTwo.txt"));

			// Read in the value from NASA until the checkNumber is longer than the value we are computing
			while (checkReader.hasNextLine() && (checkNumber.length() <= 80))
				checkNumber += checkReader.nextLine().trim();

			checkReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Not able to find the file: SquareRootTwo.txt");
		}
		System.out.println("Square Root of 2 from NASA to 30 significant digits out of " + (checkNumber.length()-1) + " digits in the array.");
		for (int ndx=0; ndx < 31; ndx++)System.out.print(checkNumber.charAt(ndx));
		System.out.println();
		System.out.println();

		// Compute the square root of 2
		System.out.println("Square Root of 2 using Newton's method with double values:");
		double result = computeSquareRoot(2.0);
		System.out.print("The square root approximation returned is: ");
		System.out.println(result);
	}	
}
