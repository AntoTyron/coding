package tree.examples;
/**
1
2	     3
1      0      5**/

//1,2,3,1,0,5,null
//null, add x
//2i-1, 2i+1
import java.util.*;

import tree.examples.ZigZag.Node;
class SerializeDeserialize{
static class Node {
	String data;
	Node left, right;
	public Node(String data) {
		this.data = data;
	}
}
public static String serialize(Node node){
	if(node ==null) {
		return null;
	}
	StringBuilder str = new StringBuilder();
	Node curr= node;
	List<Node> queue = new LinkedList<Node>();
	Boolean root=true;
	
	queue.add(curr);
	while(!queue.isEmpty()) {
		curr = queue.remove(0);
		String data = curr ==null? "x":curr.data;
		str.append( (root?"":",")+data);
		root=false;
		if(curr!=null) {
queue.add(curr.left);
		queue.add(curr.right);
		}
	}
	return str.toString();
}
//1, 2, 3, 4, 5, 6
public static Node deserialize(String str) {
	String[] input = str.split(",");
	
	
	if(input.length<0) return null;
	Node node = new Node(input[0]);
	
	int level = 0;
	deser(node,level, input);
	return node;
}
	private static void deser(Node node, int level, String[] input) {
	// TODO Auto-generated method stub
		if(node ==null || input.length<level) return;
		node.left = input[2*level+1].equals("x") ?null:new Node(input[2*level+1]);
		node.right = input[2*level+2].equals("x") ?null:new Node(input[2*level+2]);
		if (node.left!=null) deser(node.left,level+1,input);
		if(node.right!=null) deser(node.right,level+1,input);
	
}
	public static void printTree(Node node) {
			if(node==null) return;
			System.out.print(node.data+"->");
			printTree(node.left);
			printTree(node.right);
	}
	
	public static void main(String args[]) {
		Node node1 = new Node("1");
		node1.left = new Node("3");
		node1.right = new Node("4");
		node1.left.left= new Node("1");
		node1.right.left = new Node("6");
		node1.right.right = new Node("2");
		node1.left.left.left = new Node("7");
		node1.left.left.right = new Node("2");
		String str = serialize(node1);
		Node node2 = deserialize(str);
		System.out.println(str);
		printTree(node2);
		
	}
	

}
