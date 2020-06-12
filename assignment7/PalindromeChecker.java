/**
 * PalindromeChecker.java
 */
package assignment7;

/***************************************************************************
 * METHOD START LINE 78 BJP5 Exercise 14.8: isPalindrome
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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Tests the isPalindrome(Queue<Integer> q) method
 * @author Nora P.
 * @version 6/11/20
 */
public class PalindromeChecker {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> testPal1 = new LinkedList<>(); // isPalindrome data structure
		Queue<Integer> testPal2 = new LinkedList<>();
		
		int[] pal1 = { 3, 8, 17, 9, 17, 8, 3 }; // test values for isPalindrome == true
		int[] pal2 = { 3, 8, 17, 9, 4, 17, 8, 3 }; // isPalindrome == false
		
		for (int n : pal1) {
			testPal1.add(n);
		}

		for (int n : pal2) {
			testPal2.add(n);
		} // post: both Queues hold integers for tests
		
		System.out.println("isPalindrome Test:");
		System.out.println("Original Queue: front " + testPal1 + " back");
		System.out.println("Palindrome? >> " + isPalindrome(testPal1));
		System.out.println("Post-test Queue: front " + testPal1 + " back \n");
		System.out.println("2nd original Queue: front " + testPal2 + " back");
		System.out.println("Palindrome? >> " + isPalindrome(testPal2));
		System.out.println("Post-test Queue: front " + testPal1 + " back \n");


	}
	
	/**
	 * Returns true if the given Queue reads the same forwards as backwards.
	 * Trivially true for empty or 1-letter strings.
	 * 
	 * @param q The queue to evaluate as in a palindrome sequence
	 * @return boolean
	 */
	public static boolean isPalindrome(Queue<Integer> q) {
		Stack<Integer> s = new Stack<>(); // REQUIREMENT: 1 Stack as auxiliary storage
		int origSize = q.size(); // store a reference to the original queue size
		boolean isPalindrome = true; // default value

		// ADD Queue elements to Stack for comparison
		for (int n : q) {
			s.push(n);
		} // post: stack contains same sequence of integers --> stack.pop() allows back
			// values to be accessed

		// System.out.println("1. tracing... " + "temp stack: " + s);
		// System.out.println("1. tracing... " + "queue: " + q);

		// COMPARISON: Loop iterates N times based on original Queue size
		for (int i = 0; i < origSize; i++) {
			int a = q.remove(); // front q element removed
			int b = s.pop(); // top s element removed
			q.add(a); // NOTE: queue element re-added to back of queue
						// --> meets requirement: restore original Queue sequence

			if (a != b) {
				// System.out.println("If not equal: tracing... " + "temp stack: " + s);
				isPalindrome = false;

			} // end if
		} // end loop

		return isPalindrome;

	} // end isPalindrome

} // end class


