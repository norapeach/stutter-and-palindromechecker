import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * StackandQueueExercises.java
 */

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

/***************************************************************************
 * BJP5 Exercise 14.8: isPalindrome
 * This program also tests the method a method isPalindrome: 
 * "Take a queue of integers as a parameter and return true if the numbers in 
 * the queue represent a palindrome (and false otherwise). 
 * A sequence of numbers is considered a palindrome if it is the same in 
 * reverse order. 
 * For example, suppose a queue called q stores these values:
 * front [3, 8, 17, 9, 17, 8, 3] back
 * isPalindrome(q); should return true because this sequence is the same in reverse order. 
 * 
 * If the queue had instead stored these values:
 * front [3, 8, 17, 9, 4, 17, 8, 3] back
 * The call on isPalindrome would instead return false 
 * because this sequence is not the same in reverse order (the 9 and 4 in the 
 * middle don't match). 
 * 
 * REQUIREMENTS
 * - The empty queue should be considered a palindrome. 
 * - You may not make any assumptions about how many elements are in the queue 
 * 		and your method must restore the queue so that it stores the same sequence 
 * 		of values after the call as it did before. 
 * - You may use one stack as auxiliary storage.
 **************************************************************************/

/**
 * @author Nora P.
 * @version 06/09/20
 *
 */
public class StackandQueueExercises {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>(); // for stutter
		Queue<Integer> testPal1 = new LinkedList<>();
		Queue<Integer> testPal2 = new LinkedList<>();
		int[] stutter1 = { 3, 7, 1, 14, 9 }; // test for stutter
		int[] pal1 = {3, 8, 17, 9, 17, 8, 3}; // test for palindrome
		int[] pal2 = {3, 8, 17, 9, 4, 17, 8, 3}; // !palindrome

		for (int n : stutter1) {
			s.push(n);
		}
		
		System.out.println("Stutter Test:");
		System.out.println("Original Stack: bottom " + s + " top \n");
		stutter(s);
		System.out.println("Stuttered Stack: bottom " + s + " top \n");
		
		for (int n : pal1) {
			testPal1.add(n);
		}
		
		for (int n : pal2) {
			testPal2.add(n);
		}
		
		System.out.println("isPalindrome Test:");
		System.out.println("Original Queue 5: " + testPal1);
		System.out.println("Palindrome? >> " + isPalindrome(testPal1) + " \n");
		System.out.println("Original Queue 6: " + testPal2);
		System.out.println("Palindrome? >> " + isPalindrome(testPal2) + " \n");

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

	/**
	 * Returns true if the given Queue reads the same forwards as backwards.
	 * Trivially true for empty or 1-letter strings.
	 * 
	 * @param q The queue to evaluate as in a palindrome sequence
	 * @return boolean
	 */
	public static boolean isPalindrome(Queue<Integer> q) {
		// I want to get the reverse and compare each int from the queue and stack
		// two tracks?
		// WHAT DO I KNOW FIRST: trying recursive solutation

		int origSize = q.size(); // get the queue size
		Stack<Integer> s = new Stack<>(); // REQUIREMENT: 1 stack as aux storage

		if (origSize < 2) {
			return true; // base case
		} else {
			while (!q.isEmpty()) {
				int n = q.remove(); // remove all values from queue
				s.push(n); // add to stack
			} //1. post: Temp Stack contains original sequence
			System.out.println("tracing... " + "temp stack: " + " bottom " + s + " top");
			System.out.println("tracing... " + "queue: front " + q +  " back\n");
		
			while (!s.isEmpty()) {
				int n = s.pop();
				q.add(n);
			} // 2. post: queue contains reversed
		
			// compare?
		} 
		
		
		
		
		
		

		// REQUIREMENT: restore the queue
		return false;
	}
	// REFERENCE googledoc: npRecursion basic examples --> search isPalindrome
	/***************************************************************************
	 * BJP5 Exercise 14.8: isPalindrome This program also tests the method a method
	 * isPalindrome: "Take a queue of integers as a parameter and return true if the
	 * numbers in the queue represent a palindrome (and false otherwise). A sequence
	 * of numbers is considered a palindrome if it is the same in reverse order. For
	 * example, suppose a queue called q stores these values: front [3, 8, 17, 9,
	 * 17, 8, 3] back isPalindrome(q); should return true because this sequence is
	 * the same in reverse order.
	 * 
	 * If the queue had instead stored these values: front [3, 8, 17, 9, 4, 17, 8,
	 * 3] back The call on isPalindrome would instead return false because this
	 * sequence is not the same in reverse order (the 9 and 4 in the middle don't
	 * match).
	 * 
	 * REQUIREMENTS - The empty queue should be considered a palindrome. - You may
	 * not make any assumptions about how many elements are in the queue and your
	 * method must restore the queue so that it stores the same sequence of values
	 * after the call as it did before. - You may use one stack as auxiliary
	 * storage.
	 **************************************************************************/

}
