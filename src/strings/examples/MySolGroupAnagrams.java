package strings.examples;

//Questions:
//What is the size, can I vary
//Can I consider caps and lower case the same?
//Check spaces, ascii char
//Conditions:
//1element return back same
//check size and do the ebelow
//char[] array and compare ech elem of first with the 2nd, increment counter
//check counter and size are same and then group them to one list
//ex   abc   , a=1,b=1,c=1   ifarr[elem] !=1 then false else ++

import java.util.*;
class MySolGroupAnagrams {
	public static List<List<String>> groupTheAnagram(String[] input) {
	List<String> tempGroup = new ArrayList<String>();
	List<List<String>> result = new ArrayList<List<String>>();

	HashSet<String> visited = new HashSet<String>();
	if( input.length==1) {
		tempGroup.add(input[0]);
		result.add(tempGroup);
		return result;
	}
	// abc, cba, dab, abd, aaa
	for(int i=0; i<input.length; i++) {
		char[] letters = input[i].toCharArray();
		int[] counter = new int[128]; 
		//Arrays.fill(counter, -1);
		List<String> group = new ArrayList<String>();
		if (visited.contains(input[i])) continue;

		group.add(input[i]);	//abc
		visited.add(input[i]);

		for(char letter: letters) {
			counter[letter]+=1;
		}				//a=1,b=1,c=1
		for( int j=i+1; j<input.length; j++) {  //cba
			if(input[i].length() != input[j].length()) continue;
			if (visited.contains(input[j])) continue;
			char[] lettersComp = input[j].toCharArray();
			boolean notAnagram = false;
			for(char letter: lettersComp) {
				if(counter[letter]<=0) {
				notAnagram = true;
				break;
				}
				counter[letter] = counter[letter]-1;
			}
			if(!notAnagram) {
				group.add(input[j]);
				visited.add(input[j]);
			}

		}
		result.add(group);
	}
	return result;

	}
	public static void main(String args[]) {
		String[] input = new String[]{"abc","aaaa","acb","abc","bab","bba","ba"};
		System.out.println(MySolGroupAnagrams.groupTheAnagram(input) );
		
	}

}

