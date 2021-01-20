package java8.examples;

import java.util.*;
import java.util.stream.Collectors;
public class Examples {
	
	public static void main(String args[]) {
		
		List<Integer> input = new ArrayList<Integer>();
		input.add(1);
		//input = null;
		//Optional status = Optional.ofNullable(input);
		
		//Function key;
		List status = Optional.ofNullable(input).orElseGet(Collections::emptyList)
				.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
		
		System.out.println(status);
	}
}
