package backtracking.examples;

//Integers
//Range, negative numbers, while displaying do they need to be in sorted order.
//Should the permutation always be  within the length
//Have a running for loop of each elem - N
//recur (substring, result)
//when reaches null add to result
//Conditions if null, if there is an elem in subarray
//Can it exceed int limit

import java.util.*;

class Permutation{
	public static List<List<Integer>> callPermutations(int[] A) {
		if(A == null || A. length==0) {
			return null;
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		performRecursion(A,result, 0);
		return result;
	}
	//A:1,2,3     2,3     3
	//result:null, null   null 1,2,3
	//partial: 1    2      #3 
	public static void performRecursion(int[] A, List<List<Integer>> result, int start) {
		if(start> A.length-1) {
			List<Integer> partial = new ArrayList<Integer>();
			for(int elem: A) {
				partial.add(elem);
			}
			System.out.println(partial);
			result.add(partial);
		}
		for( int i=start; i<A.length; i++) {
			swap(A, start, i);
			performRecursion(A, result, start+1);
			swap(A, start, i); // swap to leave back the order
		}
	}

	public static void swap(int[] A, int start, int end) {
		int temp = A[start];
		A[start] = A[end];
		A[end] = temp;
		
	}
	
	public static void main(String args[]) {
	int[] A = {1,2,3};
	System.out.println(callPermutations(A));
	}
}

