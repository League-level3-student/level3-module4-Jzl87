
package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */

	public static boolean doBracketsMatch(String c) {
		Stack <Character> openB = new Stack <Character> ();
		
		char[] ca = c.toCharArray();
		
		for (int x = 0; x < ca.length; x++) {
			if (ca[x] == '{') {
				openB.push(ca[x]);
			} else if ( openB.size() > 0 && ca[x] =='}') {
				openB.pop();
			} else {
				return false;
			}
		}
		
		if (openB.size() > 0) {
			return false;
		}
		
		return true;
	}
}