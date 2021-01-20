package linkedlist.examples;

import java.util.*;

//1->2->3->4->5->6    2->4->5->6->
//Can there be an example 1->2->3->4->5  2->3
//There will be split after they have joined?
class IntersectionNode {
Node head;
static class Node{
	int value;
	Node next;
	public Node(int data) {
		this.value=data;
		this.next = null;
	}
	
}

public int intersectionNode(Node node1, Node node2) {
	int output=0;
	Node lastnode1= node1;
	Node lastnode2=node2;
	HashMap<Integer,Integer> values = new HashMap<Integer,Integer>();
	if(lastnode1==null || lastnode2==null) {
		return output;
	}
	while(lastnode1!=null || lastnode2!=null) {      //1, 5, 6, 7  :   3,7
		int node1Value = (lastnode1==null)?-1:lastnode1.value;
		int node2Value = (lastnode2==null)?-1:lastnode2.value;
		if(node1Value == node2Value ) return lastnode1.value;
if(values.containsKey(node1Value) && values.get(node1Value)==2) return lastnode1.value;

if(values.containsKey(node2Value) && values.get(node2Value)==1) {
		return lastnode2.value;
}
		if(lastnode1!=null) values.put(lastnode1.value,1);
		if(lastnode2!=null) values.put(lastnode2.value,2);  //1,3,5,7
		lastnode1 = lastnode1 == null ? null:lastnode1.next;	
		lastnode2 = lastnode2 == null? null: lastnode2.next;	
	}
	return output;
}

public static void main(String args[] ) {
IntersectionNode list = new IntersectionNode();

	Node node1 = new Node(1);
	
	//list.head = node1;
	node1.next =  new Node(2);
	node1.next.next = new Node(3);
node1.next.next.next = new Node(4);
node1.next.next.next.next = new Node(5);
node1.next.next.next.next.next = new Node(6);

node1.next.next.next.next.next.next = new Node(5);

Node node2 = new Node(12);
	
	//list.head = node1;
	node2.next =  new Node(15);
	System.out.println(list.intersectionNode(node1,node2));
}
}

