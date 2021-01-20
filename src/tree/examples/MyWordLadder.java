package tree.examples;

import java.util.*;
class MyWordLadder{
	public static HashMap<String, HashSet<String>> cache = new HashMap<String,HashSet<String>>();

	public static void createCache(HashSet<String> words, String dest) {
		HashSet<String> oneElemDiffs = getOneDiffs(words, dest);
		cache.put(dest, oneElemDiffs);
		words.remove(dest);
		if(oneElemDiffs==null)return;
		for(String elem: oneElemDiffs) {
			createCache(words, elem);
		}
	}
	public static  HashSet<String> getOneDiffs(HashSet<String> words, String dest){
		HashSet<String> result = new HashSet<String>();
		for(String elem: words) {
			if(checkOneDiff(elem, dest)) result.add(elem);
		}
		return result;
	}
	public static Boolean checkOneDiff(String source, String dest) {
		int diff=0;
		char[] sourArr =source.toCharArray();
		char[] destArr =dest.toCharArray();
		for(char letter: sourArr) {
			for(char secLetter: destArr){
				if( letter == secLetter) diff++;
			}
		}
		return dest.length()-diff ==1;
	}
	public static Boolean pathExist(String dest, String source, HashSet<String> words){
		if(!words.contains(dest)) return false;
		createCache(words, dest);
		return pathExistRec(dest, source);		
	}
	public static  Boolean pathExistRec(String dest, String source) {
		if(dest==null || !cache.containsKey(dest)) return false;
		if(checkOneDiff(dest,source)) return true;
		HashSet<String> oneDiffs = cache.get(dest);
		for(String elem: oneDiffs) {
			if(pathExistRec(elem,source) ){
				return true;
			}
		}
		return false;
	}
	public static void main(String args[]) {
		System.out.println(pathExist("dog","hit", 
				new HashSet<>(Arrays.asList("hot","cog","dog","log","lot","dot")))
				);
			
	}

}

