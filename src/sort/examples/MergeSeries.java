package sort.examples;
import java.util.*;
import java.util.stream.*;
class MergeSeries{
	static class Event{
		int start;
		int value;
		public Event(int start, int value){
			this.start= start;
			this.value=value;
		}
		
		@Override
		public String toString(){
			return start+":"+value;
		}
	}
	public static List<Event> mergeSeries ( List<List<Event>> events){
	List<Event> mergedList = events.stream().flatMap(List::stream).collect(Collectors.toList());
	mergedList.sort((a,b) ->
		{
		return Integer.compare(a.start,b.start);
		});
	System.out.println(mergedList);
	int prev=0;
	int size=0;
	Event prevElem=null;
	for(int index=0; index<mergedList.size(); index++){
		Event elem = mergedList.get(index);
		if(prevElem!=null && prevElem.start == elem.start) {
			prevElem.value+=elem.value;
		}
		else{
			int temp = elem.value;
			elem.value+=prev;
			prev = temp;
			mergedList.set(size, elem);
			prevElem=elem; 
			size++;			
		}
	}
	mergedList.subList(size, mergedList.size()).clear();
	return mergedList;
	}

	public static void main(String args[]){
		List<List<Event>> events = new ArrayList<List<Event>>();
		List<Event> t1 = new ArrayList<Event>();
		List<Event> t2 = new ArrayList<Event>();
		List<Event> t3 = new ArrayList<Event>();
		t1.add(new Event(0,0));
		t1.add(new Event(5,3));
		t1.add(new Event(7,4));
		t1.add(new Event(8,-1));
		t1.add(new Event(12,5));
		t2.add(new Event(1,3));
		t2.add(new Event(6,4));
		t2.add(new Event(8,3));
		t3.add(new Event(0,3));
		t3.add(new Event(7,4));
		t3.add(new Event(11,3));
		events.add(t1);
		events.add(t2);
		events.add(t3);
		
		System.out.println(mergeSeries(events));

		
	}
}

