package backtracking.examples;

import java.util.*;
class AndroidKeyPad {
	public static int findPath(int n, HashSet<Integer> visited, int current, HashMap<String, Integer> jumps){		
if(n==1) {			
			return 1;
		}
		int paths = 0;
		//int[] control=[-1,+1,-3,+3,-4,+4,-2];
		for( int i=1; i<10; i++) {
			if(!visited.contains(i) ){
				if((!jumps.containsKey(current+"-"+i) && (Math.abs(current-i)/3 <1))||
					(jumps.containsKey(current+"-"+i)
&& visited.contains(jumps.get(current+"-"+i )))) {
					visited.add(i);
					paths +=findPath(n-1, visited, i, jumps );
					visited.remove(i);
				}
							
			}
		}

		return paths;

	}
	
	public static void main(String args[]) {
		
		HashMap<String,Integer> jumps = new HashMap<String,Integer>();
			jumps.put("1-7",4);
			jumps.put("1-3", 2);
			jumps.put("1-9", 5);
			jumps.put("2-8", 5);
			jumps.put("3-1", 2);
			jumps.put("3-7", 5);
			jumps.put("3-9", 6);
			jumps.put("4-6", 5);
			jumps.put("6-4", 5);
			jumps.put("7-1", 4);
			jumps.put("7-3", 5);
			jumps.put("7-9", 8);
			jumps.put("8-2",5);
			jumps.put("9-1", 5);
			jumps.put("9-3", 6);
			jumps.put("9-7", 8);
		
		int paths = 4*AndroidKeyPad.findPath(4, new HashSet<Integer>(),
				1, jumps)+
		4*AndroidKeyPad.findPath(4, new HashSet<Integer>(),
				2, jumps)+
		4*AndroidKeyPad.findPath(4, new HashSet<Integer>(),
				5, jumps);
		
		System.out.println(paths);
	
	}
}

