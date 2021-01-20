package dynamic.examples;

import java.util.*;
public class FindMaxSubArray {
	
	public static int findMAxSubArray(List<Integer> A) {
		int maxEnd = 0;
		int maxSeen = 0;
		for(int i=0; i<A.size(); i ++) {
			maxEnd = Math.max(A.get(i), A.get(i)+maxEnd);
			maxSeen = Math.max(maxSeen, maxEnd);
		}
		return maxSeen;
	}
	
	public static void main(String agrs[]) {
		System.out.println(findMAxSubArray(Arrays.asList(-2,3,1,-7,3,2,-1)));
	}

}
