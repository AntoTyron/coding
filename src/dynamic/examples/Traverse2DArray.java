package dynamic.examples;

import java.util.*;
import java.util.stream.*;
class Traverse2DArray {
	public static int traverse(int[][] A) {
		if(A.length<=1 ||A[0].length<=1) return 0;
		return traverseRec(A, A.length-1, A[A.length-1].length-1);
	}
	public static int traverseRec(int[][] A, int i, int j) {
		if(i==0 && j==0) {
			return 1;
		}
		if(A[i][j]==0) {
			int waysToLeft = i==0?0: traverseRec(A,i-1,j);
			int waysToRight= j==0?0:traverseRec(A,i,j-1);
			A[i][j] = waysToLeft + waysToRight;
		}
		return A[i][j];		
	}
	public static void main(String args[]) {
		int[][] A = new int[4][4];
		for(int[] elem: A) {
			Arrays.fill(elem, 0);
		}
		System.out.println(traverse(A));
		Stream.of(A).map(Arrays::toString).forEach(System.out::println);;
	}
	//(n+m-2)/(n-1)!(m-1)!
}

