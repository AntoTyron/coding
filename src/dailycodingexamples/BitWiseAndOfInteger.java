package dailycodingexamples;
/** Problem: 317 Medium
Good morning! Here's your coding interview problem for today.
This problem was asked by Yahoo.
Write a function that returns the bitwise AND of all integers between M and N, inclusive.
//Collect to an array -. arr[] and then elem>>i&1
// prev I element & current I element**/
import java.util.*;
import java.util.stream.Collectors;
class BitWiseAndOfInteger{

	public static List<Integer> performBitwiseAnd(int start, int end){
		if(start>end) {return null;}
		int[] arr = new int[8];
		for( int i=start; i<=end; i++){
			
			Arrays.fill(arr,1);
			for(int j=0; j<8; j++) {
				arr[j] &= i>>j&1;
			}
			Arrays.stream(arr).forEach(System.out::print);
			System.out.println();
		}
		return Arrays.stream(arr).boxed().collect(Collectors.toList());
	}
	
	public static void main(String args[]){
		List<Integer> result = performBitwiseAnd(21, 28);
		Collections.reverse(result);
		
		result.forEach(System.out::print);
	}

}
