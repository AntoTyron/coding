package dailycodingexamples;
/**
 * Problem:1
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?

Brute force
if( arr ==null || arr.length<1 ) { return false;}
for( int i=0; i<arr.length; i++) {
	for( int j=i+1; j<arr.length;j++){
		if(arr[i] + arr[j] == input) {
			return true;
		}
	}
}
**/
//Learn, trying to dp found a clue, always see if   x+y=z and with the result you can find out something
import java.util.*;
class AddItemPresent{
	public static boolean addItemPresent(int[] arr, int input) {  // 10, 15,3,7,6
		if(arr.length<1) return false;
		HashSet<Integer> map = new HashSet<Integer>();
		for( int i=0; i<arr.length; i++) {
			if(map.contains(arr[i])){ return true;}
			map.add(input-arr[i]);
		}
		return false;
	}
	
	public static void main (String args[]){
		int[] arr = {10, 15, 3, 7,6, 20,0 ,-3};
		System.out.println(addItemPresent(arr, 17));
		System.out.println(addItemPresent(arr, 20));
		System.out.println(addItemPresent(arr, 8));
		System.out.println(addItemPresent(arr, 4));
	}
}

