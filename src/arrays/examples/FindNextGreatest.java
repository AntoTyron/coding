package arrays.examples;

import java.util.*;
import java.lang.*;

class FindNextGreatest {
	public static void main(String args[]) {
		List<Integer> input  = Arrays.asList(3,1,4,6,5,8,7);
		List <Integer> sortedList = new ArrayList<Integer>();
		Integer maxElem=0 ;
		Integer prevElem =0;
		for(int i = input.size()-1; i>=0 ; i--) {
			if(sortedList.isEmpty() || maxElem == input.get(i)) {
				maxElem = input.get(i);
				prevElem= maxElem;
				sortedList.add(-1);
				continue;
			}
			if(maxElem< input.get(i)) {
				maxElem = input.get(i);
				prevElem= maxElem;
				sortedList.add(-1);
				continue;
			}
			else if ( input.get(i) < prevElem) {
				maxElem = prevElem;
			}
			prevElem= input.get(i);
			sortedList.add(maxElem);
		}
		Collections.reverse(sortedList);
		System.out.println(input);
		System.out.println(sortedList);
	}
}

