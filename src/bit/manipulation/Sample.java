package bit.manipulation;
import java.util.*;
import java.util.stream.*;
public class Sample {
	
	public static void main (String args[]) {
		
		int num = 12;
		num = num<<32; // 12*2^n
		//num >>=5;
		System.out.println(num);
		
		//String a="reee";
		//a.toCharArray()
		
		//12/4 = 4*2=8 4*4=16  So take 8, 12-8 = 4
		//     4 * 1 = 4, matches. so 4+4
		//15/3 = 3*2 = 6, 3*4 =12, 3*8= 24, so 4 times
		// 3*1 =3
		//18/4 = 4*2=8  4*4=16 so 4 remaining 2
		//4*1
		
		List<String> arr = Arrays.asList("elvis","levis","anto");
		HashMap<String,List<String>> cache = new HashMap<String,List<String>>();
		for(String elem: arr) {
			String sortedStr = Stream.of(elem.split("")).sorted().collect(Collectors.joining());
			cache.computeIfAbsent(sortedStr, k ->  new ArrayList<String>()).add(elem);
		}
		cache.values().stream().filter( s -> s.size() >1).forEach(System.out::println);

	}

}
