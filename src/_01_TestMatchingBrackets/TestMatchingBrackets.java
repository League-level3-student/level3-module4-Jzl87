
package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack <Character> d = new Stack <Character>(); 
    	
    	for (int ind = 0; ind < b.length(); ind++) {
    		char[] x =b.toCharArray();
    		d.add(x[ind]);
    	}
    	
    	
    	
    	
    	
        return false;
    }
}