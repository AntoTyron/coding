package backtracking.examples;
import java.util.*;
class MatchedParen{
	public static List<String> matchParen(int k) {
		if(k==0) return null;
		List<String> result = new ArrayList<String>();
		formComb(k,k,result, "");
		return result;
	}
	public static void formComb(int numOfLeftPar, int numOfRightPar, List<String> result, String str) {
		if(numOfRightPar==0) result.add(str);
		if(numOfLeftPar >0 ) {
			formComb(numOfLeftPar-1, numOfRightPar, result, str+"(");
		}
		if(numOfLeftPar< numOfRightPar) {
			formComb(numOfLeftPar, numOfRightPar-1, result,str+")");
		}
	}
	public static void main(String args[]) {
		System.out.println(matchParen(2));
		System.out.println(matchParen(3));
		System.out.println(matchParen(4));
		System.out.println(matchParen(5));
	}

}

