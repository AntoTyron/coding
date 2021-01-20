package arrays.examples;

//{0,1,2,0,1,2}
//{0,0,1,1,2,2} -pivot 1
//{0,1,0,1,2,2} – pivot 2
//less than pivot
//{0,0,2,1,1,2}
//{0,0,1,1,22}

//less, equal, greater
//equalStart, equalEnd
//if(equalStart<=less || equalEnd>=greater
//if equal ++equalStart
//if less  swap(equalStart,less) and ++less
//if greater swap(equalEnd,greater)  –greater
import java.util.*;
class DutchProblem {
	public static void main(String args[]){
		//List[] arr= new int[6]{0,1,2,0,1,2};
		List<Integer> arr = Arrays.asList(0,1,2,0,3,2,1,1);
		System.out.println(arr);
		int less =0;
		int greater = arr.size()-1;
		int equalStart = less;
		int pivot = 1;
		while(equalStart<=greater) {
			if(equalStart<less) ++equalStart;
			if(arr.get(equalStart) == pivot) equalStart++;
			else if(arr.get(equalStart) < pivot) {
				Collections.swap(arr,equalStart,less);
				less++;
			}
			else if(arr.get(equalStart) > pivot) {
				Collections.swap(arr,equalStart,greater);
				greater--;
			}

		}
		
		System.out.println(arr);
	
	}

}

