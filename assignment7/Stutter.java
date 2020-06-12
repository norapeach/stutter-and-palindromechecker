/**
 * Stutter.java
 */
package assignment7;

/***************************************************************************
 * START LINE 82: BJP5 Exercise 14.2: stutter
 * This program tests the method stutter that takes a stack of 
 * integers as a parameter and replaces every value in the stack 
 * with two occurrences of that value.
 * 
 * Example stack to pass: bottom [3, 7, 1, 14, 9] top
 * Post method, stack should be: bottom [3, 3, 7, 7, 1, 1, 14, 14, 9, 9] top
 * 
 * REQUIREMENTS
 * - preserve the original order. 
 * - Only single queue may be used as auxiliary storage to solve this problem.
 * "In the original list the 9 was at the top and would have been popped first. 
 * In the new stack the two 9s would be the first values popped from the stack." 
 **************************************************************************/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Nora P.
 * @version 6/11/20
 *
 */
public class Stutter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>(); // data structure for stutter method test
		int[] stutter1 = { 3, 7, 1, 14, 9 }; // test for stutter
		
		for (int n : stutter1) {
			s.push(n);
		}
		
		System.out.println("Stutter Test:");
		System.out.println("Original Stack: bottom " + s + " top");
		stutter(s);
		System.out.println("Stuttered Stack: bottom " + s + " top \n");

	}
	
	/**
	 * Duplicates each integer in the stack, maintaining the original order Uses 1
	 * Queue as auxiliary storage.
	 * 
	 * @param s The stack of integers to stutter
	 */
	public static void stutter(Stack<Integer> s) {
		Queue<Integer> q = new LinkedList<>();
		while (!s.isEmpty()) { // loop through stack - post: all values will be removed and added to q
			int n = s.pop();
			q.add(n);
		}

		while (!q.isEmpty()) {
			int n = q.remove();
			s.push(n);
		} // post: Stack is reversed

		while (!s.isEmpty()) {
			int n = s.pop();
			q.add(n);
		}

		while (!q.isEmpty()) {
			int n = q.remove();
			s.push(n);
			s.push(n);
		} // post: correct original order, but stuttered

	}

}
