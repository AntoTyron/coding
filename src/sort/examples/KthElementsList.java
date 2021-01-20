package sort.examples;

import java.util.*;
import java.util.stream.*;
public class KthElementsList {

	public static List<Integer> findElement(List<Integer> arr, int k) throws Exception{		 
        assert arr.size()<k : new Exception("Does not have an element in "+k+"th position.");
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for(Integer elem: arr){        	
        		queue.add(elem);        		
        		if(queue.size()==k+1){
        			queue.remove();
        		}
        		
        	
        }
        System.out.println(queue);
        
        // return Stream.generate(queue::remove).limit(queue.size()).collect(Collectors.toList());
         return queue.stream().collect(Collectors.toList());
	}
	
	public static void main(String args[]){
		try{
		System.out.println(findElement(Arrays.asList(1,9,5,3,4,9,0,1), 3));
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
