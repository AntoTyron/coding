package tree.examples;

/**3
4		5
1	    null      6		2
7	    2                     12    11	          9	      10
Ouput: 3,4,5,1,null,6,2
Preordder: 3,4,1,null,5,6,2
Inorder: 1,4,null,3,6,5,2
PostOrder: 1,null,4,6,2,5,3
**/

//Queue:    3     4,5     1,null,6,2     7,2,12,11,9,10
//Stack:  4,5      7,2,12,11,9,10
//Queue:   
//Queue: 3,5,4, 1,null,6,2    10,9,11,12,2,7
import java.util.*;
class ZigZag{
static class Node {
public int data;
public Integer level;
public Node left;
public Node right;
public Node(int data) {
this.data=data;
this.level = null;
this.left =null;
this.right = null;
}	
}
public static void printZigZag(Node node) {
if(node==null || (node.left ==null && node.right ==null)) return;
List<Node> queue = new LinkedList<Node>();
Stack<Node> stack = new Stack<Node>();
node.level=1;
queue.add(node);
while(queue.size()>0) {
Node root = queue.remove(0);
Node left = root.left;
Node right = root.right;
if (left != null) {
left.level = root.level+1;
queue.add(left);
}
if(right != null){
right.level = root.level+1;
queue.add(right);
}	// 4,5     [1, 6,2]     [7,2
//System.out.println("root.level"+root.level%2);
if(root.level%2 == 1) {
	while(stack.size()>0) {
		System.out.print(stack.pop().data+"->");
	}
System.out.print(root.data+ "->");	//3 ,5,4, 1
}
else {
	stack.push(root);			// 4,5 
}
}
while(stack.size()>0) {
System.out.print(stack.pop().data+"->");
}

}

//Read root, set level=I , 
//read  from queue , get left, right = set levele+1  , if root.level=1 print it else stack and then print it
//Loop until queue is empty

public static void main(String args[]) {
	Node node1 = new Node(1);
	node1.left = new Node(3);
	node1.right = new Node(4);
	node1.left.left= new Node(1);
	node1.right.left = new Node(6);
	node1.right.right = new Node(2);
	node1.left.left.left = new Node(7);
	node1.left.left.right = new Node(2);
	printZigZag(node1);
}


}

