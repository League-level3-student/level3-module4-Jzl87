package _00_IntroToStacks;

import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> doble = new Stack<Double>();

		// 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for (int x = 0; x < 100; x++) {
			Double y = (Double) (Math.random() * 100);
			System.out.println(y);
			doble.push(y);
		}
		System.out.println("-------------------------------");
		
		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		String sd1 = JOptionPane.showInputDialog("Enter a number between 0 and 100");
		String sd2 = JOptionPane.showInputDialog("Enter a number between 0 and 100");

		Double larger;
		Double smaller;

		if (Double.parseDouble(sd1) > Double.parseDouble(sd2)) {
			larger = Double.parseDouble(sd1);
			smaller = Double.parseDouble(sd2);
		} else {
			smaller = Double.parseDouble(sd1);
			larger = Double.parseDouble(sd2);
		}

		// 4. Pop all the elements off of the Stack. Every time a double is popped that
		// is
		// between the two numbers entered by the user, print it to the screen.

		while (!doble.isEmpty()) {
			Double x = doble.pop();
			if (x > smaller && x < larger) {
				System.out.println(x);
			}
		}
		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}
