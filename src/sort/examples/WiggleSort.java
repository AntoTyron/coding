package sort.examples;

//<
//=
//> 
//flag
import java.util.*;
class WiggleSort{
public static void printWiggleSort(List<Integer> arr) {
	int prevSmallest=-1, b=0,c=1;
	boolean even = true;
	for( int i=0; i< arr.size()-1; i++) {
		if(arr.get(b)==arr.get(c) && prevSmallest>=0) {
			Collections.swap(arr,prevSmallest,c);
		}
		if((even && arr.get(c)<arr.get(b)) || (!even && arr.get(c) >arr.get(b))){
		 	Collections.swap(arr,b,c);
		}
		c++;b++;
		prevSmallest = even?prevSmallest+1: prevSmallest;
		even = !even;
	}

}

public static void printWiggleSort2(List<Integer> arr) {
	
	for ( int i=1; i< arr.size(); i+=2){
		
		if(arr.get(i-1)>=arr.get(i)){
			Collections.swap(arr, i, i-1);
		}
		if(i+1<arr.size() && arr.get(i)<=arr.get(i+1)){
			Collections.swap(arr, i, i+1);
		}
	}
}

public static void main(String args[]) {
	
	//List<Integer> arr =new ArrayList<Integer>(Arrays.asList(1,3,2,2,3,1));
	List<Integer> arr =new ArrayList<Integer>(Arrays.asList(1,2,1,2,1,2,1,1,1,2,2,2));
	//List<Integer> arr =new ArrayList<Integer>(Arrays.asList(2,5,2,2,1,4));
	printWiggleSort2(arr);
	System.out.println(arr);
}

}

