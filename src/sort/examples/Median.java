package sort.examples;

//For even 1   1,2    1,2,3   1,2,3,4    1,2,3,4,5
//For odd
//index going halfway through
import java.util.*;
class Median {
	static class Node{
		int val;
		Node next;
		public Node(int val){ this.val=val;}
		public Node(int val, Node next) { this.val=val; this.next = next;}
	}
	public static Double medianOfArrays(Node arr1, Node arr2){
		// 1,3      2
		Node curr = new Node(0,null);
		Node L1 = arr1, L2 =arr2;     //L1=1, L2=2, curr=0
		int count=1;
		Node median = curr;
		while(L1!=null && L2!=null) {
			if(L1.val< L2.val) {
				curr.next = L1;
				L1 = L1.next;  //1. L1=2, L2=2
			}
			else{
				curr.next = L2;
				L2 = L2.next;
			}
			curr = curr.next;		//1. L1=3, L2=2, curr=1  2.  L1=3, L2=null, curr=1

			if(!isEven(count)){ median = median.next;}
			count++;
		}
		curr.next = L1==null? L2: L1;
		while(curr.next!=null) {	
			curr= curr.next;		
			if(!isEven(count)){ median = median.next;}			
			count++;
		}
		double result=0;
		if(isEven(count-1) && median.next!=null) {
			result = (float)(median.val+ median.next.val)/2;
		} else if(!isEven(count-1)){
			result = median.val;
		}
		return result;
	}	
	public static boolean isEven( int count) {
		return count%2==0;
	}
	
	public static void main(String agrs[]) {
		
		Node node1 = new Node(0);
		node1.next = new Node(0);
		Node node2 = new Node(1);
		//node2.next = new Node(0);
		System.out.println(medianOfArrays(null, node2));
		
	}

}

