package heap.priorityqueue.examples;

import java.util.*;
import java.lang.*;
import java.io.*;
class FindKElements {
	public static void main (String args[] ) {
		List<Integer> input = Arrays.asList(5,6,1,8,10,4,3,51,57);
		int k = 5;
		// Find maximum k elements
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for ( int i=0; i<input.size(); i ++) {
			if (i<5) {
				pq.add(input.get(i));
			}
			else{
				if(pq.peek() < input.get(i)) {
					pq.poll();
					pq.add(input.get(i));
				}
			}
		}
		ArrayList<Integer> sortedList = new ArrayList<Integer>(pq);
		Collections.sort(sortedList, Collections.reverseOrder());
		System.out.print(sortedList);
	}
}

