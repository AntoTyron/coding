package sort.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
	
	public static void main(String args[]) {
		
		List<String> input = Arrays.asList("10","2","90","9");
		Collections.sort(input, new Comparator<String>(){
			@Override
			public int compare(String a, String b){
				String ab = String.valueOf(a)+String.valueOf(b);
				String ba = String.valueOf(b)+String.valueOf(a);
				return ab.compareTo(ba)>0?-1:1;
			}
			
		});
		
		input.forEach(key -> System.out.print(key));
		
	}

}
