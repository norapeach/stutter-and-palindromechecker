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
 * START LINE 134 BJP5 Exercise 14.8: isPalindrome
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
 * @version 06/09/20 This program tests the isPalindrome(Queue<Integer>) and
 *          stutter(Stack<Integer>) methods
 */
public class StackandQueueExercises {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>(); // data structure for stutter method test

		Queue<Integer> testPal1 = new LinkedList<>(); // isPalindrome data structure
		Queue<Integer> testPal2 = new LinkedList<>();

		int[] stutter1 = { 3, 7, 1, 14, 9 }; // test for stutter
		int[] pal1 = { 3, 8, 17, 9, 17, 8, 3 }; // test for isPalindrome == true
		int[] pal2 = { 3, 8, 17, 9, 4, 17, 8, 3 }; // NOT a palindrome

		for (int n : stutter1) {
			s.push(n);
		}

		System.out.println("Stutter Test:");
		System.out.println("Original Stack: bottom " + s + " top");
		stutter(s);
		System.out.println("Stuttered Stack: bottom " + s + " top \n");

		for (int n : pal1) {
			testPal1.add(n);
		}

		for (int n : pal2) {
			testPal2.add(n);
		}

		System.out.println("isPalindrome Test:");
		System.out.println("Original Queue: fron t" + testPal1 + " back");
		System.out.println("Palindrome? >> " + isPalindrome(testPal1));
		System.out.println("Post: test Queue: front " + testPal1 + " back \n");
		System.out.println("2nd original Queue: front " + testPal2);
		System.out.println("Palindrome? >> " + isPalindrome(testPal2));
		System.out.println("Post: test Queue: front " + testPal1 + " back \n");

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
		Stack<Integer> s = new Stack<>(); // REQUIREMENT: 1 Stack as auxiliary storage
		int origSize = q.size(); // store a reference to the original queue size
		boolean isPalindrome = true; // default

		// ADD Q elements to S for comparision back vs. front
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
