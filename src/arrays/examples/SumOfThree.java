package arrays.examples;

//[-1, 	0,	1,	-1,	2]
import java.util.*;
class SumOfThree {
	public static void main(String args[]) {
		List<Integer> input = Arrays.asList(-1,0,1,-1,2,7,-6,-1);
		
//Sort the Array
		Collections.sort(input);    //[-1,	-1,	0,	1,	2]

		for( int i=0; i<input.size()-2; i++) {
		Integer first = i+1;
		Integer last = input.size()-1;
//if I are the same don’t do it
		if(i>0 && input.get(i) == input.get(i-1)) {
			continue;
		}
		if(input.get(i)>0) {
			break;
}
		
//i=-1, first=-1, last=2 , add all if =0 print else if result<0 first++, result>0 last--; 
		while(last>first) {
//Stop if last<first
			int result = input.get(i) + input.get(first) + input.get(last);
			//System.out.println(result);
			if(result ==0 ) {
				System.out.println(input.get(i)+","+input.get(first)+","+input.get(last));
				first++;
				last--;
			}
			else if (result <0 ) {
				first++;
			}
			else if(result >0) {
				last --;
			}
		}
		}

}	
}


