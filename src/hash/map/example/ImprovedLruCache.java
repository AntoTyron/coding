package hash.map.example;

import java.util.*;

public class ImprovedLruCache {

	LinkedHashMap<Integer, Integer> lru;
	
	public ImprovedLruCache(final int capacity) {
		this.lru = new LinkedHashMap<Integer,Integer>(capacity, 1.0f, true){
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 5330261057248627596L;

			@Override
			public boolean removeEldestEntry(Map.Entry<Integer, Integer> e){
				return this.size() > capacity;
			}
		};
	}
	
	public Integer lookup(Integer key){
		return lru.getOrDefault(key, -1);
	}
	
	public void insert(Integer key, Integer value){
		lru.putIfAbsent(key, value);
	}
	public Boolean erase(Integer key){
		return lru.remove(key)!=null;
	}
	
	public static void main(String args[]) {
		
		ImprovedLruCache lruCache = new ImprovedLruCache(5);
		lruCache.insert(1, 100);
		lruCache.insert(2, 200);
		lruCache.insert(3, 300);
		lruCache.insert(4, 400);
		lruCache.insert(5, 500);
		System.out.println(lruCache.lru);
		lruCache.insert(6, 600);		
		System.out.println(lruCache.lru);
		lruCache.lookup(2);
		lruCache.insert(7, 700);
		System.out.println(lruCache.lru);
		lruCache.erase(5);
		System.out.println(lruCache.lru);
	}
}
