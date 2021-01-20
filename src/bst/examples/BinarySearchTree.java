package bst.examples;

import java.util.Arrays;

public class BinarySearchTree {
	// Trees: ! root and 0 or more childs. WE use recursion to traverse through the tress(Inorder, preorder, postoder). They are always directed and acylic, flowing in from top to bottom direction.

	//Binary Search Tree: Always in sorted order.
	// Insert : Start with the root
	//Add elements based on the x< root add to left else right.
	//Condiitons: Node is null, add there
	//Search: Node is null, return false, if node==value return true, node<root go left, node>right go right

	class Node {
		private Integer data;
		private Node left;
		private Node right;
		public Node(Integer data) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public Integer getData(){
			return this.data;
		}

	public Node getLeft(){
			return this.left;
		}
	public Node getRight(){
			return this.right;
		}
		public void setRight(Node node) {
			this.right= node;
		}
		public void setLeft(Node node) {
			this.left = node;
		}
		
	}
	//Binary Search Tree: Always in sorted order.
	// Insert : Start with the root
	//Add elements based on the x< root add to left else right.
	//Condiitons: Node is null, add there
	//Search: Node is null, return false, if node==value return true, node<root go left, node>right go right

	class BST {
		private Node root;
		public BST(Node root) {
			this.root = root;
		}
		public void insert (Integer input) {
			if(this.root == null) {
				this.root = new Node(input);
			} else {
				insertNode(this.root, input);
			}
		}
	public void insertNode (Node node, Integer input) {
	if (input < node.getData()) {
		if(node.getLeft() ==null) {
			node.setLeft(new Node(input));
		}
		else {
			insertNode(node.getLeft(), input);
		}
			}
	else {
		if(node.getRight() ==null) {
			node.setRight(new Node(input));
		}
		else {
			insertNode(node.getRight(), input);
		}
	}
		}

		public boolean find(Integer value) {
			if(this.root == null) {
				return false;
			}
			else{
				return searchChild(this.root, value);
			}
		}
		public boolean searchChild(Node node, Integer value) {
			if(node.getData() ==value) {
				return true;
			}
			else if(value < node.getData()) {
				if(node.getLeft() ==null) {
					return false;
				}
				else {
					return searchChild(node.getLeft(),value);
				}
			}
	else {
				if(node.getRight() ==null) {
					return false;
				}
				else {
					return searchChild(node.getRight(),value);
				}
			}

		}
		
		//Find the element
				//Get Left node, if left node ==null then take the parent and see if it is greater than child and return it
			//IF left not present recursive into the right most node, node is null return, got tonode.right, node has value = return value;
				//Get Right node if right node is null take just the parent and see if it is lesser than child
			//IF left not present recursive into the left most node, node is null return, got to node.left, node has value = return value;

				public Integer[] findFloorCeiling(Node parent, Integer value, Integer floor, Integer ceiling){
					if(parent == null) {
						return new Integer[]{floor,ceiling};
					}
					if(parent.getData() == value) {
						return new Integer[]{value,value};
					}
					Integer[] floorCeiling = null;
					if(value < parent.getData()) {
						floorCeiling= findFloorCeiling(parent.getLeft(),value,floor, parent.getData());
					}
		else if(value > parent.getData()) {
						floorCeiling= findFloorCeiling(parent.getRight(),value, parent.getData(),ceiling);
					}
					return floorCeiling;
				}

					public Integer[] findTopBottom(Integer value) {
						
						return findFloorCeiling(this.root, value, null, null);
					}
		
	}
	
	
	
	
	
	public static void main(String args[]) {
			BinarySearchTree bst = new BinarySearchTree();
		
			Node node1= bst.new Node(6);
			
			BST b = bst.new BST(node1);
			b.insert(6);
			b.insert(2);
			b.insert(7);
			b.insert(3);
			b.insert(4);
			
			System.out.println(b.find(5));		
			
			Arrays.stream(b.findTopBottom(5)).forEach(System.out::println);
	}




}

