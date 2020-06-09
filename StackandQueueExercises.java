import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * StackandQueueExercises.java
 */

/***************************************************************************
 * BJP5 Exercise 14.2: stutter
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
		Stack<Integer> s = new Stack<>();
		int[] nums1 = {3, 7, 1, 14, 9};
		
		
		for (int n : nums1) {
			s.push(n);
		}
		System.out.println("Original Stack: bottom " + s + " top ");
		stutter(s);
		System.out.println("Stuttered Stack: bottom " + s + " top ");

	}
	
	/**
	 * Duplicates each integer in the stack, maintaining the original order
	 * Uses 1 Queue as auxiliary storage.
	 * @param s The stack of integers to stutter
	 */
	public static void stutter(Stack<Integer> s) {
		Queue<Integer> q = new LinkedList<>();
		while(!s.isEmpty()) { // loop through stack - post: all values will be removed and added to q
			int n = s.pop();
			q.add(n);
		}
		
		while(!q.isEmpty()) {
			int n = q.remove();
			s.push(n);
		} // post: Stack is reversed
		
		while(!s.isEmpty()) {
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
