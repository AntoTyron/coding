package sort.examples;

//{2,3,3,5,5,6,7,7,8,12} ->  2,3,5,6,7,8,12   ->5,6,8,9,10

//{5,5,6,8,8,9,10,10}
//Can I alter the list?  Remove all duplicates
//Do I need to return in a sorted order

//smallest one on outer loop, biggest on the inner
//first, last, if between then binary search
import java.util.*;

class ComputeIntersection {
	public static List<Integer> findIntersection(List<Integer> A, List<Integer> B) {
		if(A.size()==0 || B.size()==0) return null;
		List<Integer> intersectionAB = new ArrayList<Integer>();
		//If the Arrays are equals O(m+n)
		if(A.size() == B.size() ) {
			int i=0;
			int j=0;
			while(i<A.size() && j<B.size()) {
				if(((i==0) || !A.get(i).equals(A.get(i-1))) &&
					A.get(i).equals(B.get(j))) {
					intersectionAB.add(B.get(j));
					i++;
					j++;
				} 
				else if(A.get(i) < B.get(j)) i++;
				else j++;
			}
		}
		else{ //If Arrays are different size O(nlogm)
			List<Integer> small = A.size() > B.size()? B: A;
			List<Integer> big = A.size()> B.size()? A: B;
			int i=0;
			while(i< small.size()){
				if((i==0|| !small.get(i).equals(small.get(i-1))) &&
				Collections.binarySearch(big,small.get(i))>=0) {
					intersectionAB.add(small.get(i));
					
				}
				i++;
			}
		}
		return intersectionAB;
		
	}
	
	public static void main(String args[]) {
		
		System.out.println(findIntersection(Arrays.asList(2,3,3,5,5,6,7,7,8,12),
					Arrays.asList(5,5,6,8,8,9,10,10,11,12)));
	}
}

