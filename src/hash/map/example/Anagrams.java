package hash.map.example;

import java.util.*;
import java.util.stream.*;
class Anagrams{
	public static List<List<String>> getAnagrams(List<String> dict) throws Exception{
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		if(dict == null || dict.size()<=0)  throw new Exception("No element found");
		for(String elem: dict) {
			String slist = Stream.of(elem.split("")).sorted().collect(Collectors.joining());
			map.putIfAbsent(slist, new ArrayList<String>());
			map.get(slist).add(elem);
		}	
		return map.values().stream().filter(group -> group.size()>1).collect(Collectors.toList());
	}
	
	public static final int MULT =997;
	public static int hashString(String s, int modulus) {
		return s.chars().reduce(0, (val,c)-> ((val* MULT)+c)%modulus);
	}

	public static void generateAnagrams(List<String> s) {
		HashMap<String,List<String>> map = new HashMap<String,List<String>>();
		for(String elem: s) {
			String sortedString = Stream.of(elem.split("")).sorted().collect(Collectors.joining());
			
			map.computeIfAbsent(sortedString, k -> new ArrayList<String>()).add(elem);
		}
		map.values().stream().filter(e -> e.size()>1).forEach(System.out::println);

	}

	
	public static void main(String args[]) {
		try {
			//System.out.println(getAnagrams(Arrays.asList("elvis","lives","levis","silent","listen", "anto")));
			generateAnagrams(Arrays.asList("elvis","lives","levis","silent","listen", "anto"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
