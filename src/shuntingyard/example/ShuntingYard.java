package shuntingyard.example;

import java.util.Stack;

public class ShuntingYard {
	//Split input into arr
	//Loop through arr and store to stack
	//Identify brackets
	//Perform operation
	
	public static void main(String[] args) {
		System.out.println(performShunting("(54+2)*3"));
	}
	
	public static Integer performShunting(String input) {
		char[] inputArr = input.toCharArray();
		Stack<Integer> operand = new Stack<Integer>();
		Stack<String> operator = new Stack<String>();
		Integer output;
		String accOerpand= "0123456789";
		String accOperator = "+-*/()";
		String collecNo = "";
		for(int i=0; i<inputArr.length; i++) {
			if (accOerpand.contains(String.valueOf(inputArr[i]))) {
				collecNo = collecNo + String.valueOf(inputArr[i]);
				System.out.println(collecNo);						
			}
			if (accOperator.contains(String.valueOf(inputArr[i]))) {	
				operand.push(Integer.parseInt(collecNo));	
				operator.push(String.valueOf(inputArr[i]));
				collecNo = "";
			}
		}
		if (!collecNo.equals("")) operand.push(Integer.parseInt(collecNo));
		output = performOperation(operand, operator);
		return output;
	}
	
	public static Integer performOperation(Stack<Integer> operand, Stack<String> operator) {

			int SecElem = operand.pop();			//4
			int firsElem = operand.pop();			//5
			String operatorSym = operator.pop();	//-
			Integer output=null;
			System.out.println(SecElem+operatorSym+firsElem);
			
			switch(operatorSym) {
			case "+" : output = firsElem + SecElem; break;
			case "-" : output = firsElem - SecElem; break;
			case "/" : output = firsElem / SecElem; break;
			case "*" : output = firsElem * SecElem; break;
			}
			
			
			if(!operand.isEmpty()) 
			{
				operand.push(output);			// -1, 3
				output = performOperation(operand, operator);
			}
			return output;
				
	}

}
