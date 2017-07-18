package javaCache;

import org.junit.Test;

public class LRUMapTest {
	
	@Test
	public void test() {
		LRUCache<String, String> cache = new LRUCache<String, String>(3);
		cache.put("1", "a");
		cache.put("2", "a");
		cache.put("3", "a");
		cache.put("4", "a");
		cache.put("5", "a");
		cache.put("6", "a");
		
		System.out.println(cache.toString());
	}
}
