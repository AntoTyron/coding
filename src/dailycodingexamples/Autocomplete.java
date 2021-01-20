package dailycodingexamples;

/**
 * Daily Coding Problem: Problem #11 [Medium] 
 * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].

 */
import java.util.*;
public class Autocomplete {
	
	public static HashMap<Character, HashMap> dictWords = new HashMap<Character,HashMap>();
	
	public static void insert(String text){
		HashMap<Character, HashMap> dict = dictWords;
		for(Character letter: text.toCharArray()){
			dict.putIfAbsent(letter, new HashMap<Character,HashMap>());
			dict = dict.get(letter);			
		}
	}
	
	public static List<String> autoCompleteElem(String text){
		HashMap<Character, HashMap> dict = dictWords;
		for(Character letter: text.toCharArray()){
			dict = dict.get(letter);
		}
		return getElements(dict);
	}
	
	public static List<String> getElements(HashMap<Character, HashMap> dict){
		List<String> result = new ArrayList<String>();
		//String str ="";
		for(Map.Entry<Character, HashMap> elem: dict.entrySet()){
			List<String> prevResult = getElements(elem.getValue());
			if(prevResult.isEmpty()){
				result.add(String.valueOf(elem.getKey()));
			} else{
				for(String str: prevResult){
					result.add(elem.getKey() + str);
				}
			}						
		}
		return result;
	}
	
	public static void main(String args[]){
		insert("deer");
		insert("desert");
		insert("den");
		insert("dentist");
		insert("deal");
		insert("dog");
		//System.out.println(dictWords);
		System.out.println(autoCompleteElem("de"));
	}

}
