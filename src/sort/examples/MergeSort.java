package sort.examples;

import java.util.Arrays;

/* Java program for Merge Sort */
class MergeSort { 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
	public void mergeSort(int[] input) {
		if(input.length <1) {
			return ;
		}
		
		//Get max elem
		int max = Arrays.stream(input).max().getAsInt() + 1;
		mergeRec(input, 0, input.length-1, max);
	}

	public void mergeRec(int[] input, int beg, int end, int max) {
		if(beg<end) {
	int mid = (beg+end)/2;
		mergeRec(input, beg, mid, max);
		mergeRec(input, mid+1, end, max);
		merge(input,beg,mid, end,max);
	}
	}

	public void merge(int[] input, int beg, int mid, int end, int max) {
		int i=beg;
		int j=mid+1;
		int k = beg;
		while(i<= mid && j <= end) {
			if(input[i]%max < input[j]%max) {
				input[k] = input[k] + (input[i]%max)*max;
				i++;
				k++;
			}
			else {
				input[k] = input[k] +(input[j]%max)*max;
				j++;
				k++;

			}
		}
		while(i<= mid) {
			input[k] = input[k] + (input[i]%max)*max;
			i++;
			k++;

		}
		while(j<=end) {
			input[k] = input[k] + (input[j]%max)*max;
			j++;
			k++;

		}
		System.out.println("Before");
		Arrays.stream(input).forEach(elem -> System.out.print(elem + " "));
		for(int p=beg; p <=end ; p++) {
			input[p]=input[p]/max;
		}
		System.out.println("");
		System.out.println("After");
		Arrays.stream(input).forEach(elem -> System.out.print(elem + " "));
	}


  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = { 12, 11, 13, 5,  7 , 6}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.mergeSort(arr); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 