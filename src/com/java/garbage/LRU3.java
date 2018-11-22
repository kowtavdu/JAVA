package com.java.garbage;

import java.util.LinkedHashMap;
import java.util.Map;

class LastRecentlyUsed{
	public static <K, V> Map<K, V> leastRecentlyUsedCache(final int maxSize) {
		
        return new LinkedHashMap<K, V>(maxSize , 0.7f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            	System.out.println("@@@@@@@@@ "+(size() > maxSize));
                //return size() > maxSize;
            	return false;
            }
        };
    }
}
public class LRU3 {

	public static void main(String[] args) {
		Map<Object, Object> leastRecentlyUsed = new LastRecentlyUsed().leastRecentlyUsedCache(3);
	    leastRecentlyUsed.put("Robert", "Raj");
	    leastRecentlyUsed.put("Auzi", "Aiz");
	    leastRecentlyUsed.put("Sandy", "S");
	    leastRecentlyUsed.put("Tript", "tty");  
	    System.out.println(leastRecentlyUsed);	
	}
	
}
