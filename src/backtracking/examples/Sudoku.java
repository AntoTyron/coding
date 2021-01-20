package backtracking.examples;

import java.util.*;
class Sudoku{
	public static Boolean solveSudoku(List<List<Integer>> sudoku) {
		return solvePartial(0,0, sudoku);
	}
	// If is valid and it reaches the end of the row , I,j>size
	public static Boolean solvePartial(int i, int j, List<List<Integer>> sudoku) {
	if(i==sudoku.size()) {
		i=0;
		if(++j==sudoku.size()) {
			return true;
		}
	}
	if (sudoku.get(i).get(j) != 0) {
		return solvePartial(i+1,j,sudoku);
	}
	for( int val=1; val<=sudoku.size(); val++) {
		if( !IsDuplicate(sudoku, i, j, val)) {
			sudoku.get(i).set(j,val);
			if( solvePartial(i+1,j, sudoku)) {
				return true;
			}
			
		}
	}
	sudoku.get(i).set(j,0);
	return false;
	}
	public static Boolean IsDuplicate(List<List<Integer>> sudoku, int i, int j, int val) {
		if(sudoku.stream().anyMatch(row -> row.get(j) == val)){
			return true;
		}
		if( sudoku.get(i).contains(val)) return true;
		int rowSize = (int) Math.sqrt(sudoku.size());
		int I = i/rowSize;
		int J = j/rowSize;
		
		for( int k=0; k<rowSize; k++) {
			for(int m=0; m<rowSize;m++) {
				if(val == sudoku.get(rowSize*I+k).get(rowSize*J+m)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String agrs[]){
		List<List<Integer>> sudoku = new ArrayList<List<Integer>>();
		sudoku.add(new ArrayList<Integer>(Arrays.asList(5,3,0,0,7,0,0,0,0)));
		sudoku.add(new ArrayList<Integer>(Arrays.asList(6,0,0,1,9,5,0,0,0)));
		sudoku.add(new ArrayList<Integer>(Arrays.asList(0,9,8,0,0,0,0,6,0)));
		sudoku.add(new ArrayList<Integer>(Arrays.asList(8,0,0,0,6,0,0,0,3)));
		sudoku.add(new ArrayList<Integer>(Arrays.asList(4,0,0,8,0,3,0,0,1)));
		sudoku.add(new ArrayList<Integer>(Arrays.asList(7,0,0,0,2,0,0,0,6)));
		sudoku.add(new ArrayList<Integer>(Arrays.asList(0,6,0,0,0,0,2,8,0)));
		sudoku.add(new ArrayList<Integer>(Arrays.asList(0,0,0,4,1,9,0,0,5)));
		sudoku.add(new ArrayList<Integer>(Arrays.asList(0,0,0,0,8,0,0,7,9)));
		sudoku.forEach(row -> {
			System.out.println(row);
			//System.out.println();
		});
		System.out.println();
		solveSudoku(sudoku);
		sudoku.forEach(row -> {
			System.out.println(row);
			//System.out.println();
		});
	}
}

