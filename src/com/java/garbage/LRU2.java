package com.java.garbage;

import java.util.Iterator;
import java.util.LinkedHashMap;


class LruImpl{
	private int capacity;
    private LinkedHashMap map;

    public LruImpl(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap();
    }

    public int get(Integer key) {
        Integer value = (Integer) this.map.get(key);
        if (value == null) {
            value = -1;
        } else {
            this.set(key, value);
        }
        return value;
    }

    public void set(int key, int value) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else if (this.map.size() == this.capacity) {
            Iterator<Integer> it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }
        map.put(key, value);
    }
}
public class LRU2 {

	public static void main(String[] args) {
	
		LruImpl cache = new LruImpl(2);
		cache.set(1, 111);
		cache.set(2, 222);
		cache.set(3, 333);
		System.out.println(cache.get(1));
	}
	
}
