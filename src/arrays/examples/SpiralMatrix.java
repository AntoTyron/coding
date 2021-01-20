package arrays.examples;

//Spiral Matrix
//i>length-1
import java.util.*;
class SpiralMatrix{
	public static List<Integer> createSpiral(List<List<Integer>> input) {
		int[][] SHIFT = {{0,1},{1,0},{0,-1},{-1,0}};
		List<Integer> result = new ArrayList<Integer>();
		int row=0,col=0,dir=0,nextRow=0,nextCol=0;
		for( int i=0; i<input.size()*input.size();i++) {
			result.add(input.get(row).get(col));
			input.get(row).set(col,0);
			//chang	e dir
				nextRow = row+SHIFT[dir][0];
				nextCol = col+SHIFT[dir][1];
	
			if( nextRow<0 || nextRow>input.size()-1 || nextCol<0 || 
					nextCol>input.size()-1|| input.get(nextRow).get(nextCol) ==0) {
				dir = (dir+1)%4;
				nextRow = row+SHIFT[dir][0];
				nextCol = col+SHIFT[dir][1];
			}
			row=nextRow;
			col = nextCol;	
		}
		return result;
		
	}
	
	public static void main(String args[]){
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		input.add(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)));
		input.add(new ArrayList<Integer>(Arrays.asList(6,7,8,9,10)));
		input.add(new ArrayList<Integer>(Arrays.asList(11,12,13,14,15)));
		input.add(new ArrayList<Integer>(Arrays.asList(16,17,18,19,20)));
		input.add(new ArrayList<Integer>(Arrays.asList(21,22,23,24,25)));
		
		System.out.println(createSpiral(input));
	}

}

