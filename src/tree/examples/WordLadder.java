package tree.examples;
import java.util.*;
public class WordLadder {

	public static class StringWithLength{

		String currString;
		Integer distance;
		public StringWithLength(String currString,Integer distance){
			this.currString = currString;
			this.distance = distance;
		}
	}

	public static Integer wordDistance(Set<String> words, String start, String end) {

		Set<String> visited = new HashSet<String>(words);
		Queue<StringWithLength> q = new ArrayDeque<>();

		visited.remove(start);
		q.add(new StringWithLength(start,0));
		StringWithLength f;
		while((f=q.poll())!=null) {
			if(f.currString.equals(end)){
				return f.distance;
			}
			String str = f.currString;
			for(int i=0; i<start.length(); i++) {
	
				String prefix = i==0?"":str.substring(0,i);
				String suffix = i<start.length()? str.substring(i+1):"";
	
				for(char c='a'; c<='z'; c++) {
	
				String searchStr = prefix + c +suffix;
	
					if(visited.contains(searchStr)){
						visited.remove(searchStr);
						q.add(new StringWithLength(searchStr,f.distance+1));
					}
				}
			}
		}
		return -1;
	}
	public static void main(String args[]) {
		System.out.println(wordDistance(
				new HashSet<>(Arrays.asList("hot","cog","dog","log","lot","dot")),
				"hit","cog")
				);
			
	}

}
