package hash.map.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BrickWall{
	public HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();


	public static void main (String args[]){
		List<List<Integer>> wall = Arrays.asList(
						Arrays.asList(3,5,1,1),
						Arrays.asList(2,3,3,2),
						Arrays.asList(5,5),
						Arrays.asList(4,4,2),
						Arrays.asList(1,3,3,3),
						Arrays.asList(1,1,6,1,1));
		// Iterate through each eleme
		// Add to hash map, check if exist and incrment
		// keep a temp of the max count
		System.out.println(wall.size());
		int max=0;
		int rowSize = 0;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		

		for(int i=0; i< wall.size(); i++ ) {
			List bricks = wall.get(i);
			int sum = 0;
			for( int j=0; j< bricks.size()-1; j++) {
				int brick = (int)bricks.get(j);
				sum = sum + brick;
				int tmpCount = map.get(sum)==null?0:map.get(sum);
				int count = tmpCount+1;
				map.put(sum, count);
				if(count > max) {
 					max=count;
				}				
			}

		}
		//map.forEach((key,value) -> System.out.println("Key-Value:"+key+"-"+value));
		System.out.println("Rows to add "+(wall.size() - max));
	}
}