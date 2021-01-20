package tree.examples;

import java.util.*;

//inorder
//increment elem until reaches k

class KElement {
public static Integer count=0;
static class Node {
int data;
Node left, right;
public Node(int data) {
	this.data = data;
}
}
public static List<Integer> kElement(Node node, Integer k) {
if(node == null) return null;
List<Integer> kElemList = new ArrayList<Integer> ();
recurseElem(node, k,kElemList);
return kElemList;
}
public static void recurseElem(Node node, Integer k, List<Integer> kElemList ) {
if(node!=null  && kElemList.size()<k) {
	recurseElem(node.left, k,kElemList);
	if(kElemList.size()<k) {
		kElemList.add(node.data);
		recurseElem(node.right, k,kElemList);
	}

}
}

public static void main(String args[]) {
	Node node1= new Node(8);
	node1.left = new Node(4);
	node1.right = new Node(9);
	node1.left.left = new Node(3);
	node1.left.right = new Node(7);
	node1.left.left.left = new Node(2);
	System.out.println(kElement(node1,4));
	
}
}	
