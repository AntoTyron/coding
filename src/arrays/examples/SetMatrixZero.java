package arrays.examples;
import java.util.*;
class SetMatrixZero {

	public static void main(String args [] ) {
		int[][] input = {{1,3,6,1},{1,1,1,1},{2,1,3,1},{0,1,1,1}};

		Boolean firstRowZero = false;
		ArrayList<Integer> rowElem;
		for( int i=0; i<input.length; i++) {
			for( int j=0; j<input[0].length; j++) {
				Integer elem = input[i][j];
				if ( i==0 && elem == 0) {
					firstRowZero = true;
					break;
				} else if(elem==0) {
					input[0][j]=0;
					//System.out.println(rowElem);
				}
			}
		}
		System.out.println(input);
		for( int i=1; i<input.length; i++) {
			for( int j=0; j<input[0].length; j++) {
				Integer currElem = input[i][j];
				Integer aboveElem = input[i-1][j];
				if ( aboveElem == 0) {
					input[i][j]=0;
				}
			}
		}
	if(firstRowZero) {
		//ArrayList<Integer> zeroList = new ArrayList<Integer>();
		for(int i=0; i< input[0].length; i++) {
			input[0][i]=0;
		}
	}
	
	for(int i =0 ; i<input.length;i++) {
		Arrays.stream(input[i]).forEach(System.out::print);
		System.out.println();
	}
	}

}
