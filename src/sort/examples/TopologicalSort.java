package sort.examples;

//Convert to hashset
//Find all items with no prereq and add to todo
//Convert prereq to courses
//go through todo and remove all the prereq from coursesToPrereq , append to result
//Remove circular dependency
import java.util.*;
import java.util.stream.Collectors;

class TopologicalSort {
	public static List<String> doSort(HashMap<String,List<String>> coursesToPrereq) {
		List<String> result = new LinkedList<String>();
List<String> todo= new LinkedList<String>();
		HashMap<String,HashSet<String>> coToPreq = new HashMap<String,HashSet<String>>();
		HashMap<String,ArrayList<String>> preqToCol = new HashMap<String,ArrayList<String>>();

		for(Map.Entry<String,List<String>> elem:coursesToPrereq.entrySet()) {
			HashSet<String> newValue = new HashSet<String>();
			newValue.addAll(elem.getValue());
			coToPreq.put(elem.getKey(),newValue);
			if(elem.getValue().isEmpty()) todo.add(elem.getKey());
			for(String listElem: elem.getValue()) {
				ArrayList<String> newList = preqToCol.get(listElem);
				if(newList == null) newList = new ArrayList<String>(Arrays.asList(elem.getKey()));
				else newList.add(elem.getKey());
				preqToCol.put(listElem, newList );
			}
		}
		System.out.println(coToPreq);
		System.out.println(todo);
		System.out.println(preqToCol);

		while(!todo.isEmpty()) {
			String todoElem = todo.remove(0);
			result.add(todoElem);
			if(preqToCol.containsKey(todoElem)) {
				List<String> keyElem = preqToCol.get(todoElem);
for(String key: keyElem) {
				if(coToPreq.containsKey(key)) {
					coToPreq.get(key).remove(todoElem);
				}
				if(coToPreq.get(key).isEmpty()) todo.add(key);
			}
			}
			
		}
		if(result.size() < coToPreq.size()) return null;
		return result;
	}

	
	public static void main(String args[]) {
		HashMap<String,List<String>> course = new HashMap<String,List<String>>();
		course.put("CSC300", Arrays.asList("CSC100","CSC200"));
		course.put("CSC200", Arrays.asList("CSC100"));
		course.put("CSC100", Arrays.asList());
		System.out.println(doSort(course));
	}

}








