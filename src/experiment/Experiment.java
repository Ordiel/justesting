package experiment;

import uNumberLibrary.UNumber;

public class Experiment {
	public static void main (String [] args) {
		UNumber v1 = new UNumber("125", 2, true);		// v1 = 12.5
		System.out.println("v1 = " + v1.toDecimalString());
		UNumber v2 = new UNumber("275", 1, true);		// v2 = 2.75
		System.out.println("v2 = " + v2.toDecimalString());
		UNumber v3 = new UNumber("35", 0, true);	// v3 = 0.35
		System.out.println("v3 = " + v3.toDecimalString());
		UNumber d1 = new UNumber("143", 2, true);		// d1 = 14.3
		System.out.println("d1 = " + d1.toDecimalString());
		UNumber d2 = new UNumber("33", 1, true);		// d2 = 3.3;
		System.out.println("d2 = " + d2.toDecimalString());
		UNumber result = new UNumber(v1,20);				// Set up the result = v1
		System.out.println("result = " + result.toDecimalString());
		result.add(v2);									// Add in the second variable; result = v1 + v2
		System.out.println("result = " + result.toDecimalString());
		result.add(v3);									// Add in the third; result = v1 + v2 + v3
		System.out.println("result = " + result.toDecimalString());
		UNumber temp = new UNumber(d1); 				// Set up a temp = d1
		System.out.println("temp = " + temp.toDecimalString());
		temp.sub(d2); 									// Compute the difference; temp = d1 – d2
		System.out.println("temp = " + temp.toDecimalString());
		result.div(temp); 								// Compute the quotient; result = result / temp
		System.out.println("result = " + result.toDecimalString());
	}
}
