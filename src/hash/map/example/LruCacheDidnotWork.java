package hash.map.example;

//Did not work out
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class LruCacheDidnotWork {
	
	private HashMap<String,Integer> map = new HashMap<String,Integer>(); 
	private LinkedList<String> lList = new LinkedList<String>();
	//private LinkedList lList = new LinkedList();
	private int size = 0;
	private int index=0;
	
	class Node {
		private String data;
		private String value;
		private Node previous;
		private Node next;
		
		public Node(String data, String value) {
			this.data = data;
			this.value = value;
		}
	}
	
	class LinkedList1 {
		private Node head;
		private Node tail;
		private int size;
		
		public LinkedList1(){
			this.head = null;
			this.tail = null;
		}
		
		public void addElem(Node node) {
			
			if(node == null) {
				return;
			}
			if (this.head == null && this.tail == null) {
				this.head = node;
				this.tail = node;
			}
			else {
				this.tail.next = node;
				node.previous = this.tail;
				this.tail = node;
			}
			this.size++;
		}
		
		public Node pullFirst() {
			if (head == null) {
				return null;
			}
			this.size--;
			return head;
		}
		
		public Node pullLast() {
			if (tail == null) {
				return null;
			}
			this.size--;
			return tail;
		}
		public int size() {
			return size;
		}
	}
	
	public LruCacheDidnotWork(int size) {
		this.size = size;
	}
	//Initialize with a fixed Size
	//set method, and should remove the LRU element when it exceeds
	//get the element or return null if not present
	
	//What is the size
	//What can be the keys, String, should the value be saved as the key or can I save the count
	//blank key and can there be null
	//Can null be accepted
	//All has to be of same datatype
	//Removed elem will not show?
	
	 public void set(String key, String value) {
		 if (key==null || key.equals("")) {
			 return;
		 }
		 //Put into map
		 map.put(key, this.index);
		 if(lList.size()>=this.size ) {
			 String removeKey = lList.pollFirst();
			 map.remove(removeKey);
			 
		 }
		 lList.add(key);
		// Node node = new Node(key,value);
		 
		 //Put into Queue, if the size of llist< size
//		 if(lList.size()>this.size ) {
//			 lList.pullFirst();
//		 }
//		 lList.addElem(node);		
		 
		 
		 this.index++;
		 //Else remove head and insert in the tail
		 
		 //Array of size, calculate the hashcode and modulo of 10
		 
		 
	 }
	 
	 public void printListAndMap(){
		 map.forEach((key,value) -> System.out.println("Key-Value:"+key+"-"+value));
		 lList.forEach(k -> System.out.println("Frequency:"+ k));
	 }
	 
	 public String get (String key) {
		 if (!map.containsKey(key)) {
			 return null;
		 }
		 //Integer index = map.get(key);
		 lList.remove(key);
		 lList.add(key);
		 index--;
		 return key;
	 }

	 public static void main (String args[]) {
		 LruCacheDidnotWork lruCache = new LruCacheDidnotWork(5);
		 lruCache.set("1", "1");
		 lruCache.set("2", "2");
		 lruCache.set("3", "3");
		 lruCache.set("4", "4");
		 lruCache.set("5", "5");
		 lruCache.set("6", "6");
		 lruCache.printListAndMap();
		 lruCache.get("2");
		 lruCache.set("1", "1");
		 lruCache.printListAndMap();
		 
	 }
}
