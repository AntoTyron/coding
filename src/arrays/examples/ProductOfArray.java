package arrays.examples;

import java.util.Arrays;

class ProductOfArray{
	public static void productArrayExceptSelf(int[] arr) {
		int[] before = new int[arr.length];
		int[] after = new int[arr.length];
		int prev=1, next=1;
		for( int i=0; i<arr.length; i++){
			before[i]= prev*arr[i];
			after[arr.length-1-i] = next * arr[arr.length-1-i];
			prev = before[i];
			next = after[arr.length-1-i];
		}
		for(int i=0; i<arr.length; i++) {
			prev = i-1>=0? before[i-1]:1;
			next = i+1<arr.length? after[i+1]:1;
			arr[i] = prev*next;
		}
		
	}
	public static void main(String args[]) {
		int[] input = new int[]{1,4,2,3,5};
		productArrayExceptSelf(input);
		Arrays.stream(input).forEach(k -> System.out.print(k+","));
	}

}

