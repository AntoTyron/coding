package dailycodingexamples;

import java.util.Arrays;

class ProductOfElements{
	/** Not working
	public static int[] findProductOfElem(int[] arr){
		int leftMax=1,rightMax=1,leftPos=0,rightPos=arr.length-1;
		for( int i=0; i<arr.length; i++){
			int left =leftMax,right=rightMax;
			leftMax *=arr[leftPos];
			rightMax *=arr[rightPos];	
			if(leftPos == rightPos){
				arr[i] = left* right;				
			}
			else if(leftPos > rightPos){
				arr[rightPos] = right * (rightPos-1>0?arr[rightPos-1]:1);
				arr[leftPos] = left * (leftPos+1<arr.length?arr[leftPos+1]:1);
			}		
			leftPos++;
			rightPos--;
		}
		return arr;
	}
	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 5,1,2};
		//int[] arr = {10, 3, 5, 6 };
		findProductOfElem(arr);
		Arrays.stream(arr).mapToObj(k -> String.valueOf(k)+",").forEach(System.out::print);
	}**/
	public static void main(String args[]) {
		int[] arr = { 1, 2, 3, 4, 5,1,2};
		 final double EPS = 1e-9; 
		//int[] arr = {10, 3, 5, 6 };
		double result = Math.log10(2)+Math.log10(3);
		System.out.println(EPS + Math.pow(10.00, result-Math.log10(2)));
	}

}

