package sort.examples;

//find pivot = k
//sort the element
//6,7,8,4,9,2,1   pivot=4
//1,7,8,4,9,2 6
//1  7,8,4,9,2  6
//1 2,8,4,9  7,6
//1,2  8,4,9   7,6
//1,2  9,4     8,7,6
//1,2, 4  9,8,7,6
//pivot<k
//9,8,7,6
//6,8,7  9
//6 8,7 9
//6,7  8  9
//pivot>k

import java.util.*;
class KthElement{
	public static Integer findKthLargestElement(List<Integer> arr, int k){
		
		return findKthElem(arr, k, (a,b)->Integer.compare(a,b));		

	}
	
	public static Integer findKthElem(List<Integer> arr, int k, Comparator<Integer> cmp) {
		Random rdm = new Random(0);
		int left=0, right=arr.size()-1;
		
		while(left<=right){
			int pivotIndx = rdm.nextInt(right -left +1)+left;
			int newPivotIndx = partitionPivot(arr,left,right,pivotIndx);
			if(newPivotIndx == k-1) {
				return arr.get(newPivotIndx);
			}
			else if (newPivotIndx <k-1) {
				left = newPivotIndx+1;
			}
			else{
				right = newPivotIndx-1;
			}
		}
		return null;
	}
	
	public static Integer partitionPivot(List<Integer> arr, int left, int right, int pivotIndx){
		int newPivotIndx = left;
		int pivotValue= arr.get(pivotIndx);
		Collections.swap(arr, pivotIndx, right);
		
		for(int i=left; i <right; i++) {
			if(arr.get(i)<pivotValue){
				Collections.swap(arr, i, newPivotIndx++);
			}
		}
		Collections.swap(arr, newPivotIndx, right);
		return newPivotIndx;
	}
	
	public static Integer findKthLargestUnkownSize(Iterator<Integer> stream, int k){
		ArrayList<Integer> result =new ArrayList<Integer>(2*k-1);
		while(stream.hasNext()){
			int value = stream.next();
			result.add(value);
			if(result.size() == (2*k-1)){
				findKthLargestElement(result,k);
				result.subList(k, result.size()).clear();
			}
		}
		return findKthLargestElement(result,k);
	}
	
	public static void main(String args[]){
		
		System.out.println(findKthLargestElement(new ArrayList<Integer>(Arrays.asList(1,9,5,3,4,2,2,10,15,20,4,3,67,4,34,55,12,43)), 10));
		System.out.println(findKthLargestUnkownSize(new ArrayList<Integer>(Arrays.asList(1,9,5,3,4,2,2,10,15,20,4,3,67,4,34,55,12,43)).iterator(), 10));
													//0,1,1,3,4,5,9,9
		
	}

}

