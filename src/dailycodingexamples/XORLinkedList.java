package dailycodingexamples;
/**
 * Daily Coding Problem: Problem #6 [Hard] 
An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields, it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list; it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.
If using a language that has no pointers (such as Python), you can assume you have access to get_pointer and dereference_pointer functions that converts between nodes and memory addresses.

**/

public class XORLinkedList {

	Node root, tail;
	static class Node{
		int value;
		Node next,prev;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	public void add(Node node){
		if(root == null){
			root = node;
			tail = node;
		} else{
		tail.next = node;
		tail.next.prev = tail;
		tail = tail.next;
		//Get tails and new nodes memory location
		// XOR it.. Curr ^ NextNode
		//To get back the next or prev element, 
		//get current xor'd value and then xor it with current position
		// Curr ^ NextNode ^ Curr = NextNode
		
		}
	}
	
	public void printElements(){
		if(root!=null){
			Node curr = root;
			while(curr!=null){
				System.out.println(curr.value);
				curr = curr.next;
			}
		}
	}
	
	public static void main(String args[]){
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		XORLinkedList list = new XORLinkedList();
		list.add(node1);
		list.add(node2);
		list.printElements();
		
		
	}
}
