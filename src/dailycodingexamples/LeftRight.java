package dailycodingexamples;
import java.util.*;
class LeftRight{
	public static List<Integer> findRelation(int[][] rules) throws Exception{
		Deque<Integer> stack = new ArrayDeque<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		HashMap<Integer,List<Integer>> relations = new HashMap<Integer,List<Integer>>();
		HashSet<Integer> visited = new HashSet<Integer>();
		HashSet<Integer> cycles = new HashSet<Integer>();
		for( int i=0; i<rules.length; i++) {
			relations.putIfAbsent(rules[i][0], new ArrayList<Integer>());
			relations.get(rules[i][0]).add(rules[i][1]);
		}
		int count=0, O=0;
		boolean flag=true;
		if(!visited.contains(rules[count][0])) {stack.push(rules[count][0]);}
		if(!visited.contains(rules[count][1])) { stack.push(rules[count][1]);}	
			
		while(!stack.isEmpty()){
			flag=true;
			O++;
			int right = stack.peek();
			if(relations.containsKey(right)) {
				cycles.add(right);
				for(Integer value: relations.get(right)){
					O++;
					if(visited.contains(value)){ flag=true;continue;}
					if( cycles.contains(value)){ throw new Exception("Rules contradict");}
					stack.push(value);
					//cycles.add(value);
					flag= false;
				}
			} if( flag){
				stack.pop();
				visited.add(right);
				result.add(right);
				cycles.clear();
				flag=true;
			}
			while(stack.isEmpty() && count<rules.length-1){
			++count;
			if(!visited.contains(rules[count][0])) {stack.push(rules[count][0]);}
			if(!visited.contains(rules[count][1])) { stack.push(rules[count][1]);}			
			}
		}
		Collections.reverse(result);
		System.out.println("O("+O+")");
		return result;
		
	}
	
	public static void main(String args[]){
		int[][] rules = {{1,3},{6,8},{4,3},{8,4},{2,3},{2,8}};
		try{
			System.out.println(findRelation(rules));
		
		}catch(Exception e){System.out.println(e);}
		
	}
}

