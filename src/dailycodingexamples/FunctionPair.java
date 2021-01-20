package dailycodingexamples;

/**
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
Given this implementation of cons:
Daily Coding Problem: Problem #5 [Medium]
 */
import java.util.function.*;
public class FunctionPair {
	
	static class Pair{
		Integer a,b;
		public Pair(Integer a, Integer b){
			this.a=a;
			this.b=b;
		}
	}
	
	public static Pair pair(Integer a, Integer b) {
		return new Pair(a,b);
	}
	/**
	public static Integer cons(Function<Pair,Integer> func, Integer a, Integer b){
		return func.apply(pair(a,b));
	}
	
	**/
	
	public static Integer left(Function<Function<Pair,Integer>,Integer> func){
		return func.apply(p -> p.a);
	}
	
	public static Integer right(Function<Function<Pair,Integer>,Integer> func){
		return func.apply(p -> p.b);
	}
	
	public static Function<Function<Pair,Integer>,Integer> cons1( Integer a, Integer b){
		return p -> p.apply(pair(a,b));
	}
	
	// No longer control what should be returned inside the function
	public static Function<Function<Pair,Integer>,Integer> cons2( Integer a, Integer b){
		return p -> p.apply(pair(b,a));
	}
	
	public static void main(String args[]){
		int a=1,b=2;
		//Function<Function<Pair,Integer>,Integer> left = func -> func.apply((a,b) -> a);
		Function<Function<Function<Pair,Integer>,Integer>,Integer> 
		leftSimple = func -> func.apply(p -> p.a);		//Function<Pair,Integer> right = p ->p.b;
		//System.out.println(leftSimple(cons1(a,b)));
		System.out.println(left(cons1(a,b)));
		System.out.println(left(cons2(a,b)));
		System.out.println(right(cons2(a,b)));
		System.out.println(right(cons1(a,b)));
		//System.out.println(cons(right,a,b ));
	}
	

}
