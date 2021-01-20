package strings.examples;
import java.util.*;

public class GroupAnagrams {

	public static List<List<String>> groupAllAnagrams(String[] input) {

		List<List<String>> groupedAnagrams = new ArrayList<List<String>>();

		HashMap<String,List<String>> visited = new HashMap<String,List<String>>();
		
		for(String word: input) {

			char[] characters = word.toCharArray();
			Arrays.sort(characters);
			String newWord = new String(characters);
			if(!visited.containsKey(newWord)) {
				visited.put(newWord,new ArrayList<String>());				
			}
			visited.get(newWord).add(word);
		}
		groupedAnagrams.addAll(visited.values());
		return groupedAnagrams;

	}
	
	public static void main(String args[]) {
		String[] input = new String[]{"abc","aaaa","acb","abc","bab","bba","ba"};
		System.out.println(GroupAnagrams.groupAllAnagrams(input) );
		
	}
}

