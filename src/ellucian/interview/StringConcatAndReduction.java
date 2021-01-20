package ellucian.interview;

//  aabcccabba -> cabba  aabcc = cacc
// There is a match, increment both pointer
// No match , stop at that point
// Or can match with previous string


import java.util.*;
public class StringConcatAndReduction {
	
	public static void main(String args[]) throws Exception{
		
		String input = "aabcccabba";
		if(input==null || input.isEmpty()) throw new Exception("No input given");
		int mid = input.length()/2-1;
		int rIndex = input.length()-1;
		int lIndex = 0;
		Character compStr='1';
		
		while(lIndex<=mid && rIndex>mid) {
			Character right = input.charAt(rIndex), left = input.charAt(lIndex);			
			if(right == left){
				rIndex--;lIndex++;
				compStr = right;
			}
			else if(right == compStr){
				rIndex--;
			}
			else if(left == compStr){
				lIndex++;
			}
			else{
				break;
			}
			
		}
		
		System.out.println((mid-lIndex)+(rIndex-mid)+1);
	}

}
