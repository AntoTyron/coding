package bit.manipulation;

import java.util.Arrays;

public class FindOrigAmong3Duplicates {
	public static Integer findNonDuplicate(int[] arr) {
		//[6,6,1]
	
	int[] result = new int[5];
	int output=0;
	Arrays.fill(result,0);

	//Get the first element of the bit and store to an array
	//Add each of those bit
	for ( int i=0; i<arr.length;i++) {
		for( int j=0; j<result.length; j++) {
			int elem = arr[i];
			int sum = elem >> j & 1;
			result[j] += sum;
			System.out.print(sum);
		}
		System.out.println();
	}
	System.out.println();
	for ( int i=0; i<result.length; i++) {
		System.out.print(result[i]);
		int elem = result[i];
		if( elem %3 !=0 ) {
			output +=Math.pow(2,i);
	}
	}
	return output;
	//Modulo 3 to eliminate the matching bits
	}
	
	public static void main(String args[]) {
		System.out.println(FindOrigAmong3Duplicates.findNonDuplicate(new int[]{6,6,3,6}));
	}


}
