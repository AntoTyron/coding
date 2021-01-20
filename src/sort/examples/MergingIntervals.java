package sort.examples;

//Add the elements and sort the list
//Event.start+1<curr.start<Event.end+1 – take event.start and Max(event.end,curr.end) – point as last index
import java.util.*;
import java.util.stream.*;

import sort.examples.MergeSeries.Event;
class MergingIntervals{
	static class Event{
		int start;
		int finish;
		public Event(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
		@Override
		public String toString() {
			return start+":"+finish;
		}
	}
	public static List<Event> mergeEvents(List<Event> eventList, List<Event> input) {
		List<Event> events = Stream.concat(eventList.stream(),input.stream())
									.collect(Collectors.toList());
		events.sort((a,b) ->
		{ return Integer.compare(a.start,b.start);
		});
		System.out.println(events);
		//int curr = 0;
		int visited = 1;
		for(int curr=1;curr<events.size(); curr++) {
			Event currEv = events.get(curr);
			Event visitedEv = events.get(visited-1);
			// -4,-1   0,2  1,8   3,6   7,9    11,12  14,17
			if(currEv.start>= (visitedEv.start) && currEv.start<=(visitedEv.finish+1)) {
				visitedEv.finish = Math.max(visitedEv.finish, currEv.finish);
				events.set(visited, visitedEv);
				//curr++;
			}
			else{
				
				events.set(visited, currEv);
				visited++;
				//curr++;
			}
		}
			
			 events.subList(visited, events.size()).clear();
			 return events;
	}
	public static void main(String args[]){
		//List<List<Event>> events = new ArrayList<List<Event>>();
		List<Event> t1 = new ArrayList<Event>();
		List<Event> t2 = new ArrayList<Event>();
		List<Event> t3 = new ArrayList<Event>();
		t1.add(new Event(-4,-1));
		t1.add(new Event(0,2));
		t1.add(new Event(3,6));
		t1.add(new Event(7,9));
		t1.add(new Event(11,12));
		t1.add(new Event(14,17));
		t2.add(new Event(1,8));
		t2.add(new Event(17,20));

		//events.add(t1);
		//events.add(t2);
		//events.add(t3);
		
		System.out.println(mergeEvents(t1,t2));

		
	}
}


