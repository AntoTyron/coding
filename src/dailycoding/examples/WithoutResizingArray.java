package dailycoding.examples;

import java.util.HashMap;

//LinkedList
//need to makes sure I return true for correct values, 
//need to make sure that I can make mistakes
//Hash
//301 Medium
class WithoutResizingArray{
public static void main(String args[]) {
		MyArray myarr = new MyArray();
		myarr.add(4);
		myarr.add(5);
		myarr.add(7);
		System.out.println(myarr.check(4));
		System.out.println(myarr.check(7));
	}
}

class MyArray{
	public static Object[] arr = new Object[10];
	int hash=7;
	static class Node{
		Integer value;
		Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	 public void add(Integer input) {
		int hash = calculateHash(input);	
		int pos = hash%arr.length;
		System.out.println(hash+":"+pos);
		Node node = new Node(input);
		node.next = arr[pos] != null ? (Node)arr[pos]:null;		
		arr[pos]= node;
	}
	public boolean check(Integer input) {
		int hash = calculateHash(input);	
		int pos = hash%arr.length;
		System.out.println(hash);
		return arr[pos] !=null? true:false; 
	}
	public int calculateHash(Integer input) {
		return hash*13+input;
	}
	
	
}
