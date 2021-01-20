package linkedlist.examples;

import java.util.*;
class AddReverseList {
	public static void main(String args[]) {
		List<Integer> list1 = new LinkedList<Integer>();
		List<Integer> list2 =new LinkedList<Integer>();
		list1.add(4);
		list1.add(7);
		list1.add(1);
		list2.add(4);
		list2.add(9);
		List<Integer> result = new LinkedList<Integer>();

		System.out.println(list1);
		System.out.println(list2);
		Integer max = list1.size() > list2.size() ? list1.size():list2.size();
		Integer quotient =0;
		for ( int i=0; i<max; i++) {// 1->7->4      9->4 = 471+49 =  520
			Integer x = list1.isEmpty() ? 0 :list1.remove(0);
			Integer y = list2.isEmpty() ? 0:list2.remove(0);
			Integer resultAdd = x+y+quotient;   //10, 12,5
			Integer reminder = resultAdd % (int)Math.pow(10,1); //0,2,5
			quotient = resultAdd/(int)Math.pow(10,1); //1,1
			System.out.println(quotient);
			result.add(i,reminder) ; //0,2>
		}
		
		System.out.println(result);
		

	}	

}
