package tree.examples;

// IS it a full binary tree
// With just one node, then I return if number return number else none
//Can an operator be on the leaf
//My numbers can be of any range, there can be decimals
//Post order traversal
//+-*/, there wouldn’t be any braces

//      *
//     /     \
  // 1        2

//traverse through the tree
//switch for the operator on the root node
class ArithmeticExecutor {
	public class Node {
		private String data;
		private Node left;
		private Node right;
		public Node(String data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right; 
		}
		public void setLeft(Node left) {
			this.left =left;
		}
		public void setRight(Node right) {
			this.right =right;
		}

		public Node getLeft() {
			return this.left;
		}
		public Node getRight() {
			return this.right;
		}
		public String getData() {
			return this.data;
		}

	}
	public class Tree{
		private Node root;
		public Tree(Node root) {
		  this.root = root;
		}

		public int performOperation() {
				//Post order traversal – left, right, root
				//At the root check for operator and perform operation
				return traverse(root);   //*
		}
		public boolean isOperator(Node node) {
			if(node.getData() == "*" || node.getData() == "+" || node.getData() == "-" 
								|| node.getData() == "/") {
			return true;
			}
			return false;
		}

		public Integer traverse(Node node) {   //* , 1
			if (node == null || (node.getLeft() == null && node.getRight() ==null && isOperator(node))) {  
				return null;
			}
			else if (node.getLeft() == null && node.getRight() ==null && !isOperator(node)) {
				return Integer.valueOf(node.getData());
			}
			int left = traverse(node.getLeft());     //1
			int right = traverse(node.getRight());
			Integer result = null;
			switch (node.getData()) {
				case "+":
				   result = left + right;
			    break;
				case "-":
			  	   result = left - right;
			    break;
			
				case "*":
			                 result = left * right;
			    break;
			
				case "/":
				 // if(right!=0) {
				   result = left / right;
				  //}else {
					//throw ArithmeticException("Cannot divide by zero);
				//}
			}
			return result;
			
		}	
	}
	public static void main(String args[]) {
		ArithmeticExecutor ae = new ArithmeticExecutor();
		ArithmeticExecutor.Node node1 = ae.new Node("/", null, null);
		ArithmeticExecutor.Node node2 = ae.new Node("8", null, null);
		ArithmeticExecutor.Node node3 = ae.new Node("12", null, null);
		ArithmeticExecutor.Tree tree = ae.new Tree(node1);
		node1.setLeft(node2);
		node1.setRight(node3); // 10 min just to implement
		int result = tree.performOperation();
		System.out.print("result"+result);
	}
}

