package strings.examples;

import java.util.*;
public class LongestSubstring{
	public static void main(String args[]) {
	//String input = "aaabcdbbade";
	String input = "abcbdca";
	// counter array, increment it
	// if(counter=1 then erase counter and maxElem < currCount put as max elem
	// counter[elem] increment , cur count++;
	int[] counter = new int[128];
	int maxElem = 0;
	int currElem = 0;
	String resultString = "";
	int a=1;
	int b=1;
	for(char letter: input.toCharArray()) {
		if(counter[letter]>0 && counter[letter]<b && counter[letter]>=a){
			maxElem =maxElem < (b-a)?(b-a):maxElem ;
			a=counter[letter]+1;	//apoint=3, apoint=4
			//System.out.println("Apointer:"+a);
			resultString = input.substring(a-1,b-1);
			
		}
			
			counter[letter]=b;  //a=1, b=2, c=3, b=4, d=5, c=6, a=7
			b++;				//apoint=1; bpoin=2; bpoin=3; bpoin=4;apoint=3, bpoin=5;bpoin=6;
			//System.out.println("bpointer:"+b);
			
			
		
		
	}
	//System.out.println(currElem);
	if(maxElem < (b-a)) {
		maxElem = b-a;
		resultString = input.substring(a-1,b-1);
		
	}
	System.out.print("MaxEleme: "+ maxElem +", ResultString: " + resultString);

	}
}

