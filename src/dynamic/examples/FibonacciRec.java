package dynamic.examples;

import java.util.*;
public class FibonacciRec {
	static HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
	
	public static Integer fibonacciRec(Integer n){
		if(n<=1) return n;
		
		cache.putIfAbsent(n, fibonacciRec(n-2)+fibonacciRec(n-1));
		return cache.get(n);
		
	}
	
	public static Integer fibonacciDP(Integer n){
		Integer minus1=1;
		Integer minus2=0;
		for(int i=2; i<=n; i++) {
			int f = minus2 + minus1;
			minus2= minus1;
			minus1 = f;			
		}
		return minus1;
	}
	
	public static void main(String args[]) {
		
		System.out.println(fibonacciRec(6));
		System.out.println(fibonacciDP(6));
	}

}
