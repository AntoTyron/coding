package graphs.examples;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;


public class CyclicGraph {
	public static void main(String args[]) {
		Map<String, List<String>> graph = new HashMap<String,List<String>>();
		graph.put("JFK", Arrays.asList("SFO","LAX"));
		graph.put("SFO", Arrays.asList("ORL"));
		graph.put("ORL", Arrays.asList("JFK","LAX","DFW"));
		graph.put("LAX", Arrays.asList("DFW"));
		Set<String> visited = new HashSet<String>();
		System.out.println(isCyclic(graph,"JFK", visited));
		visited.forEach(System.out::println);
	}
		// JFK -> SFO ->ORL ->JFK
		// JFK -> 

	public static boolean isCyclic ( Map<String, List<String>> graph, String start, Set<String> visited) {
		boolean isCyclic= false;
		//System.out.println("start:"+start);
if(visited.contains(start)) {
			//System.out.println("Visited"+start);
			return true;
		}
visited.add(start);		//JFK  / SFO /ORL
		if(graph.containsKey(start)) {
			
			for (String elem : graph.get(start)) {
				//System.out.println("elem"+elem);
				isCyclic  = isCyclic(graph, elem, visited);
				if(isCyclic){
					break;
				}
			}
		}	
		if(!isCyclic){
			visited.remove(start);
		}
		
return isCyclic;
	}
}
