package task1;
/**
 * <p>
 * Title: Recognizer
 * </p>
 *
 * <p>
 * Description: A class to use to hold the recognizer for Task 1
 * </p>
 *
 * <p>
 * Copyright: Copyright © 2014
 * </p>
 *
 * @author Lynn Robert Carter
 * @version 1
 */
public class Recognizer {
	/**********
	 * This is a recognizer pair.  This algorithms can be used to convert input Strings into an
	 * actual UNumber.  The only difference is that these methods do not produce a UNumber.  They 
	 * just return true or false based on what is found in the input. This method processes the 
	 * exponent portion of the FSM, States 6, 7, and 8.
	 * 
	 * @param s		The input string to be check to see if it is a UNumber
	 * 
	 * @param ndx	The index of the location within the string
	 * 
	 * @return		The Boolean value of whether or not the input is a valid UNumber
	 */
	private static boolean hasUNumberState6(String s, int ndx) {
			return false;	// Replace this line with a recognizer for states 6, 7, and 8
	}																
	
	/**********
	 * This is a recognizer pair.  This algorithms can be used to convert input Strings into an
	 * actual UNumber.  The only difference is that these methods do not produce a UNumber.  They 
	 * just return true or false based on what is found in the input. This method processes the 
	 * mantissa portion of the FSM, States 0 through 5.
	 * 
	 * @param s		The input string to be check to see if it is a UNumber
	 * 
	 * @param ndx	The index of the location within the string
	 * 
	 * @return		The Boolean value of whether or not the input is a valid UNumber
	 */
	public static boolean hasUNumber(String src) {
		String s = src + ';';								// Add the sentinel at the end 
		int ndx = 0;										// Start at the beginning of the string
		// State 0											// We start in State 0
		if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {		// If the first character is a digit, 
			// State 1										// transition to State 1 and process
			ndx = 1;										// as many more digits as is there
			while (s.charAt(ndx) >= '0' && s.charAt(ndx) <= '9') ndx++;		// When we encounter a
			if (s.charAt(ndx) == '.') {						// non-digit, see if it was a decimal 
				// State 2									// point.  If so transition to State 2
				ndx++;										// Accept it and see if there are more
				if (s.charAt(ndx) >= '0' && s.charAt(ndx) <= '9') {	// is another digit.  If so we
					// State 3								// transition to State 3
					ndx++;									// Accept the digit and then skip as 
					while (s.charAt(ndx) >= '0' && s.charAt(ndx) <= '9') ndx++;	// many as there are
															// When the end of the digit sequence 
					if (s.charAt(ndx) == 'E' || s.charAt(ndx) == 'e')	// If there is an 'E' or 'e'
						return hasUNumberState6(s, ndx+1);	// use State 6 method and return result. 
					
					// End of State 3, but no exponent, so see if we are at the sentinel.  If so we
					else if (ndx + 1 == s.length()) return true;	// done and we return true
					else return false;						// otherwise, error and return false
					
				// State 2, but it is not a digit			// Therefore, we see if it might be an
				} else if (s.charAt(ndx) == 'E' || s.charAt(ndx) == 'e') {	// an exponent.  If so
					return hasUNumberState6(s, ndx+1);				// return was State6 method does
					
				// State 2, but no digit or exponent		// If it is the sentinel, then we return
				} else if (ndx + 1 == s.length()) return true;	// true, it is a UNumber
				
				// State 2, but not a digit, an exponent or the sentinel
				else 										// It is an error, so we return false
					return false;							// The whole String is not a UNumber
				
			// At the end of State 1, but it was not a decimal point that ended it; could it be?	
			} else 											// an exponent?  If it is an 'E' or
				if (s.charAt(ndx) == 'E' || s.charAt(ndx) == 'e') {	// an 'e', it is an exponent,
					return hasUNumberState6(s, ndx+1);		// so, return the result from State6
				
			// At the end of State 1, not a decimal point or an exponent? COuld it be the sentinel?
			} else if (ndx + 1 == s.length())				// Check for the sentinel and return
				 return true;								// true if it is there... It is a UNumber
			else 											// else it is an error and 
				return false;								// we should return false
		}
		
		// We are at State 0 the next character was not a digit, see if it is a decimal point
		else if (s.charAt(0) >= '.') {						// If so, then we must transition to
			// State 4										// State 4 to process any digits after
			if (s.charAt(1) >= '0' && s.charAt(1) <= '9') {	// the decimal point. Is there a digit?
				// state 5									// If so, we need to accept the digit
				ndx++;										// and set up to skip as many more 
				while (s.charAt(ndx) >= '0' && s.charAt(ndx) <= '9') ndx++;	// digits as it can.  
															// The loop ends at an exponent, the
				if (s.charAt(ndx) == 'E' || s.charAt(ndx) == 'e') {	// sentinel, or an error. If an
					return hasUNumberState6(s, ndx+1);		// exponent, use hasUNumberState6.
				} else 										// If not an exponent are we at the 
					if (ndx + 1 == s.length()) 				// the sentinel? If so, it is a UNumber
						return true;
					else 									// If not an exponent and not the
						return false;						// sentinel, the whole String is not
			}												// a UNumber.
			
			// Coming here means that there is no digit before or after the period.
			else return false;								// That is an error!	
			
		}
		// Coming here means the first character is not a digit or a decimal point.
		else return false;									// That is an error
	}
}
