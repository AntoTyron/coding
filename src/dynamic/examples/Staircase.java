package dynamic.examples;

import java.util.*;
public class Staircase {
	public static void main(String args[]) {
		int climbStair = 4;
		int[] combinations = new int[]{1,3};

		//f(4) =f(3)+f(2)
		HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
		cache.put(0,1);
		for( int i=1; i<=climbStair;i++) {
			Integer sum=0;
			for(int j=0; j<combinations.length; j++) {
				System.out.println(i-combinations[j]);
				System.out.println(cache.get(i-combinations[j]) + "--------");
				if(cache.containsKey(i-combinations[j])) {
					sum += cache.get(i-combinations[j]);
				}
			}
			cache.put(i,sum);
		} 
		System.out.println(cache.get(climbStair));
	}
}

