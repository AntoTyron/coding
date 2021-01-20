package dailycodingexamples;

/**
Daily Coding Problem: Problem #8 [Easy]
A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
Given the root to a binary tree, count the number of unival subtrees.
For example, the following tree has 5 unival subtrees:
   0
  / \
 1   0
    / \
   1   0
  / \
 1   1
**/
class NumberUnivalSubTrees{
 static class TreeNode{
	int val;
	TreeNode left, right;
	public TreeNode(int val){
		this.val= val;
	}
  }
public static Integer numberUnivalSubTrees (TreeNode tree) {
	if( tree == null) { return 0;}
	Integer count=0;
	count += numberUnivalSubTrees(tree.left);
	count += numberUnivalSubTrees(tree.right);
	if (( tree.left ==null && tree.right==null) ||( tree.left!=null && tree.right!=null &&
				tree.left.val== tree.val && tree.right.val == tree.val )){
		++count;
	}
	return count;
}
public static void main(String args[]){
	TreeNode tree = new TreeNode(0);
	tree.left = new TreeNode(1);
	tree.right= new TreeNode(0);
	tree.right.left = new TreeNode(1);
	tree.right.right = new TreeNode(0);
	tree.right.left.left = new TreeNode(1);
	tree.right.left.right = new TreeNode(1);
	System.out.println(numberUnivalSubTrees(tree));
	
	TreeNode tree2 = new TreeNode(1);
	tree2.left = new TreeNode(1);
	tree2.right= new TreeNode(1);
	System.out.println(numberUnivalSubTrees(tree2));
}
}

