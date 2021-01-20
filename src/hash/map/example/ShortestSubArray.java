package hash.map.example;

//apple, tiger, mango,cat, sleep, wake, apple, fight,cat
//apple,cat      apple,cat,mango
//apple – index pos, =0, pos=6
//cat – pos=3, pos=3, pos= 8 
//shortestsofar=3, 3, 2
import java.util.*;
class ShortestSubArray{
	 
	public static int myGetShortestArray(List<String> text, HashSet<String> search) {
		HashMap<String,Integer> visited = new HashMap<String,Integer>();
		int i=1;
		int shortestDist=Integer.MAX_VALUE;
		for(String elem: text) {
			if (search.contains(elem) ){
				visited.put(elem,i);
				if(visited.size() == search.size() && visited.containsKey(elem)) {
					int min=Integer.MAX_VALUE, max=0;
					for(Map.Entry<String,Integer> mElem : visited.entrySet())	{
						min = Math.min(min,mElem.getValue());
						max = Math.max(max,mElem.getValue());
					}
					shortestDist = shortestDist<(max-min)+1 ?shortestDist: (max-min)+1;
				}
				
			}
			//visited.put(elem,i);
			i++;
		}
		return shortestDist;
	}
	
	static class SubArray{
		int start=-1,end=-1;
		public SubArray(int start,int end) {
			this.start=start;
			this.end=end;
		}
		@Override
		public String toString(){
			return start+":"+end;
		}
	}
	public static SubArray getShortestArray(List<String> text, List<String> keywords) {
		SubArray subArray =new SubArray(-1,-1);
		LinkedHashMap<String,Integer> visited = new LinkedHashMap<String,Integer>(keywords.size(),1,true);
		for(String elem: keywords){
			visited.put(elem, null);
		}
		int idx=0;
		int visitedNodes = 0;
		for(String elem: text) {
			
			if(visited.containsKey(elem)){
				
				if(visited.get(elem)==null) visitedNodes++;
				
				visited.put(elem, idx);
				if(visitedNodes== keywords.size()) {
					int firstOcc = getFirstelem(visited);
					if((subArray.start ==-1 && subArray.end==-1) ||
							idx - firstOcc < subArray.end-subArray.start ){
						subArray.start= firstOcc;
						subArray.end=idx;
					}
				}
			}
			
			idx++;
		}
		
		return subArray;
		
	}
	public static int getFirstelem(LinkedHashMap<String,Integer> visited){
		int result=-1;
		for(Map.Entry<String, Integer> elem: visited.entrySet()) {
				result = elem.getValue();
				break;
		}
		return result;
	}
	
	public static void main(String args[]) {
		
		System.out.println(getShortestArray(Arrays.asList("apple", "tiger", "zero", "mango","cat", "apple", "wake", "apple", "fight","cat","mango"),
					Arrays.asList("apple","mango","cat")));
	}

	
}


