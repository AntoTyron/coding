package dailycodingexamples;

/*
Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
You can modify the input array in-place.
*/

import java.util.*;
class MissingPositiveInteger{
	public static Integer myApproachfindMissingPosInteger(List<Integer> arr){
		int negPos=0;
		for(int i=0; i<arr.size();i++){
			if( arr.get(i) <=0 ){
				Collections.swap(arr,i,negPos++);	
			}
		}
		for( int i=negPos; i<arr.size();i++) {
		 	while(arr.get(i) <= arr.size()-negPos && arr.get(i)!= i-negPos+1){
				Collections.swap(arr,arr.get(i),i);
			}
		}
		for(int i=negPos; i<arr.size();i++){
			if(arr.get(i)!=i-negPos+1){
				return i-negPos+1 ;
			}
		}
		return arr.size()-negPos+1;
	}
	
	public static Integer findMissingPosInteger(List<Integer> arr){
		int negPos=0;
		for(int i=0; i<arr.size();i++){
			if( arr.get(i) <=0 ){
				Collections.swap(arr,i,negPos++);	
			}
		}
		for( int i=negPos; i<arr.size();i++) {
			int x = Math.abs(arr.get(i));
		 	if(x <= arr.size()-negPos && x>0){
				arr.set(x, -arr.get(x));
			}
		}
		for(int i=negPos; i<arr.size();i++){
			if(arr.get(i)>0){
				return i-negPos+1 ;
			}
		}
		return arr.size()-negPos+1;
	}
	
	public static void main(String agrs[]){
		System.out.println(findMissingPosInteger(new ArrayList<Integer>(
											Arrays.asList(3,4,-1,1))));
	}
}
