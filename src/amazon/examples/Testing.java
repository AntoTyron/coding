package amazon.examples;

import java.util.stream.*;

public class Testing {
	
	public static void main(String agrs[]){
		String input="HelloWorld";
		char[] inputChar = input.toCharArray();
		for(char i:inputChar){
			System.out.println(i);
		}

		System.out.println(input.
				chars().mapToObj(i -> {int s=(char)i; return (char)s; })
				.map(Object::toString)
				.
				.collect(Collectors.joining());
	}

}
