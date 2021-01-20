package linkedlist.examples;

//Odd, even
//1   =1
//1->2 =1->2
//1->2->4 = 1->4->2  == 1-> 2->
//1->2->4->5->4 == 1->2 == 2->4 , 4->2 == 2->5 == 5->4, 4->5, 4->2
//keep track of last odd
//node.head -> node.head.child.child
//curr.next = next.next
//next.next = curr
//lastodd.next = next
import java.util.*;
class ReorderLinkedList {
	Node head;
	static class Node {
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}
	public ReorderLinkedList(Node head) {
		this.head = head;
	}
	public void reorderEvenOdd(){
		if(head == null || head.next==null) {
			return;
		}
		Node lastOdd = head;
		Node curr = head;
		Node second = head.next;
		int row=1;
//node.head -> node.head.child.child
//curr.next = next.next
//next.next = curr
//lastodd.next = next
//1->2->4->5->4 == 1->2 == 2->4 , 4->2 == 2->5 == 5->4, 4->5, 4->2
		Node temp;

		while(second !=null) { //1->2->3->4->5->7     1->2->3
			if(row%2==0) {
				curr.next = second.next;
				second.next = lastOdd.next;
				lastOdd.next = second;
				lastOdd = second;
				second = curr;
			}
			
				temp = second.next;
				curr = second;
				second = temp;
			
			row++;
		}
		
	}
	public void printList(){
		Node curr = head;
		while(curr!=null) {
		System.out.print(curr.value+"->");
		curr = curr.next;
		}
	}

	public static void main(String args[] ) {
		Node node1 = new Node(1);
		ReorderLinkedList list = new ReorderLinkedList(node1);
		//list.head = node1;
		list.head.next =  new Node(2);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(5);
		list.head.next.next.next.next.next = new Node(6);
		//list.head.next.next.next.next.next.next = new Node(7);
		list.reorderEvenOdd();
		list.printList();
	}

}
