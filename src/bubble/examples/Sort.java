package bubble.examples;

import java.util.Arrays;

class Sort {
	public static int[] bubbleSort(int[] input) {
		//2 counters i, i+1, last elem
		//Iterate and if(i-1>i) swap till the end, at the end elem--;
		if(input.length<=1) {
			return input;
		}
		int elemLength = input.length;
		for(int j=elemLength; j>1;j--) {
				for(int i=1; i< j; i++) {
					if(input[i-1]>input[i]) {
						int temp = input[i-1];
						input[i-1] = input[i];
						input[i] = temp;
					}
					
				}
		}
		return input;
	}

public static void main(String args[]) {
	int[] input = new int[]{5,7,3,2,-1,1};
	Arrays.stream(bubbleSort(input)).forEach(System.out::println);
}
}

