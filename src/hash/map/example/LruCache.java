package hash.map.example;

//Did not work out
import java.util.Arrays;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class LruCache {
	
	class Node {
		private String data;
		private Node prev;
		private Node next;
		
		public Node(String data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
		public Node(String data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}	
		
		public String getData() {
			return this.data;
		}
		
		public Node getPrev() {
			return this.prev;
		}
		
		public Node getNext() {
			return this.next;
		}
		
		
		
		public void setPrev(Node node) {
			this.prev = node;
		}
		
		public void setNext(Node node) {
			this.next = node;
		}
	}
	
	class LinkedList {
		
		private Node head;
		private Node tail;
		int size=0;
		
		public LinkedList() {
			this.head = null;
			this.tail = null;
		}
		
		public boolean addElem(Node elem) {
			if (elem ==null) {
				return false;
			}
			if (head == null || tail == null) {
				head = elem;
				tail = elem;
			}
			else {
				tail.next = elem;
				elem.prev = tail;
				tail = elem;
			}
			size++;
			return true;			
		}
		
		public boolean movesElemToTail(Node node) {
			if (node == null) {
				return false;
			}
			if (node.getNext() == null) {
				return true;
			}
			Node tempPrev = node.getPrev();
			Node tempNext = node.getNext();
			if(tempPrev == null) {
				tempNext.prev = null;
				this.head = tempNext;
			}
			tail.next = node;
			node.prev = tail;
			tail = node;
			return true;
		}
		
		public String removeFirst() {
			if (this.head != null) {
				Node tmp = this.head.next;
				Node tmpPrev = this.head;
				tmp.setPrev(null);
				this.head = tmp;
				return tmpPrev.getData();
			}
			return null;
		}
		
		public int getSize() {
			return size;
		}
	}
	
	private HashMap<String,Node> map = null;
	private LinkedList lList = null;
	private int size;
	
	public LruCache(int size) {
		map = new HashMap<String,Node>();
		lList = new LinkedList();
		this.size=size;
	}
	
	
	public void set(String key, String value) {
		Node node = new Node(value);
		map.remove(key);
		if(lList.getSize()>=size) {
			String data = lList.removeFirst();
			map.remove(data);
			
		}
		lList.addElem(node);
		map.put(key, node);
	}
	
	public String get(String key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			lList.movesElemToTail(node);
			return node.getData();
		}
		return null;
	}
	
	public void printCache() {
		map.forEach((key,value) -> System.out.println("Key-Value:"+key+value.getData()));
	}
	
	public static void main(String args[]) {
		LruCache lruCache = new LruCache(5);
		lruCache.set("1","1");
		lruCache.set("2","2");
		lruCache.set("3","3");
		lruCache.set("4","4");
		lruCache.set("5","5");
		lruCache.set("6","6");
		lruCache.printCache();
		System.out.println("------");
		lruCache.get("2");
		lruCache.set("7","7");
		lruCache.set("8","8");
		lruCache.printCache();
	}

}
