package honorclass.examples;
import java.util.*;
public class LeftRight {
	static class Node{
		int val=0,totalElem=0;
		Node left,right;
		public Node(int val){
			this.val=val;
		}
	}
	static class Rule{
		int left,right;
		public Rule(int left, int right){
			this.left = left;
			this.right =right;
		}
	}
	public static Node arrangeAccordingToRule(List<Rule> rules){
		Node dummyHead = new Node(0);
		int totalElem=0;
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		for(Rule rule: rules){
			map.putIfAbsent(rule.left, new Node(rule.left));
			map.putIfAbsent(rule.right, new Node(rule.right));
			Node left = map.get(rule.left), right = map.get(rule.right);
			if(map.size()<=2){
				dummyHead.right = left;
			}
			if(left.right == null && right.left == null){
				left.right = right;
				right.left = left;
				totalElem+=2;
			}
			else{
				//if(!check satisfies condiiton) {
					Node rightPrev = right.left;
					if(left.right!=null) left.right.left = left.left;
					if(left.left!=null) left.left.right = left.right;
					if(right.left!=null) right.left.right = right.right;
					if(right.right!=null) right.right.right = right.left;
					right.left = left;
					left.right = right;
					left.left = rightPrev;					
				//}
			}
			
		}
		
		return dummyHead.right;
	}
	
	public static void printNodes(Node node){
		if(node==null){ System.out.println("No element");return;}
		Node start = node,slow=node,fast=node.right;
		while(slow!=null && fast!=null && slow.right!=null && fast.right!=null){
			if(slow == fast){ System.out.println("Rules do not satisfy");return;}
			slow= slow.right;
			fast= fast.right.right;
		}
		
		while(start!=null){
			System.out.print(start.val + "->");
			start = start.right;
		}
	}
	
	public static void main(String agrs[]){
		Rule rule1= new Rule(1,3);
		Rule rule2= new Rule(3,2);
		//Rule rule3= new Rule(2,3);
		Node node=arrangeAccordingToRule(Arrays.asList(rule1,rule2));
		printNodes(node);
		
	}

}
