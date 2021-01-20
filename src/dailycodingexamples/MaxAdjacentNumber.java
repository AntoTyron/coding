package dailycodingexamples;

/**
 * Daily Coding Problem: Problem #9 [Hard] 
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
Follow-up: Can you do this in O(N) time and constant space?
 * @author antot
 *
 */
class MaxAdjacentNumber{
	public static Integer findMaxAdjSum(int[] arr){
		if(arr.length<0) return 0;
		int iMinus1=0, iMinus2=0, sum=0;
		for( int i=0; i<arr.length; i++){
			iMinus2 = i-2<0?0: arr[i-2];
			iMinus1 = i-1<0?0:arr[i-1];
			sum = iMinus2+arr[i];
			arr[i] = sum>iMinus1?sum:iMinus1;
		}
		return arr[arr.length-1];
	}
	
	public static void main(String args[]){
		//int[] input = {2,4,6,2,5};
		int[] input = {5,1,1,-5};
		System.out.println(findMaxAdjSum(input));
	}
}

