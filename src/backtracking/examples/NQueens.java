package backtracking.examples;

import java.util.*;
class NQueens {
	//Place on first col
	//col>n return true;
	// Iterate through all rows for that col to check if it’s a valid
	// set as 1
	//If true recurse to new col and is returned true then return true
	//If false set as 0
	private int N;
	public NQueens(int N){
		this.N= N;
	}
	public void printTheBoard(int[][] board) {
		Arrays.asList(board).forEach(key -> {
Arrays.stream(key).forEach(key1 -> System.out.print(key1+" "));
System.out.println();
});
	}

	public void NQueensSol(){
		int[][] board = { {0,0,0,0},
				{0,0,0,0},
				{0,0,0,0},
				{0,0,0,0}};

		if(NQueensSolUtil(board,0)) {
			System.out.println("No solution available");
		}
		printTheBoard(board);
	}
	public boolean NQueensSolUtil(int[][] board, int col) {

		if(col>=N) {
			return true;
		} 
		for( int row=0; row<N; row++) {
			
			if(isValid(board, row, col)) {
				board[row][col] =1;
				if(NQueensSolUtil(board, ++col) ==true) {
					return true;
				}
			}
			board[row][col] =0;
		}
		return false;
	}

	public boolean isValid(int[][] board, int row , int col) {
		//Check that col has been visited
		for( int prevCol=0; prevCol<col; prevCol++) {
			if(board[row][prevCol] ==1) {
				return false;
			}
		}
		for( int prevCol=col-1, prevRow=row-1; prevCol >=0 && prevRow >=0; prevCol --, prevRow--) {
if(board[prevRow][prevCol] ==1) {
				return false;
			}

		}
		for( int prevCol=col-1, prevRow=row+1; prevCol >=0 && prevRow <N; prevCol --, prevRow++) {
if(board[prevRow][prevCol] ==1) {
				return false;
			}

			
		// Check upper left diagonal
		//Check lower left diagonal
		
		}
		return true;
	}
	
	public static void main(String args[]) {
		
			NQueens nq = new NQueens(4);
			nq.NQueensSol();
	}
}

