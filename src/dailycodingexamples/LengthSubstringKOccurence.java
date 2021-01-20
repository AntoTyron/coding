package dailycodingexamples;

/** Working
abaac = ab  aba abaa =4,  remove a -> baa, remove b -> aac
abcac

Daily Coding Problem: Problem #13 [Hard] 
Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".

**/
//ab =2,  abc = 2, abac = 3
// HashSet add and remove
//first, last pointer , last pointer moves when present in hashset, first pointer moves when not present

import java.util.*;
class LengthSubstringKOccurence{
	public static Integer findOccurence(String str, int k){
		if(str == null || str.isEmpty()) return 0;
		//HashS<Character> cache = new HashSet<Character>();
		HashMap<Character,Integer> cache = new HashMap<Character,Integer>();		
		int first=0,last=1,max=1,sum=1, diff =1;
		
		cache.put(str.charAt(first), 1);
		while(first<str.length() && last<str.length()){		
			char fChar = str.charAt(first), lChar = str.charAt(last);
			if(cache.containsKey(lChar)){
				cache.put(lChar, cache.get(lChar)+1);
				sum++;last++;
			}
			else if(cache.size()<k){
				cache.put(lChar, 1);
				sum++;last++;
			}
			else{
				max = Math.max(max, sum);
				int count = cache.get(fChar);
				if(--count==0)cache.remove(fChar);
				else cache.put(fChar,count);
				first++;sum--;
			}
		}
		max = Math.max(max, sum);
		return max;
	}
	
	public static void main (String args[]){
		System.out.println(findOccurence("abacbcbd",2));
	}

}

