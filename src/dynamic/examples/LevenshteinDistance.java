package dynamic.examples;

import java.util.*;
class LevenshteinDistance{
  public static Integer editDistance(String A, String B){
	int[][] computeDist = new int[A.length()][B.length()];
	for(int[] row: computeDist) {
		Arrays.fill(row,-1);
	}
	return calcDist(computeDist, A, A.length()-1, B, B.length()-1);
  }
  public static int calcDist(int[][] computeDist, String A, int aLen, String B, int bLen) {
	if(aLen<0) return bLen+1;
	if(bLen<0) return aLen+1;
	if(A.charAt(aLen) == B.charAt(bLen)) {
		computeDist[aLen][bLen]= calcDist(computeDist,A,aLen-1, B, bLen-1);
	}
	else{
		int replace=calcDist(computeDist,A,aLen-1, B, bLen-1);
		int insert= calcDist(computeDist,A,aLen-1, B, bLen);
		int delete= calcDist(computeDist,A,aLen, B, bLen-1);
		computeDist[aLen][bLen] = 1 + Math.min(replace,Math.min(insert,delete));
	}
	return computeDist[aLen][bLen];

}
  
  public static void main(String args[]) {
	  
	  System.out.println(editDistance("Carthorse","Orchestra"));
  }
}

