package trie.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie {
	private Map<Character,HashMap> trieMap;
	public Trie() {
		trieMap = new HashMap<Character,HashMap>();
	}

	public void insert(String text) {
		Map<Character,HashMap> tempMap = trieMap;
		for(char word: text.toCharArray()) {
			if(!tempMap.containsKey(word)) {
				//System.out.println(word);
				tempMap.put(word, new HashMap<Character,HashMap>());
			}
			tempMap = tempMap.get(word);
		}
		tempMap.put('#',new HashMap<Character,HashMap>());
	}
	
	public List<String> autoComplete(String input) {
			List<String> strList = new ArrayList<String>();
				Map<Character,HashMap> tempMap = trieMap;
				boolean found=true;
				for (Character word: input.toCharArray()) {
					if(!tempMap.containsKey(word)) {
						found=false;
						break;
					}
					tempMap = tempMap.get(word);
					found = true;
				}
			if(found){
				addToList("",tempMap,strList);
			}
			return strList;
			
	}
	
	public void addToList(String word,Map<Character,HashMap> map, List<String> strList) {
		
			if(map.containsKey('#')) {
				strList.add(word);
				return;
			}
			map.forEach((key,value) -> addToList(word+key,value,strList));
			
	}
	
	public void printMap() {
		
			System.out.println(trieMap);
	}
	
	public static void main (String args[]) {
		
			Trie t = new Trie();
			t.insert("Anto");
			t.insert("Any");
			t.insert("Ansible");
			//t.printMap();
			System.out.println(t.autoComplete("A"));
	}
	

} 

