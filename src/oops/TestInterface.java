package oops;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class TestInterface {

	public static void main(String[] args) {
		Map hashMap= new HashMap();
        Map weakHashMap = new WeakHashMap();

        String keyHashMap = new String("keyHashMap");
        String keyWeakHashMap = new String("keyWeakHashMap");

        hashMap.put(keyHashMap, "helloHash");
        weakHashMap.put(keyWeakHashMap, "helloWeakHash");
        System.out.println("Before: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));

        keyHashMap = null;
        keyWeakHashMap = null;

        //System.gc();  

        System.out.println("After: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));
        
        
        Map m = new HashMap();
        m.put(2, 3);
        m.put(m.put(2, 3), 4);
        System.out.println("@@@@@@@ "+m);
	}
	
}
