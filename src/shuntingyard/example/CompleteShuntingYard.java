package shuntingyard.example;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class CompleteShuntingYard {

		//Input:    3+4*5
		//Take first elem check if operand -> push to queue else operator -> pop last elem and check if this is of higher precedence. if (higher predence push that elem to queue and new elem to stack else push to queue. If it reaches ) pop all elem out into queue until )
	//After postfix is setup push to the stack and if reaches and operator get last pop as 2nd elem and next pop as first perform and save it to the stack
	 
		public static Integer performShunting(String input) throws Exception {
			char[] inputChar = input.toCharArray();
			Stack< String > stack = new Stack<String>();
			Queue< String > queue = new LinkedList<String>();
			String collectChar = "";
			for ( int i=0; i<inputChar.length; i++ ) {
				if(isOperator(String.valueOf(inputChar[i]))) {
					if(collectChar !=null && !collectChar.equals("") ) {
						queue.add(collectChar);
						collectChar="";
					}
					if(!stack.isEmpty()){
						String prevOp = stack.pop();
						while(prevOp != null && higherPrecedence(prevOp, String.valueOf(inputChar[i]))) {
							queue.add(prevOp);
							if(!stack.isEmpty()){
								prevOp = stack.pop();
							}else{
								prevOp=null;
							}
						} 
					
					stack.push(prevOp);
					}
					stack.push(String.valueOf(inputChar[i]));				
				}
				else if (isOperand(String.valueOf(inputChar[i]))) {
					collectChar +=inputChar[i];
				}
				else {
					throw new Exception("Not allowed character");
				}
				
			}
			if(!collectChar.equals("")) {
				queue.add(collectChar);
			}
			while(!stack.isEmpty()) {
				queue.add(stack.pop());
			}
			//return postfixExecution(queue);
			
			queue.forEach(System.out::println);
			
			return 0;
			
		}

		public static boolean isOperator(CharSequence elem) {
			String operator = "+-*/^()";
			return operator.contains(elem);
		}

		public static boolean isOperand(CharSequence elem) {
			String operand = "0123456789";
			return operand.contains(elem);
		}


		public static boolean higherPrecedence(String prev, String curr){
			Map<String, Integer> precedenceChecker = new HashMap<String, Integer>();
			precedenceChecker.put("+", 1);
			precedenceChecker.put("-", 1);
			precedenceChecker.put("*", 2);
			precedenceChecker.put("/", 2);
			precedenceChecker.put("^", 3);
			int prevPrec = precedenceChecker.get(prev);
			int currPrec = precedenceChecker.get(curr);
			return prevPrec>=currPrec? false: true;
		}
		
		public static void main(String args[]) {
			try{
			performShunting("3+4*5");
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}
