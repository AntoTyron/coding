package dynamic.examples;

import java.util.*;
class CountCombination{
	public static Integer countCombination(List<Integer> change, Integer total) {
		int [][] changeCombForTotal = new int[change.size()][total+1];
		for(int i=0; i<change.size(); i++) {
			changeCombForTotal[i][0] = 1;
			for(int j=1; j<=total; j++) {
				int withoutChange = i-1>=0? changeCombForTotal[i-1][j]:0 ;
				int withChange= (j-change.get(i)) >=0? changeCombForTotal[i][j-change.get(i)]:0;
				changeCombForTotal[i][j]= withoutChange+ withChange;
			}
		}
		
		for (int i=0; i<changeCombForTotal.length; i++) {
			for( int j=0; j<changeCombForTotal[0].length; j++){
				System.out.print(changeCombForTotal[i][j]+" ");
			}
			System.out.println();
		}
		return changeCombForTotal[change.size()-1][total];

	}

	public static void main(String args[]) {
		System.out.println(countCombination(Arrays.asList(1,2,5),6));
	}
}

