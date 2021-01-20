package tree.examples;
import java.util.*;

//2i-1, 2i+1   [1,2,null,3,null
class InorderTraverse {
	
	static class Node {
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
			this.left= null;
			this.right=null;
		}
	}
	public static void traverseInorder(Node node) {   
		Stack<Node> stack = new Stack<Node>();

		Node curr = node;
		
		while(curr!=null || stack.size()>0 ) {

			//stack.push(curr);
			while(curr!=null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			System.out.print(curr.data+"->");
			curr = curr.right;
		}
	}
	public static void traversePreOrder(Node node) {
		List<Node> queue = new LinkedList<Node>();
		Node curr = node;
		while(curr!=null || queue.size()>0) {
			while(curr!=null) {
				queue.add(curr);
				curr=curr.left;
			}
			curr= queue.remove(0);
			System.out.print(curr.data+"->");
			curr = curr.right;
		}
		
	}
	public static void traversePostOrder(Node node) {
		Stack<Node> stack = new Stack<Node>();
		Node curr = node;
		while(curr!=null || stack.size()>0) {
			//Node parentCurr = curr;
		while(curr!=null) {	
				if(curr!=null)stack.add(curr);
				if(curr.right!=null) stack.add(curr.right);
				if(curr.left!=null) stack.add(curr.left);
				curr = curr.left;
		}
			
			//if(parentCurr!=null)System.out.print(parentCurr.data+"->");
			curr=stack.pop();
			System.out.print(curr.data+"->");
			//curr = curr.right;
			
			
		}
	}
	
	public static void main(String args[]) {
		Node node1= new Node(1);
		node1.left = new Node(2);
		node1.right = new Node(3);
		node1.left.left = new Node(4);
		node1.left.right = new Node(5);
		node1.right.left = new Node(7);
		node1.right.right = new Node(6);
		traverseInorder(node1);
		System.out.println();
		traversePreOrder(node1);
		System.out.println();
		traversePostOrder(node1);
		
	}

}


