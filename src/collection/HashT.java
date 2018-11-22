package collection;

import java.util.Hashtable;
import java.util.Iterator;

public class HashT {

	public static void main(String[] args) {
		Hashtable<Integer,String> hs =  new Hashtable<>();
		hs.put(0, null);
		hs.put(1, "Saurabh");
		hs.put(2, "Munna");
		
		System.out.println("@@@@@@@@@@2 "+hs);
		 int oldCapacity = 10;
		 int newCapacity = oldCapacity + (oldCapacity >> 1);
		 
		 System.out.println("@@@@@@@@@@kkkkkkk "+newCapacity);
		 
		
	}
}
